import java.awt.Color;
import java.awt.event.MouseEvent;



public class Board {
	private Chesspiece[][] chessboard;
	private Chesspiece[] blackpieceslost;
	private Chesspiece[] whitepieceslost;
	private int rows;
	private int columns;
	private Color black = new Color(0,0,0);
	private Color white = new Color(255,255,255);
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
		int c=0;
		int m=0;
		int xpos=0;
		int ypos=0;
		for(int a = 0; a<rows;a++) {
			for(int k=0;k<rows;k++){
				Chesspiece b = chessboard[a][k];
				if(b.beenClickedon(e)) 
					if(e2.getY()>b.getypos()&&e2.getX()==b.getxpos()) {
						b.move(e.getY()-b.getypos(), b.d("UP"), b.d("UP"));
						if(chessboard[b.getypos()][b.getxpos()]!=null) {
							if(chessboard[b.getypos()][b.getxpos()].getColor()==black) {
								blackpieceslost[c]=chessboard[b.getypos()][b.getxpos()];
								c++;
							}
							else {
								whitepieceslost[m]=chessboard[b.getypos()][b.getxpos()];
								m++;
							}
						}
						if(b.getColor().equals(white)) {
							ypos = b.getypos();
							xpos=b.getxpos();
							b=new Queen(xpos,ypos,white);
						}
						chessboard[b.getypos()][b.getxpos()]=b;
					}
					else if(e2.getY()<b.getypos()&&e2.getX()==b.getypos()) {
						b.move(b.getypos()-e2.getY(), b.d("DOWN"), b.d("DOWN"));
						if(chessboard[b.getypos()][b.getxpos()]!=null) {
							if(chessboard[b.getypos()][b.getxpos()].getColor()==black) {
								blackpieceslost[c]=chessboard[b.getypos()][b.getxpos()];
								c++;
							}
							else {
								whitepieceslost[m]=chessboard[b.getypos()][b.getxpos()];
								m++;
							}
						}
						if(b.getColor().equals(black)) {
							ypos=b.getypos();
							xpos=b.getxpos();
							b=new Queen(xpos,ypos,black);
						}
						chessboard[b.getypos()][b.getxpos()]=b;
					}
					else if(e2.getY()==b.getypos()&&e2.getX()>b.getxpos()) {
						b.move(e2.getX()-b.getxpos(), b.d("RIGHT"), b.d("RIGHT"));
						if(chessboard[b.getypos()][b.getxpos()]!=null) {
							if(chessboard[b.getypos()][b.getxpos()].getColor()==black) {
								blackpieceslost[c]=chessboard[b.getypos()][b.getxpos()];
								c++;
							}
							else {
								whitepieceslost[m]=chessboard[b.getypos()][b.getxpos()];
								m++;
							}
						}
						chessboard[b.getypos()][b.getxpos()]=b;
					}
					else if(e2.getY()==b.getypos()&&e2.getX()<b.getxpos()) {
						b.move(b.getxpos()-e2.getX(), b.d("LEFT"), b.d("LEFT"));
						if(chessboard[b.getypos()][b.getxpos()]!=null) {
							if(chessboard[b.getypos()][b.getxpos()].getColor()==black) {
								blackpieceslost[c]=chessboard[b.getypos()][b.getxpos()];
								c++;
							}
							else {
								whitepieceslost[m]=chessboard[b.getypos()][b.getxpos()];
								m++;
							}
						}
						chessboard[b.getypos()][b.getxpos()]=b;
					}
					else if(e2.getY()>b.getypos()&&e2.getX()<b.getxpos()) {
						b.move(e.getY()-b.getypos(), b.d("LEFT"), b.d("UP"));
						if(chessboard[b.getypos()][b.getxpos()]!=null) {
							if(chessboard[b.getypos()][b.getxpos()].getColor()==black) {
								blackpieceslost[c]=chessboard[b.getypos()][b.getxpos()];
								c++;
							}
							else {
								whitepieceslost[m]=chessboard[b.getypos()][b.getxpos()];
								m++;
							}
						}
						chessboard[b.getypos()][b.getxpos()]=b;
					}
					else if(e2.getY()>b.getypos()&&e2.getX()>b.getxpos()) {
						b.move(e.getY()-b.getypos(), b.d("RIGHT"), b.d("UP"));
						if(chessboard[b.getypos()][b.getxpos()]!=null) {
							if(chessboard[b.getypos()][b.getxpos()].getColor()==black) {
								blackpieceslost[c]=chessboard[b.getypos()][b.getxpos()];
								c++;
							}
							else {
								whitepieceslost[m]=chessboard[b.getypos()][b.getxpos()];
								m++;
							}
						}
						chessboard[b.getypos()][b.getxpos()]=b;
					}
					else if(e2.getY()<b.getypos()&&e2.getX()>b.getxpos()) {
						b.move(b.getypos()-e2.getY(), b.d("RIGHT"), b.d("DOWN"));
						if(chessboard[b.getypos()][b.getxpos()]!=null) {
							if(chessboard[b.getypos()][b.getxpos()].getColor()==black) {
								blackpieceslost[c]=chessboard[b.getypos()][b.getxpos()];
								c++;
							}
							else {
								whitepieceslost[m]=chessboard[b.getypos()][b.getxpos()];
								m++;
							}
						}
						chessboard[b.getypos()][b.getxpos()]=b;
					}
					else if(e2.getY()<b.getypos()&&e2.getX()<b.getxpos()) {
						b.move(b.getypos()-e2.getY(), b.d("LEFT"), b.d("DOWN"));
						if(chessboard[b.getypos()][b.getxpos()]!=null) {
							if(chessboard[b.getypos()][b.getxpos()].getColor()==black) {
								blackpieceslost[c]=chessboard[b.getypos()][b.getxpos()];
								c++;
							}
							else {
								whitepieceslost[m]=chessboard[b.getypos()][b.getxpos()];
								m++;
							}
						}
						chessboard[b.getypos()][b.getxpos()]=b;
					}

				}
			}
		}
	
	public boolean check(Color color) {
		int a=0;
		for(int k =0;k<rows;k++) {
			for(int c=0;c<columns;c++) {
				if(chessboard[k][c] instanceof King) {
					while((k+a!=rows||c+a!=columns)||(k-a!=-1||c-a!=-1)) {
						if(chessboard[k+a][c] instanceof Castle&&!chessboard[k+a][c].equals(color) || chessboard[k][c+a] instanceof Castle&&!chessboard[k][c+a].equals(color)||
								chessboard[k-a][c] instanceof Castle&&!chessboard[k-a][c].equals(color) ||chessboard[k][c-a] instanceof Castle&&!chessboard[k][c-a].equals(color)) {
							return true;
						}
						else if(chessboard[k+a][c+a] instanceof Bishop&&!chessboard[k+a][c+a].equals(color)|| chessboard[k-a][c+a] instanceof Bishop&&!chessboard[k-a][c+a].equals(color)||
								chessboard[k+a][c-a] instanceof Bishop&&!chessboard[k+a][c-a].equals(color)|| chessboard[k-a][c-a] instanceof Bishop&&!chessboard[k-a][c-a].equals(color)) {
							return true;
						}
						else if(chessboard[k+a][c+a] instanceof Queen && !chessboard[k+a][c+a].equals(color)|| chessboard[k-a][c+a] instanceof Queen&&!chessboard[k-a][c+a].equals(color)||
								chessboard[k+a][c-a] instanceof Queen&&!chessboard[k+a][c-a].equals(color)|| chessboard[k-a][c-a] instanceof Queen&&!chessboard[k-a][c-a].equals(color)||
								chessboard[k+a][c] instanceof Queen&&!chessboard[k+a][c].equals(color) || chessboard[k][c+a] instanceof Queen&&!chessboard[k][c+a].equals(color)||
								chessboard[k-a][c] instanceof Queen&&!chessboard[k-a][c].equals(color) ||chessboard[k][c-a] instanceof Queen&&!chessboard[k][c-a].equals(color)) {
							return true;
						}
						else if((k+1!=rows||c+1!=columns)||(k-a!=-1||c-a!=-1)) {
							if(chessboard[k+1][c+a] instanceof Knight && !chessboard[k+1][c+a].equals(color)||chessboard[k-1][c+a] instanceof Knight && !chessboard[k-1][c+a].equals(color)||
									chessboard[k+a][c+1] instanceof Knight && !chessboard[k+a][c+1].equals(color)||chessboard[k-a][c-1] instanceof Knight && !chessboard[k-a][c-1].equals(color)||
									chessboard[k-a][c+1] instanceof Knight && !chessboard[k-a][c+1].equals(color)|| chessboard[k+a][c-1] instanceof Knight && !chessboard[k+a][c-1].equals(color)) {
								return true;
							}
							else if(color.equals(black)) {
								if(chessboard[k-1][c+1] instanceof Pawn|| chessboard[k-1][c-1] instanceof Pawn) {
									return true;
								}
							}
							else if(color.equals(white)) {
								if(chessboard[k+1][c+1] instanceof Pawn|| chessboard[k+1][c-1] instanceof Pawn) {
									return true;
								}
							}
						}
					}
				}


			}
		}
		return false;
	}
	public boolean checkmate(Color color) {
		Chesspiece h =null;
		for(int a=0;a<rows;a++) {
			for(int c=0;c<columns;c++) {
				if(chessboard[a][c] instanceof King) {
					h=chessboard[a][c];
					if((a+1!=rows||c+1!=columns)||(a-1!=-1||c-1!=-1)) {
						
					}
					}
				}
			}
		  return false;
		}
	

	public Chesspiece[] getBlack() {
		return blackpieceslost;
	}
	public Chesspiece[] getWhite() {
		return whitepieceslost;
	}
	public int getRows(){
		return rows;
	}
	public int getColumns(){
		return columns;
	}

}

