package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Scanner;

public class Ex3 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Ex3");
        stage.setHeight(500);
        stage.setWidth(800);

        Label lblMsg = new Label("Entry Accessed.");
        lblMsg.setFont(new Font(80));

        stage.setScene(new Scene(lblMsg));
        stage.show();
    }


    public static void main(String[] args) {
        System.out.print("Input password:");

        Scanner input = new Scanner(System.in);
        String value = input.nextLine();

        if(!(value.equals("Password"))){
            System.out.println(">Your entry is not accessed.");
            System.exit(1);
        }

        Application.launch();
    }

}
