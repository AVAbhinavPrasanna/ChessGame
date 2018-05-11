import java.awt.event.MouseEvent;


public class Board {
   private Chesspiece[][] chessboard;
   private int rows;
   private int columns;
   public Board(int row, int col){
	   rows = row;
	   columns = col;
	   chessboard = new Chesspiece[rows][columns];
   }
   public void create(){
	   for(int a =0; a<rows;a++){
		   for(int k =0; k<columns;k++){
			   if(k==columns-2||k==2 ){
				   chessboard[a][k]= new Pawn(a,k);
			   }
			   else if(k==columns-1||k==0){
				   if(a==0||a==rows-1){
					   chessboard[a][k]=new Castle(a,k);
				   }
				   else if(a==1||a==rows-2){
					   chessboard[a][k]=new Knight(a,k);
				   }
				   else if(a==2||a==rows-3){
					   chessboard[a][k]=new Bishop(a,k);
				   }
				   else if(a==3){
					   chessboard[a][k]=new Queen(a,k);
				   }
				   else if(a==4){
					   chessboard[a][k]=new King(a,k);
				   }
			   }
		   }
	   }
   }
   
   public int getRows(){
	   return rows;
   }
   public int getColumns(){
	   return columns;
   }
   public void redraw(MouseEvent e){
	  for(int a =0; a<rows;a++){
		  for(int k=0; k<columns;k++){
			  if(chessboard[a][k].beenClickedon(e)){
				  
			  
		  }
	  }
   }
   }
}

