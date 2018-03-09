import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;
import javax.swing.SwingWorker;

//http://www.javacreed.com/swing-worker-example/
public class Gravity extends SwingWorker<Integer, String>
{
    
    
    public Gravity(){
        
    }
    protected Integer doInBackground() throws Exception {
            //System.out.println(gra);
        
            while(UNIFIED.run){
                
                if(UNIFIED.canChange){
                   
                    
                    
                    for(int i = 0; i<Intogohr.target.size();i++){
                        if(Intogohr.target.get(i).getCOL()){
                            Intogohr.target.get(i).setY(Intogohr.target.get(i).getY()-10);
                        }
                    }
                    
                }
                    
                    
                     Thread.sleep(25);
             }
               
                
            
        
            return 0;
    }
    protected void process(final List<String> chunks) {
        for (final String string : chunks) {
          //System.out.println(string);
          
        }
    }
    
    
    
}
