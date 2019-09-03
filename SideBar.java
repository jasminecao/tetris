import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SideBar extends JPanel
{
	private JTextField scoreValue, lineValue, levelValue;
	private JButton newGame;

	public SideBar()
	{
		setBounds(500, 100, 150, 640);
		setBackground(Color.DARK_GRAY);
		
		Box box = Box.createVerticalBox();
		box.setPreferredSize(new Dimension(180, 280));
		box.setBorder(new EmptyBorder(5,5,5,5));
		 
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 2, 3, 50));
		panel.setBackground(Color.DARK_GRAY);
		
		JLabel levelLabel = new JLabel("Level: ");
		panel.add(levelLabel);
		levelLabel.setForeground(Color.WHITE);
		levelLabel.setFont(new Font("Verdana", Font.BOLD, 16));
		levelValue =new JTextField();
		panel.add(levelValue);
		levelValue.setEditable(false);
		
		JLabel lineLabel = new JLabel("Lines: ");
		panel.add(lineLabel);
		lineLabel.setForeground(Color.WHITE);
		lineLabel.setFont(new Font("Verdana", Font.BOLD, 16));
		lineValue = new JTextField();
		panel.add(lineValue);
		lineValue.setEditable(false);
		
		JLabel scoreLabel = new JLabel("Score: ");
		panel.add(scoreLabel);
		scoreLabel.setForeground(Color.WHITE);
		scoreLabel.setFont(new Font("Verdana", Font.BOLD, 16));
		scoreValue = new JTextField();
		panel.add(scoreValue);
		scoreValue.setEditable(false);
		
		box.add(panel);
		this.add(box);
		
		setVisible(true);
	}
	
	public void update(int line)
	{
		lineValue.setText(line + "");
		int score = line*25;
		scoreValue.setText(score + "");
		int level = line/5 + 1;
		levelValue.setText(level + "");
	}
	
}
