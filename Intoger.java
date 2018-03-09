import java.util.*;

public class Intoger{
        int[][] tar;
        int deltaX;
        int deltaY;
        
        boolean nully;
        boolean collision;
        
        final char killLeft = 'L';
        final char killRight = 'R';
        final char killTop = 'T';
        final char killBottom = 'B';
        
        final char Mushroom = 'M';
        final char FireFlower = 'F';
        
        final char unLeft = 'W';
        final char unRight = 'E';
        final char unTop = 'N';
        final char unBottom = 'S';
        
        ArrayList<Character> options;
        char unitType; // type that collision options are applied to.
        /*
         *  'M' mario
         *  'S' super mario
         *  'G' goomba
         *  'P' platform
         *  
         * 
         * 
         */
        
        
        Intoger(int[][] inp,boolean col, char UNIType, char... in){
            tar = inp;
            deltaX = 0;
            deltaY = 0;
            options = new ArrayList<Character>();
            unitType = UNIType;
            for(char x: in){
                options.add(x);
                System.out.println(x);
            }
            nully = false;
            collision = col;
            
        }
        
        public boolean getCOL(){
            return collision;
        }
        
         
        public boolean getNul(){
            return nully;
        }
         public void setNul(boolean stuff){
            nully = stuff;
        }
        
        public void newTypes(char newValue){
            unitType = newValue;
        }
        
        public char getTypes(){
            return unitType;
        }
        
        public ArrayList<Character> condCollide(){
            return options;
        }
        
        public int[][] getTAR(){
            return tar;
        }
        
        public void reset(int[][] inp){
            tar = inp;
        }
        
        public void setX(int x){
            deltaX = x;
        }
        public void setY(int y){
            deltaY = y;
        }
        
        public int getX(){
            return deltaX;
        }
        public int getY(){
            return deltaY;
        }
    }