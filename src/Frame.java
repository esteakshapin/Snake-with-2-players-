import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Frame extends JPanel{
	
	private int[] snakeXlength = new int[250];
	private int[] snakeYlength = new int[250];
	
	private final int startingX = 100;
	private final int startingY = 100;
	
	private boolean left = false;
	private boolean right = false;
	private boolean up = false;
	private boolean down = false;
	
	private ImageIcon rightmouth;
	private ImageIcon leftmouth;
	private ImageIcon upmouth;
	private ImageIcon downmouth;
	
	private int lengthofsnake = 3;
	
	private ImageIcon snakeimage;
	
	private int [] fruitxpos = new int [34];
	private int [] fruitypos = new int [23];
	
	private ImageIcon fruitimage;
	
	private Random random = new Random();
	private int xpos, ypos;
	
	private int moves = 0;
	
	private int score = 0;
	
	private ImageIcon titleImage;
	
	private boolean gameOver = false;
	
	
	public Frame() {
		for (int i = 0; i < 34; i++) {
			fruitxpos[i] = 25 + (i * 25);
		}
		for (int i = 0; i < 23; i++) {
			fruitypos[i] = 75 + (i * 25);
		}
		
		xpos = random.nextInt(16);
		ypos = random.nextInt(23);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if(getMoves() == 0) {
			
			for (int i = getLengthofsnake() - 1; i >= 0; i--) {
				snakeXlength[i] = startingX - (25 * i);
			}
			
			for (int i = getLengthofsnake() - 1; i >= 0; i--) {
				snakeYlength[i] = startingY;
			}
			
		}
		
		//draw border for GamePlay
				g.setColor(Color.GREEN);
				g.drawRect(24, 74, 401, 577);
				
				//draw background for the gameplay
				g.setColor(Color.black);
				g.fillRect(25, 75, 400, 575);
				
				//draw score board
				g.setColor(Color.black);
				g.setFont(new Font("arial", Font.PLAIN, 14));
				g.drawString("score: " + getScore(), 100, 30);
				
				//draw length of the snake
				g.setColor(Color.black);
				g.setFont(new Font("arial", Font.PLAIN, 14));
				g.drawString("Length: " + getLengthofsnake(), 100, 50);
				
				rightmouth = new ImageIcon("rightmouth.png");
				rightmouth.paintIcon(this, g, snakeXlength[0], snakeYlength[0]);
				
				for (int a = 0; a < getLengthofsnake(); a++) {
					if (a == 0 && isRight()) {
						rightmouth = new ImageIcon ("rightmouth.png");
						rightmouth.paintIcon(this, g, snakeXlength[a], snakeYlength[a]);
					}
					if (a == 0 && isLeft()) {
						leftmouth = new ImageIcon ("leftmouth.png");
						leftmouth.paintIcon(this, g, snakeXlength[a], snakeYlength[a]);
					}
					if (a == 0 && isDown()) {
						downmouth = new ImageIcon ("downmouth.png");
						downmouth.paintIcon(this, g, snakeXlength[a], snakeYlength[a]);
					}
					if (a == 0 && isUp()) {
						upmouth = new ImageIcon ("upmouth.png");
						upmouth.paintIcon(this, g, snakeXlength[a], snakeYlength[a]);
					}
					
					if (a!= 0) {
						snakeimage = new ImageIcon ("snakeimage.png");
						snakeimage.paintIcon(this, g, snakeXlength[a], snakeYlength[a]);
					}
				}
				
				fruitimage = new ImageIcon("fruit.png");
				
				if (fruitxpos[xpos] == snakeXlength [0] && fruitypos[ypos] == snakeYlength[0]) {
					setScore(getScore() + 1);
					setLengthofsnake(getLengthofsnake() + 1);
					xpos = random.nextInt(16);
					ypos = random.nextInt(23);
				}
				
				fruitimage.paintIcon(this, g, fruitxpos[xpos], fruitypos[ypos]);
				
				for (int i = 1; i < getLengthofsnake(); i++) {
					if (snakeXlength [i] == snakeXlength [0] && snakeYlength [i] == snakeYlength[0]) {
						setRight(false);
						setLeft(false);
						setUp(false);
						setDown(false);
						gameOver = true;
						g.setColor(Color.white);
						g.setFont(new Font("arial", Font.BOLD, 50));
						g.drawString ("Game Over", 80, 300);
						
						g.setFont(new Font("arial", Font.BOLD, 20));
						g.drawString ("Press Space to Restart", 85, 340);
					}
				}
				
				g.dispose();

	}
	
	public void gameEngine() {
		if (!gameOver) {
			
			if (isRight()) {
				for (int r =  getLengthofsnake() - 1; r >= 0; r--) {
					snakeYlength[r+1] = snakeYlength[r];
					
				}
				for (int r = getLengthofsnake(); r>= 0; r--) {
					if (r == 0) {
						snakeXlength[r] = snakeXlength [r] + 25; 
					}else {
						snakeXlength [r] = snakeXlength [r-1];
					}
					if (snakeXlength[r] > 400) {
						snakeXlength[r] = 25;
					}
				}
				
				repaint();
			}
			if (isLeft()) {
				for (int r =  getLengthofsnake() - 1; r >= 0; r--) {
					snakeYlength[r+1] = snakeYlength[r];
					
				}
				for (int r = getLengthofsnake(); r>= 0; r--) {
					if (r == 0) {
						snakeXlength[r] = snakeXlength [r] - 25; 
					}else {
						snakeXlength [r] = snakeXlength [r-1];
					}
					if (snakeXlength[r] < 25) {
						snakeXlength[r] = 400;
					}
				}
				
				repaint();
			}
			if (isDown()) {
				for (int r =  getLengthofsnake() - 1; r >= 0; r--) {
					snakeXlength[r+1] = snakeXlength[r];
					
				}
				for (int r = getLengthofsnake(); r>= 0; r--) {
					if (r == 0) {
						snakeYlength[r] = snakeYlength [r] + 25; 
					}else {
						snakeYlength [r] = snakeYlength [r-1];
					}
					if (snakeYlength[r] > 625) {
						snakeYlength[r] = 75;
					}
				}
				
				repaint();
				
			}
			if (isUp()) {
				for (int r =  getLengthofsnake() - 1; r >= 0; r--) {
					snakeXlength[r+1] = snakeXlength[r];
					
				}
				for (int r = getLengthofsnake(); r>= 0; r--) {
					if (r == 0) {
						snakeYlength[r] = snakeYlength [r] - 25; 
					}else {
						snakeYlength [r] = snakeYlength [r-1];
					}
					if (snakeYlength[r] < 75) {
						snakeYlength[r] = 625;
					}
				}
				
				repaint();
			}
			}
			
	}
	

	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	public int getMoves() {
		return moves;
	}

	public void setMoves(int moves) {
		this.moves = moves;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getLengthofsnake() {
		return lengthofsnake;
	}

	public void setLengthofsnake(int lengthofsnake) {
		this.lengthofsnake = lengthofsnake;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}
}
