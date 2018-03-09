
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.util.Timer;
import java.util.TimerTask;

import java.util.*;


public class DestroyerONE extends Intogohr implements Draw
{
    Images img;
    Images img2;
    Images img3;
    Images img4;
   
    
    int subject;

    public DestroyerONE()
    {
        
        
        super();    
        subject = getNextNum();
        
        
        
        img = new Images(new BufferedImage[][] {Drawer.init("Platforms/Front")},subject);
        img2 = new Images(new BufferedImage[][] {Drawer.init("Platforms/Gnd")},subject+1);
        img3 = new Images(new BufferedImage[][] {Drawer.init("Platforms/Plat")},subject+2);
        img4 = new Images(new BufferedImage[][] {Drawer.init("Platforms/Rear")},subject+3);
        
        img.init();
        img2.init();
        img3.init();
        img4.init();
        
        addIntoger(subject,new Intoger( img.getTAR(),false, 'P' ));
        addIntoger(subject+1,new Intoger( img2.getTAR(),false,'P' ));
        addIntoger(subject+2,new Intoger( img3.getTAR(),false,'P', 'S'  ));
        addIntoger(subject+3,new Intoger( img4.getTAR(),false, 'P' ));
    }
    
    
    
    public Images[] getIMG(){
        return new Images[]{img,img2,img3,img4};
    }
    public Collision getCol(){
        return null;
    }
    
    public void init(){
        // do nothing
    }
    
    public void Reset(){
        reset(subject, img.getTAR());
        reset(subject+1, img2.getTAR());
        reset(subject+2, img3.getTAR());
        reset(subject+3, img4.getTAR());
        
    }
    public void reRun(){
        
    }
    public boolean die(){
        return false;
    }
    
    public void setVectors(){
        img.draw(512, 525,511,150);
        img2.draw( 1820, 640,800, 35);
        img3.draw( 1620, 500,305, 35);
        img4.draw(1820+800,525,511,150);
        // do nothing
    }
}



