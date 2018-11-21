/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmbadger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author gecko
 */
public class DMBadger extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));     //fxmlの参照
        root.setStyle("-fx-background-radius: 10;-fx-background-color: rgba(0,0,0,0);");

        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(false);

        Scene scene = new Scene(root);      //シーンの作成

        scene.setFill(null);    //シーンの背景を透明

        //ウィンドウ位置指定
        Rectangle2D d = Screen.getPrimary().getVisualBounds();
        stage.setX(d.getMaxX() - 500);
        stage.setY(d.getMaxY() - 270);

        stage.setScene(scene);              //シーンをステージにセット
        stage.show();                       //ステージの表示
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
