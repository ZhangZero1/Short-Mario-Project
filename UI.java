import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.util.Timer;
import java.util.TimerTask;

public class UI extends JFrame{
   
   final static int WIDTH = 500;
   final static int HEIGHT = 300;
  
   
   UI() {
      Drawer.INITIALIZE();
      UNIFIED.Stage = new Drawing(); 
      
      Gravity a = new Gravity();
      a.execute();
      
      UNIFIED.Stage.setPreferredSize(new Dimension(WIDTH,HEIGHT));
      
      UNIFIED.Stage.addMouseListener(new MouseAdapter() {
         @Override
         public void mousePressed(MouseEvent evt) {
            Mouse.mousePressed(evt);
         }
         });
      UNIFIED.Stage.addMouseMotionListener(new MouseMotionAdapter() {
         @Override
         public void mouseDragged(MouseEvent evt) {
            Mouse.mouseDragged(evt);
         }
      });
      
      
      
      
       

      
      setContentPane(UNIFIED.Stage);
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setTitle("Paint");
      pack();
      setVisible(true);
      
      
      
      
  }
      
      
      
      
      
      
   }   
   
