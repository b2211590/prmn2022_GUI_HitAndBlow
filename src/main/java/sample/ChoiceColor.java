package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ChoiceColor extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Choice");
        stage.setWidth(280);
        stage.setHeight(180);

        Rectangle rect = new Rectangle(200,200);

        ChoiceBox<String> cb = new ChoiceBox<>();
        cb.getItems().addAll("RED", "BLUE", "GREEN", "YELLOW");
        cb.getSelectionModel().selectedItemProperty().addListener(
                (ov, old_val, new_val) -> rect.setFill(Color.valueOf(cb.getValue())));
        cb.getSelectionModel().selectFirst();

        HBox root = new HBox();
        root.getChildren().addAll(cb, rect);

        stage.setScene(new Scene(root));
        stage.show();
    }
}
