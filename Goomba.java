
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.util.Timer;
import java.util.TimerTask;

import java.util.*;


public class Goomba extends Intogohr implements Draw
{
    Images img;
    int subject;
    int x = 300;
    int y = 0;
    Collision col;
    boolean death;
    boolean isRight; 
    public Goomba()
    {
        
        
        super();    
        subject = getNextNum();
        death = false;
        
        //UNIFIED.img2 = new Images[]{b,b,b,b,b,b}; 
        
        img = new Images(new BufferedImage[][] {Drawer.init("Enemies/Goomba/Walk")
                                               ,Drawer.init("Enemies/Goomba/Die")},subject);
        isRight = true;
        img.init();
        addIntoger(subject,new Intoger( img.getTAR(),true, 'G', 'R', 'L', 'T' ));
        col = new Collision(subject);
    }
    
    public Goomba(int x, int y)
    {
        
        
        super();  
        
        this.x = x;
        this.y = y;
        subject = getNextNum();
        death = false;
        
        //UNIFIED.img2 = new Images[]{b,b,b,b,b,b}; 
        isRight = Math.random()<0.5;
        img = new Images(new BufferedImage[][] {Drawer.init("Enemies/Goomba/Walk")
                                               ,Drawer.init("Enemies/Goomba/Die")},subject);
        
        img.init();
        addIntoger(subject,new Intoger( img.getTAR(),true, 'G', 'R', 'L', 'T' ));
        col = new Collision(subject);
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
        int subj = getCol().getSUBJECT();
        img.advance();
        String temp = col.collisionType();
        
        if(!isRight){
            setX(subj, -5);
        }else{
            setX(subj, +5);
        }
              
          for(int i = 0; i<temp.length()/2; i++){
              if(temp.substring(2*i+1,2*i+2).equals( "M" )){
                  
                  if(condCol(i, 'T') && temp.substring(2*i,2*i+1).equals( "T")){
                      death = true;
                      
                      System.out.println("DIE");
                  }
                  
                
            }
            if(temp.substring(2*i,2*i+1).equals( "L")){
                isRight = true;
            }
            if(temp.substring(2*i,2*i+1).equals( "R")){
                isRight = false;
            }
        
        
        }
        
        if(y >= 700){
                      death = true;
                  }
        
    }
    public boolean die(){
        if(death == true){
            
            removeIntoger(subject);
            UNIFIED.totalScore += 1;
        }
        return death;
    }
    
    public void setVectors(){
        int subj = getCol().getSUBJECT();
        
          x += getX(subj);
          y -= getY(subj);
          
          
          
        img.draw(x,y,25,25);
        // do nothing
    }

}
