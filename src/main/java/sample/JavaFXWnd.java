package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class JavaFXWnd extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage){

        stage.setTitle("Hello, JavaFX!");
        stage.setWidth(540);
        stage.setHeight(220);
        Label lblMsg = new Label("Hello, JavaFX!");
        lblMsg.setFont(new Font(90));
        stage.setScene(new Scene(lblMsg));
        stage.show();
    }

    public void init(){
        System.out.println("初期化します.");
    }
    public void stop(){
        System.out.println("正常に終了しました.");
    }
}
