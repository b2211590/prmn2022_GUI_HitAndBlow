package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class prefMax extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("prefMax");
        stage.setWidth(220);
        stage.setHeight(200);

        Button button1 = new Button("Pref = 80");
        button1.setPrefWidth(80);

        Button button2 = new Button("Min = 120");
        button2.setMinWidth(120);

        Button button3 = new Button("Pref = 260");
        button3.setPrefWidth(260);

        Button button4 = new Button("Min = 260");
        button4.setMinWidth(260);

        Button button5 = new Button("Min,Max = 120");
        button5.setMinWidth(120);
        button5.setMaxWidth(120);

        Label label = new Label();

        VBox root = new VBox(2);
        root.getChildren().addAll(button1, button2, button3, button4, button5, label);

        label.textProperty().bind(stage.widthProperty().asString());

        stage.setScene(new Scene(root));
        stage.show();
    }
}
