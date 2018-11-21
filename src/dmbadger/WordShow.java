/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmbadger;

/**
 *
 * @author gecko
 */
public class WordShow {     //Textに文字を表示する際のアニメーション

    protected String inputWord;
    protected int wordNum;

    private int timeNum;

    WordShow(String inputWord) {
        this.inputWord = inputWord;
        this.wordNum = inputWord.length();
        System.out.println("ShowWord:");
    }

    public String outputWord() {
        timeNum++;
        System.out.println("_[" + inputWord.substring(0, timeNum) + "]");
        return inputWord.substring(0, timeNum);
    }

}
