import Chesspiece.Direction;


public class Bishop extends Chesspiece {
   private int xpos;
   private int ypos;
   
   public Bishop(int x, int y){
	   xpos = x;
	   ypos = y;
   }


	@Override
	public void take() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move(int numtimes,Direction d,Direction d2) {
		if(d.equals(Direction.LEFT)){
			
		}
		
	}

}
