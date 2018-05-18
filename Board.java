import java.awt.Color;
import java.awt.event.MouseEvent;



public class Board {
	private Chesspiece[][] chessboard;
	private int rows;
	private int columns;
	private Color black = new Color(0,0,0);
	private Color white = new Color(255,255,255);
	private int Blacklost;
	private int Whitelost;
	public Board(int row, int col){
		rows = row;
		columns = col;
		chessboard = new Chesspiece[rows][columns];
	}
	public void create(){
		for(int a =0; a<rows;a++){
			for(int k =0; k<columns;k++){
				if(a==columns-2||a==2 ){
					if(a==columns-2) {
						chessboard[a][k]= new Pawn(k,a,black);
					}
					else if (a==2) {
						chessboard[a][k]= new Pawn(k,a,white);
					}
				}
				else if(a==columns-1||a==0){
					if(k==0||k==rows-1){
						if(a==columns-1) {
							chessboard[a][k]=new Castle(k,a,black);
						}
						else if (a==0) {
							chessboard[a][k]=new Castle(k,a,white); 
						}
					}
					else if(k==1||k==rows-2){
						if(a==columns-1) {
							chessboard[a][k]=new Knight(k,a,black);
						}
						else if(a==0) {
							chessboard[a][k]=new Knight(k,a,white); 
						}
					}
				}
				else if(k==2||k==rows-3){
					if(a==columns-1) {
						chessboard[a][k]=new Bishop(k,a,black);
					}
					else if(a==0) {
						chessboard[a][k]=new Bishop(k,a,white); 
					}
				}
				else if(k==3){
					if(a==columns-1) {
						chessboard[a][k]=new Queen(k,a,black);
					}
					else if(a==0){
						chessboard[a][k]=new Queen(k,a,white);
					}
				}
				else if(a==4){
					if(a==columns-1) {
						chessboard[a][k]=new King(k,a,black);
					}
					else if(a==0) {
						chessboard[a][k]=new King(k,a,white);
					}
				}
			}
		}
	}
	public void redraw(MouseEvent e, MouseEvent e2) {
		for(int a = 0; a<rows;a++) {
			for(int k=0;k<rows;k++){
				Chesspiece b = chessboard[a][k];
				if(b.beenClickedon(e)) {
					if(e2.getY()>b.getypos()&&e2.getX()==b.getxpos()) {
						b.move(e.getY()-b.getypos(), b.d("UP"), b.d("UP"));
						if(chessboard[b.getypos()][b.getxpos()]!=null) {
							if(chessboard[b.getypos()][b.getxpos()].getColor()==black) {
								Blacklost=Blacklost+1;
							}
							else {
								Whitelost=Whitelost+1;
							}
						}
						chessboard[b.getypos()][b.getxpos()]=b;
					}
					else if(e2.getY()<b.getypos()&&e2.getX()==b.getypos()) {
						b.move(b.getypos()-e2.getY(), b.d("DOWN"), b.d("DOWN"));
						if(chessboard[b.getypos()][b.getxpos()]!=null) {
							if(chessboard[b.getypos()][b.getxpos()].getColor()==black) {
								Blacklost=Blacklost+1;
							}
							else {
								Whitelost=Whitelost+1;
							}
						}
						chessboard[b.getypos()][b.getxpos()]=b;
					}
					else if(e2.getY()==b.getypos()&&e2.getX()>b.getxpos()) {
						b.move(e2.getX()-b.getxpos(), b.d("RIGHT"), b.d("RIGHT"));
						if(chessboard[b.getypos()][b.getxpos()]!=null) {
							if(chessboard[b.getypos()][b.getxpos()].getColor()==black) {
								Blacklost=Blacklost+1;
							}
							else {
								Whitelost=Whitelost+1;
							}
						}
						chessboard[b.getypos()][b.getxpos()]=b;
					}
					else if(e2.getY()==b.getypos()&&e2.getX()<b.getxpos()) {
						b.move(b.getxpos()-e2.getX(), b.d("LEFT"), b.d("LEFT"));
						if(chessboard[b.getypos()][b.getxpos()]!=null) {
							if(chessboard[b.getypos()][b.getxpos()].getColor()==black) {
								Blacklost=Blacklost+1;
							}
							else {
								Whitelost=Whitelost+1;
							}
						}
						chessboard[b.getypos()][b.getxpos()]=b;
					}
					else if(e2.getY()>b.getypos()&&e2.getX()<b.getxpos()) {
						b.move(e.getY()-b.getypos(), b.d("LEFT"), b.d("UP"));
						if(chessboard[b.getypos()][b.getxpos()]!=null) {
							if(chessboard[b.getypos()][b.getxpos()].getColor()==black) {
								Blacklost=Blacklost+1;
							}
							else {
								Whitelost=Whitelost+1;
							}
						}
						chessboard[b.getypos()][b.getxpos()]=b;
					}
					else if(e2.getY()>b.getypos()&&e2.getX()>b.getxpos()) {
						b.move(e.getY()-b.getypos(), b.d("RIGHT"), b.d("UP"));
						if(chessboard[b.getypos()][b.getxpos()]!=null) {
							if(chessboard[b.getypos()][b.getxpos()].getColor()==black) {
								Blacklost=Blacklost+1;
							}
							else {
								Whitelost=Whitelost+1;
							}
						}
						chessboard[b.getypos()][b.getxpos()]=b;
					}
					else if(e2.getY()<b.getypos()&&e2.getX()>b.getxpos()) {
						b.move(b.getypos()-e2.getY(), b.d("RIGHT"), b.d("DOWN"));
						if(chessboard[b.getypos()][b.getxpos()]!=null) {
							if(chessboard[b.getypos()][b.getxpos()].getColor()==black) {
								Blacklost=Blacklost+1;
							}
							else {
								Whitelost=Whitelost+1;
							}
						}
						chessboard[b.getypos()][b.getxpos()]=b;
					}
					else if(e2.getY()<b.getypos()&&e2.getX()<b.getxpos()) {
						b.move(b.getypos()-e2.getY(), b.d("LEFT"), b.d("DOWN"));
						if(chessboard[b.getypos()][b.getxpos()]!=null) {
							if(chessboard[b.getypos()][b.getxpos()].getColor()==black) {
								Blacklost=Blacklost+1;
							}
							else {
								Whitelost=Whitelost+1;
							}
						}
						chessboard[b.getypos()][b.getxpos()]=b;
					}

				}
			}
		}
	}
	public int getWhiteLost() {
		return Whitelost;
	}
	public int getBlackLost() {
		return Blacklost;
	}
	public int getRows(){
		return rows;
	}
	public int getColumns(){
		return columns;
	}

}

