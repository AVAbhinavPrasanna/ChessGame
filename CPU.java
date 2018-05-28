import java.awt.Color;
import java.util.ArrayList;

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
	public ArrayList<ArrayList> getallpossiblemoves(Board a, Color j){
		Chesspiece[][] board = a.getBoard();
		Pawn b= null;
		Knight n = null;
		Queen y = null;
		King o = null;
		Castle l = null;
		Bishop p = null;
		ArrayList<ArrayList> moves = new ArrayList<ArrayList>();
		for(int r=0;r<board.length;r++) {
			for(int c=0;c<board[0].length;c++) {
				if(board[r][c] instanceof Pawn&&board[r][c].equals(j)) {
					b=(Pawn) board[r][c];
					moves.add(b.getpossiblemoves(a, j));
				}
				else if(board[r][c] instanceof Knight && board[r][c].equals(j)) {
					n= (Knight)board[r][c];
					moves.add(n.getpossiblemoves(a, j));
				}
				else if(board[r][c] instanceof Queen && board[r][c].equals(j)) {
					y = (Queen)board[r][c];
					moves.add(y.getpossiblemoves(a, j));
				}
				else if(board[r][c] instanceof King && board[r][c].equals(j)) {
					o = (King)board[r][c];
					moves.add(o.getpossiblemoves(a, j));
				}
				else if(board[r][c] instanceof Castle && board[r][c].equals(j)) {
					l=(Castle)board[r][c];
					moves.add(l.getpossiblemoves(a, j));
				}
				else if(board[r][c] instanceof Bishop && board[r][c].equals(j)) {
					p=(Bishop)board[r][c];
					moves.add(p.getpossiblemoves(a, j));
				}
			}
		}
		return moves;
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
	public int calculateboardvalues(Board b, Color g) {
		Chesspiece[][] board = b.getBoard();
		int a = 0;
		int whitepawns = 0;
		int blackpawns=0;
		int whiteknights =0;
		int blackknights = 0;
		int blackqueens = 0;
		int whitequeens = 0;
		int blackkings =0;
		int whitekings =0;
		int blackcastles=0;
		int whitecastles = 0;
		int blackbishops = 0;
		int whitebishops = 0;
		for(int r=0;r<board.length;r++) {
			for(int c=0;c<board[0].length;c++) {
				if(g.equals(white)) {
					if(board[r][c] instanceof Pawn&&board[r][c].equals(g)) {
						a+=10;
						whitepawns++;
					}
					else if(board[r][c] instanceof Knight && board[r][c].equals(g)) {
						a+=30;
						whiteknights++;
					}
					else if(board[r][c] instanceof Queen && board[r][c].equals(g)) {
						a+=90;
						whitequeens++;
					}
					else if(board[r][c] instanceof King && board[r][c].equals(g)) {
						a+=900;
						whitekings++;
					}
					else if(board[r][c] instanceof Castle && board[r][c].equals(g)) {
						a+=50;
						whitecastles++;
					}
					else if(board[r][c] instanceof Bishop && board[r][c].equals(g)) {
						a+=30;
						whitebishops++;
					}
				}
				else if(g.equals(black)) {
					if(board[r][c] instanceof Pawn&&board[r][c].equals(g)) {
						a-=10;
						blackpawns++;
					}
					else if(board[r][c] instanceof Knight && board[r][c].equals(g)) {
						a-=30;
						blackknights++;
					}
					else if(board[r][c] instanceof Queen && board[r][c].equals(g)) {
						a-=90;
						blackqueens++;
					}
					else if(board[r][c] instanceof King && board[r][c].equals(g)) {
						a-=900;
						blackkings++;
					}
					else if(board[r][c] instanceof Castle && board[r][c].equals(g)) {
						a-=50;
						blackcastles++;
					}
					else if(board[r][c] instanceof Bishop && board[r][c].equals(g)) {
						a-=30;
						blackbishops++;
					}
				}
			}
		}
		return a;
	}
	public moves bestmove(Board a,Color j) {
		Board b = a;
		Chesspiece[][] board = b.getBoard();
		ArrayList<ArrayList> moves = getallpossiblemoves(a, j);
		ArrayList<moves> search = new ArrayList<moves>();
		int i = 0;
		moves k = null;
		int best=0;
		int current=1000;
		moves bes = null;
		for(int index=0; index<moves.size();index++) {
		     search = moves.get(index);
		     while(i<search.size()) {
		    	 k=search.get(i);
		    	 board[k.gety()][k.getx()]=null;
		    	 if(j.equals(white)) {
		    		 current = calculateboardvalues(a,black);
		    		 if(current<best) {
		    			 best = current;
		    			 bes=k;
		    		 }
		    		
		    	 }
		    	 else if(j.equals(black)) {
		    		 current = calculateboardvalues(a,white);
		    		 if(current<best) {
		    			 best = current;
		    			 bes=k;
		    		 }
		     }
		}
		}
		return bes;
		
	}
	public void mediummove(Board a,Color j) {
		moves move = bestmove(a,j);
		Chesspiece[][] board = a.getBoard();
		Chesspiece k = null;
		for(int i=0; i<board.length;i++) {
			for(int m=0; m<board.length;m++) {
				if(move.piece().equals("Pawn")&&board[i][m] instanceof Pawn &&withinBoard(a,board[i][m],move.getx(),move.gety()) ) {
					k=board[i][m];
				}
				else if(move.piece().equals("Queen")&&board[i][m] instanceof Queen &&withinBoard(a,board[i][m],move.getx(),move.gety()) ) {
					k=board[i][m];
				}
				else if(move.piece().equals("Knight")&&board[i][m] instanceof Knight &&withinBoard(a,board[i][m],move.getx(),move.gety()) ) {
					k=board[i][m];
				}
				else if(move.piece().equals("Bishop")&&board[i][m] instanceof Bishop &&withinBoard(a,board[i][m],move.getx(),move.gety()) ) {
					k=board[i][m];
				}
				else if(move.piece().equals("King")&&board[i][m] instanceof King &&withinBoard(a,board[i][m],move.getx(),move.gety()) ) {
					k=board[i][m];
				}
				else if(move.piece().equals("Castle")&&board[i][m] instanceof Castle &&withinBoard(a,board[i][m],move.getx(),move.gety()) ) {
					k=board[i][m];
				}
				
			}
		}
		a.CPUmove(k, move.getx(), move.gety());
	}
	public void randomMove(Board a) {
		Chesspiece[][] moves = a.getBoard();
		int x =0;
		int y=0;
		int xpos = 0;
		int ypos = 0;
		Chesspiece k = null;
		if(d==Diff.Easy) {
			x = (int)(Math.random()*moves[0].length);
			y = (int)(Math.random()*moves.length);
			k= moves[y][x];
			xpos = (int)(Math.random()*moves[0].length);
			ypos = (int)(Math.random()*moves.length);
			if(withinBoard(a,k,xpos,ypos)) {
				a.CPUmove(k,xpos,ypos);
			}
		}
	}













}
