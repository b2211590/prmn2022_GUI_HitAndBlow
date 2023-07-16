package HandB;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HABTitleController {

    @FXML
    private Button startBtn;

    @FXML
    protected void onClickedStartBtn(){
        startBtn.getScene().getWindow().hide();
        Screen screen = new Screen();
        screen.transitionScreen("Main.fxml", "ヒットアンドブロー");
    }
}
