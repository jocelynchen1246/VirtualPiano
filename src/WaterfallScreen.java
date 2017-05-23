import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

import javax.sound.midi.MidiUnavailableException;
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

	private JPanel waterfall, wf1, wf2;
	private WaterfallKeyboard key;
	private Waterfall synth;
	public static final int WIDTH = 1195;
	public static final int HEIGHT = 600;
	private int count, interval, notenum;
	private double barpos;
	private Bars bluebar, greenbar;
	private double duration;
	private ArrayList<Bars> b;
	VirtualPiano v;
	
	
	/**
	 * Creates a JPanel that displays the waterfall formatting of the 
	 */
	public WaterfallScreen(VirtualPiano v, Song x) throws MidiUnavailableException{
		count= 0;
		wf1= new JPanel();
		wf1.setOpaque(false);
		wf2= new JPanel();
		wf2.setOpaque(false);
		barpos = 0;
		interval = 0;
		duration = 0.0;
	//	waterfall = new JPanel();
		b = new ArrayList<Bars>(); 
	
		setLayout(new GridLayout(3,1));
		key = new WaterfallKeyboard(new RealtimePlayer(), v);
		synth = new Waterfall(x);
		bluebar = new Bars("bluerect.png",0,0,0.0,synth,"0");
		greenbar = new Bars("greenrect.png",0,0,0.0,synth,"0");
		notenum = synth.getNotes().size();
		this.v = v;
		add(wf2);
		add(wf1);
		add(key); 

		int g = 0;
		g = key.getHeight()/2;
		
		setVisible(true);
	}

	public void paint(Graphics g){
		super.paint(g);
		int width = getWidth();
	    int height = getHeight();
	    double rx = width/1195.0;
	    double ry = height/600.0;

	    Graphics2D g2 = (Graphics2D)g;
	    g2.scale(rx, ry);
	    
	    
	    g2.setStroke(new BasicStroke(3));
	    for(int i = 0; i<15 ; i++){
	    	g2.drawRoundRect(75+(interval*count),0, 70, 650,20,20)
	    	;
	    	interval = (1195-75)/15;
	    	count++;
	    }
	    
	    for (int k = 0; k<synth.getNotes().size(); k++){
	    	bluebar.getHeight(synth, k);
	    	bluebar.setX(synth, k);
	    	b.add(bluebar);
	    	b.get(k).update();
	    	b.get(k).draw(g, this);
	    }
			repaint();  

	}
	public WaterfallKeyboard getKeyboard(){
		return key;
	}
	public Waterfall getWaterfall(){
		return synth;
	}
	
}