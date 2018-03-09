
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.util.Timer;
import java.util.TimerTask;

import java.util.*;



public class Mario extends Intogohr implements CharPress, Draw
{
    Collision col;
    int x;
    int y;
    Images img;
    
    char oldS;
    char states = ' ';
    int isRight = -1;
    
    boolean death;
    
    int subject;  
    int time;
    
    
    
    
    public Mario(int _X_, int _Y_){
        
        super();
        
        death = false;
        subject = getNextNum();
        
        
        BufferedImage[] a = Drawer.init("Sprites/Small/Stand");
        BufferedImage[] b = Drawer.init("Sprites/Small/Walk");
        
        x = _X_;
        y = _Y_;
          
         img = new Images(new BufferedImage[][] {a,b},subject);
         
         
         img.init();
         col = new Collision(subject);
         addIntoger(  subject,new Intoger( img.getTAR(),true, 'M', 'T' ) );
         
         img.setState('S');
         states = ' ';
         time = 0;
         
         
         //UNIFIED.img.setState('W');
    }
    
    public Collision getCol(){
        return col;
    }
    
    
    public Images[] getIMG(){
        return new Images[]{img};
    }
    
    public void init(){
        states = ' ';
        isRight = -1;
        oldS  = img.getState();
        
        
    }
    
    public void Reset(){
        
        reset(0, img.getTAR());
        
    }
    
    public void reRun(){
        int subj = getCol().getSUBJECT();
        if(x<=50){
            x = 50;
            UNIFIED.X = 0;
        }
        if(x>=5000){
            x = 5000;
            UNIFIED.X = 5000;
        }
        
        if(getX(subj)==0 &&  getY(subj) == 0){
                  states = 'S';
              }
        else{
            if(getX(subj) !=0){
                states = 'W';
                if(getX(subj)>0){
                    isRight = 1;
                }
                else{
                    isRight = 0;
                }
            }

              /*if(UNIFIED.target.get(a.getCol().getSUBJECT()).getY() != 0){
                  states = 'J';
              }*/
        }
      
              //System.out.println(UNIFIED.target.get(0).getY());
              String temp = col.collisionType();
              
              for(int i = 0; i<temp.length()/2; i++){
                  if(temp.substring(2*i+1,2*i+2).equals( "G" )){
                      
                      if(condCol(i, 'R') && temp.substring(2*i,2*i+1).equals( "R")){
                          death = true;
                          System.out.println("DIE");
                      }
                      if(condCol(i, 'L') && temp.substring(2*i,2*i+1).equals( "L")){
                          death = true;
                          System.out.println("DIE");
                      }
                      if(condCol(i, 'T') && temp.substring(2*i,2*i+1).equals( "T")){
                          death = true;
                          System.out.println("DIE");
                      }
                  }
                  }
                  
                  if(y >= 700){
                      death = true;
                  }
                
                
              
              
              img.advance();
              if(oldS != states){
                  img.setState(states);
              }
              img.init();
              
              if(col.collisionType().contains("B")){
                  time = 0;
              }
              if(time >5){
                  UNIFIED.canJUMP = false;
                }
                else{
                    UNIFIED.canJUMP = true;
                }
              
        
              //System.out.println("X: " + getX(subj));
              //System.out.println("Y: " + getY(subj));
              
              
              
                  //System.out.println(UNIFIED.target.get(0).getY());
                  //System.out.println("GET MOAR DATA . . ."+UNIFIED.X);
              
    }
    
    public boolean die(){
        if(death == true){
            removeIntoger(subject);
            UNIFIED.X = 0;
            UNIFIED.Y = 0;
        }
        return death;
    }
    
    public void setVectors(){
        int subj = getCol().getSUBJECT();
        
          x += getX(subj);
          y -= getY(subj);
          UNIFIED.X += getX(subj);
          UNIFIED.Y += getY(subj);
          
          img.draw(x,y,25,25);
    }
    
    public void UpPressed(){
        if(UNIFIED.canChange && UNIFIED.canJUMP){
            setY(subject,+25);
            time++;
        }
    }
    public void UpReleased(){
        if(UNIFIED.canChange){
            setY(subject,0);
        }
    }
    
    public void DownPressed(){
        if(UNIFIED.canChange){
            setY(subject,-25);
        }
    }
    public void DownReleased(){
        if(UNIFIED.canChange){
            setY(subject,0);
        }
    }
    
    public void RightPressed(){
        if(UNIFIED.canChange){
            setX(subject,+25);
        }
    }
    public void RightReleased(){
        if(UNIFIED.canChange){
            setX(subject,0);
        }
    }
    
    public void LeftPressed(){
        if(UNIFIED.canChange){
            setX(subject,-25);
        }
    }
    public void LeftReleased(){
        if(UNIFIED.canChange){
            setX(subject,0);
        }
    }
    
  
          
    
    
}
