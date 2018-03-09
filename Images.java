import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.util.*;

/**
 * Write a description of class Images here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Images
{
    BufferedImage[][] bi;
    
    final int x = 0; // src[x][0] or src[x][1]
    final int y = 1; // src[y][0] or src[y][1]
    
    private int counter;
    private int state;
    
    private int subject;
    
    int[][] src;
    int[][] target;
    
    boolean drawIt;
   
    
    Images(BufferedImage[][] BI, int sub){
        bi = BI;
        src = new int[2][2];
        target = new int[2][2];
        counter = 0;
        state = 0;
        drawIt = true;
        
        subject = sub;
    }
    
   
    public BufferedImage get(){
        return bi[state][counter];
    }
    public void setState(int states){
        state = states;
    }
    public void setState(char states){
        switch(states){
            // Small mario actions
            case 'S':                  // stand
               state = 0;
               break;
            case 'W':                  // walk
               state = 1;
               break;
            
            // Super mario actions
            case 'J':                  // jump
               state = 2;
               break;
            case 'C':                  // climb
               state = 3;
               break;
            case 'D':                  // duck
               state = 4;
               break;
            case 'K':                  // skid
               state = 5;
               break;
            // Fire mario actions
            case 'F':                  // shoot
               state = 6;
               break;
            
            
            
        }
        setC(0);
    }
    public char getState(){
        switch(state){
            // Small mario actions
            case 0:                  // stand
               return 'S';
            case 1:                  // walk
               return 'W';
            
            // Super mario actions
            case 2:                  // jump
               return 'J';
            case 3:                  // climb
               return 'C';
            case 4:                  // duck
               return 'D';
            case 5:                  // skid
               return 'K';
            // Fire mario actions
            case 6:                  // shoot
               return 'F';
            
            
            
        }
        return 'E'; // Shold not run           ERROR
    }
    
    public void setDraw(boolean datas){
        drawIt = datas;
    }
    public boolean getDraw(){
        return drawIt;
    }
    
    public void setSRC(int x1, int y1, int x2, int y2){
        src[x][0] = x1;
        src[x][1] = x2;
        src[y][0] = y1;
        src[y][1] = y2;
    }
    public void set(int x1, int y1, int x2, int y2){
        target[x][0] = x1;
        target[x][1] = x2;
        target[y][0] = y1;
        target[y][1] = y2;
        
        
    }
    
    public void init(){
        setSRC(0,bi[state][counter].getHeight(),bi[state][counter].getWidth(),0);
    }
    
    public void draw(int x, int y, int width, int height){
        int x1 = x-width;
        int x2 = x+width;
        int y1 = y+height;
        int y2 = y-height;
        set(x1,y1,x2,y2);
    }
    
    public void setC(int i){
        counter = i;
    }
    public int getC(){
        return counter;
    }
    
    public void advance(){
        if(counter == bi[state].length-1){
            counter = -1;
        }
        counter++;
    }
    
    public int[][] getSRC(){
        return src;
    }
    public int[][] getTAR(){
        return target;
    }

}
