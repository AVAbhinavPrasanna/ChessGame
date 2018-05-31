import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;



public class Pawn extends Chesspiece {

	private int xpos;
	private int ypos;

	private Color color;

	public Pawn(int x, int y,Color g){
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
	@Override
	public void move(int numtimes,Direction d,Direction d2) {
		if( (numtimes<=2) && (d.equals(Direction.UP)||d.equals(Direction.DOWN))){
			if(d.equals(Direction.UP)&&d2.equals(Direction.UP)){
				ypos = ypos+numtimes;
			}
			if(d.equals(Direction.DOWN)&&d2.equals(Direction.DOWN)){
				ypos=ypos-numtimes;
			}
		}
		else if ((numtimes==1) && ((d.equals(Direction.LEFT)||d.equals(Direction.RIGHT)))){
			if(d.equals(Direction.RIGHT)&&d2.equals(Direction.UP)){
				ypos = ypos+numtimes; 
				xpos=xpos+numtimes;
			}
			if(d.equals(Direction.LEFT)&&d2.equals(Direction.UP)){
				xpos = xpos-numtimes;
				ypos=ypos+numtimes;


				if(d.equals(Direction.RIGHT)&&d2.equals(Direction.DOWN)){
					xpos = xpos+numtimes; 
					ypos = ypos-numtimes;
				}
				if(d.equals(Direction.LEFT)&&d2.equals(Direction.DOWN)){
					xpos = xpos-numtimes;
					ypos = ypos-numtimes;
				}
			}
		}


	}
	public  ArrayList<moves> getpossiblemoves(Board a,Color g) {
		ArrayList<moves> moves= new ArrayList<moves>();
		Chesspiece[][] board = a.getBoard();
		Chesspiece k=null;
		int o=0;
		for(int u=0; u<board.length;u++) {
			for(int i=0;i<board[0].length;i++) {
				if(board[u][i] instanceof Queen&&board[u][i].getColor().equals(g)) {
					k=board[u][i];
				}
			}
		}
		if(k.getxpos()+1!=board.length&&k.getypos()+1!=board[0].length) {
			if(board[k.getypos()+1][k.getxpos()+1]==null&&(!board[k.getypos()+1][k.getxpos()+1].equals(g))) {
				moves.add(new moves(k.getxpos()+1,k.getypos()+1,"Pawn"));
			}
		}
		else if(k.getxpos()-1!=-1&&k.getypos()+1!=board[0].length) {
			if(board[k.getypos()+1][k.getxpos()-1]==null&&(!board[k.getypos()+1][k.getxpos()-1].equals(g))) {
				moves.add(new moves(k.getxpos()-1,k.getypos()+1,"Pawn"));
			}
		}
		else if(k.getxpos()+1!=board.length&&k.getypos()-1!=-1) {
			if(board[k.getypos()-1][k.getxpos()+1]==null&&(!board[k.getypos()-1][k.getxpos()+1].equals(g))) {
				moves.add(new moves(k.getxpos()+1,k.getypos()-1,"Pawn"));
			}
		}
		else if(k.getxpos()-1!=-1&&k.getypos()-1!=-1) {
			if(board[k.getypos()-1][k.getxpos()-1]==null&&(!board[k.getypos()-1][k.getxpos()-1].equals(g))) {
				moves.add(new moves(k.getxpos()-1,k.getypos()-1,"Pawn"));
			}
		}
		while(o<=2) {
		 if(k.getypos()+o!=board.length&&(k.getxpos()!=board[0].length&&k.getxpos()!=-1)) {
			if(board[k.getypos()+o][k.getxpos()]==null&&(!board[k.getypos()+o][k.getxpos()].equals(g))) {
				moves.add(new moves(k.getxpos(),k.getypos()+o,"Pawn"));
				o++;
			}
		}
	}
		while(o<=2) {
		 if(k.getypos()-o!=-1&&(k.getxpos()!=board.length&&k.getxpos()!=-1)) {
			if(board[k.getypos()-o][k.getxpos()]==null&&(!board[k.getypos()-o][k.getxpos()].equals(g))) {
				moves.add(new moves(k.getxpos(),k.getypos()+o,"Pawn"));
				o--;
			}
		}
	}
		
		return moves;
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
	
	
	@Override
	public void setpos(int x, int y) {
		// TODO Auto-generated method stub
		xpos = x;
		ypos = y;
	}
	
}


