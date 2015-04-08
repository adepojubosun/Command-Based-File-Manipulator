/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileproject.model;


/**
 *
 * @author bosun
 */
public class FileEntity {
    
    private String filename;
    private final String filepath = "./data/";
 
    
    public FileEntity(String name){
        this.filename = filepath+name;
    }
    
    public FileEntity(){
        
    }
    
    
    public String getName(){
        return filename;
    }
    
    public void setName(String name){
        this.filename = filepath+ name;

    }

    public String getFilepath() {
        return filepath;
    }

 
}
