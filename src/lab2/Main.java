/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package lab2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author hana
 */
public class Main extends Application {
    Events e=new Events();
    @Override
    public void start(Stage stage) {
        NotePad root = new NotePad();
        root.newItem.setOnAction((ActionEvent event)->e.newButton(stage, root.textArea));
        //open reading from file
        root.openItem.setOnAction((ActionEvent event)->e.openButton( stage, root.textArea)); 
        //save in to file
        root.saveItem.setOnAction((ActionEvent event)->e.saveButton(stage,root.textArea)); 
        //exit
        root.exitItem.setOnAction((ActionEvent event)->stage.close()); 
        //undo
        root.undoItem.setOnAction((ActionEvent event)->root.textArea.undo()); 
        //cut
        root.cutItem.setOnAction((ActionEvent event)->root.textArea.cut());
        //copy
        root.copyItem.setOnAction((ActionEvent event)-> root.textArea.copy());
        root.pasteItem.setOnAction((ActionEvent event)-> root.textArea.paste());
        //delete
        root.deleteItem.setOnAction((ActionEvent event)->
                                root.textArea.setText(root.textArea.getText().replace(root.textArea.getSelectedText(), " ")));
       root.selectAllItem.setOnAction((ActionEvent event)->root.textArea.selectAll());
        root.aboutItem.setOnAction((ActionEvent event)-> e.helpButton());
 
        Scene scene = new Scene(root, 300, 250);
        
        stage.setTitle("NotePad");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
