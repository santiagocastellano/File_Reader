/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filereaderfx2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author santi
 */
public class FXMLShowTxtController implements Initializable {

    @FXML
    private Button boton;
    @FXML
    private Label labeleado;
    @FXML
    private CheckBox checkbox1;
    @FXML
    private Button cambiar;
    @FXML
    private StackPane stack;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void initialize(ActionEvent event) {
       // Node nodo= stack.getChildren().get(1);
      // Node nodo=(Node) stack.getChildren();
       // System.out.println(nodo.getId());
       // nodo.setVisible(false);
       // changeTop();
       putVisible(2);
        
    }
    private void putVisible(int toTrue){
         ObservableList<Node> childs = this.stack.getChildren();
         Node node;
        
         for (int i=0;i<childs.size();i++){
            node= childs.get(i);
            
            if(i!=toTrue) node.setVisible(false); 
            else node.setVisible(true); 
           
         }
        //Node nodo=(Node) stack.getChildren();
    }
    private void changeTop() {
       ObservableList<Node> childs = this.stack.getChildren();
 
       if (childs.size() > 1) {
           //
           Node topNode = childs.get(childs.size()-1);
          
           // This node will be brought to the front
           Node newTopNode = childs.get(childs.size()-2);
                  
           topNode.setVisible(false);
           topNode.toBack();
          
           newTopNode.setVisible(true);
       }
   }
    
}
