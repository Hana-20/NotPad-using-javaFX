/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Events {

    FileChooser fileChooser;

    public Events() {
        fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter( ".txt","*.txt*"));
    }

    public void newButton(Stage stage, TextArea txt) {
        if (!txt.getText().equals("")) {
            ButtonType save = new ButtonType("Save", ButtonBar.ButtonData.OK_DONE);
            ButtonType noSave = new ButtonType("Don't Save", ButtonBar.ButtonData.NO);
            ButtonType close = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you Want to save Changes", save, noSave, close);
            alert.setTitle("Save");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get().getText() == "Save") {
                saveButton(stage, txt);
            } else if (result.isPresent() && result.get().getText() == "Cancel") {
                return;
            }
        }
        txt.setText("");
    }

    public void saveButton(Stage primaryStage, TextArea txt) {
        FileOutputStream fos = null;
        try {
            fileChooser.setTitle("Save");
            File file = fileChooser.showSaveDialog(primaryStage);
            if(file!=null){
            fos = new FileOutputStream(file.getAbsolutePath());
            byte[] b = txt.getText().getBytes();
            fos.write(b);
            fos.close();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NotePad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(NotePad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void openButton(Stage stage, TextArea txt) {
        FileInputStream fis = null;
        try {
            fileChooser.setTitle("Open");
            File file = fileChooser.showOpenDialog(stage);
            if(file!=null){
            fis = new FileInputStream(file.getAbsolutePath());
            int size = fis.available();
            byte[] b = new byte[size];
            fis.read(b);
            txt.setText(new String(b));
            }
        } catch (FileNotFoundException ex) {
           Logger.getLogger(NotePad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(NotePad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void helpButton() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Look, an Information Dialog");
        alert.setContentText("I can help you!");
        alert.showAndWait();
    }
}
