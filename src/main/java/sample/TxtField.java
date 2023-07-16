package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TxtField extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("TxtField");
        stage.setHeight(160);
        stage.setWidth(240);

        TextField textField = new TextField();

        Label label = new Label();
        label.textProperty().bind(textField.textProperty());

        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10,10,10,10));
        root.setSpacing(10.0);
        root.getChildren().addAll(textField, label);

        stage.setScene(new Scene(root));
        stage.show();
    }
}
