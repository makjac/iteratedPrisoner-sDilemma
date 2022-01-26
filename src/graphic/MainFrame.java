package graphic;

import javax.swing.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import IPD.*;

public class MainFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	
	JButton startBut = new JButton("start");
	Game game = new Game();
	Hitmap hm = new Hitmap();
	
	public MainFrame()
	{
		super("Prisoners dilemma");
		setSize(420, 440);
		setVisible(true);
		JPanel panel = new JPanel();
		eventSetup();
		panel.add(startBut);
		panel.add(hm);
		add(panel);
	}
	
	void printData() throws FileNotFoundException, UnsupportedEncodingException
	{
		try (PrintWriter writer = new PrintWriter("mainData.txt", "UTF-8")) {
			for(int i=0; i<32; i++)
			{
				writer.print(hm.getYaxisLabel(i));
				for(int j=0; j<32; j++)
				{
					//score = score + hm.getValue(i, j);
					writer.print(" " + hm.getValue(j, i));
				}
				writer.println("");
				//writer.print(hm.getYaxisLabel(i) + " " + score);
			}
		}
	}
	
	void eventSetup()
	{
		startBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("START!!!");
				for(int i=0; i<32; i++)
				{
					game.setPlayer1(i);
					hm.setXYaxisLabel(i, game.getPlayer1Name());
					for(int j=0; j<32; j++)
					{
						game.setPlayer2(j);
						game.play();
						hm.setValue(game.getPalyer1FScore(), i, j);
					}
				}
				try {
					printData();
				} catch (FileNotFoundException | UnsupportedEncodingException e1) {
					e1.printStackTrace();
				}
			}});
	}

}
