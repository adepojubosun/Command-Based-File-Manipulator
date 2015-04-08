/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileproject.main;

import fileproject.model.FileEntity;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author bosun
 */
public class FilenameController implements Initializable {

    private Stage dialogStage;
    private boolean valueReturned = false;
    private FileEntity entity ;
    private final String ext = ".txt";
    private String fname;
    private String name;
    private Alert alert = new Alert();

    @FXML
    private TextField nameField;

    /**
     * Initializes the controller class.
     */
   

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }
    
     public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
     
     public void SetFileEntity(FileEntity entity){
         this.entity = entity;
     }

    public boolean returnValue() {
        return valueReturned;
    }


    @FXML
    private void handleGetName(ActionEvent event) {
        if(!nameField.getText().isEmpty() && nameField.getText() != null){
            name = nameField.getText();
        fname = name + ext;
        entity.setName(fname);
        
            valueReturned = true;
            dialogStage.close();
        }else{
            alert.display("Error", "Empty Field");
        }
        
        
    }
    
    }


