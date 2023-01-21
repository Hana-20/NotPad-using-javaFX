package lab2;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;

public class NotePad extends BorderPane {

    protected final MenuBar menuBar;
    protected final Menu fileMenu;
    protected final MenuItem newItem;
    protected final MenuItem openItem;
    protected final MenuItem saveItem;
    protected final MenuItem exitItem;
    protected final Menu editMenu;
    protected final MenuItem undoItem;
    protected final MenuItem cutItem;
    protected final MenuItem copyItem;
    protected final MenuItem pasteItem;
    protected final MenuItem deleteItem;
    protected final MenuItem selectAllItem;
    protected final Menu helpMenu;
    protected final MenuItem aboutItem;
    protected final TextArea textArea;

    public NotePad() {

        menuBar = new MenuBar();
        fileMenu = new Menu();
        newItem = new MenuItem();
        openItem = new MenuItem();
        saveItem = new MenuItem();
        exitItem = new MenuItem();
        editMenu = new Menu();
        undoItem = new MenuItem();
        cutItem = new MenuItem();
        copyItem = new MenuItem();
        pasteItem = new MenuItem();
        deleteItem = new MenuItem();
        selectAllItem = new MenuItem();
        helpMenu = new Menu();
        aboutItem = new MenuItem();
        textArea = new TextArea();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(menuBar, javafx.geometry.Pos.CENTER);

        fileMenu.setMnemonicParsing(false);
        fileMenu.setText("File");

        newItem.setMnemonicParsing(false);
        newItem.setText("New");
        newItem.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN));

        openItem.setMnemonicParsing(false);
        openItem.setText("Open");
        openItem.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN));

        saveItem.setMnemonicParsing(false);
        saveItem.setText("Save");
        saveItem.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));

        exitItem.setMnemonicParsing(false);
        exitItem.setText("Exit");

        editMenu.setMnemonicParsing(false);
        editMenu.setText("Edit");

        undoItem.setMnemonicParsing(false);
        undoItem.setText("Undo");

        cutItem.setMnemonicParsing(false);
        cutItem.setText("Cut");

        copyItem.setMnemonicParsing(false);
        copyItem.setText("Copy");
        
        pasteItem.setMnemonicParsing(false);
        pasteItem.setText("Paste");
        
        deleteItem.setMnemonicParsing(false);
        deleteItem.setText("Delete");

        selectAllItem.setMnemonicParsing(false);
        selectAllItem.setText("Select All");

        helpMenu.setMnemonicParsing(false);
        helpMenu.setText("Help");

        aboutItem.setMnemonicParsing(false);
        aboutItem.setText("About NotePad");
        setTop(menuBar);

        BorderPane.setAlignment(textArea, javafx.geometry.Pos.CENTER);
        textArea.setPrefHeight(200.0);
        textArea.setPrefWidth(200.0);
        setCenter(textArea);

        fileMenu.getItems().add(newItem);
        fileMenu.getItems().add(openItem);
        fileMenu.getItems().add(saveItem);
        fileMenu.getItems().add(exitItem);
        menuBar.getMenus().add(fileMenu);
        editMenu.getItems().add(undoItem);
        editMenu.getItems().add(cutItem);
        editMenu.getItems().add(copyItem);
        editMenu.getItems().add(pasteItem);
        editMenu.getItems().add(deleteItem);
        editMenu.getItems().add(selectAllItem);
        menuBar.getMenus().add(editMenu);
        helpMenu.getItems().add(aboutItem);
        menuBar.getMenus().add(helpMenu);

    }
}
