package graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class Hitmap extends JPanel{
	private static final long serialVersionUID = 1L;
	int maxVal = 0;
	int elem;
	int[][] temp;
	int sWidth, sHeight;
	String[] XaxisLabels;
	String[] YaxisLabels;
	int XaxisSize, YaxisSize;
	String color;
	
	//----constructors----
	Hitmap() 
	{
		elem = 32;
		temp = new int[elem][elem];
		XaxisLabels = new String[elem];
		YaxisLabels = new String[elem];
		XaxisSize = YaxisSize = 80;
		zeros();
		setSize(10*elem + XaxisSize + 1, 10*elem + YaxisSize + 1);
		sWidth = sHeight = 10;
		color = "blue";
	}
	
	Hitmap(int width, int height)
	{
		elem = 32;
		temp = new int[elem][elem];
		XaxisLabels = new String[elem];
		YaxisLabels = new String[elem];
		XaxisSize = YaxisSize = 50;
		zeros();
		setSize(width + XaxisSize + 1, height + YaxisSize + 1);
		sWidth = super.getWidth() / elem;
		sHeight = super.getHeight() / elem;
		color = "blue";
	}
	
	Hitmap(int elements) 
	{
		elem = elements;
		temp = new int[elem][elem];
		XaxisLabels = new String[elem];
		YaxisLabels = new String[elem];
		XaxisSize = YaxisSize = 50;
		zeros();
		setSize(10*elem + XaxisSize + 1, 10*elem + YaxisSize + 1);
		sWidth = sHeight = 10;
		color = "blue";
	}
	
	Hitmap(int elements, int width, int height)
	{
		elem = elements;
		temp = new int[elem][elem];
		XaxisLabels = new String[elem];
		YaxisLabels = new String[elem];
		XaxisSize = YaxisSize = 50;
		zeros();
		setSize(width + XaxisSize + 1, height + YaxisSize + 1);
		sWidth = super.getWidth() / elem;
		sHeight = super.getHeight() / elem;
		color = "blue";
	}
	//----end constructors----
	
	//-----getters------
	/**@return square point width*/
	public int getSquareWidth() { return sWidth; }
	/**@return square point height*/
	public int getSquareHeight() { return sHeight; }
	/**@return label element from x axis*/
	public String getXaxisLabel(int n) { return XaxisLabels[n]; }
	/**@return label element from y axis*/
	public String getYaxisLabel(int n) { return YaxisLabels[n]; }
	/**
	 * Returns the value of the selected matrix element.
	 * @param i - matrix column index
	 * @param j - matrix row index
	 * @return value of the matrix element
	 * */
	public int getValue(int i, int j)
	{
		if((i>=0 && i<elem) && (j>=0 && j<elem)) { return temp[j][i]; }
		return -1;
	}
	
	public Color getColor(int i, int  j)
	{
		if((i>=0 && i<elem) && (j>=0 && j<elem))
		{
			
			int x = 255-temp[i][j];
			/*if(maxVal != 0) x = 255-(int)(255*((float)temp[i][j]/(float)maxVal));
			else x=255;*/
			Color c;
			switch(color)
			{
			case "blue":
				c = new Color(x, x, 255);
				return c;
			case "red":
				c = new Color(255, x, x);
				return c;
			case "green":
				c = new Color(x, 255, x);
				return c;
			default:
				c = new Color(x, x, x);
				return c;
			}
		}
		return Color.black;
	}
	String getColorType() { return color; }

	public Dimension getPreferredSize() { return new Dimension(super.getWidth(), super.getHeight()); }
	//-----end getters----
	
	//------setters------
	public void setXaxisLabel(int n, String label) { XaxisLabels[n] = label; }
	public void setYaxisLabel(int n, String label) { YaxisLabels[n] = label; }
	public void setXYaxisLabel(int n, String label) { XaxisLabels[n] = YaxisLabels[n] = label; }
	public void setRedColor() { color = "red"; }
	public void setGreenColor() { color = "green"; }
	public void setBlueColor() { color = "blue"; }
	public void setMonochromaticColor() { color = "mono"; }
	/**
	 * Sets the value in the selected matrix element.
	 * @param value - value
	 * @param i - matrix column index
	 * @param j - matrix row index
	 * */
	boolean setValue(int value, int i, int j)
	{
		if((i>=0 && i<elem) && (j>=0 && j<elem))
		{
			if(value > maxVal) { maxVal = value; }
			temp[j][i] = value;
			return true;
		}
		return false;
	}
	//------end setters-----
	
	/**cleans the matrix*/
	void zeros()
	{
		for(int i=0; i<elem; i++)
			for(int j=0; j<elem; j++)
				temp[i][j] = (int)(Math.random()*100);
		for(int i=0; i<elem; i++)
		{
			XaxisLabels[i] = "shgahgejhafgjh";
			YaxisLabels[i] = "adwhgfhafuyug";
		}
	}
	
	void printLabels(Graphics2D g2d)
	{
		AffineTransform at = new AffineTransform();
		Font Yfont = new Font("Arial", Font.PLAIN, sHeight-1);
		Font Xfont = new Font("Arial", Font.PLAIN, sWidth-1);
		
		g2d.setFont(Yfont);
		for(int i = 0; i<elem; i++)
			g2d.drawString(YaxisLabels[i], 0, YaxisSize+((i+1)*sHeight-2));
		
		at.rotate(Math.PI / 2);
	    g2d.setTransform(at);
		g2d.setFont(Xfont);
		for(int i = 0; i<elem; i++)
			g2d.drawString(XaxisLabels[i], 0, (XaxisSize+i*sWidth+2)*(-1));
		
		at.rotate(3*Math.PI / 2);
		g2d.setTransform(at);
	}
	
	void printMatrix(Graphics2D g2d)
	{
		for(int i=0; i<elem; i++)
			for(int j=0; j<elem; j++) 
			{
				g2d.setColor(getColor(i, j));
				g2d.fillRect(sWidth*j+XaxisSize, sHeight*i+YaxisSize, sWidth, sHeight);
				g2d.setColor(Color.black);
				g2d.drawRect(sWidth*j+XaxisSize, sHeight*i+YaxisSize, sWidth, sHeight);
			}
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		printLabels(g2d);
		printMatrix(g2d);
		g2d.setColor(Color.black);
		g2d.drawRect(XaxisSize, YaxisSize, elem*sWidth, elem*sHeight);
		try {
			Thread.sleep(1);
		} catch(InterruptedException t) {}
		repaint();
	}
	
}