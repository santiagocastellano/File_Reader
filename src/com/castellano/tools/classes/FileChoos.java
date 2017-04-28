/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.castellano.tools.classes;

import java.io.File;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

/**
 *
 * @author santi TODO: preguntar si se puede evitar hacer uso del get, si hay alguna manera de resumir en un solo paso
 * la devolucion de un dato que si o si se va a necesitar como el filecontent
 */
public class FileChoos {
   private ExtensionFilter filter ;
   private Stage context;
   private File filePath;
    public FileChoos(ExtensionFilter filter, Stage context) {
        this.filter = filter;
        this.context = context;
        openFileChoos();
       
    }
    
   private void openFileChoos(){
        FileChooser fileChoos=new FileChooser();
        fileChoos.setTitle("Open file");
        fileChoos.getExtensionFilters().addAll(this.filter);
        this.filePath= fileChoos.showOpenDialog(this.context); 
        
   }

    public File getFilePath() {
        return filePath;
    }
   
}
