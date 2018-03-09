import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.util.*;

public class Drawer
{
    public static BufferedImage inits(String name){
          BufferedImage img = null;
          
          
          try {
              img =  ImageIO.read(new File(name));
          }  catch (IOException e) {
             System.out.println(e);  
          }
          
          
          return img;
    }
    
    public static BufferedImage[] init(String name){
        BufferedImage[] returnValue = null;
        try {
              returnValue = new BufferedImage[new File(name).listFiles().length];
              for(int i = 0; i<returnValue.length; i++){
                     returnValue[i] = ImageIO.read(new File(name).listFiles()[i]);
                }
          }  catch (IOException e) {
             System.out.println(e);  
          }
        return returnValue;
    }
    
    public static void INITIALIZE(){
        UNIFIED.target = new ArrayList<Intoger>();
    }
    
    /*public static void addIMG(Images img){
        
        UNIFIED.target.add(new Intoger(  img.getTAR() ));
        //System.out.println(UNIFIED.target.get(0).getY());
    
    }*/
    
    public static void setVx(int amo){
        Intoger aes = UNIFIED.target.get(0);
        aes.setX(amo);
        UNIFIED.target.set(0, (aes ));
    }
    public static void setVy(int amo){
        Intoger aes = UNIFIED.target.get(0);
        aes.setY(amo);
        UNIFIED.target.set(0, (aes ));
    }
    
	
    
    
   
    
}
