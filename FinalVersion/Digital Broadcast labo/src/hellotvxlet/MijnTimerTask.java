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
            //MOVE CARS
            if(mc.score % 100 == 0) 
            {
                mc.speed = mc.speed + 0.5f;
                System.out.println("Speed: " + (int)mc.speed);
            }
            /* MAIN ENEMY*/
            mc.y = mc.y-(int)(mc.speed/3f);
            if(mc.y < -720) mc.y = 0; 
            mc.ey = mc.ey-(int)mc.speed;
            if(mc.ey < -150)
            {
                mc.randomLane = mc.rnd.nextInt(3);
                mc.randomColor = mc.rnd.nextInt(3);
                mc.ey = 715;
            }
            /* SECOND ENEMY*/
            mc.ety = mc.ety-(int)mc.speed;
            if(mc.ety < -1020) //LESS FREQUENT
            {
                mc.ety = 715;
            }
            
            //SOCRE
            mc.score = mc.score+1;
            mc.scoreSt = "SCORE: " + (mc.score)/100;
            
            mc.highScoreSt = "HIGHSCORE: " + (mc.highScore)/100;
            if(mc.score > mc.highScore)
            {
                mc.highScore = mc.score;
            }
            
            //COLLISION DETECTION
            if((mc.sx == mc.ex && mc.ey < 200 && mc.ey > -90) || (mc.sx == mc.etx && mc.ety < 200 && mc.ety > -90))
            {
                mc.gameOver = "GAME OVER";
                mc.pressNumZero = "druk op 0 om te beginnen";
                System.out.println("Botsing");
                mc.dead = true;
            }
            
            mc.repaint();
        } 
    }

}
