/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.util.TimerTask;

/**
 *
 * @author student
 */
public class MijnTimerTask extends TimerTask{
    
    public MijnComponent mc;
    public void run() {
        if(!mc.dead)
        {
            mc.y = mc.y-2;
            if(mc.y < -715) mc.y = 0; 

            mc.ey = mc.ey-6;

            if(mc.ey < -150)
            {
                mc.randomNum = mc.rnd.nextInt(3);
                mc.ey = 715;
                
            }
            
            mc.score = mc.score+1;
            mc.scoreSt = "SCORE: " + (mc.score)/100;
            
            mc.highScoreSt = "HIGHSCORE: " + (mc.highScore)/100;
            if(mc.score > mc.highScore)
            {
                mc.highScore = mc.score;
            }

            if(mc.sx == mc.ex && mc.ey < 160 && mc.ey > -130)
            {
                mc.gameOver = "GAME OVER";
                mc.pressNumZero = "druk op 0 om opnieuw te beginnen";
                System.out.println("Botsing");
                mc.dead = true;
            }

            mc.repaint();
        } 
    }

}
