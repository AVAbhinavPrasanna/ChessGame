import Chesspiece.Direction;


public class Pawn extends Chesspiece {

	private int xpos;
	private int ypos;
	
	public Pawn(int y, int x){
		xpos = x;
		ypos = y;
	}
			
	

	@Override
	public void take() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move(int numtimes,Direction d,Direction d2) {
		if(numtimes<=2){
			if(d.equals(Direction.UP)){
				ypos = ypos+numtimes;
			}
		}
		
	}

}
