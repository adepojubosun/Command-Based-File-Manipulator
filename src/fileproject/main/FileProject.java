/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileproject.main;

import fileproject.model.FileEntity;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


/**
 *
 * @author bosun
 */
public class FileProject extends Application {
    
 
    private Stage primarystage;
    private AnchorPane layout;
    
    @Override
    public void start(Stage primaryStage) {
       this.primarystage = primaryStage;
       primaryStage.setTitle("FILE APPLICATION");
       primaryStage.setResizable(false);
       initStage();
    }

     
    public void initStage(){
       
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(FileProject.class.getResource("Main.fxml"));
            layout = (AnchorPane) loader.load();
            Scene scene = new Scene(layout);
            primarystage.setScene(scene);
            primarystage.centerOnScreen();
            
            MainController controller = loader.getController();
            controller.setMainApp(this);
           
            primarystage.show();
        } catch (IOException ex) {
            Logger.getLogger(FileProject.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();;
        }
    }
    
    
    public boolean dialogStage(FileEntity entity){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(FileProject.class.getResource("filename.fxml"));
            AnchorPane pane = (AnchorPane) loader.load();
        
            
            Stage dialogStage = new Stage();
            dialogStage.setTitle("FILE-NAME");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primarystage);
            Scene scene = new Scene(pane);
            dialogStage.setScene(scene);            
            FilenameController controller = loader.getController();  
            controller.setDialogStage(dialogStage);   
            controller.SetFileEntity(entity);
            dialogStage.centerOnScreen();
            dialogStage.showAndWait();
            
            
            return controller.returnValue();
        } catch(IOException ex){
            ex.printStackTrace();
            return false;
        }
    }
    
    public void FileEditStage(FileEntity entity){
      
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(FileProject.class.getResource("fileMain.fxml"));
            AnchorPane pane = (AnchorPane)loader.load();
            Scene scene = new Scene(pane);
            primarystage.setScene(scene);
            primarystage.centerOnScreen();
            
            FileMainController controller = loader.getController();
            controller.setFile(entity);
            controller.setMainApp(this);
            
            
        } catch (IOException ex) {
            Logger.getLogger(FileProject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void helpStage(String values){
        try {
             FXMLLoader loader = new FXMLLoader();
        loader.setLocation(FileProject.class.getResource("help.fxml"));
            AnchorPane layout = (AnchorPane) loader.load();
            Scene scene = new Scene(layout);
            primarystage.setScene(scene);
            primarystage.centerOnScreen();
            
            HelpController controller = loader.getController();
            controller.editTextArea(values);
            controller.setApp(this);
            
        } catch (IOException ex) {
            Logger.getLogger(FileProject.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
    
    
    
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
