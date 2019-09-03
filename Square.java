import java.awt.Color;

public class Square 
{
	private boolean present;
	private Color color;
	private char square;
	
	public Square(boolean b, Color c, char abc)
	{
		present = b;
		color = c;
		square = abc; //a = current piece, b = random piece, c = empty
	}
	
	public boolean getB()
	{
		return present;
	}
	
	public Color getColor()
	{
		return color;
	}
	
	public char getChar()
	{
		return square;
	}
}
