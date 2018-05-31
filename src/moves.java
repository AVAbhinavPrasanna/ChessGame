
public class moves {
    private int xpos;
    private int ypos;
    private String piece;
	public moves(int x, int y,String a) {
		xpos = x;
		ypos = y;
		piece = a;
	}
	
	public int getx() {
		return xpos;
	}
	public int gety() {
		return ypos;
	}
	public String getpiece() {
		return piece;
	}
}
