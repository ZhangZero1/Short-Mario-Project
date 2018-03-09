import java.awt.*;
import javax.swing.*;
public class MAIN
{
    public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         // Run the GUI codes on the Event-Dispatching thread for thread safety
         @Override
         public void run() {
            new UI(); // Let the constructor do the job
         }
      });
   }
}
