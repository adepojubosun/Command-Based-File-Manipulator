/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileproject.main;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author bosun
 */
public class Alert {

    private Stage window;
    private Label label;
    private Scene scene;
    private Button button;
    private VBox layout;

    public Alert(){
        
    }
    
    
    
    public void display(String title, String message) {
        window = new Stage();
        
        window.setTitle(title);
        window.initModality(Modality.WINDOW_MODAL);
        window.setResizable(false);
         window.setHeight(70);
         window.setWidth(320);
        label = new Label(message);
        
         
        button = new Button("OK");
        button.alignmentProperty().set(Pos.CENTER);
        label.alignmentProperty().set(Pos.CENTER);

        button.setOnAction(e -> window.close());
        button.setOnKeyPressed(e -> window.close());

        layout = new VBox(20);
        layout.prefHeight(200);
        layout.prefWidth(320);
        
        layout.getChildren().addAll(label, button);
        
        scene = new Scene(layout);
      
        window.setScene(scene);
        window.centerOnScreen();
        window.showAndWait();
        
       
           
       

    }

}
