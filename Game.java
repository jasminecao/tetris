import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Game extends JPanel implements KeyListener
{
	private Piece piece;
	private Color color;
	private int type;
	private Square[][] grid;
	private int w = 40;
	private int speed;
	private int r1, c1, r2, c2, r3, c3, r4, c4;
	private int rotation;
	private int line;
	private boolean downPressed;
	private boolean gameOver;
	private SideBar sidepanel;
	private JLabel asdf; private JPanel panel;
	
	public Game(int n, SideBar sidepanel)
	{
		setBounds(100, 100, 400, 640);
		setBackground(Color.BLACK);
		panel = new JPanel(new GridLayout(1, 0, 5, 5));
		panel.setBackground(Color.BLACK);
		JLabel gameover = new JLabel("GAME OVER");
		gameover.setFont(new Font("Verdana", Font.BOLD, 60));
		gameover.setForeground(new Color(0, 190, 220));
		panel.add(gameover);
		panel.setVisible(false);
		this.add(panel);
		
		//initializes and sets grid as false
		grid = new Square[17][11];
		for(int k = 0; k < 17; k++)
		{
			for(int j = 0; j < 11; j++)
			{
				grid[k][j] = new Square(false, Color.BLACK, 'c');
			}
		}
		
		if(n == 0) speed = 800;
		if(n == 1) speed = 600;
		if(n == 2) speed = 400; 
		
		gameOver = false;
		new Thread(){
			public void run()
			{
				while(true)
				{
					try
					{
						if(downPressed) Thread.sleep(80);
						else Thread.sleep(speed);

						moveDown();
						if(gameOver) 
							{
								panel.setVisible(true);
								break;
							}

						sidepanel.update(line);
					}
					catch(InterruptedException e) {}
				}
			}
		}.start();

		newPiece(); 
		setFocusable(true);
		addKeyListener(this);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		drawPiece(piece, g);
		
		g.setColor(Color.DARK_GRAY);
		for(int r = 0; r < 17; r++)
		{
			g.drawLine(0, r*40, 400, r*40);
		}
		for(int c = 0; c < 11; c++)
		{
			g.drawLine(c*40, 0, c*40, 640);
		}
		
	}

	public void drawPiece(Piece piece, Graphics g)
	{
		for(int k = 0; k < 16; k++)
		{
			for(int j = 0; j < 10; j++)
			{
				if(grid[k][j].getB() == true)
				{
					g.setColor(grid[k][j].getColor());
					g.fillRect(j*w, k*w, w, w);
				}
			}
		}
	}
	
	public void newPiece()
	{
		piece = new Piece((int)(Math.random()*6));
		rotation = 0;
		color = piece.getColor();
		type = piece.getType();
		r1 = piece.getr1(); r2 = piece.getr2(); r3 = piece.getr3(); r4 = piece.getr4();
		c1 = piece.getc1(); c2 = piece.getc2(); c3 = piece.getc3(); c4 = piece.getc4();
		gameOver();
		gridUpdate();
	}

	 public void gridErase()
	 {
		grid[r1][c1] = new Square(false, Color.BLACK, 'c');
	 	grid[r2][c2] = new Square(false, Color.BLACK, 'c');
	 	grid[r3][c3] = new Square(false, Color.BLACK, 'c');
	 	grid[r4][c4] = new Square(false, Color.BLACK, 'c');
	 	repaint();
	 }
	 
	 public void gridUpdate()
	 {
		 grid[r1][c1] = new Square(true, color, 'a');
		 grid[r2][c2] = new Square(true, color, 'a');
		 grid[r3][c3] = new Square(true, color, 'a');
		 grid[r4][c4] = new Square(true, color, 'a');
		 repaint();
	 }
	 
	 public void gridUpdateLast()
	 {
		 grid[r1][c1] = new Square(true, color, 'b');
		 grid[r2][c2] = new Square(true, color, 'b');
		 grid[r3][c3] = new Square(true, color, 'b');
		 grid[r4][c4] = new Square(true, color, 'b');
		 repaint();
	 }
	 
	public boolean gameOver()
	{
		if(r1 == 0 || r2 == 0 || r3 == 0 || r4 == 0)
		{
			if(grid[r1+1][c1].getChar() == 'b' || grid[r2+1][c2].getChar() == 'b' || grid[r3+1][c3].getChar() == 'b' || grid[r4+1][c4].getChar() == 'b') 
				{
					gameOver = true;
					return false;
				}
		}
		return true;
	}
	
	public void gameOverDisplay()
	{
		if(gameOver == true)
			{
				JLabel gameover = new JLabel("GAME OVER");
				panel.add(gameover);
				JLabel hello = new JLabel("HELLO");
				panel.add(hello);
				this.add(panel);
			}
	}
	 
	public boolean collidesDown()
	{
		if(grid[r1+1][c1].getChar() == 'b' || grid[r2+1][c2].getChar() == 'b' || grid[r3+1][c3].getChar() == 'b' || grid[r4+1][c4].getChar() == 'b') return false;		
		return true;
	}
	
	public boolean isValidDown()	
	 {
		if(r1 >= 15 || r2 >= 15 || r3 >= 15 || r4 >= 15) return false;
		if(r1 < 0 || r2 < 0 || r3 < 0 || r4 < 0) return false;
		if(collidesDown() == false) return false;
		return true;
	 }
	 
	public boolean collidesRight()
	 {
		if(grid[r1][c1+1].getChar() == 'b' || grid[r2][c2+1].getChar() == 'b' || grid[r3][c3+1].getChar() == 'b' || grid[r4][c4+1].getChar() == 'b') return false;
		else return true;
	 }
	 
	public boolean isValidRight()
	 {
		if(c4 >= 9 || c3 >= 9 || c2 >= 9 || c1 >= 9) return false;
		else if(collidesRight() == false) return false;
		return true;
	 }
	
	public boolean collidesLeft()
	{
		if(grid[r1][c1-1].getChar() == 'b' || grid[r2][c2-1].getChar() == 'b' || grid[r3][c3-1].getChar() == 'b' || grid[r4][c4-1].getChar() == 'b') return false;
		
		else return true;
	}
	
	public boolean isValidLeft()
	{
		if(c4 <= 0 || c3 <= 0 || c2 <= 0 || c1 <= 0) return false;
		else if(collidesLeft() == false) return false;
		return true;
	}
	
	 public void moveDown()
		{
		 	if(isValidDown())
			{
		 		gridErase();
		 		r1++; r2++; r3++; r4++; 
		 		gridUpdate();
			}
		 	if(isValidDown() == false) 
		 	{
		 		gridUpdateLast();
		 		clearLine(checkLine());
		 		newPiece();
		 	}
		}
		
	public void moveRight()
		{
			if(isValidRight())
			{
		 		gridErase();
		 		c1++; c2++; c3++; c4++;
		 		gridUpdate();
			}
		 	if(isValidRight() == false) 
		 	{
		 		gridUpdate();
		 	}
		}
	

	public void moveLeft()
		{
			if(isValidLeft())
			{
				gridErase();
				c1--; c2--; c3--; c4--;
				gridUpdate();
			}
			if(isValidRight() == false)
			{
				gridUpdate();
			}
		}
	
	public boolean checkRotate()
	{
		if(isValidDown() && isValidRight() && isValidLeft()) return true;
		else return false;
	}
	
	public boolean[] checkLine()
	{
		boolean[] fullLines = new boolean[16];
		for(int j = 0; j < 16; j++)
		{
			int c = 0;
			for(int k = 0; k < 10; k++)
			{
				if(grid[j][k].getB() == false) 
				{
					c++;
				}
			}
			if(c == 0) 
				{
					fullLines[j] = true;
				}
		}
		return fullLines;
	}
	
	public void clearLine(boolean[] fullLines)
	{
		for(int k = 0; k < 16; k++)
		{
			if(fullLines[k])
			{
				line++;
				for(int j = 0; j < 10; j++)
				{
					grid[k][j] = new Square(false, Color.BLACK, 'c');
				}
				for(int m = 0; m < 10; m++)
				{
					for(int n = k; n > 1; n--)
					{
						grid[n][m] = grid[n-1][m];
					}
				}
				if(line % 5 == 0 && speed > 150) 
					{speed = speed - 100;System.out.print(speed);}
			}
		}
	}
	
	public void rotate()
	{
		if(r1 > 1 && r2 > 1 && r3 > 1 && r4 > 1)
		{if(checkRotate())
		{
			gridErase();
			rotation++;
			switch(type)
			{
				case 0:
					switch(rotation % 2)
					{
						case 0:
							if(r3 > 13)
							{
								r1 = r1 - 3; r2 = r2 - 2; r3 = r3 - 1;
								c1 = c1 + 2; c2 = c2 + 1; c4 = c4 - 1;
							}
							r1 = r1 + 2; r2 = r2 + 1; r4 = r4 - 1;
						 	c1 = c1 - 2; c2 = c2 - 1; c4 = c4 + 1;
						 	break;
						case 1:
							r1 = r1 - 2; r2 = r2 - 1; r4 = r4 + 1;
							c1 = c1 + 2; c2 = c2 + 1; c4 = c4 - 1;
							break;
					}
					break;
				case 1:
					switch(rotation % 4)
					{
						case 0:
							r1 = r1-1; r3 = r3+1; r4 = r4+2;
							c2 = c2-1; c4 = c4+1;
							break;
						case 1:
							r2 = r2-1; r4 = r4+1;
							c1 = c1+2; c2 = c2+1; c4 = c4-1;
							break;
						case 2:
							r1 = r1 + 2; r2 = r2 + 1; r4 = r4-1; 
							c2 = c2+1; c4 = c4-1;
							break;
						case 3:
							r2 = r2+1; r4 = r4-1;
							c1 = c1-2; c2 = c2-1; c4 = c4+1;
							break;
					}
					break;
				case 2:
					switch(rotation % 4)
					{
						case 0:
							r1 = r1-1; r3 = r3+1;
							c1 = c1-1; c3 = c3+1; c4 = c4+2;
							break;
						case 1:
							r1 = r1-1; r3 = r3+1; r4 = r4+2;
							c1 = c1+1; c3 = c3-1; 
							break;
						case 2:
							r1 = r1+1; r3 = r3-1;
							c1 = c1+1; c3 = c3-1; c4 = c4-2;
							break;
						case 3:
							r1 = r1+1; r3 = r3-1; r4 = r4-2;
							c1 = c1-1; c3 = c3+1;
							break;
					}
					break;
				case 3: break;
				case 4: 
					switch(rotation % 2)
					{
						case 0:
							r1 = r1+1; r2 = r2-1; r4 = r4-2;
							c1 = c1-1; c3 = c3-1; 
							break;
						case 1:
							r1 = r1-1; r2 = r2+1; r4 = r4+2;
							c1 = c1+1; c3 = c3+1;
							break;
					}
					break;
				case 5:
					switch(rotation % 4)
					{
						case 0:
							r1 = r1-1; r2 = r2-1; r4 = r4+1;
							c1 = c1-1; c2 = c2+1; c4 = c4+1;
							break;
						case 1:
							r1 = r1-1; r2 = r2+1; r4 = r4+1;
							c1 = c1+1; c2 = c2+1; c4 = c4-1;
							break;
						case 2:
							r1 = r1+1; r2 = r2+1; r4 = r4-1;
							c1 = c1+1; c2 = c2-1; c4 = c4-1;
							break;
						case 3:
							r1 = r1+1; r2 = r2-1; r4 = r4-1;
							c1 = c1-1; c2 = c2-1; c4 = c4+1;
							break;
					}
					break;
				case 6:
					switch(rotation % 2)
					{
						case 0:
							r2 = r2-1; r4 = r4-1;
							c1 = c1-2; c2 = c2-1; c4 = c4+1;
							break;
						case 1:
							r2 = r2+1; r4 = r4+1;
							c1 = c1+2; c2 = c2+1; c4 = c4-1;
							break;
					}
					break;
			}
			gridUpdate();
		}
		if(checkRotate() == false)
		{
			gridUpdate();
		}}
	}
	
	public void keyPressed(KeyEvent e) 
	{
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_LEFT:
				moveLeft();
				break;
			case KeyEvent.VK_RIGHT:
				moveRight();
				break;
			case KeyEvent.VK_DOWN:
				downPressed = true;
				break;
			case KeyEvent.VK_UP:
				rotate();
				break;
		}
		
	}

	public void keyReleased(KeyEvent e)
		{
			switch(e.getKeyCode())
			{
				case KeyEvent.VK_DOWN:
					downPressed = false;
					break;
			}
		
		}
	
	public static void main(String[] args)
	{
		TitlePage page = new TitlePage();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}