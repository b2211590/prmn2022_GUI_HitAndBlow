package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TxtArea extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("TxtArea");
        stage.setWidth(360);
        stage.setHeight(300);

        TextArea textArea = new TextArea();
        textArea.setPrefRowCount(5);
        textArea.setPrefColumnCount(20);
        textArea.setText("複数行の文字列\n2\n3\n4\n5\n6");

        TextArea displayArea = new TextArea();
        displayArea.setPrefRowCount(5);
        displayArea.setPrefColumnCount(20);

        displayArea.setEditable(false);
        displayArea.textProperty().bind(textArea.textProperty());

        VBox root;
        root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10,10,10,10));
        root.setSpacing(20.0);
        root.getChildren().addAll(textArea, displayArea);

        stage.setScene(new Scene(root));
        stage.show();
    }
}
