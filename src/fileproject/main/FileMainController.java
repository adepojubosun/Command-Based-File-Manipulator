/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileproject.main;


import fileproject.model.FileEntity;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.web.HTMLEditor;


/**
 * FXML Controller class
 *
 * @author bosun
 */
public class FileMainController implements Initializable {

    
    private FileProject main;
    private Alert alert = new Alert();
    
    @FXML
    private TextField searchField;
    @FXML
    private HTMLEditor textarea;
    private FileEntity entity;
    private String value = new String();
  //  private File file = new File(entity.getName());
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        
       
        // TODO
    }    


     public void setMainApp(FileProject project){
        this.main = project;
    }
     
   
     public void setFile(FileEntity entity){
        this.entity = entity;
        File file = new File(entity.getName());
          if(file.exists()){
            
        String value;
        try {
        FileReader read = new FileReader(file);
        BufferedReader buf =  new BufferedReader(read);
        while((value = buf.readLine()) != null){
        textarea.setHtmlText(value);
        }
        
        } catch ( Exception ex2) {
        Logger.getLogger(FileProject.class.getName()).log(Level.SEVERE, null, ex2);
        }
        }else{
        
        }
        
     }
     
     
     
     
     

    @FXML
    private void handleSearch(ActionEvent event) {
    }

    @FXML
    private void handleSave(ActionEvent event) {
        File file = new File(entity.getName());
            String details = textarea.getHtmlText();
            char[] buf = new char[details.length()];
            details.getChars(0, details.length(), buf, 0);
            try {
                FileWriter fo = new FileWriter(file);
                fo.write(buf);
                fo.close();
            } catch (IOException ex) {
                Logger.getLogger(FileProject.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                alert.display("SUCCESS", "FILE SAVED");
                main.initStage();
            }
    }

    @FXML
    private void handleClose(ActionEvent event) {
        main.initStage();
    }
    
}
