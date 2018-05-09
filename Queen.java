import Chesspiece.Direction;


public class Queen extends Chesspiece {
   private int xpos;
   private int ypos;
   
   public Queen(int x, int y){
	   xpos = x;
	   ypos= y;
	   
   }
	@Override
	public void move(int numtimes,Direction d,Direction d2) {
		if(d.equals(Direction.UP)){
		    xpos = xpos+numtimes;
		}
		if(d.equals(Direction.DOWN)){
			xpos=xpos-numtimes;
		}
		if(d.equals(Direction.RIGHT)){
			xpos=xpos+numtimes;
			ypos=ypos+numtimes;
		}
		if(d.equals(Direction.LEFT)){
			xpos=xpos-numtimes;
			ypos=ypos-numtimes;
		}
		
	}

	@Override
	public void take() {
		// TODO Auto-generated method stub
		
	}

}
