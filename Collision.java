import java.util.*;

public class Collision extends Intogohr
{
    
    
    
    int subject;
    
    public Collision( int sub){
        
        subject = sub;
        
    }
    
    public int getSUBJECT(){
        return subject;
    }
    
    
   
    
    public char Collide(int tar){
        int left = getTAR(tar)[0][0] + getX(tar);
        int right = getTAR(tar)[0][1] + getX(tar);
        int bottom = getTAR(tar)[1][0] - getY(tar);
        int top = getTAR(tar)[1][1] - getY(tar);
        
        int Left = getTAR(subject)[0][0] + getX(subject);
        int Right = getTAR(subject)[0][1] + getX(subject);
        int Bottom = getTAR(subject)[1][0] - getY(subject);  
        int Top = getTAR(subject)[1][1] - getY(subject);
        
        int pleft = getTAR(tar)[0][0];
        int pright = getTAR(tar)[0][1];
        int pbottom = getTAR(tar)[1][0];
        int ptop = getTAR(tar)[1][1];
        
        int pLeft = getTAR(subject)[0][0];
        int pRight = getTAR(subject)[0][1];
        int pBottom = getTAR(subject)[1][0];
        int pTop = getTAR(subject)[1][1];
        
        
        // which side are we outisde of relative to the target box
        boolean B = pTop>=pbottom;
        boolean T = pBottom<=ptop;
        boolean R = pLeft>=pright;
        boolean L = pRight<=pleft;
        
        boolean VER = Top<bottom && Bottom>top;
        
        boolean HOR = Left<right && Right>left;
        
        boolean V = pTop<pbottom && pBottom>ptop;
        
        boolean H = pLeft<pright && pRight>pleft;
        
        
            
    
        
        // corner exception :: BEFORE HORIZONTAL/VERTICAL collision set
        // OR NOT before on one side and after on the other side (Speed through the boundry)
        if(R && Right<left && VER){
            return 'L';
        }else if(L && Left>right && VER){
            return 'R';
        }else if(B && Bottom<top && HOR){
            return 'T';
        }else if(T && Top>bottom && HOR){
            return 'B';
        }else{
            
            
         
            if(HOR && VER && R && V ){
                return 'L';
            }else if(HOR && VER && L && V){
                return 'R';
            }else if(VER && HOR && B && H){
                return 'T';
            }else if(VER && HOR && T && H){
                return 'B';
            }else{
                if(HOR && VER){
                    if(R&&T){
                        return 'B';
                    }else if(R&&B){ 
                        return 'T';
                    }else if(L&&T){ 
                        return 'B';
                    }else if(L&&B){
                        return 'T';
                    }
                }else{
                    return 'F';
                }
            }   
            
            
        }
        return 'F'; // stop annoying me java.
    }
    
    public String collisionType(){
        //char[] finalStuff = new char[size()-1];
        String finalStuff = "";
        
        int c = 0;
        
        
        while( c<size()){
            if(c!=subject){
                
                
                finalStuff += Collide(c) +""+ getType(c);
                
                
            }else{
                finalStuff += "XX";
            }
            c++;
            
        }
        
        return finalStuff;
    }
    
    public boolean collide(int tar){
        //System.out.println("     "+Collide(tar));
        boolean[] can = {false, false, false, false, true};
        if(condCol(tar, 'N')){
            can[0] = true;
            
        }
        if(condCol(tar, 'S')){
            can[1] = true;
            
        }
        if(condCol(tar, 'E')){
            can[2] = true;
            
        }
        if(condCol(tar, 'W')){
            can[3] = true;
            
        }
        return !( (Collide(tar) == 'F' &&  can[4] ) || (Collide(tar) == 'B' && can[0])  || (Collide(tar) == 'T' && can[1]) || (Collide(tar) == 'L' && can[2]) || (Collide(tar) == 'R' && can[3])  );
    }
    
    public int Xdiff(int tar){
        int left = getTAR(tar)[0][0] + getX(tar);
        int right = getTAR(tar)[0][1] + getX(tar);
        
        
        int Left = getTAR(subject)[0][0] + getX(subject);
        int Right = getTAR(subject)[0][1] + getX(subject);
        char test = Collide(tar);
        if(test == 'L' ){
            
            return right-Left    +1;
        }else if(test == 'R' ){
            
            return left-Right   -1 ;
        }else{
            
            return 0;
        }
        
    }
    
    public int Ydiff(int tar){
        int bottom = getTAR(tar)[1][0] - getY(tar);
        int top = getTAR(tar)[1][1] - getY(tar);
        
        int Bottom = getTAR(subject)[1][0] - getY(subject);
        int Top = getTAR(subject)[1][1] - getY(subject);
        char test = Collide(tar);
        
        if(test == 'T' ){
            return  bottom-Top    +1 ;
        }else if(test == 'B'){
            return top-Bottom     -1;
        }else{
            return 0;
        }
    }
    
    public int[][] correct(){
        int[][] finalStuff = new int[size()-1][2];
        int[] temp;
        int c = 0;
        int i = 0;
        while( c<size()){
            if(c!=subject){
                if(!collide(c)){
                    temp = new int[]{0,0};
                }
                else{
                    temp = new int[]{Xdiff(c), -Ydiff(c)};
                }
                
                finalStuff[i] = temp;
                i++;
                
            }
            c++;
            
        }
        /*System.out.println("==================");
        for(int g = 0; g<finalStuff.length; g++){
            
            System.out.println(finalStuff[g][0] +"          " + finalStuff[g][1]);
        }*/
        return finalStuff;
    }
    
    public void Correct(){
        corX(correct());
        corY(correct());
        
        
    }
    
    void corX(int[][] correction){
        boolean correct = false;
        
        int smallest = 0;
        for(int i = 0; i<correction.length;i++){
            correct = correct || correction[i][0]!=0;
        }
        
        if(correct ){
            
            for(int i = 0; i<correction.length;i++){
               
               if(Math.abs(correction[i][0]) >= Math.abs(smallest))
               {
                   smallest = correction[i][0];
                   
               }
               
            }
            
            
            setX(subject, getX(subject)+smallest);
            
            
            
            
        }
        else{
            // do nothing
            
        }
        
    }
    
    void corY(int[][] correction){
        boolean correct = false;
        int smallest = 0;
        
        for(int i = 0; i<correction.length;i++){
            correct = correct || correction[i][1]!=0;
        }
        
        if(correct ){
            
            for(int i = 0; i<correction.length;i++){
               if(Math.abs(correction[i][1]) >= Math.abs(smallest))
               {
                   smallest = correction[i][1];
               }
            }
            //System.out.println("SMALLEST:  "+smallest);
            
            setY(subject, getY(subject)+smallest);
            
            
            
        }
        else{
            // do nothing
            
        }
        
    }
    
    
}
