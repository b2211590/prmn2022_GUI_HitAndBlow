package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

class MsgBox extends Stage{
    public MsgBox(Window wnd, String msg){
        setTitle("DispMsgBox");
        initStyle(StageStyle.UTILITY);
        initOwner(wnd);
        initModality(Modality.APPLICATION_MODAL);

        Label lbl = new Label();
        lbl.setPrefWidth(160);
        lbl.setText(msg);

        Button btnOK = new Button("OK");
        btnOK.setPrefWidth(80);
        btnOK.setOnAction(event -> this.close());

        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setSpacing(20.0);
        root.getChildren().addAll(lbl, btnOK);

        setScene(new Scene(root));
    }
}

public class DispMsgBox extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("DispMsgBox");
        stage.setWidth(240);
        stage.setHeight(120);

        Label lblMsg = new Label("Hello, JavaFX!");
        lblMsg.setFont(new Font(20));

        Button btnOk = new Button("表示");
        btnOk.setPrefWidth(80);
        btnOk.setOnAction(event -> onClick(stage));

        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setSpacing(20.0);
        root.getChildren().addAll(lblMsg, btnOk);

        stage.setScene(new Scene(root));
        stage.show();
    }
    void onClick(Stage stage){
        Window wnd = stage;
        Stage msgBox = new MsgBox(wnd, "Hello, JavaFX!!");
        msgBox.show();
    }
}


