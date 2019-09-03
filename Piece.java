import java.awt.Color;
import java.awt.Graphics;

public class Piece
{
	private int r1, c1, r2, c2, r3, c3, r4, c4;
	private Color color;
	private int type;
	
	public Piece(int modelType)
	{
			if(modelType == 0) //I
			{
				type = 0;
				color = new Color(0, 255, 255); //light blue
				r1 = 0; r2 = 0; r3 = 0; r4 = 0;
				c1 = 3; c2 = 4;	c3 = 5; c4 = 6;
			}
			if(modelType == 1)//J
			{
				type = 1;
				r1 = 0; r2 = 1; r3 = 1; r4 = 1;
				c1 = 3; c2 = 3;	c3 = 4; c4 = 5;
				color = Color.BLUE;			
			}
			if(modelType == 2)// L
			{
				type = 2;
				r1 = 1; r2 = 1; r3 = 1; r4 = 0;
				c1 = 3; c2 = 4;	c3 = 5; c4 = 5;
				color = Color.ORANGE; 
			}
			if(modelType == 3) //O
			{
				type = 3;
				r1 = 0; r2 = 0; r3 = 1; r4 = 1;
				c1 = 3; c2 = 4; c3 = 4; c4 = 3;
				color = Color.YELLOW;
			}
			if(modelType == 4) // S
			{
				type = 4;
				r1 = 1; r2 = 0; r3 = 1; r4 = 0;
				c1 = 3; c2 = 4;	c3 = 4; c4 = 5;
				color = new Color(51, 255, 51); //green
			}
			if(modelType == 5) // T
			{
				type = 5;
				r1 = 1; r2 = 0; r3 = 1; r4 = 1;
				c1 = 3; c2 = 4;	c3 = 4; c4 = 5;
				color = new Color(153, 51, 255); //purple
			}
			if(modelType == 6) // Z
			{
				type = 6;
				r1 = 0; r2 = 0; r3 = 1; r4 = 1;
				c1 = 4; c2 = 5;	c3 = 5; c4 = 6;
				color = Color.RED; 
			}
	}
	
	public void setPieceFields(int row1, int row2, int row3, int row4, int col1, int col2, int col3, int col4)
	{
		r1 = row1; r2 = row2; r3 = row3; r4 = row4;
		c1 = col1; c2 = col2; c3 = col3; c4 = col4;
	}
	
	public int getr1()
	{ return r1; }
	
	public int getr2()
	{ return r2; }
	
	public int getr3()
	{ return r3; }
	
	public int getr4()
	{ return r4; }
	
	public int getc1()
	{ return c1; }
	
	public int getc2()
	{ return c2; }
	
	public int getc3()
	{ return c3; }
	
	public Color getColor()
	{ return color;	}
	
	public int getc4()
	{ return c4; }
	
	public int getType()
	{
		return type;
	}
}
