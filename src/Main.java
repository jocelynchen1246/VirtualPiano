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
	
	private JFrame f;
	private JPanel btnpnl, inst, j, keyscreen, wfscreen;
	private JLabel info;
	private TitleScreen game;
	private JButton instructions, waterfall, keyboard, iback, wback, kback;
	private CardLayout c;
	private WaterfallScreen w;
	private WaterfallKeyboard wk;
	private ScoreScreen s;
	private Keyboard k;
	
	public Main() throws MidiUnavailableException{
		f = new JFrame("Virtual Piano");
		c = new CardLayout();
		j = new JPanel();
		k = new Keyboard(new RealtimePlayer());
		
		wfscreen = new JPanel();
		j.setLayout(c);
		setBounds(100, 100, 1125, 800);
		setLayout(new BorderLayout());
		game = new TitleScreen();
		add(j, BorderLayout.CENTER);
		j.add(game, "0");
		RealtimePlayer player = new RealtimePlayer();
		wk = new WaterfallKeyboard(player);
		w = new WaterfallScreen(player);
		Keyboard board = new Keyboard(player);
		setFocusTraversalKeysEnabled(false);
	    addKeyListener(board);
	    setResizable(true);
	    
	    instructions = new JButton("How To Play");
	    waterfall = new JButton("Synthesia");	    
	    keyboard = new JButton("Keyboard");
	    
	    btnpnl = new JPanel();
	    btnpnl.setLayout(new GridLayout(1,3));
	    btnpnl.setOpaque(false);

	    btnpnl.add(waterfall);
	    btnpnl.add(instructions);
	    btnpnl.add(keyboard);
	    add(btnpnl, BorderLayout.SOUTH);
	    
		inst = new JPanel();
		inst.setSize(1125,800);
		inst.setLayout(new BorderLayout());
		String text = "<br>How To Play <br>By: Ivy Huang, Jocelyn Chen, Natalie Tarn"
				+ "<br>Virtual Piano<br>"
				+ "This application stimulates a real life piano, allowing the player to play real songs <br> using the computer keyboard in two different modes, \"Keyboard\", and \"Synthesia\"."
				+ "<br>Please refer to the README for the full piano to computer key relationship. ";

		info = new JLabel("<html><div style='text-align: center;'>" + text + "</html>",SwingConstants.CENTER);
		info.setFont(new Font("Dosis", 0, 15));
		inst.add(info, BorderLayout.NORTH);
		iback = new JButton("Back");
		wback = new JButton("Back");
		kback = new JButton("Back");
		
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
				w.add(wk);
			//	wfscreen.add(w, BorderLayout.CENTER);
				j.add(w, "2");
				btnpnl.setVisible(false);
				wback.setVisible(true);
				w.add(wback, BorderLayout.WEST);
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
				keyscreen = new JPanel();
				keyscreen.setSize(1125,800);
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
	}
	
	
	public static void main(String[] args) throws MidiUnavailableException{
		Main main = new Main();
		main.setVisible(true);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         }

}
