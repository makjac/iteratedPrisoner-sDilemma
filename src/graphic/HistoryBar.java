package graphic;

import javax.swing.*;
import java.awt.*;

public class HistoryBar extends JPanel{
	private static final long serialVersionUID = 1L;
	
	int size;
	int mSize;
	int sWidth, sHeight;
	boolean[][] Map;
	Color coopColor = new Color(64, 144, 76);
	Color defColor = new Color(254, 60, 60);
	Color emptyColor = new Color(149, 149, 149);
	
	//----constructors----
	HistoryBar() 
	{
		super();
		size = 5;
		mSize = 0;
		Map = new boolean[2][size];
		setSize(200, 50);
		sWidth = super.getWidth()/size;
		sHeight = super.getHeight()/2;
		setBorder(BorderFactory.createLineBorder(Color.orange));
	}
	
	HistoryBar(int width, int height)
	{
		super();
		size = 5;
		mSize = 0;
		Map = new boolean[2][size];
		setSize(width, height);
		sWidth = width/size;
		sHeight = height/2;
		setBorder(BorderFactory.createLineBorder(Color.orange));
	}
	
	HistoryBar(int n)
	{
		super();
		size = n;
		mSize = 0;
		Map = new boolean[2][size];
		setSize(200, 50);
		sWidth = super.getWidth()/size;
		sHeight = super.getHeight()/2;
		setBorder(BorderFactory.createLineBorder(Color.orange));
	}
	
	HistoryBar(int n, int width, int height)
	{
		super();
		size = n;
		mSize = 0;
		Map = new boolean[2][size];
		setSize(width, height);
		sWidth = width/size;
		sHeight = height/2;
		setBorder(BorderFactory.createLineBorder(Color.orange));
	}
	//-------end constructors-------
	
	//-----getters------
	/**@return square point width*/
	int getSquareWidth() { return sWidth; }
	/**@return square point height*/
	int getSquareHeight() { return sHeight; }
	Color getElementMapColor(int i, int j)
	{
		if(j >= size) { return Color.black; }
		if(j >= mSize) { return emptyColor; }
		if(Map[i][j]) { return coopColor; }
		return defColor;
	}
	public Dimension getPreferredSize() { return new Dimension(super.getWidth(), super.getHeight()); }
	//-----end getters----
	
	public void addChoice(boolean p1, boolean p2)
	{
		if(mSize < size)
		{
			Map[0][mSize] = p1;
			Map[1][mSize] = p2;
		}
		else
		{
		for(int i=0; i<size-1; i++)
		{
			Map[0][i] = Map[0][i+1];
			Map[1][i] = Map[1][i+1];
		}
		Map[0][size-1] = p1;
		Map[1][size-1] = p2;
		}
		mSize++;
		repaint();
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		for(int i=0; i<2; i++)
			for(int j=0; j<size; j++) 
			{
				g.setColor(getElementMapColor(i, j));
				g.fillRect(sWidth*j, sHeight*i, sWidth, sHeight);
				g.setColor(Color.black);
				g.drawRect(sWidth*j, sHeight*i, sWidth, sHeight);
			}
		try {
			Thread.sleep(1);
		} catch(InterruptedException t) {}
		repaint();
	}
}
