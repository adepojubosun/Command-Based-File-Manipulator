/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileproject.main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author bosun
 */
public class HelpController implements Initializable {
    
    private FileProject main;
    @FXML
    private TextArea textArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void setApp(FileProject main){
        this.main = main;
        
    }
    
    public void editTextArea(String values){
        textArea.appendText(values);
    }
    
    
    @FXML
    private void handleOK(ActionEvent event) {
        main.initStage();
    }

  


}
