
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.util.Timer;
import java.util.TimerTask;

import java.util.*;


public class QBlock extends Intogohr implements Draw
{
    Images img;
    int subject;
    Collision col;
    
    int x,y;
    
    public QBlock()
    {
        
        
        super();    
        x = 450;
        y = 150;
        
        
        subject = getNextNum();
        
        col = new Collision(subject);
        
        //UNIFIED.img2 = new Images[]{b,b,b,b,b,b}; 
        
        img = new Images(new BufferedImage[][] {Drawer.init("Platforms/QBLOC/Standerd"),
                                                Drawer.init("Platforms/QBLOC/Death")},subject);
        img.init();
        addIntoger(subject, new Intoger( img.getTAR(), false,'P' ) );
        
    }
    
    
    
    public Images[] getIMG(){
        return new Images[]{img};
    }
    public Collision getCol(){
        return col;
    }
    
    public void init(){
        // do nothing
    }
    
    public void Reset(){
        reset(subject, img.getTAR());
    }
    public void reRun(){
        
        if(col.collisionType().substring(0,1) .equals( "B" )){
            img.setState('W');
        }
        img.advance();
        
    }
    public boolean die(){
        return false;
    }
    
    public void setVectors(){
        img.draw(x,y,25,25);
        // do nothing
    }

}
