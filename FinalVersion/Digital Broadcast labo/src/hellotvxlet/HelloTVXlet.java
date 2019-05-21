    
package hellotvxlet;

import java.util.Timer;
import javax.tv.xlet.*;
import org.bluray.ui.event.HRcEvent;
import org.dvb.event.EventManager;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;


public class HelloTVXlet implements Xlet, UserEventListener
{
    MijnComponent mc;
    
    public void initXlet(XletContext context) 
    {
      HScene scene = HSceneFactory.getInstance().getDefaultHScene();
      
      mc = new MijnComponent(0,0,720,576);
      
      scene.add(mc);
      //maakt verzameling, voegt pijltjes toetsen toe
      UserEventRepository rep = new UserEventRepository("naam");
      rep.addAllArrowKeys();
      rep.addAllNumericKeys();
      
      //gebruikt singleton om aan te geveen naar waar de events gestuurd moeten worden
      EventManager.getInstance().addUserEventListener(this, rep);
      
      scene.validate();
      scene.setVisible(true);
      
      MijnTimerTask tt = new MijnTimerTask();
      tt.mc = mc;
      Timer t = new Timer();
      t.scheduleAtFixedRate(tt, 0, 10);
      
    }

    public void startXlet() {
    
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }

    public void userEventReceived(UserEvent e) {
        //PLAYER MOVEMENT
        if(e.getCode() == HRcEvent.VK_UP && mc.sx != 100 && e.getType() == HRcEvent.KEY_PRESSED && mc.dead == false)
        {
            mc.sx = mc.sx - 150; mc.repaint();
        }
        if(e.getCode() == HRcEvent.VK_DOWN && mc.sx != 400 && e.getType() == HRcEvent.KEY_PRESSED && mc.dead == false)
        {
            mc.sx = mc.sx + 150; mc.repaint();
        } 
        
        //RESTART
        if(e.getCode() == HRcEvent.VK_0 && e.getType() == HRcEvent.KEY_PRESSED)
        {
            mc.dead = false;
            
            mc.sx = 250;
            mc.ex = 250;
            mc.ey = 715;
            mc.etx = 250;
            mc.ety = 715;
            
            mc.speed = 6;
    
            mc.y = 0;
    
            mc.score = 0;
            
            mc.gameOver= "";
            mc.pressNumZero= "";
            
            mc.randomLane = mc.rnd.nextInt(3);
            
            mc.repaint();
        } 
    }
}
