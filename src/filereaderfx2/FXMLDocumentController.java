/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filereaderfx2;

import com.castellano.tools.classes.Connect;
import com.castellano.tools.classes.FileChoos;
import com.castellano.tools.classes.FileTransaction;
import com.castellano.tools.classes.ImageTransaction;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

/**
 *
 * @author santi
 */
public class FXMLDocumentController implements Initializable {
    private ExtensionFilter filter;
    private FileReaderFX2 ProgramaPrincipal;
    @FXML
    private ImageView imageView1;
    @FXML
    private WebView webView1;
    @FXML
    private StackPane stack1;

    public void setProgramaPrincipal(FileReaderFX2 ProgramaPrincipal) {
        this.ProgramaPrincipal = ProgramaPrincipal;
    }
    @FXML
    private MenuItem menuTxt;
    @FXML
    private AnchorPane anchor;
    @FXML
    private MenuBar menuBar;
    @FXML
    private Menu s;
    @FXML
    private Menu menuFile;
    @FXML
    private MenuItem menuUrl;
    @FXML
    private MenuItem menuVideo;
    @FXML
    private MenuItem menuAudio;
    @FXML
    private MenuItem menuImage;
    @FXML
    private TextArea txtArea;
    private TitledPane paneInsertUrl;
   // private StackPane stack;
 /*  private File openFileChoos(ExtensionFilter filter){
        FileChooser fileChoos=new FileChooser();
        fileChoos.setTitle("Open file");
        fileChoos.getExtensionFilters().addAll(filter);
        File file= fileChoos.showOpenDialog(FileReaderFX2.stg); //ver si este parche esta bien y se peude acceder al stage de otra manera
        return file;
   }*/
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        // TODO
        /* menuTxt.setOnAction((ActionEvent event1) -> {
            System.out.println("menutexto");
        });*/
    }   
    //pregunta : es bueno mandar como un argumento un objeto generico? esto lo hago porque necesito 
    //la posicion de un nodo dentro de un stack, para que el codigo sea mas extensible no se cuantos
    //ni que tipo de children contendra el stack
    private int indexOfNode(Object obj){
        int indx= stack1.getChildren().indexOf(obj);
        return indx;
    }
    @FXML
    private void handleMenuTxt(ActionEvent event) {

       ExtensionFilter extension=new ExtensionFilter("Text Files", "*.txt","*.log","*.dat","*.csv");
       Stage stg= FileReaderFX2.stg; //preguntar si el stage no se puede obtener de otra manera
       //llamado a un filechooser que devuelve el path del seleccionado referenciado por el metodo getFilePath
       FileChoos fileChooser= new FileChoos(extension,stg);
       //apertura del archivo, devuelve el contenido de  un file mandandole el path
       FileTransaction fileTransaction=new FileTransaction(fileChooser.getFilePath().toString());
       //transformo lo que retorna la clase fileTransaction a string y lo mando al textarea
    
       txtArea.setText(fileTransaction.getStringFile());
       
       //envio el id entero del nodo que quiero hacer aparecer en el tope, los otros se ocultan dentro del metodo putvisible
       int index= indexOfNode(txtArea);
       putVisible(index);
       
       // System.out.println(stack1.getChildren().indexOf(imageView1));
      // txtArea.setText(fileChooser.getFilePath().toString());
        
        
    /*    FileChooser fileChoos=new FileChooser();
        fileChoos.setTitle("Open TXT file");
        fileChoos.getExtensionFilters().addAll(
         new ExtensionFilter("Text Files", "*.txt"),
         new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
         new ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
         new ExtensionFilter("Video Files", "*.avi","*.mpg"));
       // FileChooser.ExtensionFilter filter= new FileChooser.ExtensionFilter("TXT files", "*.txt");
       // fc.setSelectedExtensionFilter(filter);
        File file= fileChoos.showOpenDialog(FileReaderFX2.stg); //ver si este parche esta bien y se peude acceder al stage de otra manera
        */
       // 
        
      /*  fc.setSelectedExtensionFilter(filter); filtro = new FileNameExtensionFilter("*.TXT", "txt", "*.LOG", "log",
        "*.CSV","csv", "*.TEXT", "text", "*.INF", "inf", "*.DAT","dat", "*.HTM", "htm",
        "*.HTML", "html","*.PHP","php", "*.COM", "com");*/
    }
     
  /*  class ThreadURLLoad implements Runnable{

        @Override
        public void run() {
           
            TextInputDialog dialog = new TextInputDialog("http://www.oracle.com/products/index.html");
            dialog.setTitle("Text Input Dialog");
            dialog.setContentText("Enter URL:");
            Optional<String> result = dialog.showAndWait();
            if (result.isPresent()){
                // System.out.println("Your name: " + result.get());
                WebEngine webEngine=webView1.getEngine();
                String url=result.get();
                if(!url.contains("http://")){
                    url="http://"+url;
                }
                webEngine.load(url);
                int index= indexOfNode(webView1);
                putVisible(index);
            }
        }
        
    }*/
    @FXML
    private void handleMenuUrl(ActionEvent event) {
       
       // new Thread(new ThreadURLLoad()).start();
        System.out.println("url");
        TextInputDialog dialog = new TextInputDialog("http://www.oracle.com/products/index.html");
        dialog.setTitle("Enter URL");
       dialog.setContentText("Enter URL:");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
           // System.out.println("Your name: " + result.get());
            WebEngine webEngine=webView1.getEngine();
            String url=result.get();
            if(!url.contains("http://")){
                url="http://"+url;
            }
            webEngine.load(url);
            int index= indexOfNode(webView1);
            putVisible(index);
        }

        
     }

    @FXML
    private void handleMenuImage(ActionEvent event) {

       ExtensionFilter extension=new ExtensionFilter("Image Files", "*.jpg","*.jpeg","*.png","*.gif");
       Stage stg= FileReaderFX2.stg; //preguntar si el stage no se puede obtener de otra manera
       //llamado a un filechooser que devuelve el path del seleccionado referenciado por el metodo getFilePath
       FileChoos fileChooser= new FileChoos(extension,stg);
        try {
            //apertura del archivo, devuelve el contenido de  un file mandandole el path
            ImageTransaction imageTransaction= new ImageTransaction(fileChooser.getFilePath().toString());
            imageView1.setImage(imageTransaction.getImage());
            int index= indexOfNode(imageView1);
            putVisible(index);
            //transformo lo que retorna la clase fileTransaction a string y lo mando al textarea
        } catch (IOException ex) {
            System.out.println("failed to access");
          
        }
    
       //txtArea.setText(fileTransaction.getStringFile());
       
       //envio el id entero del nodo que quiero hacer aparecer en el tope, los otros se ocultan dentro del metodo putvisible
       
      
      
    }

    @FXML
    private void handleMenuVideo(ActionEvent event) {
        System.out.println("video");
      //  Connect conect= new Connect();
       
    }

    @FXML
    private void handleMenuAudio(ActionEvent event) {
        System.out.println("audio");
    }


    private void handlebtnInsertUrlClose(ActionEvent event) {
         paneInsertUrl.setVisible(false);
        System.out.println("ssss");
    }

    private void putVisible(int toTrue){
        //se almacenan todos los nodos en un listado
         ObservableList<Node> childs = stack1.getChildren();
         Node node;
         //se visualiza o se oculta cada nodo segun toTrue
         for (int i=0;i<childs.size();i++){
            node= childs.get(i);          
            if(i!=toTrue) node.setVisible(false); 
            else node.setVisible(true); 
           
         }
      
    }

   
    
    
}
