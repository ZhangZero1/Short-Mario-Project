
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.util.Timer;
import java.util.TimerTask;

import java.util.*;


public class Platform extends Intogohr implements Draw
{
    Images[] img;
    int subject;
    
    public Platform()
    {
        
        
        super();    
        
        subject = getNextNum();
        
        //UNIFIED.img2 = new Images[]{b,b,b,b,b,b}; 
        
        img = new Images[6];
        for(int i = 0; i<img.length;i++){
            img[i] = new Images(new BufferedImage[][] {Drawer.init("Platforms/Floor")},subject+i);
            
        } 
        
        for(int i = 0; i<img.length;i++){ 
            img[i].init();
            addIntoger(subject+i, new Intoger( img[i].getTAR(),false, 'P' ) );
        }
    }
    
    
    
    public Images[] getIMG(){
        return img;
    }
    public Collision getCol(){
        return null;
    }
    
    public void init(){
        // do nothing
    }
    
    public void Reset(){
        for(int i = 0; i<img.length;i++){
              reset(i+subject, img[i].getTAR());
        }
    }
    public void reRun(){
        
    }
    public boolean die(){
        return false;
    }
    
    public void setVectors(){
        for(int i = 0; i<img.length;i++){
              img[i].draw(50*(i+1),150,25,25);
                      
        }
        // do nothing
    }

}
