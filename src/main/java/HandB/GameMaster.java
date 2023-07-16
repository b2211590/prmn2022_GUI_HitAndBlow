package HandB;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static javafx.scene.paint.Color.*;

public class GameMaster {

    // ターンを表す変数 はじめは 1 ターン目
    private int turnCounter = 1;

    private int numberOfHits = 0;
    private int numberOfBlows = 0;

    private final ArrayList<Color> answer = new ArrayList<>();

    private ArrayList<Color> trial;

    public GameMaster(){
        ArrayList<Color> colors = new ArrayList<>(Arrays.asList(BLUE, RED, YELLOW, GREEN, PINK, ORANGE));
        Collections.shuffle(colors);

        // 答えとなる4つをセットする
        for (int i = 0; i < 4; i++) {
            answer.add(colors.get(i));

            // 開発用
            String colorHexadecimal = colors.get(i).toString();
            switch (colorHexadecimal) {
                case "0x0000ffff":
                    System.out.println("ans_blue");
                    break;
                case "0xff0000ff":
                    System.out.println("ans_red");
                    break;
                case "0x008000ff":
                    System.out.println("ans_green");
                    break;
                case "0xffff00ff":
                    System.out.println("ans_yellow");
                    break;
                case "0xffc0cbff":
                    System.out.println("ans_pink");
                    break;
                default:
                    System.out.println("ans_orange");
                    break;
            }
        }
    }

    public void goNextTurn(){
        turnCounter++;
    }

    public int getTurnCounter(){
        return turnCounter;
    }

    public void setTrial(ArrayList<Color> colors){
        this.trial = colors;
    }

    public void countHAndB(){
        // 初期化
        numberOfHits = 0;
        numberOfBlows = 0;

        // indexの比較で判定を行う
        for (int i = 0; i < 4; i++) {
            int trialIndex = trial.indexOf(answer.get(i));
            //System.out.println(trialIndex);

            if (trialIndex == i){
                numberOfHits++;
            } else if (trialIndex > -1) {
                numberOfBlows++;
            }
        }
    }

    public int getNumberOfHits() {
        return numberOfHits;
    }

    public int getNumberOfBlows() {
        return numberOfBlows;
    }

    public ArrayList<Color> getAnswer() {
        return answer;
    }
}
