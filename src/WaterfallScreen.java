import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;

import javax.sound.midi.MidiUnavailableException;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfugue.realtime.RealtimePlayer;
/**
 * This class displays the "waterfall" functioning of the app, and implements the 
 * 
 * @author IvyHuang
 *
 */
public class WaterfallScreen extends JPanel{

	private JPanel waterfall, wf;
	private WaterfallKeyboard key;
	private Waterfall synth;
	public static final int WIDTH = 1125;
	public static final int HEIGHT = 200;
	private int count, interval;
	private RealtimePlayer player;
	
	/**
	 * Creates a JPanel that displays the waterfall formatting of the
	 * @throws midi unavailable exception 
	 */
	public WaterfallScreen(RealtimePlayer play) throws MidiUnavailableException{
		super();
		player = play;
		count = 0;
		interval = 0;
		waterfall = new JPanel();
		wf = new JPanel();
		waterfall.setLayout(new BorderLayout());
		key = new WaterfallKeyboard(player);
		synth = new Waterfall( new Song ("mary had a little lamb"));
		
		waterfall.setBounds(100, 100, 1125, 200);
  		
  		waterfall.setFocusTraversalKeysEnabled(false);
 		key.setFocusTraversalKeysEnabled(false);
 	
  	    waterfall.addKeyListener(key);
		waterfall.setMinimumSize(new Dimension(500,400));
		waterfall.setSize(WIDTH, HEIGHT);
		waterfall.add(key, BorderLayout.SOUTH);
		waterfall.setVisible(true);
	}
	
	/**
	 * Draws the waterfall screen to the window.
	 * @g the Graphics component used to draw the screen.
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		int width = getWidth();
	    int height = getHeight();
	    double rx = width/1125.0;
	    double ry = height/800.0;

	    Graphics2D g2 = (Graphics2D)g;
	    g2.scale(rx, ry);
	    
	    //not showing after resize
	    g2.setStroke(new BasicStroke(3));
	    for(int i = 0; i <15 ; i++){
	    	g.drawRoundRect(75+(interval*count),0, 70, 650, 20, 20);
	    	interval = (1125-75)/15;
	    	count++;
	    }
	    
	   repaint();
	}
	
	
	
	
}