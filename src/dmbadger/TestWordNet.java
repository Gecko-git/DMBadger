/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmbadger;

import edu.cmu.lti.jawjaw.JAWJAW;
import edu.cmu.lti.jawjaw.pobj.POS;
import java.util.Set;

/**
 *
 * @author gecko_win10
 */
public class TestWordNet {

    protected String inputWord;
    
    TestWordNet(String inputWord) {
        this.inputWord = inputWord;

        TestWordNet.run(inputWord, POS.v);
    }

    private static void run(String word, POS pos) {
        // ファサードから日本語 WordNet にアクセス

        Set<String> hypernyms = JAWJAW.findHypernyms(word, pos);
        Set<String> hyponyms = JAWJAW.findHyponyms(word, pos);
        Set<String> consequents = JAWJAW.findEntailments(word, pos);
        Set<String> translations = JAWJAW.findTranslations(word, pos);
        Set<String> definitions = JAWJAW.findDefinitions(word, pos);
        // 結果表示（多義語はごっちゃになっています）

        System.out.println("hypernyms of " + word + " : \t" + hypernyms);
        System.out.println("hyponyms of " + word + " : \t" + hyponyms);
        System.out.println(word + " entails : \t\t" + consequents);
        System.out.println("translations of " + word + " : \t" + translations);
        System.out.println("definitions of " + word + " : \t" + definitions);
    }

}
