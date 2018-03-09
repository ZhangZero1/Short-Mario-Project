import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

//http://stackoverflow.com/questions/22730715/java-keyboard-input-game-development

public class KeyBinding extends JPanel {
   private static final String UP_KEY_PRESSED = "up key pressed";
   private static final String UP_KEY_RELEASED = "up key released";
   
   private static final String DOWN_KEY_PRESSED = "down key pressed";
   private static final String DOWN_KEY_RELEASED = "down key released";
   
   private static final String LEFT_KEY_PRESSED = "left key pressed";
   private static final String LEFT_KEY_RELEASED = "left key released";
   
   private static final String RIGHT_KEY_PRESSED = "right key pressed";
   private static final String RIGHT_KEY_RELEASED = "right key released";
   
   
   private static final int TIMER_DELAY = 10;
   
   Mario mar = new Mario(250,0);
   
   private Timer upTimer;
   private Timer downTimer;
   private Timer leftTimer;
   private Timer rightTimer;
   
   
   

   public KeyBinding() {
      
      
      
      int condition = WHEN_IN_FOCUSED_WINDOW;
      InputMap inputMap = getInputMap(condition);
      ActionMap actionMap = getActionMap();
      
      
      KeyStroke upKeyPressed = KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, false);
      KeyStroke upKeyReleased = KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, true);
      
      KeyStroke downKeyPressed = KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, false);
      KeyStroke downKeyReleased = KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, true);
      
      KeyStroke leftKeyPressed = KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, false);
      KeyStroke leftKeyReleased = KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, true);
      
      KeyStroke rightKeyPressed = KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, false);
      KeyStroke rightKeyReleased = KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, true);

      
      
      inputMap.put(upKeyPressed, UP_KEY_PRESSED);
      inputMap.put(upKeyReleased, UP_KEY_RELEASED);

      actionMap.put(UP_KEY_PRESSED, new UpAction(false));
      actionMap.put(UP_KEY_RELEASED, new UpAction(true));
      
      
      inputMap.put(downKeyPressed, DOWN_KEY_PRESSED);
      inputMap.put(downKeyReleased, DOWN_KEY_RELEASED);

      actionMap.put(DOWN_KEY_PRESSED, new DownAction(false));
      actionMap.put(DOWN_KEY_RELEASED, new DownAction(true));
      
      
      
      
      
      inputMap.put(leftKeyPressed, LEFT_KEY_PRESSED);
      inputMap.put(leftKeyReleased, LEFT_KEY_RELEASED);

      actionMap.put(LEFT_KEY_PRESSED, new LeftAction(false));
      actionMap.put(LEFT_KEY_RELEASED, new LeftAction(true));
      
      
      inputMap.put(rightKeyPressed, RIGHT_KEY_PRESSED);
      inputMap.put(rightKeyReleased, RIGHT_KEY_RELEASED);

      actionMap.put(RIGHT_KEY_PRESSED, new RightAction(false));
      actionMap.put(RIGHT_KEY_RELEASED, new RightAction(true));
      

   }
   
   public Mario getMario(){
       return mar;
    }

   private class UpAction extends AbstractAction {
      private boolean onKeyRelease;
      
      
      public UpAction(boolean onKeyRelease) {
         
         this.onKeyRelease = onKeyRelease;
      }

      @Override
      public void actionPerformed(ActionEvent evt) {
         if (!onKeyRelease) {
            if (upTimer != null && upTimer.isRunning()) {
               return;
            }
            

            upTimer = new Timer(TIMER_DELAY, new ActionListener() {

               @Override
               public void actionPerformed(ActionEvent e) {
                  mar.UpPressed();
               }
            });
            upTimer.start();
         } else {
            mar.UpReleased();
            if (upTimer != null && upTimer.isRunning()) {
               upTimer.stop();
               upTimer = null;
            }
            
         }
      }

   }
   
   private class DownAction extends AbstractAction {
      private boolean onKeyRelease;
      
      
      public DownAction(boolean onKeyRelease) {
         
         this.onKeyRelease = onKeyRelease;
      }

      @Override
      public void actionPerformed(ActionEvent evt) {
         if (!onKeyRelease) {
            if (downTimer != null && downTimer.isRunning()) {
               return;
            }
            

            downTimer = new Timer(TIMER_DELAY, new ActionListener() {

               @Override
               public void actionPerformed(ActionEvent e) {
                  mar.DownPressed();
               }
            });
            downTimer.start();
         } else {
            mar.DownReleased();
            if (downTimer != null && downTimer.isRunning()) {
               downTimer.stop();
               downTimer = null;
            }
            
         }
      }

   }
   
   private class RightAction extends AbstractAction {
      private boolean onKeyRelease;
      
      
      public RightAction(boolean onKeyRelease) {
         
         this.onKeyRelease = onKeyRelease;
      }

      @Override
      public void actionPerformed(ActionEvent evt) {
         if (!onKeyRelease) {
            if (rightTimer != null && rightTimer.isRunning()) {
               return;
            }
            

            rightTimer = new Timer(TIMER_DELAY, new ActionListener() {

               @Override
               public void actionPerformed(ActionEvent e) {
                  mar.RightPressed();
               }
            });
            rightTimer.start();
         } else {
            mar.RightReleased();
            if (rightTimer != null && rightTimer.isRunning()) {
               rightTimer.stop();
               rightTimer = null;
            }
            
         }
      }

   }
   
   private class LeftAction extends AbstractAction {
      private boolean onKeyRelease;
      
      
      public LeftAction(boolean onKeyRelease) {
         
         this.onKeyRelease = onKeyRelease;
      }

      @Override
      public void actionPerformed(ActionEvent evt) {
         if (!onKeyRelease) {
            if (leftTimer != null && leftTimer.isRunning()) {
               return;
            }
            

            leftTimer = new Timer(TIMER_DELAY, new ActionListener() {

               @Override
               public void actionPerformed(ActionEvent e) {
                  mar.LeftPressed();
               }
            });
            leftTimer.start();
         } else {
            mar.LeftReleased();
            if (leftTimer != null && leftTimer.isRunning()) {
               leftTimer.stop();
               leftTimer = null;
            }
            
         }
      }

   }

   
}