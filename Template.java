
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.util.Timer;
import java.util.TimerTask;

import java.util.*;


public class Template extends Intogohr implements Draw
{
    Images img;
    int subject;
    int x = 50;
    int y = 150;
    public Template()
    {
        
        
        super();    
        subject = getNextNum();
        
        
        //UNIFIED.img2 = new Images[]{b,b,b,b,b,b}; 
        
        img = new Images(new BufferedImage[][] {Drawer.init("Platforms/Floor")},subject);
        
        img.init();
        addIntoger(subject, new Intoger( img.getTAR(),false, 'P' ));
        
    }
    
    
    
    public Images[] getIMG(){
        return new Images[]{img};
    }
    public Collision getCol(){
        return null;
    }
    
    public void init(){
        // do nothing
    }
    
    public void Reset(){
        reset(subject, img.getTAR());
        
    }
    public void reRun(){
        
    }
    public boolean die(){
        return false;
    }
    
    public void setVectors(){
        img.draw(x,y,25,25);
        // do nothing
    }

}
