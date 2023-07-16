package HandB;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class HABMainController {

    //ゲームを始める
    GameMaster master = new GameMaster();

    // 塗り替えたいボールが選択されると代入される変数
    private Circle selectedBall = null;
    // 塗り替えたい色が選択されると代入される 変数
    private Circle selectedColor = null;

    private boolean isFinished = false;

    private final ArrayList<Color> ballTryColor = new ArrayList<>();

    private final ArrayList<VBox> gameAreas = new ArrayList<>();
    private final ArrayList<Label> txtHits = new ArrayList<>();
    private final ArrayList<Label> txtBlows = new ArrayList<>();

    private final ArrayList<Circle> ballAs = new ArrayList<>();
    private final ArrayList<Circle> ballBs = new ArrayList<>();
    private final ArrayList<Circle> ballCs = new ArrayList<>();
    private final ArrayList<Circle> ballDs = new ArrayList<>();

    Glow glow = new Glow(0.8);
    Glow glowReset = new Glow(0);

    @FXML
    private Button colorUpdateBtn;

    // 塗り替えたいボールと色が選択されている時にボタンが押されると、塗り変わる
    // 同時に選択がリセットされる
    @FXML
    protected void onClickedColorUpdateBtn(){
        if (selectedBall != null && selectedColor != null){
            selectedColor.setEffect(glowReset);
            selectedBall.setFill(selectedColor.getFill());
        }

        else if (selectedBall != null){
            selectedBall.setFill(Color.WHITE);
        }

        else if (selectedColor != null){
            selectedColor.setEffect(glowReset);
        }

        selectedBall = null;
        selectedColor = null;
    }

    @FXML
    private Button dicisionBtn;

    @FXML
    protected void onClickedDicisionBtn(){
        // 初期化
        setTxtHits();
        setTxtBlows();
        setGameAreas();
        setBallTryColor();

        if (isFinished){
            System.exit(0);
        }
        if (hasNonSelected()) {
            // 意図していない挙動避け
            Alert alert = new Alert(Alert.AlertType.WARNING, "4つ埋めてから判定せよ！");
            alert.show();

        } else if(hasMultiColor()){
            // 意図していない挙動避け
            Alert alert = new Alert(Alert.AlertType.WARNING, "4種類の色を使って判定せよ！");
            alert.show();

        } else {


            // 次のターンに進む
            master.goNextTurn();

            // 判定
            master.setTrial(ballTryColor);
            master.countHAndB();
            final int numberOfHits = master.getNumberOfHits();
            final int numberOfBlows = master.getNumberOfBlows();

            // 画面更新
            // ヒット数とブロー数表示更新
            Label properTxtHit = txtHits.get(master.getTurnCounter() - 2);
            Label properTxtBlow = txtBlows.get(master.getTurnCounter() - 2);
            properTxtHit.setText(String.valueOf(numberOfHits));
            properTxtBlow.setText(String.valueOf(numberOfBlows));

            if (master.getTurnCounter() == 9){
                finishGame("失敗..", Color.BLUE);
            }

            else if(numberOfHits == 4) {
                finishGame("成功！", Color.RED);
            }

            else {
                // 操作不可能部分の更新
                // 透明度の更新
                for (VBox gameArea :gameAreas){
                    gameArea.setDisable(true);
                    gameArea.setOpacity(0.25);
                }
                VBox properGameArea = gameAreas.get(master.getTurnCounter() - 1);
                properGameArea.setDisable(false);
                properGameArea.setOpacity(1.0);
            }

        }
    }

    private void setGameAreas(){
        gameAreas.add(gameArea1);
        gameAreas.add(gameArea2);
        gameAreas.add(gameArea3);
        gameAreas.add(gameArea4);
        gameAreas.add(gameArea5);
        gameAreas.add(gameArea6);
        gameAreas.add(gameArea7);
        gameAreas.add(gameArea8);
    }

    private void setTxtHits(){
        txtHits.add(txtHit1);
        txtHits.add(txtHit2);
        txtHits.add(txtHit3);
        txtHits.add(txtHit4);
        txtHits.add(txtHit5);
        txtHits.add(txtHit6);
        txtHits.add(txtHit7);
        txtHits.add(txtHit8);
    }

    private void setTxtBlows(){
        txtBlows.add(txtBlow1);
        txtBlows.add(txtBlow2);
        txtBlows.add(txtBlow3);
        txtBlows.add(txtBlow4);
        txtBlows.add(txtBlow5);
        txtBlows.add(txtBlow6);
        txtBlows.add(txtBlow7);
        txtBlows.add(txtBlow8);
    }

    private void setBallAs(){
        ballAs.add(ballTryA1);
        ballAs.add(ballTryA2);
        ballAs.add(ballTryA3);
        ballAs.add(ballTryA4);
        ballAs.add(ballTryA5);
        ballAs.add(ballTryA6);
        ballAs.add(ballTryA7);
        ballAs.add(ballTryA8);
    }

    private void setBallBs(){
        ballBs.add(ballTryB1);
        ballBs.add(ballTryB2);
        ballBs.add(ballTryB3);
        ballBs.add(ballTryB4);
        ballBs.add(ballTryB5);
        ballBs.add(ballTryB6);
        ballBs.add(ballTryB7);
        ballBs.add(ballTryB8);
    }

    private void setBallCs(){
        ballCs.add(ballTryC1);
        ballCs.add(ballTryC2);
        ballCs.add(ballTryC3);
        ballCs.add(ballTryC4);
        ballCs.add(ballTryC5);
        ballCs.add(ballTryC6);
        ballCs.add(ballTryC7);
        ballCs.add(ballTryC8);
    }

    private void setBallDs() {
        ballDs.add(ballTryD1);
        ballDs.add(ballTryD2);
        ballDs.add(ballTryD3);
        ballDs.add(ballTryD4);
        ballDs.add(ballTryD5);
        ballDs.add(ballTryD6);
        ballDs.add(ballTryD7);
        ballDs.add(ballTryD8);
    }

    private void setBallTryColor(){
        ballTryColor.clear();
        setBallAs();
        setBallBs();
        setBallCs();
        setBallDs();

        Circle properBallTryA = ballAs.get(master.getTurnCounter() - 1);
        Circle properBallTryB = ballBs.get(master.getTurnCounter() - 1);
        Circle properBallTryC = ballCs.get(master.getTurnCounter() - 1);
        Circle properBallTryD = ballDs.get(master.getTurnCounter() - 1);

        ballTryColor.add((Color) properBallTryA.getFill());
        ballTryColor.add((Color) properBallTryB.getFill());
        ballTryColor.add((Color) properBallTryC.getFill());
        ballTryColor.add((Color) properBallTryD.getFill());

        // 開発用
        for (int i = 0; i < 4; i++) {
            String colorHexadecimal = ballTryColor.get(i).toString();
            switch (colorHexadecimal) {
                case "0x0000ffff":
                    System.out.println("try_blue");
                    break;
                case "0xff0000ff":
                    System.out.println("try_red");
                    break;
                case "0x008000ff":
                    System.out.println("try_green");
                    break;
                case "0xffff00ff":
                    System.out.println("try_yellow");
                    break;
                case "0xffc0cbff":
                    System.out.println("try_pink");
                    break;
                case "0xffa500ff":
                    System.out.println("try_orange");
                    break;
                case "0xffffffff":
                    System.out.println("try_white");
                    break;
                case "0x1e90ffff":
                    System.out.println("try_dodgerblue");
                    break;
                default:
                    System.out.println("try_?????");
                    break;
            }
        }
    }

    public boolean hasNonSelected(){
        return ballTryColor.contains(Color.WHITE) || ballTryColor.contains(Color.DODGERBLUE);
    }

    public boolean hasMultiColor(){
        boolean bool = false;
        for (int i = 0; i < 4; i++) {
            int lastIndex = ballTryColor.lastIndexOf(ballTryColor.get(i));
            if (lastIndex != i){
                bool = true;
            }
        }
        return bool;
    }

    public void finishGame(String msg, Color color){
        ballAnsA.setFill(master.getAnswer().get(0));
        ballAnsB.setFill(master.getAnswer().get(1));
        ballAnsC.setFill(master.getAnswer().get(2));
        ballAnsD.setFill(master.getAnswer().get(3));

        isFinished = true;

        txtFinish.setText(msg);
        txtFinish.setTextFill(color);
        dicisionBtn.setText("終了");

        colorUpdateBtn.setDisable(true);
        ballBlue.setDisable(true);
        ballRed.setDisable(true);
        ballYellow.setDisable(true);
        ballGreen.setDisable(true);
        ballPink.setDisable(true);
        ballOrange.setDisable(true);
    }

    //ここからゲームゾーンの処理

    @FXML
    private VBox gameArea1;
    @FXML
    private Label txtHit1;
    @FXML
    private Label txtBlow1;

    @FXML
    private VBox gameArea2;
    @FXML
    private Label txtHit2;
    @FXML
    private Label txtBlow2;

    @FXML
    private VBox gameArea3;
    @FXML
    private Label txtHit3;
    @FXML
    private Label txtBlow3;

    @FXML
    private VBox gameArea4;
    @FXML
    private Label txtHit4;
    @FXML
    private Label txtBlow4;

    @FXML
    private VBox gameArea5;
    @FXML
    private Label txtHit5;
    @FXML
    private Label txtBlow5;

    @FXML
    private VBox gameArea6;
    @FXML
    private Label txtHit6;
    @FXML
    private Label txtBlow6;

    @FXML
    private VBox gameArea7;
    @FXML
    private Label txtHit7;
    @FXML
    private Label txtBlow7;

    @FXML
    private VBox gameArea8;
    @FXML
    private Label txtHit8;
    @FXML
    private Label txtBlow8;

    @FXML
    private Label txtFinish;

    @FXML
    private Circle ballAnsA;
    @FXML
    private Circle ballAnsB;
    @FXML
    private Circle ballAnsC;
    @FXML
    private Circle ballAnsD;

    @FXML
    private Circle ballTryA1;
    @FXML
    protected void onClickedBT_A1(){
        if (selectedBall != null){
            selectedBall.setFill(Color.WHITE);
        }
        ballTryA1.setFill(Color.DODGERBLUE);
        selectedBall = ballTryA1;
    }

    @FXML
    private Circle ballTryB1;
    @FXML
    protected void onClickedBT_B1(){
        if (selectedBall != null){
            selectedBall.setFill(Color.WHITE);
        }
        ballTryB1.setFill(Color.DODGERBLUE);
        selectedBall = ballTryB1;
    }

    @FXML
    private Circle ballTryC1;
    @FXML
    protected void onClickedBT_C1(){
        if (selectedBall != null){
            selectedBall.setFill(Color.WHITE);
        }
        ballTryC1.setFill(Color.DODGERBLUE);
        selectedBall = ballTryC1;
    }

    @FXML
    private Circle ballTryD1;
    @FXML
    protected void onClickedBT_D1(){
        if (selectedBall != null){
            selectedBall.setFill(Color.WHITE);
        }
        ballTryD1.setFill(Color.DODGERBLUE);
        selectedBall = ballTryD1;
    }

    @FXML
    private Circle ballTryA2;
    @FXML
    protected void onClickedBT_A2(){
        if (selectedBall != null){
            selectedBall.setFill(Color.WHITE);
        }
        ballTryA2.setFill(Color.DODGERBLUE);
        selectedBall = ballTryA2;
    }

    @FXML
    private Circle ballTryB2;
    @FXML
    protected void onClickedBT_B2(){
        if (selectedBall != null){
            selectedBall.setFill(Color.WHITE);
        }
        ballTryB2.setFill(Color.DODGERBLUE);
        selectedBall = ballTryB2;
    }

    @FXML
    private Circle ballTryC2;
    @FXML
    protected void onClickedBT_C2(){
        if (selectedBall != null){
            selectedBall.setFill(Color.WHITE);
        }
        ballTryC2.setFill(Color.DODGERBLUE);
        selectedBall = ballTryC2;
    }

    @FXML
    private Circle ballTryD2;
    @FXML
    protected void onClickedBT_D2(){
        if (selectedBall != null){
            selectedBall.setFill(Color.WHITE);
        }
        ballTryD2.setFill(Color.DODGERBLUE);
        selectedBall = ballTryD2;
    }

    @FXML
    private Circle ballTryA3;
    @FXML
    protected void onClickedBT_A3(){
        if (selectedBall != null){
            selectedBall.setFill(Color.WHITE);
        }
        ballTryA3.setFill(Color.DODGERBLUE);
        selectedBall = ballTryA3;
    }

    @FXML
    private Circle ballTryB3;
    @FXML
    protected void onClickedBT_B3(){
        if (selectedBall != null){
            selectedBall.setFill(Color.WHITE);
        }
        ballTryB3.setFill(Color.DODGERBLUE);
        selectedBall = ballTryB3;
    }

    @FXML
    private Circle ballTryC3;
    @FXML
    protected void onClickedBT_C3(){
        if (selectedBall != null){
            selectedBall.setFill(Color.WHITE);
        }
        ballTryC3.setFill(Color.DODGERBLUE);
        selectedBall = ballTryC3;
    }

    @FXML
    private Circle ballTryD3;
    @FXML
    protected void onClickedBT_D3(){
        if (selectedBall != null){
            selectedBall.setFill(Color.WHITE);
        }
        ballTryD3.setFill(Color.DODGERBLUE);
        selectedBall = ballTryD3;
    }

    @FXML
    private Circle ballTryA4;
    @FXML
    protected void onClickedBT_A4(){
        if (selectedBall != null){
            selectedBall.setFill(Color.WHITE);
        }
        ballTryA4.setFill(Color.DODGERBLUE);
        selectedBall = ballTryA4;
    }

    @FXML
    private Circle ballTryB4;
    @FXML
    protected void onClickedBT_B4(){
        if (selectedBall != null){
            selectedBall.setFill(Color.WHITE);
        }
        ballTryB4.setFill(Color.DODGERBLUE);
        selectedBall = ballTryB4;
    }

    @FXML
    private Circle ballTryC4;
    @FXML
    protected void onClickedBT_C4(){
        if (selectedBall != null){
            selectedBall.setFill(Color.WHITE);
        }
        ballTryC4.setFill(Color.DODGERBLUE);
        selectedBall = ballTryC4;
    }

    @FXML
    private Circle ballTryD4;
    @FXML
    protected void onClickedBT_D4(){
        if (selectedBall != null){
            selectedBall.setFill(Color.WHITE);
        }
        ballTryD4.setFill(Color.DODGERBLUE);
        selectedBall = ballTryD4;
    }

    @FXML
    private Circle ballTryA5;
    @FXML
    protected void onClickedBT_A5(){
        if (selectedBall != null){
            selectedBall.setFill(Color.WHITE);
        }
        ballTryA5.setFill(Color.DODGERBLUE);
        selectedBall = ballTryA5;
    }

    @FXML
    private Circle ballTryB5;
    @FXML
    protected void onClickedBT_B5(){
        if (selectedBall != null){
            selectedBall.setFill(Color.WHITE);
        }
        ballTryB5.setFill(Color.DODGERBLUE);
        selectedBall = ballTryB5;
    }

    @FXML
    private Circle ballTryC5;
    @FXML
    protected void onClickedBT_C5(){
        if (selectedBall != null){
            selectedBall.setFill(Color.WHITE);
        }
        ballTryC5.setFill(Color.DODGERBLUE);
        selectedBall = ballTryC5;
    }

    @FXML
    private Circle ballTryD5;
    @FXML
    protected void onClickedBT_D5(){
        if (selectedBall != null){
            selectedBall.setFill(Color.WHITE);
        }
        ballTryD5.setFill(Color.DODGERBLUE);
        selectedBall = ballTryD5;
    }

    @FXML
    private Circle ballTryA6;
    @FXML
    protected void onClickedBT_A6(){
        if (selectedBall != null){
            selectedBall.setFill(Color.WHITE);
        }
        ballTryA6.setFill(Color.DODGERBLUE);
        selectedBall = ballTryA6;
    }

    @FXML
    private Circle ballTryB6;
    @FXML
    protected void onClickedBT_B6(){
        if (selectedBall != null){
            selectedBall.setFill(Color.WHITE);
        }
        ballTryB6.setFill(Color.DODGERBLUE);
        selectedBall = ballTryB6;
    }

    @FXML
    private Circle ballTryC6;
    @FXML
    protected void onClickedBT_C6(){
        if (selectedBall != null){
            selectedBall.setFill(Color.WHITE);
        }
        ballTryC6.setFill(Color.DODGERBLUE);
        selectedBall = ballTryC6;
    }

    @FXML
    private Circle ballTryD6;
    @FXML
    protected void onClickedBT_D6(){
        if (selectedBall != null){
            selectedBall.setFill(Color.WHITE);
        }
        ballTryD6.setFill(Color.DODGERBLUE);
        selectedBall = ballTryD6;
    }

    @FXML
    private Circle ballTryA7;
    @FXML
    protected void onClickedBT_A7(){
        if (selectedBall != null){
            selectedBall.setFill(Color.WHITE);
        }
        ballTryA7.setFill(Color.DODGERBLUE);
        selectedBall = ballTryA7;
    }

    @FXML
    private Circle ballTryB7;
    @FXML
    protected void onClickedBT_B7(){
        if (selectedBall != null){
            selectedBall.setFill(Color.WHITE);
        }
        ballTryB7.setFill(Color.DODGERBLUE);
        selectedBall = ballTryB7;
    }

    @FXML
    private Circle ballTryC7;
    @FXML
    protected void onClickedBT_C7(){
        if (selectedBall != null){
            selectedBall.setFill(Color.WHITE);
        }
        ballTryC7.setFill(Color.DODGERBLUE);
        selectedBall = ballTryC7;
    }

    @FXML
    private Circle ballTryD7;
    @FXML
    protected void onClickedBT_D7(){
        if (selectedBall != null){
            selectedBall.setFill(Color.WHITE);
        }
        ballTryD7.setFill(Color.DODGERBLUE);
        selectedBall = ballTryD7;
    }

    @FXML
    private Circle ballTryA8;
    @FXML
    protected void onClickedBT_A8(){
        if (selectedBall != null){
            selectedBall.setFill(Color.WHITE);
        }
        ballTryA8.setFill(Color.DODGERBLUE);
        selectedBall = ballTryA8;
    }

    @FXML
    private Circle ballTryB8;
    @FXML
    protected void onClickedBT_B8(){
        if (selectedBall != null){
            selectedBall.setFill(Color.WHITE);
        }
        ballTryB8.setFill(Color.DODGERBLUE);
        selectedBall = ballTryB8;
    }

    @FXML
    private Circle ballTryC8;
    @FXML
    protected void onClickedBT_C8(){
        if (selectedBall != null){
            selectedBall.setFill(Color.WHITE);
        }
        ballTryC8.setFill(Color.DODGERBLUE);
        selectedBall = ballTryC8;
    }

    @FXML
    private Circle ballTryD8;
    @FXML
    protected void onClickedBT_D8(){
        if (selectedBall != null){
            selectedBall.setFill(Color.WHITE);
        }
        ballTryD8.setFill(Color.DODGERBLUE);
        selectedBall = ballTryD8;
    }

    // 以下、色が選択された時の処理
    @FXML
    private Circle ballBlue;
    @FXML
    protected void onClickedBB(){
        if(selectedColor != null){
            selectedColor.setEffect(glowReset);
        }
        ballBlue.setEffect(glow);
        selectedColor = ballBlue;
    }

    @FXML
    private Circle ballRed;
    @FXML
    protected void onClickedBR(){
        if(selectedColor != null){
            selectedColor.setEffect(glowReset);
        }
        ballRed.setEffect(glow);
        selectedColor = ballRed;
    }

    @FXML
    private Circle ballYellow;
    @FXML
    protected void onClickedBY(){
        if(selectedColor != null){
            selectedColor.setEffect(glowReset);
        }
        ballYellow.setEffect(glow);
        selectedColor = ballYellow;
    }

    @FXML
    private Circle ballGreen;
    @FXML
    protected void onClickedBG(){
        if(selectedColor != null){
            selectedColor.setEffect(glowReset);
        }
        ballGreen.setEffect(glow);
        selectedColor = ballGreen;
    }

    @FXML
    private Circle ballPink;
    @FXML
    protected void onClickedBP(){
        if(selectedColor != null){
            selectedColor.setEffect(glowReset);
        }
        ballPink.setEffect(glow);
        selectedColor = ballPink;
    }

    @FXML
    private Circle ballOrange;
    @FXML
    protected void onClickedBO(){
        if(selectedColor != null){
            selectedColor.setEffect(glowReset);
        }
        ballOrange.setEffect(glow);
        selectedColor = ballOrange;
    }
}

