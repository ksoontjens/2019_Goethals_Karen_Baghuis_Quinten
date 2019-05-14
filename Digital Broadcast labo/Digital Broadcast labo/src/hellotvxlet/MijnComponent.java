/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import org.havi.ui.HComponent;
import java.util.Random;

/**
 *
 * @author student
 */
public class MijnComponent extends HComponent 
{
    Image car;
    Image sterren;
    Image enemy;
    Random rnd = new Random();
    public boolean dead = false;
    
    public int randomNum;
    
    public int sx = 225;
    
    public int ex = 225;
    public int ey = 715;
    
    public int y = 0;
    
    public int tx = 290;
    public int ty = 250;
    
    public int score = 0;
    public String scoreSt = "SCORE: " + score;
    
    public int highScore = 0;
    public String highScoreSt = "HIGHSCORE: " + highScore;
    
    public String gameOver= "";
    public String pressNumZero= "";
    
    public MijnComponent(int w, int x, int y, int z)
    {
        this.setBounds(w, x, y, z);
        car = this.getToolkit().getImage("car.png");
        enemy = this.getToolkit().getImage("car.png");
        sterren = this.getToolkit().getImage("sterren.png");
        
        MediaTracker mt = new MediaTracker(this);
        
        mt.addImage(car, 0);
        mt.addImage(car, 1);
        
        randomNum = rnd.nextInt(3);
        
        try {
            mt.waitForAll();
        }
        catch (InterruptedException ex){
            ex.printStackTrace();
        }
        
    }
    public void paint(Graphics g)
    {
        g.drawImage(sterren, y + 715, 0, this);
        g.drawImage(sterren, y, 0, this);
        g.drawImage(car,10, sx, 150,75, this);
        //image, x, y, sizeX, sizeY)
        
        if(randomNum == 0)
        {
            ex = 225;
        }
        if(randomNum == 1)
        {
            ex = 125;
        }
        if(randomNum == 2)
        {
            ex = 325;
        }
        
        g.drawImage(enemy,ey, ex, 150,75, this);
        
        g.drawString(scoreSt, 25, 40);
        g.drawString(highScoreSt, 300, 40);
        
        g.drawString(gameOver, tx, ty);
        g.drawString(pressNumZero, tx-100, ty+35);
    }
}
