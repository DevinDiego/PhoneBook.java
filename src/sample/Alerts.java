package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Alerts {

    // A confirmation scene to ensure the user really wants to delete a selected row.
    public static void deleteConfirmation() {
        BorderPane borderPane1 = new BorderPane();
        Button confirm = new Button("Confirm Deletion");
        Button cancel = new Button("Cancel");
        Label label = new Label("Are you sure!");
        label.setFont(Font.font(14));
        HBox hBox = new HBox(label, confirm, cancel);
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(hBox, Pos.CENTER);
        borderPane1.setCenter(hBox);
        Stage stage = new Stage();
        stage.setTitle("ALERT ALERT ALERT");
        Scene scene = new Scene(borderPane1, 300, 200);
        stage.setScene(scene);
        stage.show();
        // confirmation confirm button event.
        confirm.setOnAction(actionEvent12 -> {
            Main.deleteRecord();
            stage.close();
        });
        // confirmation cancel button actionEvent.
        cancel.setOnAction(actionEvent1 -> stage.close());
    }

    // An alert scene to handle if the table is empty or a row has not been properly selected.
    public static void ifTableEmptyRowNotSelected(String alert) {
        BorderPane borderPane1 = new BorderPane();
        Button cancel = new Button("Cancel");
        Label label = new Label(alert);
        label.setFont(Font.font(14));
        HBox hBox = new HBox(label, cancel);
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(hBox, Pos.CENTER);
        borderPane1.setCenter(hBox);
        Stage stage = new Stage();
        stage.setTitle("ALERT ALERT ALERT");
        Scene scene = new Scene(borderPane1, 500, 200);
        stage.setScene(scene);
        stage.show();
        // cancel actionEvent
        cancel.setOnAction(actionEvent1 -> stage.close());
    }
}
