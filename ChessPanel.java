import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


public abstract class ChessPanel extends JPanel {
	private final int SIZE_PANEL = 1000;
        
	public static void main(String[] args) {
		JFrame frame = new JFrame("ChessPanel!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new ChessPanel() );
		frame.pack();
		frame.setVisible(true);

	}
	public ChessPanel() {
		this.setPreferredSize(new Dimension(this.SIZE_PANEL,SIZE_PANEL));
		this.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void mouseEntered(MouseEvent arg0) {
				System.out.println("You just entered!! "+arg0);
				
			}

			public void mouseExited(MouseEvent arg0) {
				System.out.println("You just exited!! "+arg0);
				
			}

			public void mousePressed(MouseEvent arg0) {
				// write your clicking code here!!
				System.out.println("You just clicked: "+arg0);
				
				
				
				
				repaint();
				
				
				
				
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
              
			}
			
		});
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
	}

}
