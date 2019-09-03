import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TitlePage extends JFrame implements ActionListener
{
	private JLabel title;
	private JButton easy, medium, hard;
	private JFrame f;
	
	public TitlePage()
	{
		f = new JFrame();
		f.setBounds(100, 100, 700, 700);
		f.setName("TETRIS");
		f.setTitle("TETRIS");

		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		c.gridx = 1; c.gridy = 1;
		title = new JLabel("TETRIS");
		title.setForeground(Color.BLUE);
		title.setFont(new Font("Verdana", Font.BOLD, 60));
		panel.add(title, c);
		
		c.gridy = 2;
		c.gridx = 0; 
		easy = new JButton("EASY");
		easy.addActionListener(this);
		panel.add(easy, c);
		
		c.gridx = 1;
		medium = new JButton("MEDIUM");
		medium.addActionListener(this);
		panel.add(medium, c);
		
		c.gridx = 2;
		hard = new JButton("HARD");
		hard.addActionListener(this);
		panel.add(hard, c);
		
		f.add(panel);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) 
	{
		JButton src = (JButton)e.getSource();
		if(src == easy)
		{
			f.dispose();
			JFrame frame = new JFrame("TETRIS");
			frame.setBounds(100, 100, 600, 680);
			frame.getContentPane().setBackground(Color.DARK_GRAY);
			
			JPanel panel = new JPanel(new BorderLayout(0, 0));
			
			SideBar sidepanel = new SideBar();
			Game game = new Game(0, sidepanel);
			
			panel.add(game, BorderLayout.CENTER);
			panel.add(sidepanel, BorderLayout.EAST);
			
			frame.add(panel);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
			frame.setResizable(false);
			frame.setVisible(true);
		}
		if(src == medium)
		{
			f.dispose();
			JFrame frame = new JFrame("TETRIS");
			frame.setBounds(100, 100, 600, 680);
			frame.getContentPane().setBackground(Color.DARK_GRAY);
			
			JPanel panel = new JPanel(new BorderLayout(0, 0));
			
			SideBar sidepanel = new SideBar();
			Game game = new Game(1, sidepanel);
			
			panel.add(game, BorderLayout.CENTER);
			panel.add(sidepanel, BorderLayout.EAST);
			
			frame.add(panel);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
			frame.setResizable(false);
			frame.setVisible(true);
		}
		if(src == hard)
		{
			f.dispose();
			JFrame frame = new JFrame("TETRIS");
			frame.setBounds(100, 100, 600, 680);
			frame.getContentPane().setBackground(Color.DARK_GRAY);
			
			JPanel panel = new JPanel(new BorderLayout(0, 0));
			
			SideBar sidepanel = new SideBar();
			Game game = new Game(2, sidepanel);
			
			panel.add(game, BorderLayout.CENTER);
			panel.add(sidepanel, BorderLayout.EAST);
			
			frame.add(panel);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
			frame.setResizable(false);
			frame.setVisible(true);
		}
	}


}
