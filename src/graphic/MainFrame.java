package graphic;

import javax.swing.*;
import java.awt.event.*;
import IPD.*;

public class MainFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	
	JButton coopBut = new JButton("cooperate");
	JButton defBut = new JButton("defect");
	static HistoryBar hb = new HistoryBar();
	Hitmap hm = new Hitmap();
	Player p;
	
	public MainFrame(Player P)
	{
		super("Prisoners dilemma");
		p = P;
		setSize(450, 520);
		setVisible(true);
		JPanel panel = new JPanel();
		panel.add(coopBut);
		panel.add(defBut);
		eventSetup();
		panel.add(hb);
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
	}

}
