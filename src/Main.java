import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Main extends JFrame implements KeyListener,ActionListener{
	
	private Timer timer;
	private int delay = 100;
	private Container container;

	public Main() {
		addKeyListener(this);
		timer = new Timer(delay, this);
		timer.start();
		container = new Container();
	      
	      add(container);
	      
	      
	      setBounds(10, 10, 905, 700);
	      setBackground(Color.BLUE);
	      setResizable(false);
	      setVisible(true);
	      setLocationRelativeTo(null);
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		  Main window = new Main();
	      
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();		
		container.getFrame().gameEngine();
		container.getFrame2().gameEngine();
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		//Key Detection for Player 2
		if (e.getKeyCode() == KeyEvent.VK_SPACE && container.getFrame2().isGameOver()) {
			container.getFrame2().setMoves(0);
			container.getFrame2().setScore(0);
			container.getFrame2().setLengthofsnake(3);
			container.getFrame2().setGameOver(false);
			repaint();
		}
		
		if (!container.getFrame2().isGameOver()) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			container.getFrame2().setMoves(container.getFrame2().getMoves() + 1);
			container.getFrame2().setRight(true);
			
			
			if(!container.getFrame2().isLeft()) {
				container.getFrame2().setRight(true);
			}else {
				container.getFrame2().setRight(false);
				container.getFrame2().setLeft(true);
			}
			
			container.getFrame2().setDown(false);
			container.getFrame2().setUp(false);
		}
		
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			container.getFrame2().setMoves(container.getFrame2().getMoves() + 1);;
			container.getFrame2().setLeft(true);
			
			if(!container.getFrame2().isRight()) {
				container.getFrame2().setLeft(true);
			}else {
				container.getFrame2().setLeft(false);
				container.getFrame2().setRight(true);
			}
			
			container.getFrame2().setDown(false);
			container.getFrame2().setUp(false);
		}
		
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			container.getFrame2().setMoves(container.getFrame2().getMoves() + 1);
			container.getFrame2().setUp(true);
			
			if(!container.getFrame2().isDown()) {
				container.getFrame2().setUp(true);
			}else {
				container.getFrame2().setUp(false);
				container.getFrame2().setDown(true);
			}
			
			container.getFrame2().setRight(false);
			container.getFrame2().setLeft(false);
		}
		
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			container.getFrame2().setMoves(container.getFrame2().getMoves() + 1);
			container.getFrame2().setDown(true);
			
			if(!container.getFrame2().isUp()) {
				container.getFrame2().setDown(true);
			}else {
				container.getFrame2().setUp(true);
				container.getFrame2().setDown(false);
			}
			
			container.getFrame2().setRight(false);
			container.getFrame2().setLeft(false);

		}
		}
		
		
		
		
		
		
		//key detection for player 1
		if (e.getKeyCode() == KeyEvent.VK_T && container.getFrame().isGameOver()) {
			container.getFrame().setMoves(0);
			container.getFrame().setScore(0);
			container.getFrame().setLengthofsnake(3);
			container.getFrame().setGameOver(false);
			repaint();
		}
		
		if (!container.getFrame().isGameOver()) {
		if (e.getKeyCode() == KeyEvent.VK_D) {
			container.getFrame().setMoves(container.getFrame().getMoves() + 1);
			container.getFrame().setRight(true);
			
			
			if(!container.getFrame().isLeft()) {
				container.getFrame().setRight(true);
			}else {
				container.getFrame().setRight(false);
				container.getFrame().setLeft(true);
			}
			
			container.getFrame().setDown(false);
			container.getFrame().setUp(false);
		}
		
		if (e.getKeyCode() == KeyEvent.VK_A) {
			container.getFrame().setMoves(container.getFrame().getMoves() + 1);;
			container.getFrame().setLeft(true);
			
			if(!container.getFrame().isRight()) {
				container.getFrame().setLeft(true);
			}else {
				container.getFrame().setLeft(false);
				container.getFrame2().setRight(true);
			}
			
			container.getFrame().setDown(false);
			container.getFrame().setUp(false);
		}
		
		if (e.getKeyCode() == KeyEvent.VK_W) {
			container.getFrame().setMoves(container.getFrame().getMoves() + 1);
			container.getFrame().setUp(true);
			
			if(!container.getFrame().isDown()) {
				container.getFrame().setUp(true);
			}else {
				container.getFrame().setUp(false);
				container.getFrame().setDown(true);
			}
			
			container.getFrame().setRight(false);
			container.getFrame().setLeft(false);
		}
		
		if (e.getKeyCode() == KeyEvent.VK_S) {
			container.getFrame().setMoves(container.getFrame().getMoves() + 1);
			container.getFrame().setDown(true);
			
			if(!container.getFrame().isUp()) {
				container.getFrame().setDown(true);
			}else {
				container.getFrame().setUp(true);
				container.getFrame().setDown(false);
			}
			
			container.getFrame().setRight(false);
			container.getFrame().setLeft(false);

		}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
