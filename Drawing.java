import javax.swing.*;
import java.awt.*;

import java.util.*;

public class Drawing extends KeyBinding{
    Mario a;
    Platform b;
    DestroyerONE c;
    
    QBlock d;
    Goomba e;
    Defeat f;
    
    ArrayList<Draw> canvas;
    ArrayList<Draw> map;
    ArrayList<Draw> lost;
    public Drawing(){
        super();
        a = getMario();
        b = new Platform();
        c = new DestroyerONE();
        d = new QBlock();
        e = new Goomba();
        
        f = new Defeat();
        canvas = new ArrayList<Draw>();
        lost = new ArrayList<Draw>();
        
        lost.add(f);
        
        canvas.add(a);
        canvas.add(b);
        canvas.add(c);
        canvas.add(d);
        canvas.add(e);
        
    }
    
    public CharPress get(){
        return a;
    }
   
   @Override
   protected void paintComponent(Graphics g) { // called back via repaint()
            /*revalidate();
            scrollRectToVisible(new Rectangle(1000,1000));
            */
            setBackground(Color.blue);
            if(a.die()){
                drawStuff(lost,g);
            }else{
                drawStuff(canvas,g);
            }
            if(UNIFIED.addObject){
                UNIFIED.addObject = false;
                canvas.add(new Goomba((int)Math.random()*2400,0)); // y: 0, x: math.random w/ UNIFIED.x
            }
            UNIFIED.addObject = Math.random()<0.025;
           
            
   
    }
    
    
   void drawStuff(ArrayList<Draw> draw, Graphics g){
       
       //g.translate(-UNIFIED.X,-UNIFIED.X);
       
       for(Draw d: draw){
           
               d.init();
            
       }
       for(Draw d: draw){
           
               d.Reset();
            
       }
       
        UNIFIED.canChange = false;
         try{
                Thread.sleep(30);
            } catch (Exception exc){
                System.out.println(exc);
            }
            a = getMario();
           
            
       
       
       for(Draw d: draw){
          
               if(d.getCol() != null){
                   d.getCol().Correct();
                    
                }
            
       }
       
       
       for(Draw d: draw){
           
               d.setVectors();
            
       }
       
       
       
       
       
       UNIFIED.canChange = true;
       
       for(Draw d: draw){
           
               d.reRun();
            
       }
       
       for(int i = 0;i< draw.size();i++){
           
               if(draw.get(i).die()){
                   draw.remove(i);
                   i--;
                }
            
       }
       
       super.paintComponent(g);
          
       for(Draw d: draw){
           
               drawImages(g,d.getIMG());
            
       }
       
       
            
       
       
       
       try{
                Thread.sleep(20);
            } catch (Exception exc){
                System.out.println(exc);
            }
            
            repaint();
            
            
       
       
       
   }
    
   void drawImages(Graphics g, Images[] img){
       for(int i = 0; i< img.length; i++){
           drawImage(g, img[i], UNIFIED.X,UNIFIED.Y);
        }
   }
    
    
    
   void drawImage(Graphics g, Images img, int x, int y){
       
      g.drawImage(img.get(),img.getTAR()[0][0]-x,img.getTAR()[1][0]+y,img.getTAR()[0][1]-x,img.getTAR()[1][1]+y
                           ,img.getSRC()[0][0],img.getSRC()[1][0],img.getSRC()[0][1],img.getSRC()[1][1]
                           ,null );
   }

    
}


/*
old code unused...
   protected void OLDpaintComponent(Graphics g) { // called back via repaint()
            
            
       
               // setup all code into groups that are added into a list...
               //          then the code will loop to run each objects in the group of the same section sequentially going through to every section
                
              char oldS = UNIFIED.img.getState();
              char states = ' ';
              int isRight = -1;
              Drawer.resetIMG(UNIFIED.img, 0);
              for(int i = 0; i<UNIFIED.img2.length;i++){
                  Drawer.resetIMG(UNIFIED.img2[i],i+1);
                }
              
              a.getCol().Correct();
              UNIFIED.canChange = false;
              try{
                Thread.sleep(50);
            } catch (Exception exc){
                System.out.println(exc);
            }
              
      
              if(UNIFIED.target.get(a.getCol().getSUBJECT()).getX()==0 &&  UNIFIED.target.get(a.getCol().getSUBJECT()).getY() == 0){
                  states = 'S';
              }
              else{
                  if(UNIFIED.target.get(a.getCol().getSUBJECT()).getX()!=0){
                      states = 'W';
                      if(UNIFIED.target.get(a.getCol().getSUBJECT()).getX()>0){
                          isRight = 1;
                      }
                      else{
                          isRight = 0;
                      }
                  }
                  
                  
                  
                  
                  //if(UNIFIED.target.get(a.getCol().getSUBJECT()).getY() != 0){
                  //    states = 'J';
                  //}
               }  
      
              //System.out.println(UNIFIED.target.get(0).getY());
              
              UNIFIED.img.advance();
              if(oldS != states){
                  UNIFIED.img.setState(states);
              }
              UNIFIED.img.init();
              for(int i = 0; i<UNIFIED.img2.length;i++){
                      UNIFIED.img2[i].init();
                      
                  }
              
              //if(UNIFIED.img.getDraw()){
                  
                  UNIFIED.X += UNIFIED.target.get(0).getX();
                  UNIFIED.Y -= UNIFIED.target.get(0).getY();
                  //System.out.println(UNIFIED.target.get(0).getY());
                  //System.out.println("GET MOAR DATA . . ."+UNIFIED.X);
                  UNIFIED.img.draw(UNIFIED.X,UNIFIED.Y,50,50);
                  for(int i = 0; i<UNIFIED.img2.length;i++){
                      UNIFIED.img2[i].draw(50*(i+1),150,25,25);
                      
                  }
                  UNIFIED.canChange = true;
                  
                  
                  
                 // System.out.println(UNIFIED.img2[0].getTAR()[0][0]);
                  
                  //UNIFIED.img.setDraw(false);
               // }
              
             
          
          
     
              super.paintComponent(g);
      
               
                           
              drawImage(g,UNIFIED.img);
              for(int i = 0; i<UNIFIED.img2.length;i++){
                      drawImage(g,UNIFIED.img2[i]);
                      
                  }
              
                  
                  
               try{
                Thread.sleep(50);
            } catch (Exception exc){
                System.out.println(exc);
            }
            
            repaint();
            
            
             
      
        
          
       
   
    }*/