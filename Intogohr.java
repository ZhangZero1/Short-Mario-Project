import java.util.*;

public class Intogohr
{
    public static ArrayList<Intoger> target;
    public static boolean isFine = false;
    public static int avalible = 0;
    
    public Intogohr(){
        if(!isFine){
            target = new ArrayList<Intoger>();
        }
        isFine = true;
    }
    
    public int getNextNum(){
        int x = -1;
        for(int i = 0; i<target.size(); i++){
            if(target.get(i).getNul() == true){
                x = i;  
            }
            
        }

        if(x == -1){
            return target.size();
        }
        else{
            return x;
        }
    }
    
    public void setType(char in, int index){
        target.get(index).newTypes(in);
    }
    public char getType(int index){
        return target.get(index).getTypes();
    }
    
    
    public ArrayList<Intoger> get(){
        return target;
    }
    
    
    public boolean condCol(int index, char in){
        boolean truth = false;
        //System.out.println(target.get(index).condCollide().size());
        
        for(int i = 0; i<target.get(index).condCollide().size();i++){
               
            
                //System.out.println((target.get(index).condCollide().get(0).charValue() == in) + "Apples");
                truth = truth || target.get(index).condCollide().get(i).charValue() == in;
                // all inputs match one target value
                // desire all inputs are matched
                
            
            
        }
        //System.out.println();
        //System.out.println(check);
        return truth;
    }

    public boolean isFine(){
        return isFine;
    }

    public void reset(int index, int[][] inp){
        target.get(index).reset(inp);
        
        
        
    }
    
    public void addIntoger(int x,Intoger img){
        
        if(x < target.size()){
            target.set(x, img);
        }else{
            target.add(img);
        }
        
    }
    public void removeIntoger(int index){
        target.get(index).reset(new int[][]{{0,0},{0,0}});
        target.get(index).setNul(true);
        target.get(index).setX(0);
        target.get(index).setY(0);
        target.get(index).newTypes('Z');
    }
    
    public int[][] getTAR(int index){
        return target.get(index).getTAR();
    }
    
    public int size(){
        return target.size();
    }
        
    public void setX(int index, int x){
        target.get(index).setX(x);
        
              
    }
    public void setY(int index, int y){
        target.get(index).setY(y);
        
        
    }
    
    public int getX(int index){
        return target.get(index).getX();
    }
    public int getY(int index){
        return target.get(index).getY();
    }
}
