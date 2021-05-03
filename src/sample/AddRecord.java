package sample;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AddRecord {

    public static void addRecord(TableView<TableHelper> tableView) {
        // Form labels
        Label FName = labelCreator("First Name:");
        Label LName = labelCreator("Last Name:");
        Label HPhone = labelCreator("Home Phone:");
        Label WPhone = labelCreator("Work Phone:");
        Label MPhone = labelCreator("Mobile Phone:");

        // Form TextFields
        TextField first_name = new TextField();
        TextField last_name = new TextField();
        TextField home_phone = new TextField();
        TextField work_phone = new TextField();
        TextField mobile_phone = new TextField();

        // Form description
        Text infoText = new Text("Enter Phone Book Record Information");
        infoText.setFont(Font.font(15));

        // Separator | width | padding
        Separator separatorTop = new Separator(Orientation.HORIZONTAL);
        separatorTop.setMaxWidth(350);
        separatorTop.setPadding(new Insets(9, 0, 0, 0));

        // Add text and separator to VBox | vGrow | margin | align left
        VBox vBoxForTextAndSeparator = new VBox(infoText, separatorTop);
        VBox.setVgrow(vBoxForTextAndSeparator, Priority.ALWAYS);
        VBox.setMargin(infoText, new Insets(7));
        vBoxForTextAndSeparator.setAlignment(Pos.CENTER_LEFT);

        // Add elements to gridPane
        GridPane gridPane = new GridPane();
        gridPane.add(FName, 0, 0);
        gridPane.add(LName, 0, 1);
        gridPane.add(HPhone, 0, 2);
        gridPane.add(WPhone, 0, 3);
        gridPane.add(MPhone, 0, 4);
        gridPane.add(first_name, 1, 0);
        gridPane.add(last_name, 1, 1);
        gridPane.add(home_phone, 1, 2);
        gridPane.add(work_phone, 1, 3);
        gridPane.add(mobile_phone, 1, 4);

        // Make gridPane adjustments
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        // Separator above buttons | width
        Separator separatorAboveButtons = new Separator(Orientation.HORIZONTAL);
        separatorAboveButtons.setMaxWidth(280);

        // Buttons ok and cancel
        Button OK = new Button("OK");
        Button Cancel = new Button("Cancel");

        // Add buttons to HBox | align right | spacing | padding
        HBox hBoxButtons = new HBox(OK, Cancel);
        hBoxButtons.setAlignment(Pos.BASELINE_RIGHT);
        hBoxButtons.setSpacing(5);
        hBoxButtons.setPadding(new Insets(10));

        // Add separator and buttons to VBox | align center | margin
        VBox vBoxBottomSection = new VBox(separatorAboveButtons, hBoxButtons);
        vBoxBottomSection.setAlignment(Pos.CENTER);
        BorderPane.setMargin(vBoxForTextAndSeparator, new Insets(10, 0, 0, 0));

        // Add layouts to BorderPane
        BorderPane borderPane1 = new BorderPane();
        borderPane1.setTop(vBoxForTextAndSeparator);
        borderPane1.setCenter(gridPane);
        borderPane1.setBottom(vBoxBottomSection);

        // Scene | stage | resizeable false
        Stage newPhoneBookStage = new Stage();
        newPhoneBookStage.setTitle("Add New Phone Book Records");
        newPhoneBookStage.setResizable(false);
        Scene sceneNewPhoneBook = new Scene(borderPane1, 350, 275);
        newPhoneBookStage.setScene(sceneNewPhoneBook);
        newPhoneBookStage.show();

        // OK button event | add input to table
        OK.setOnAction(actionEvent -> {
            // Add to table
            TableHelper tableHelper = new TableHelper();
            tableHelper.setLastName(last_name.getText());
            tableHelper.setFirstName(first_name.getText());
            tableHelper.setHomePhone(home_phone.getText());
            tableHelper.setWorkPhone(work_phone.getText());
            tableHelper.setMobilePhone(mobile_phone.getText());
            tableView.getItems().addAll(tableHelper);
            newPhoneBookStage.close();
        });

        // Cancel button event | close stage
        Cancel.setOnAction(actionEvent -> newPhoneBookStage.close());
    }

    // Short cut for creating labels
    public static Label labelCreator(String text) {
        Label label = new Label(text);
        label.setFont(Font.font(16));
        return label;
    }
}
