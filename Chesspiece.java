
public abstract class Chesspiece {
	public enum Direction{LEFT,RIGHT,UP,DOWN}
	
	
	
	public abstract void move(int numtimes,Direction d,Direction d2);
	public abstract void take();

}
