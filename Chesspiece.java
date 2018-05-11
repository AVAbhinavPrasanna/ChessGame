import java.awt.Graphics;
import java.awt.event.MouseEvent;


public abstract class Chesspiece {
	public enum Direction{LEFT,RIGHT,UP,DOWN}
	
	
	public abstract void move(int numtimes,Direction d,Direction d2);
	public abstract boolean beenClickedon(MouseEvent e);
	public abstract int getxpos();
	public abstract int getypos();
	

}
