import java.awt.Color;

public class CPU {
	enum Diff{Easy,Medium,Hard};
	private Diff d;
	private Color g;
	private Color black = new Color(0,0,0);
	private Color white = new Color(255,255,255);

	public CPU(int dif,Color color){
		if(dif<=3){
			d= Diff.Easy;
		}
		if(dif>3&&dif<=5){
			d=Diff.Medium;
		}
		if(dif>5&&dif<=10){
			d=Diff.Hard;
		}
		g = color;
	}
	public ArrayList<moves> getallpossiblemoves(Board a, Color j){
		Chesspiece[][] board = a.getBoard();
		for(int r=0;r<board.length;r++) {
			for(int c=0;c<board[0].length;c++) {
				
			}
		}
	}
	public boolean withinBoard(Board a,Chesspiece k,int x, int y) {
		Chesspiece[][] boardcheck = a.getBoard();
		for(int b=0;b<boardcheck.length;b++) {
			for(int u=0;u<boardcheck[0].length;u++) {
				if(boardcheck[b][u].equals(k)) {
					if(k.getColor().equals(g)) {
						if(k instanceof Pawn) {
							if(g.equals(white)) {
								if((x!=boardcheck.length&&y!=boardcheck[0].length)&&(x-u>0&&x-u<=2)&&y-b<=1) {
									return true;
								}
							}
							else if(g.equals(black)) {
								if(x!=-1&&y!=-1&&(u-x>0&&u-x<=2)&&b-y==1) {
									return true;
								}
							}
						}
						else if(k instanceof Castle) {
							if(((x!=boardcheck.length&&y!=boardcheck[0].length)&&(x!=-1&&y!=-1))&&(x-u==0||y-b==0)) {
								return true;
							}

						}
						else if(k instanceof Knight) {
							if(((x!=boardcheck.length&&y!=boardcheck[0].length)&&(x!=-1&&y!=-1))&&((u-x==1||b-y==0)||(x-u==1||y-b==1))) {
								return true;

							}
							else if(k instanceof Bishop) {
								if(g.equals(white)) {
									if((x!=boardcheck.length&&y!=boardcheck[0].length)&&(x!=-1&&y!=-1)) {
										return true;
									}

								}
								else if(k instanceof Queen) {

									if((x!=boardcheck.length&&y!=boardcheck[0].length)&&(x!=-1&&y!=-1)) {
										return true;
									}

								}
								else if(k instanceof King) {
									if(((x!=boardcheck.length&&y!=boardcheck[0].length)&&(x!=-1&&y!=-1))&&(((u-x>0&&u-x<=1)&&(b-y<=1))||((x-u>0&&x-u<=1)&&(y-b<=1)))) {
										return true;
									}


								}
							}
						}
					}
				}
			}

		}

		return false;
	}
   public void randomMove(Chesspiece k,Board a) {
	   Chesspiece[][] moves = a.getBoard();
	   int x =0;
	   int y=0;
	   if(d==Diff.Easy) {
		   x = (int)(Math.random()*moves[0].length);
		   y = (int)(Math.random()*moves.length);
		   if(withinBoard(a,k,x,y)) {
			   a.CPUmove(k,x,y);
		   }
	   }
   }
   
    











}
