/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.castellano.tools.classes;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;



/**
 *
 * @author santi
 */
public class ImageTransaction {
    private String file;
    private Image image;

    public Image getImage() {
        return image;
    }
  
    public ImageTransaction(String file) throws IOException {
       // this.file = file;
       InputStream is = null;
        try {
            is = new FileInputStream(file); 
            image= new Image(is);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
     /*   try {
            // File imgFileInput = new File(file);
            InputStream inputStream= new BufferedInputStream(new FileInputStream(file));
            image=ImageIO.read(inputStream);
        } catch (FileNotFoundException ex) {
            System.out.println("file not found");
        }*/
        
    }

   
    
}
