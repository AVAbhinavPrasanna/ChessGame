import java.awt.Color;

public class CPU {
  enum Diff{Easy,Medium,Hard};
  private Diff d;
  private Color g;
  
  public CPU(int dif,Color color){
	  if(dif<=3){
		  d= Diff.Easy;
	  }
	  if(dif>3&&dif<=5){
		  d=Diff.Medium;
	  }
	  if(dif>5&&dif<=10){
		  d=Diff.Hard;
	  }
	  g = color;
  }
       public boolean withinBoard(Board a,int x, int y) {
    	   Chesspiece[][] boardcheck = a.getBoard();
    	   Chesspiece k;
    	   for(int b=0;b<boardcheck.length;b++) {
    		   for(int u=0;u<boardcheck[0].length;u++) {
    			   if(boardcheck[b][u] instanceof Pawn) {
    				  k = boardcheck[b][u];
    				  
    			   }
    		   }
    	   }
    	   return false;
       }
  
  
}
