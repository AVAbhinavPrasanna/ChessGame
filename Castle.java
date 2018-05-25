import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.ArrayList;



public class Castle extends Chesspiece {
	private int xpos;
	private int ypos;
	private Color color;

	public Castle(int x, int y,Color g){
	   xpos=x;
	   ypos=y;
	   color = g; 
	}


	@Override
	public boolean beenClickedon(MouseEvent e) {
		if(e.getX()==getxpos()&&e.getY()==getypos()){
			return true;
			
		}
		return false;

	}
	public  ArrayList<moves> getpossiblemoves(Board a,Color g) {
		ArrayList<moves> moves= new ArrayList<moves>();
		Chesspiece[][] board = a.getBoard();
		Chesspiece k=null;
		int o=0;
		int b=0;
		for(int u=0; u<board.length;u++) {
			for(int i=0;i<board[0].length;i++) {
				if(board[u][i] instanceof Castle&&board[u][i].getColor().equals(g)) {
					k=board[u][i];
				}
			}
		}
		while(k.getxpos()+o!=board.length&&(k.getypos()!=board[0].length&&k.getypos()!=-1)) {
			if(board[k.getypos()][k.getxpos()+o]==null&&(!board[k.getypos()][k.getxpos()+o].equals(g))) {
				moves.add(new moves(k.getxpos()+o,k.getypos(),"Castle"));
				o++;
				
			}
		}
		while(k.getxpos()-o!=-1&&(k.getypos()!=board[0].length&&k.getypos()!=-1)) {
			if(board[k.getypos()][k.getxpos()-o]==null&&(!board[k.getypos()][k.getxpos()-o].equals(g))) {
				moves.add(new moves(k.getxpos()-o,k.getypos(),"Castle"));
				o--;
				
			}
		}
		while((k.getxpos()!=board.length&&k.getxpos()!=-1)&&k.getypos()+b!=board[0].length) {
			if(board[k.getypos()+b][k.getxpos()]==null&&(!board[k.getypos()+b][k.getxpos()].equals(g))) {
				moves.add(new moves(k.getxpos(),k.getypos()+b,"Castle"));
		        b++;
			}
		}
		while(k.getxpos()!=board.length&&k.getypos()-b!=board[0].length) {
			if(board[k.getypos()-b][k.getxpos()]==null&&(!board[k.getypos()-b][k.getxpos()].equals(g))) {
				moves.add(new moves(k.getxpos(),k.getypos()-b,"Castle"));
				b--;
			}
		}
		return moves;
	}                                    

	@Override
	public void move(int numtimes,Direction d,Direction d2) {
		if(d.equals(Direction.UP)&&d2.equals(Direction.UP)){
			ypos = ypos+numtimes;

		}
		if(d.equals(Direction.DOWN)&&d2.equals(Direction.DOWN)){
			ypos = ypos-numtimes;
		}
		if(d.equals(Direction.LEFT)&&d2.equals(Direction.LEFT)){
			xpos = xpos -numtimes;
		}
		if(d.equals(Direction.RIGHT)&&d2.equals(Direction.DOWN)){
			xpos=xpos+numtimes;
		}

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
