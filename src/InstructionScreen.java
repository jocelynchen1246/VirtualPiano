import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * This class represents the instruction screen for keyboard.
 * @author Natalie Tarn
 *
 */
public class InstructionScreen extends JPanel implements ActionListener{
	VirtualPiano v;
	private JLabel info;
	private JButton iback;
	
	public InstructionScreen(VirtualPiano piano){
		super();
		v=piano;
		this.setSize(1195,600);
		this.setLayout(new BorderLayout());
		String text = "<br>How To Play <br>By: Ivy Huang, Jocelyn Chen, Natalie Tarn"
				+ "<br>Virtual Piano<br>"
				+ "This application stimulates a real life piano, allowing the player to play real songs <br> using the computer keyboard in two different modes, \"Keyboard\", and \"Synthesia\"."
				+ "<br>Please refer to the README for the full piano to computer key relationship. ";
	
		info = new JLabel("<html><div style='text-align: center;'>" + text + "</html>",SwingConstants.CENTER);
		info.setFont(new Font("Dosis", 0, 15));
		add(info, BorderLayout.CENTER);
		iback = new JButton("Back");
		iback.addActionListener(this);
		add(iback, BorderLayout.SOUTH);
	
		setVisible(true);
	}

	public void paint(Graphics g){
		super.paint(g);
		int width = getWidth();
	    int height = getHeight();
	    double rx = width/1195.0;
	    double ry = height/600.0;

	    Graphics2D g2 = (Graphics2D)g;
	    //g2.scale(rx, ry);
	    repaint();
	}
	
	/**
	 * Changes back to the titlescreen when the back button is pressed.
	 */
	public void actionPerformed(ActionEvent arg0) {
		
		v.changePanel("1");
		
	}
}
