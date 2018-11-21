/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmbadger;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gecko
 */
public class Sleep {    //enter連打対策：処理の停止
    
    private int sleepTime = 250;
    
    void sleepMethod() {
        try {   
            System.out.println("Sleep:_["+sleepTime+"ms]");
            Thread.sleep(sleepTime);
        } catch (InterruptedException ex) {
            Logger.getLogger(Sleep.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
