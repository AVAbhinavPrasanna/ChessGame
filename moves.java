
public class moves {
  private int x;
  private int y;
  private String k;
  
  public moves(int xpos,int ypos, String a) {
	  x=xpos;
	  y=ypos;
	  k=a;
  }
  
  public int getx() {
	  return x;
  }
  public int gety() {
	  return y;
  }
  public String piece() {
	  return k;
  }
}
