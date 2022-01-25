package graphic;

import javax.swing.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import IPD.*;


public class RandomFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	JSlider chanceSlid = new JSlider(0, 100, 50);
	JButton startBut = new JButton("start");
	Game game = new Game();
	Hitmap hm = new Hitmap(512, 600, 600, false);
	RandomPrisoner rp;
	
	public RandomFrame()
	{
		super("Random Prisoners dilemma");
		setSize(1050, 600);
		setVisible(true);
		JPanel panel = new JPanel();
		panel.add(startBut);
		chanceSlid.setPaintTrack(true);
		chanceSlid.setPaintTicks(true);
		chanceSlid.setPaintLabels(true);
		chanceSlid.setMajorTickSpacing(20);
		chanceSlid.setMinorTickSpacing(5);
		panel.add(chanceSlid);
		hm.setMonochromaticColor();
		panel.add(hm);
		eventSetup();
		add(panel);
	}
	
	void printData() throws FileNotFoundException, UnsupportedEncodingException
	{
		int score;
		try (PrintWriter writer = new PrintWriter("mainData.txt", "UTF-8")) {
			for(int i=0; i<512; i++)
			{
				score = 0;
				writer.print(hm.getYaxisLabel(i));
				for(int j=0; j<512; j++)
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
				double chance = ((double)chanceSlid.getValue())/100;
				System.out.println("START!!!");
				for(int i=0; i<512; i++)
				{
					rp = new RandomPrisoner(i, chance);
					game.setPlayer1(rp);
					hm.setXYaxisLabel(i, game.getPlayer1Name());
					for(int j=0; j<512; j++)
					{
						rp = new RandomPrisoner(j, chance);
						game.setPlayer2(rp);
						game.play();
						hm.setValue(game.getPalyer1FScore(), i, j);
					}
				}
				try {
					printData();
				} catch (FileNotFoundException | UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}});
	}
}
