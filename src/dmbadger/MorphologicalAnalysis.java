/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmbadger;

import org.atilika.kuromoji.Token;
import org.atilika.kuromoji.Tokenizer;

/**
 *
 * @author gecko
 */
public class MorphologicalAnalysis {

    protected String inputWord;
    protected String rtnWord="";
    
    MorphologicalAnalysis(String inputWord) {
        this.inputWord = inputWord;
    }

    public String tokenizer() {
        Tokenizer tokenizer = Tokenizer.builder().build();
        for (Token token : tokenizer.tokenize(this.inputWord)) {
            String[] features = token.getAllFeaturesArray();
            System.out.print(token.getSurfaceForm()+"["+token.getAllFeatures()+"/");
            rtnWord+=token.getSurfaceForm()+"/";
        }
        
        return rtnWord;
    }

}
