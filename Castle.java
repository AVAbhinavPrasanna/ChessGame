import Chesspiece.Direction;


public class Castle extends Chesspiece {

	private int xpos;
	private int ypos;

	public Castle(int x,int y){
		xpos = x;
		ypos = y;
	}


	@Override
	public void take() {
		// TODO Auto-generated method stub

	}

	@Override
	public void move(int numtimes,Direction d,Direction d2) {
		if(d.equals(Direction.UP)&&d2.equals(Direction.UP)){
           ypos = ypos+numtimes;
           
		}
		if(d.equals(Direction.DOWN)&&d2.equals(Direction.DOWN)){
            ypos = ypos+numtimes;
		}
		if(d.equals(Direction.LEFT)&&d2.equals(Direction.LEFT)){
             xpos = xpos -numtimes;
		}
		if(d.equals(Direction.RIGHT)&&d2.equals(Direction.DOWN)){
             xpos=xpos+numtimes;
		}

	}

}
