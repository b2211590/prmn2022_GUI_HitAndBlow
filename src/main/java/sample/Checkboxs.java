package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Checkboxs extends Application {

    CheckBox checkboxs1 = new CheckBox("丼もの");
    CheckBox checkboxs2 = new CheckBox("麺類");
    CheckBox checkboxs3 = new CheckBox("ランチ");
    Label label = new Label();

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Checkboxs");
        stage.setHeight(150);
        stage.setWidth(230);

        checkboxs1.setOnAction( event -> setLabelText() );
        checkboxs2.setOnAction( event -> setLabelText() );
        checkboxs3.setOnAction( event -> setLabelText() );

        VBox root = new VBox();
        root.setSpacing(10);
        root.getChildren().addAll(checkboxs1, checkboxs2, checkboxs3, label);

        stage.setScene(new Scene(root));
        stage.show();
    }

    void setLabelText(){
        String s = "";
        if (checkboxs1.isSelected()){
            s = checkboxs1.getText();
        }
        if (checkboxs2.isSelected()){
            s += " " + checkboxs2.getText();
        }
        if (checkboxs3.isSelected()){
            s += " " + checkboxs3.getText();
        }
        label.setText("オーダー：" + s);
    }
}
