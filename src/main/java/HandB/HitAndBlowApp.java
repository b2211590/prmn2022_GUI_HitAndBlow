package HandB;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HitAndBlowApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            //FXMLからのシーングラフの読み込み
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Title.fxml"));
            Parent root = loader.load();

            //シーングラフのルートノードを設定したシーンの作成
            Scene scene = new Scene(root, 900, 600);

            //ステージへのシーンの設定
            primaryStage.setScene(scene);
            primaryStage.setTitle("ヒットアンドブロー");
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}