package graphic;

import javax.swing.*;
import java.awt.event.*;
import IPD.*;

public class MainFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	
	JButton coopBut = new JButton("cooperate");
	JButton defBut = new JButton("defect");
	JButton startBut = new JButton("start");
	static HistoryBar hb = new HistoryBar();
	Game game = new Game();
	Hitmap hm = new Hitmap();
	Player p;
	
	public MainFrame(Player P)
	{
		super("Prisoners dilemma");
		p = P;
		setSize(420, 440);
		setVisible(true);
		JPanel panel = new JPanel();
		//panel.add(coopBut);
		//panel.add(defBut);
		eventSetup();
		//panel.add(hb);
		panel.add(startBut);
		panel.add(hm);
		add(panel);
	}
	
	void move(boolean choice)
	{
		boolean c = p.choice();
		p.newElement(c, choice);
		hb.addChoice(c, choice);
	}
	
	void eventSetup()
	{
		coopBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				move(true);
			}});
		
		defBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				move(false);
			}});
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
			}});
	}

}
