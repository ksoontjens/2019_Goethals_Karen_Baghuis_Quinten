/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Color;
import java.awt.Font;
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
    //VARIABLES
    Image car;
    Image carGeel;
    Image carBlauw;
    Image carGroen;
    Image olie;
    Image bannaan;
    Image weg;
    
    Random rnd = new Random();
    public boolean dead = true;
    
    public int randomLane;
    public int randomColor;
    
    public int sx = 250;
    
    public float speed = 6f;
    public int ex = 250;
    public int ey = 715;
    
    public int etx = 250;
    public int ety = 715;
    
    public int y = 0;
    
    public int tx = 295;
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
        weg = this.getToolkit().getImage("road.png");
        car = this.getToolkit().getImage("car.png");
        carGeel = this.getToolkit().getImage("car_geel.png");
        carBlauw = this.getToolkit().getImage("car_blauw.png");
        carGroen = this.getToolkit().getImage("car_groen.png");
        
        MediaTracker mt = new MediaTracker(this);
        
        mt.addImage(car, 0);
        mt.addImage(car, 1);
        
        randomLane = rnd.nextInt(3);
        randomColor = rnd.nextInt(3);
        
        pressNumZero = "druk op 0 om te beginnen";
        
        try {
            mt.waitForAll();
        }
        catch (InterruptedException er){
            er.printStackTrace();
        }
        
    }
    public void paint(Graphics g)
    {
        //DRAW ROAD
        g.drawImage(weg, y + 715, 0, this);
        g.drawImage(weg, y, 0, this);
        
        //DRAW PLAYER
        g.drawImage(car,50, sx, 150,75, this);
        
        //DRAW CARS
        switch(randomLane) 
        {
          case 0:
            ex = 250;
            etx = 100;
            break;
          case 1:
            ex = 100;
            etx = 400;
            break;
          case 2:
            ex = 400;
            etx = 250;
            break;
          default:
        }
        switch(randomColor) 
        {
          case 0:
            g.drawImage(carGeel,ey, ex, 150,75, this);
            g.drawImage(carGroen,ety, etx, 150,75, this);
            break;
          case 1:
            g.drawImage(carGroen,ey, ex, 150,75, this);
            g.drawImage(carBlauw,ety, etx, 150,75, this);
            break;
          case 2:
            g.drawImage(carBlauw,ey, ex, 150,75, this);
            g.drawImage(carGeel,ety, etx, 150,75, this);
            break;
          default:
        }
        
        //DRAW TEXT
        g.setColor(Color.WHITE);
        g.drawString(scoreSt, 25, 40);
        g.drawString(highScoreSt, 300, 40);
        g.setColor(Color.RED);
        g.drawString(gameOver, tx, ty);
        g.drawString(pressNumZero, tx-70, ty+35);
    }
}
