package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Ex1 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("名前を表示しちゃうよ");
        stage.setHeight(500);
        stage.setWidth(800);

        String str = "田村 跳飛";
        Label lblMsg = new Label("私の名前は " + str);
        lblMsg.setFont(new Font(80));
        stage.setScene(new Scene(lblMsg));

        stage.show();
    }
}
