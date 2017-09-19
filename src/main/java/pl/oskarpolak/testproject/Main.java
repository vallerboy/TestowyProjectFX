package pl.oskarpolak.testproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("mainView.fxml"));
        primaryStage.setTitle("AkademiaKodu");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.setAlwaysOnTop(true);
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}