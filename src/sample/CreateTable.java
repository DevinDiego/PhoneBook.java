package sample;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CreateTable {

    public static TableView<TableHelper> createTable() {

        // Instantiate TableView
        TableView<TableHelper> tableView = new TableView<>();

        // Create Table columns
        TableColumn<TableHelper, String> lastNameColumn = new TableColumn<>("Last Name");
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        lastNameColumn.setPrefWidth(160);

        TableColumn<TableHelper, String> firstNameColumn = new TableColumn<>("First Name");
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        firstNameColumn.setPrefWidth(160);

        TableColumn<TableHelper, String> homePhoneColumn = new TableColumn<>("Home Phone");
        homePhoneColumn.setCellValueFactory(new PropertyValueFactory<>("homePhone"));
        homePhoneColumn.setPrefWidth(160);

        TableColumn<TableHelper, String> workPhoneColumn = new TableColumn<>("Work Phone");
        workPhoneColumn.setCellValueFactory(new PropertyValueFactory<>("workPhone"));
        workPhoneColumn.setPrefWidth(160);

        TableColumn<TableHelper, String> mobilePhoneColumn = new TableColumn<>("Mobile Phone");
        mobilePhoneColumn.setCellValueFactory(new PropertyValueFactory<>("mobilePhone"));
        mobilePhoneColumn.setPrefWidth(160);

        tableView.getColumns().add(lastNameColumn);
        tableView.getColumns().add(firstNameColumn);
        tableView.getColumns().add(homePhoneColumn);
        tableView.getColumns().add(workPhoneColumn);
        tableView.getColumns().add(mobilePhoneColumn);

        return tableView;
    }
}
