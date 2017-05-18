import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.midi.MidiUnavailableException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.jfugue.realtime.RealtimePlayer;
public class Main extends JFrame {
	
	public static void main(String[] args) throws MidiUnavailableException{
		
		JFrame f = new JFrame("Virtual Piano");
		CardLayout c = new CardLayout();
		JPanel j = new JPanel();
		Keyboard k = new Keyboard(new RealtimePlayer());
		WaterfallKeyboard wk = new WaterfallKeyboard(new RealtimePlayer());
		WaterfallScreen w = new WaterfallScreen();
		JPanel wfscreen = new JPanel();
	
		j.setLayout(c);
		f.setBounds(100, 100, 1195, 800);
		f.setLayout(new BorderLayout());
		TitleScreen game = new TitleScreen();
		f.add(j, BorderLayout.CENTER);
		j.add(game, "0");
		
		RealtimePlayer player = new RealtimePlayer();
		Keyboard board = new Keyboard(player);
		f.setFocusTraversalKeysEnabled(false);
	    f.addKeyListener(board);
		
	    f.setResizable(true);
	    
	    JButton instructions = new JButton("How To Play");
	    JButton waterfall = new JButton("Synthesia");	    
	    JButton keyboard = new JButton("Keyboard");
	    
	   JPanel btnpnl = new JPanel();
	    btnpnl.setLayout(new GridLayout(1,3));
	    btnpnl.setOpaque(false);

	    btnpnl.add(waterfall);
	    btnpnl.add(instructions);
	    btnpnl.add(keyboard);
	    f.add(btnpnl, BorderLayout.SOUTH);
	    
		JPanel inst = new JPanel();
		inst.setSize(1195,800);
		inst.setLayout(new BorderLayout());
		String text = "<br>How To Play <br>By: Ivy Huang, Jocelyn Chen, Natalie Tarn"
				+ "<br>Virtual Piano<br>"
				+ "This application stimulates a real life piano, allowing the player to play real songs <br> using the computer keyboard in two different modes, \"Keyboard\", and \"Synthesia\"."
				+ "<br>Please refer to the README for the full piano to computer key relationship. ";

		JLabel info = new JLabel("<html><div style='text-align: center;'>" + text + "</html>",SwingConstants.CENTER);
		info.setFont(new Font("Dosis", 0, 15));
		inst.add(info, BorderLayout.NORTH);
		JButton iback = new JButton("Back");
		JButton wback = new JButton("Back");
		JButton kback = new JButton("Back");
		
	   instructions.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				inst.add(iback, BorderLayout.SOUTH);
				j.add(inst, "1");
				btnpnl.setVisible(false);
				iback.setVisible(true);
				c.show(j, "1");
				
			}
		});
	   
	   iback.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				btnpnl.setVisible(true);
				iback.setVisible(false);
				c.show(j, "0");
			}
		});
		
		waterfall.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			//	wfscreen.setLayout(new BorderLayout());
				w.setLayout(new BorderLayout());
				w.add(wback, BorderLayout.WEST);
			//	wfscreen.add(w, BorderLayout.CENTER);
			//	wfscreen.add(wk, BorderLayout.SOUTH);
				j.add(w, "2");
				btnpnl.setVisible(false);
				wback.setVisible(true);
				c.show(j, "2");
			}
			 
		});
		
		 wback.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					btnpnl.setVisible(true);
					wback.setVisible(false);
					c.show(j, "0");
				}
			});
		
		keyboard.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JPanel keyscreen = new JPanel();
				keyscreen.setSize(1195,800);
				keyscreen.setLayout(new BorderLayout());
				keyscreen.add(kback, BorderLayout.SOUTH);
				keyscreen.add(k, BorderLayout.CENTER);
				j.add(keyscreen, "3");
				btnpnl.setVisible(false);
				kback.setVisible(true);
				c.show(j, "3");
			}
			
		});
		
		 kback.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					btnpnl.setVisible(true);
					kback.setVisible(false);
					c.show(j, "0");
				}
			});
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         }

}
