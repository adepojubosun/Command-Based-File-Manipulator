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

/**
 * FXML Controller class
 *
 * @author bosun
 */
public class MainController implements Initializable {
    @FXML
    private TextField commandText;
    
    private final String CREATE = "create";
    private final String EDIT = "edit";
    private final String DELETE = "delete";
    private final String VIEW_ALL = "view all";
    private final String EXPORT = "export";
    private final String help = "[create] - Create and Open a new File.\n\n"
                              + "[edit] - Edit/Open a previously created File.\n\n"
                              + "[delete] - Delete a previously created File.\n\n"
                              + "[view all] - View All files in directory.\n\n"
                              + "[export] - Export Contents of file.";
    private String fileName;

    
    private FileProject main;
    private  Alert alert = new Alert();
    
    
    
    /**
     * Initializes the controller class.
     * @param project
     */
    
    
    public void setMainApp(FileProject project){
        this.main = project;
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void handleExecute(ActionEvent event) {
        FileEntity entity = new FileEntity();
        boolean valueReturned;
        String name;
        switch (commandText.getText()){
            case CREATE : 
               valueReturned = main.dialogStage(entity);
                if(valueReturned){
                    commandText.setText("");
           
                 name = entity.getName();
                File file = new File(name);
                if(file.exists()){
                    
                    alert.display("ERROR", "File already exists");
                }else{
                    alert.display("MESSAGE","File Created, Press Enter to Open!");
                    main.FileEditStage(entity);
                }
         
                }else{
                    alert.display("ERROR", "Input Name");
                }
            break;
            
            case EDIT:
                  valueReturned = main.dialogStage(entity);
                if(valueReturned){
                    commandText.setText("");
                    name = entity.getName();
                    File file = new File(name);
                    if(file.exists()){
                        
                        main.FileEditStage(entity);
                    }else{
                        alert.display("ERROR", "File does not exist");
                    }
                }else{
                    alert.display("ERROR", "Input Name");
                }
            break;
                
            case DELETE :
                commandText.setText("");
                 valueReturned = main.dialogStage(entity);
                if(valueReturned){
                    name = entity.getName();
                    File file = new File(name);
                    if(file.exists()){
                        file.delete();
                        alert.display("MESSAGE", "File Deleted");
                    }else{
                        alert.display("ERROR", "File does not exist");
                    }
                }else{
                    alert.display("ERROR", "Input Name");
                }
            break;
            
           
            case VIEW_ALL :
                commandText.setText("");
                    File file = new File("./data");
                    if(file.exists()){
                        int sum = 0;
                     String[] list = file.list();
                     StringBuilder txt = new StringBuilder();
                     for(int i = 0; i<list.length;i++){
                         
                        
                         String print = String.format("%d.%s",i+1,list[i]);
                         
                         txt.append(print);
                         if(i!=list.length-1){
                             txt.append("\n\n");
                         }
                     }
                     main.helpStage(txt.toString());
                    }
                break;
            case EXPORT :
                break ; 
                
            default :
                
                commandText.setText("");
                alert.display("ERROR", "Command does not Exist, Check Help for details");
                
                       
        }
        
        }
        
        
    

    @FXML
    private void handleHelp(ActionEvent event) {
        main.helpStage(help);
    }

    
}
