import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.event.ActionListener;

import java.awt.Image;
import java.util.ArrayList;


import javax.sound.midi.MidiUnavailableException;

import javax.swing.JFrame;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import org.jfugue.theory.Note;

import org.jfugue.realtime.RealtimePlayer;
/**
 * This class displays the "waterfall" functioning of the app, and implements the 
 * 
 * @author IvyHuang
 *
 */

//take 
public class WaterfallScreen extends JPanel{

	private JPanel waterfall, wf;
	private WaterfallKeyboard key;
	private ArrayList<Note> note;
	private Waterfall synth;

	public static final int WIDTH = 1125; //1195,800
	public static final int HEIGHT = 200;


	private int count, interval;

	private RealtimePlayer player=new RealtimePlayer();

	private Bars bluebar, greenbar;
	private ImageIcon blue, green;

	private double duration;

	
	/**
	 * Creates a JPanel that displays the waterfall formatting of the song currently playing/
	 */
	public WaterfallScreen() throws MidiUnavailableException{
		super();
		
		count = 0;
		interval = 0;
		duration = 0.0;
		waterfall = new JPanel();
		bluebar = new Bars("bluerect.png",70,100);
		greenbar = new Bars("greenrect.png", 70,100);
	//	wf = new JPanel();
		waterfall.setLayout(new BorderLayout());
		key = new WaterfallKeyboard(player);
		synth = new Waterfall( new Song ("mary had a little lamb"));

		
		waterfall.setBounds(100, 100, 1125, 200);
  		
  		waterfall.setFocusTraversalKeysEnabled(false);
 		key.setFocusTraversalKeysEnabled(false);
 	
  	    waterfall.addKeyListener(key);

		note = new ArrayList<Note>();
		
		for (int i = 0; i<synth.getNotes().size(); i++){
			duration = synth.getLength(i);
			if(duration == 1.0){
				bluebar = new Bars("bluerect.png", 70, 400);
			}else if (duration == 0.5){
				bluebar = new Bars("bluerect.png", 70,200);
				
			}else if (duration == 0.25){
				bluebar = new Bars("bluerect.png", 70,100);
			}else if (duration == 0.125){
				bluebar = new Bars("bluerect.png", 70,50);
			}else{
				bluebar = new Bars("bluerect.png", 70,100);
			}
			
		}
		

		waterfall.setMinimumSize(new Dimension(500,400));
		setSize(WIDTH, HEIGHT);
		add(key, BorderLayout.SOUTH);
		setVisible(true);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		int width = getWidth();
	    int height = getHeight();
	    double rx = width/1195.0;
	    double ry = height/800.0;

	    Graphics2D g2 = (Graphics2D)g;
	    g2.scale(rx, ry);
	    
	    //not showing after resize
	    g2.setStroke(new BasicStroke(3));
	    
	    for(int i = 0; i<15 ; i++){
	    	g.drawRoundRect(75+(interval*count),0, 70, 650, 20, 20);
	    	interval = (1195-75)/15;
	    	count++;
	    }
	    
	    
	    
	   repaint();
	}
	
}
	
	
