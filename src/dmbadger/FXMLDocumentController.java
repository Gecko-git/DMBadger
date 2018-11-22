/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmbadger;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 *
 * @author gecko
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Text text;        //ラベルの定義
    @FXML
    private TextField textF;
    @FXML
    private ImageView img;

    @FXML
    private TextArea textA;

    WordShow ws;
    MorphologicalAnalysis ma;
    TestJena tj;

    TestWordNet twn;
    
    private void enterWord() {  //textField:key入力時処理(ENTER)
        if (textF.getText().length() != 0) {
            ma = new MorphologicalAnalysis(textF.getText());    //形態素解析
            ws = new WordShow(ma.tokenizer());  //表示
//            tj = new TestJena(textF.getText());    //DBPedia
//            ws = new WordShow(tj.main());  //表示

            twn = new TestWordNet(textF.getText());
            
            Sleep sp = new Sleep();     //連打対策
            sp.sleepMethod();
            timeline.stop();    //前のtimelineを念のため終了させる
            timeline.setCycleCount(ws.wordNum);
            timeline.play();
        }
    }

    @FXML
    private void keyPressed(KeyEvent event) {   //textField:key入力スイッチ
        System.out.println("PressedKey:");
        switch (event.getCode()) {
            case ENTER:
                System.out.println("_[ENTER]");
                enterWord();
                break;
            default:
                break;
        }
    }

    @FXML
    private void endProccess() {    //終了時処理：いつか使うかも
        Platform.exit();
    }

    private Timeline timeline = new Timeline(new KeyFrame(Duration.millis(40), //時間経過をトリガにするのはTimelineクラスを使う
            new EventHandler<ActionEvent>() {
        public void handle(ActionEvent actionEvent) { //ここに書いた処理がDuration.seconds(1)で示した感覚で実行される
            textA.setText(ws.outputWord());
            //text.setText(ws.outputWord());
        }
    }));

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
