package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Ex2 extends Application {

    Label lblMsg = new Label("Hello, Java!");

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Ex2");
        stage.setHeight(300);
        stage.setWidth(800);

        Button btn = new Button("ADD FX");
        btn.setPrefWidth(80);
        btn.setOnMouseClicked(event -> updatelblMsg(stage));

        lblMsg.setFont(new Font(100));

        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(2,2,2,2));
        root.setSpacing(5.0);
        root.getChildren().addAll(lblMsg, btn);

        stage.setScene(new Scene(root));
        stage.show();

    }

    void updatelblMsg(Stage stage){
        lblMsg.setText("Hello, JavaFX!");
    }
}
