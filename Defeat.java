
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.util.Timer;
import java.util.TimerTask;

import java.util.*;


public class Defeat extends Intogohr implements Draw
{
    Images img;
    
    Images img0;
    Images img1;
    Images img2;
    
    int subject;
    int x = 50;
    int y = 150;
    public Defeat()
    {
        
        
        super();    
        subject = getNextNum();
        
        
        //UNIFIED.img2 = new Images[]{b,b,b,b,b,b}; 
        
        img = new Images(new BufferedImage[][] {Drawer.init("Platforms/Floor")},subject);
        img0 = new Images(new BufferedImage[][] {Drawer.init("Death/Numbers")},subject+1);
        img1 = new Images(new BufferedImage[][] {Drawer.init("Death/Numbers")},subject+2);
        img2 = new Images(new BufferedImage[][] {Drawer.init("Death/Numbers")},subject+3);
        
        img.init();
        img0.init();
        img1.init();
        img2.init();
        
        addIntoger(subject, new Intoger( img.getTAR(),false, 'P' ));
        addIntoger(subject, new Intoger( img0.getTAR(),false, 'P' ));
        addIntoger(subject, new Intoger( img1.getTAR(),false, 'P' ));
        addIntoger(subject, new Intoger( img2.getTAR(),false, 'P' ));
        
        
    }
    
    
    
    public Images[] getIMG(){
        return new Images[]{img,img0,img1,img2};
    }
    public Collision getCol(){
        return null;
    }
    
    public void init(){
        // do nothing
    }
    
    public void Reset(){
        reset(subject, img.getTAR());
        reset(subject, img0.getTAR());
        reset(subject, img1.getTAR());
        reset(subject, img2.getTAR());
        
    }
    public void reRun(){
        img0.setC((UNIFIED.totalScore%100)%10);
        img1.setC(UNIFIED.totalScore%100-((UNIFIED.totalScore%100)%10));
        img.setC(UNIFIED.totalScore/100);
    }
    public boolean die(){
        return false;
    }
    
    public void setVectors(){
        img.draw(x,y,1000,1000);
        img0.draw(150,50,25,25);
        img1.draw(100,50,25,25);
        img2.draw(50,50,25,25);
        // do nothing
    }

}
