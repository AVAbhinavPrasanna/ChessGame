import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class Knight extends Chesspiece {
	private int xpos;
	private int ypos;
	private Color color;

	public Knight(int x, int y,Color g){
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
		if(numtimes==3){
			if(d.equals(Direction.UP)&&d2.equals(Direction.LEFT)){
               xpos=xpos-1;
               ypos=ypos+numtimes;
			}
			if(d.equals(Direction.UP)&&d2.equals(Direction.RIGHT)){
				xpos=xpos+1;
				ypos=ypos+numtimes;

			}
			if(d.equals(Direction.DOWN)&&d2.equals(Direction.LEFT)){
				xpos=xpos-1;
				ypos=ypos-numtimes;

			}
			if(d.equals(Direction.DOWN)&&d2.equals(Direction.RIGHT)){
				xpos=xpos-1;
                ypos=ypos-numtimes;
			}
			if(d.equals(Direction.LEFT)&&d2.equals(Direction.UP)){
                 xpos=xpos-numtimes;
                 ypos=ypos+1;
			}
			if(d.equals(Direction.LEFT)&&d2.equals(Direction.DOWN)){
                xpos=xpos-numtimes;
                ypos=ypos-1;
			}
			if(d.equals(Direction.RIGHT)&&d2.equals(Direction.UP)){
                xpos=xpos+numtimes;
                ypos=ypos+1;
			}
			if(d.equals(Direction.RIGHT)&&d2.equals(Direction.DOWN)){
                xpos=xpos+numtimes;
                ypos=ypos-1;
			} 
		}

	}
	public  ArrayList<moves> getpossiblemoves(Board a,Color g) {
		ArrayList<moves> moves= new ArrayList<moves>();
		Chesspiece[][] board = a.getBoard();
		Chesspiece k=null;
		int o=0;
		int b=0;
		for(int u=0; u<board.length;u++) {
			for(int i=0;i<board[0].length;i++) {
				if(board[u][i] instanceof Knight&&board[u][i].getColor().equals(g)) {
					k=board[u][i];
				}
			}
		}
		if(k.getxpos()+3!=board[0].length&&k.getypos()-1!=board.length) {
			if(board[k.getypos()-1][k.getxpos()+3]==null&&(!board[k.getypos()-1][k.getxpos()+3].equals(g))) {
				moves.add(new moves(k.getxpos()+3,k.getypos()-1,"Knight"));
				
				
			}
		}
		else if(k.getxpos()+3!=board[0].length&&k.getypos()+1!=board.length) {
			if(board[k.getypos()+1][k.getxpos()+3]==null&&(!board[k.getypos()+1][k.getxpos()+3].equals(g))) {
				moves.add(new moves(k.getxpos()+3,k.getypos()+1,"Knight"));
				
				
			}
		}
		else if(k.getxpos()-3!=board[0].length&&k.getypos()-1!=board.length) {
			if(board[k.getypos()-1][k.getxpos()-3]==null&&(!board[k.getypos()-1][k.getxpos()-3].equals(g))) {
				moves.add(new moves(k.getxpos()-3,k.getypos()-1,"Knight"));
		        
			}
		}
		else if(k.getxpos()-3!=board[0].length&&k.getypos()+1!=board.length) {
			if(board[k.getypos()+1][k.getxpos()-3]==null&&(!board[k.getypos()+1][k.getxpos()-3].equals(g))) {
				moves.add(new moves(k.getxpos()-3,k.getypos()+1,"Knight"));
				
			}
			else if(k.getxpos()-1!=board[0].length&&k.getypos()-3!=board.length) {
				if(board[k.getypos()-3][k.getxpos()-1]==null&&(!board[k.getypos()-3][k.getxpos()-1].equals(g))) {
					moves.add(new moves(k.getxpos()-1,k.getypos()-3,"Knight"));
					
				}
		}
			else if(k.getxpos()-1!=board[0].length&&k.getypos()+3!=board.length) {
				if(board[k.getypos()+3][k.getxpos()-1]==null&&(!board[k.getypos()+3][k.getxpos()-1].equals(g))) {
					moves.add(new moves(k.getxpos()-1,k.getypos()+3,"Knight"));
					
				}
		}
			else if(k.getxpos()+1!=board[0].length&&k.getypos()+3!=board.length) {
				if(board[k.getypos()+3][k.getxpos()+1]==null&&(!board[k.getypos()+3][k.getxpos()+1].equals(g))) {
					moves.add(new moves(k.getxpos()+1,k.getypos()+3,"Knight"));
					
				}
		}
			else if(k.getxpos()+1!=board[0].length&&k.getypos()-3!=board.length) {
				if(board[k.getypos()-3][k.getxpos()+1]==null&&(!board[k.getypos()-3][k.getxpos()+1].equals(g))) {
					moves.add(new moves(k.getxpos()+1,k.getypos()-3,"Knight"));
					
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
