/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.castellano.tools.classes;


import java.io.FileReader;
import java.io.IOException;


/**
 *
 * @author santi
 */
public class FileTransaction {
   // private String fileName;
    //private FileReader input = null;
    private String stringFile="";

    public String getStringFile() {
        return stringFile;
    }
    /*todo: cambiar el metodo read por lectura de linea
    * crear otro metodo para escribir un nuevo archivo
    * crear otro metodo para editar un archivo
    */
    public FileTransaction(String fileName) {
        //FileReader input=null;
        try(FileReader input=new FileReader(fileName)){
            String str="";
            int valor=input.read();
            while(valor!=-1){
                str=str+(char)valor;
                valor=input.read();
            }
            this.stringFile=str;
        } catch (IOException e1) {
            System.out.println("error");
        }catch (Exception e){
            System.out.println("error");
        }
    }
    
    
}
