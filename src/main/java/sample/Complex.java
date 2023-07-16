package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Complex extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Complex");

        //top
        Button topBtn[] = new Button[5];
        for (int i = 0; i < 5; i++) {
            topBtn[i] = new Button(Integer.toString(i));
            topBtn[i].setPrefWidth(60);
        }
        HBox top = new HBox();
        top.setAlignment(Pos.CENTER);
        top.setSpacing(10);
        top.setPadding(new Insets(5, 5, 5, 5));
        top.getChildren().addAll(topBtn);

        //left
        VBox left = new VBox();
        GridPane grid = new GridPane();
        TextField txtFld[] = new TextField[9];
        for (int i = 0; i < 9; i++) {
            txtFld[i] = new TextField(Integer.toString(i));
            txtFld[i].setPrefWidth(40);
            GridPane.setConstraints(txtFld[i], i/3, i%3);
            txtFld[i].setEditable(false);
        }
        grid.setAlignment(Pos.TOP_LEFT);
        grid.getChildren().addAll(txtFld);
        TextArea textArea = new TextArea();
        textArea.setPrefRowCount(5);
        textArea.setPrefColumnCount(8);
        left.getChildren().addAll(grid, textArea);

        //right
        TextArea right = new TextArea();
        right.setPrefColumnCount(10);
        right.setPrefColumnCount(20);

        //bottom
        HBox bottom = new HBox();
        bottom.getChildren().addAll(left, right);

        //root
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(5, 5, 5, 5));
        root.setSpacing(3.0);
        root.getChildren().addAll(top, bottom);

        stage.setScene(new Scene(root));
        stage.show();

    }
}
