package sample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    private static final TableView<TableHelper> tableView = CreateTable.createTable();

    @Override
    public void start(Stage primaryStage) {

        // Call constructor
        TableHelper tableHelper = new TableHelper();
        tableView.refresh();

        // Create BorderPane
        BorderPane borderPane = new BorderPane();

        // Create MenuBar
        MenuBar menuBar = new MenuBar();
        menuBar.setPrefWidth(800);

        // Create menuBar menus
        Menu file = new Menu("File");
        Menu edit = new Menu("Edit");

        // Create menuBar menu menuItems
        MenuItem fileNewPhoneBook = new MenuItem("New Phone Book");
        MenuItem fileExit = new MenuItem("Exit");
        MenuItem editAdd = new MenuItem("Add");
        MenuItem editModify = new MenuItem("Modify");
        MenuItem editDelete = new MenuItem("Delete");

        // Add menuItems to menu
        file.getItems().addAll(fileNewPhoneBook, fileExit);
        edit.getItems().addAll(editAdd, editModify, editDelete);

        // Add menu to MenuBar
        menuBar.getMenus().addAll(file, edit);

        // Add menuBar to HBox
        HBox menuHbox = new HBox(menuBar);

        /************************** ALL ACTION EVENTS ****************************/
        // Show table in borderPane after clicking file/New Phone Book Record
        fileNewPhoneBook.setOnAction(actionEvent -> borderPane.setCenter(tableView));

        // Exit stage after clicking file/Exit
        fileExit.setOnAction(actionEvent -> primaryStage.close());

        // Show add record form after clicking Edit/Add
        editAdd.setOnAction(actionEvent -> AddRecord.addRecord(tableView));

        // Show modify record form after clicking Edit/Modify
        editModify.setOnAction(actionEvent -> {
            // Determine if any records exist in table.
            ObservableList<TableHelper> items = tableView.getItems();
            // If no records are found.
            if (items.isEmpty()) {
                Alerts.ifTableEmptyRowNotSelected("Table is empty, press cancel to exit!");
                // If record has not been selected.
            } else if (tableView.getSelectionModel().getSelectedItem() == null) {
                Alerts.ifTableEmptyRowNotSelected("Please select a record, press cancel to exit!");
                // Modify record as intended.
            } else {
                ModifyRecord.modifyRecord(tableView);
            }
        });

        // Show confirmation scene after clicking Edit/Delete
        editDelete.setOnAction(actionEvent -> {
            // Determine if any records exist in table.
            ObservableList<TableHelper> items = tableView.getItems();
            // If no records are found.
            if (items.isEmpty()) {
                Alerts.ifTableEmptyRowNotSelected("Table is empty, press cancel to exit!");
                // If record has not been selected.
            } else if (tableView.getSelectionModel().getSelectedItem() == null) {
                Alerts.ifTableEmptyRowNotSelected("Please select a record, press cancel to exit!");
                // Delete as intended.
            } else {
                Alerts.deleteConfirmation();
            }
        });
        /*************************** END ACTION EVENTS ******************************/


        // Text at bottom of table | set the font
        Label numRecords = new Label("Number of Phone Books Records: " + tableView.getItems().size());
        numRecords.setFont(Font.font(14));

        HBox numRecordsHbox = new HBox(numRecords);

        borderPane.setTop(menuHbox);
        borderPane.setBottom(numRecordsHbox);

        Scene scene = new Scene(borderPane, 800, 600);
        primaryStage.setTitle("Phone Book");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Helper function to delete a selected record
    public static void deleteRecord() {
        tableView.getItems().removeAll(tableView.getSelectionModel().getSelectedItem());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
