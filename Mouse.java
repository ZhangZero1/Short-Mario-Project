
import java.awt.*;
import java.awt.event.*;

public class Mouse
{
    public static void mousePressed(MouseEvent evt){
        //repaint
        System.out.println("X: "+evt.getLocationOnScreen().getX());
        
        System.out.println("Y: "+evt.getLocationOnScreen().getY());
    }
    public static void mouseDragged(MouseEvent evt) {
        
    }
}
