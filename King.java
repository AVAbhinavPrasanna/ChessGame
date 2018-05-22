import java.awt.Color;
import java.awt.event.MouseEvent;



public class King extends Chesspiece {
	private int xpos;
	private int ypos;
	private Color color;

	public King(int x, int y,Color g){
	   xpos=x;
	   ypos=y;
	   color = g; 
	}


	@Override
	public void move(int numtimes,Direction d,Direction d2) {
		if(numtimes==1){
			if(d.equals(Direction.UP)&&d2.equals(Direction.UP)){
				ypos = ypos+numtimes;
			}
			if(d.equals(Direction.DOWN)&&d2.equals(Direction.DOWN)){
				ypos = ypos-numtimes;
			}
			if(d.equals(Direction.LEFT)&&d2.equals(Direction.UP)){
				xpos=xpos-numtimes;
				ypos=ypos+numtimes;
			}
			if(d.equals(Direction.RIGHT)&&d2.equals(Direction.UP)){
				xpos=xpos+numtimes;
				ypos=ypos+numtimes;
			}
			if(d.equals(Direction.RIGHT)&&d2.equals(Direction.DOWN)){
				xpos=xpos+numtimes;
				ypos=ypos-numtimes;
			}
			if(d.equals(Direction.LEFT)&&d2.equals(Direction.DOWN)){
				xpos=xpos-numtimes;
				ypos=ypos-numtimes;
			}
			if(d.equals(Direction.LEFT)&&d2.equals(Direction.LEFT)){
				xpos=xpos-numtimes;
			}
			if(d.equals(Direction.RIGHT)&&d2.equals(Direction.RIGHT)){
				xpos=xpos+numtimes;
			}

		}

	}
	public King[] getpossiblelocs(int rows, int columns,Color g) {
		King[] locs = new King[8];
		int b=this.getxpos();
		int c=this.getypos();
			if((b+1!=rows&&c+1!=columns)||(b-1!=-1&&c-1!=-1)) {
		     locs[0] =new King(b+1,c,g);
		     locs[1]=new King(b+1,c+1,g);
		     locs[2]=new King(b-1,c,g);
		     locs[3]=new King(b-1,c-1,g);
		     locs[4]=new King(b+1,c-1,g);
		     locs[5]=new King(b-1,c+1,g);
		     locs[6]=new King(b,c-1,g);
		     locs[7]=new King(b,c+1,g);
			}
		
		return locs;
	}
	

	@Override
	public int getxpos() {
		// TODO Auto-generated method stub
		return xpos;
	}
	@Override
	public int getypos() {
		// TODO Auto-generated method stub
		return ypos;
	}
	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return color;
	}
}
