import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
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

	private JPanel waterfall, wf;
	private WaterfallKeyboard key;
	private ArrayList<Note> note;
	private Waterfall synth;
	public static final int WIDTH = 1195;
	public static final int HEIGHT = 800;
	private int count, interval, notenum;
	private Bars bluebar, greenbar;
	private ImageIcon blue, green;
	private double duration;
	private ArrayList<Shape> shape;
	
	/**
	 * Creates a JPanel that displays the waterfall formatting of the 
	 */
	public WaterfallScreen() throws MidiUnavailableException{
		super();
		count= 0;
		interval = 0;
		notenum = 0;
		duration = 0.0;
		waterfall = new JPanel();
		bluebar = new Bars("bluerect.png",70,100);
		greenbar = new Bars("greenrect.png", 70,100);
		shape = new ArrayList<Shape>();
	//	wf = new JPanel();
		waterfall.setLayout(new BorderLayout());
		key = new WaterfallKeyboard(new RealtimePlayer());
		synth = new Waterfall( new Song ("Twinkle Twinkle little Star"));
		note = new ArrayList<Note>();
			
		
		
		waterfall.setMinimumSize(new Dimension(500,400));
		this.setSize(WIDTH, HEIGHT);
		this.add(key, BorderLayout.SOUTH);
		this.setVisible(true);
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
	    
	   /* g2.setStroke(new BasicStroke(3));
	    for(int i = 0; i<15 ; i++){
	    	g.drawRoundRect(75+(interval*count),0, 70, 650, 20, 20);
	    	interval = (1195-75)/15;
	    	count++;
	    }
	    */
	    
	    for (int i = 0; i<synth.getNotes().size(); i++){
			duration = synth.getLength(i);
			if(duration == 1.0){
				bluebar = new Bars("bluerect.png", 70, 400);
				greenbar = new Bars("greenrect.png", 70, 400);
			}else if (duration == 0.5){
				bluebar = new Bars("bluerect.png", 70,200);
				greenbar = new Bars("greenrect.png", 70, 200);
			}else if (duration == 0.25){
				bluebar = new Bars("bluerect.png", 70,100);
				greenbar = new Bars("greenrect.png", 70, 100);
			}else if (duration == 0.125){
				bluebar = new Bars("bluerect.png", 70,50);
				greenbar = new Bars("greenrect.png", 70, 50);
			}else{
				bluebar = new Bars("bluerect.png", 70,100);
				greenbar = new Bars("greenrect.png", 70, 100);
				
			}
			for(int j = 0; j< synth.getNotes().size(); j++){
				String s = (synth.getNotes().get(i).toStringWithoutDuration());
				if(s.equals("C4")){
					bluebar.draw(g2, 75, 0, this);
					
				}else if(s.equals("D4")){
					bluebar.draw(g2, 75*2, 0, this);
				}else if(s.equals("E4")){
					bluebar.draw(g2, 75*3, 0, this);
				}else if(s.equals("F4")){
					bluebar.draw(g2, 75*4, 0, this);
				}else if(s.equals("G4")){
					bluebar.draw(g2, 75*5, 0, this);
				}else if(s.equals("A4")){
					bluebar.draw(g2, 75*6, 0, this);
				}else if(s.equals("B4")){
					bluebar.draw(g2, 75*7, 0, this);
				}else if(s.equals("C5")){
					bluebar.draw(g2, 75*8, 0, this);
				}else if(s.equals("D5")){
					bluebar.draw(g2, 75*9, 0, this);
				}else if(s.equals("E5")){
					bluebar.draw(g2, 75*10, 0, this);
				}else if(s.equals("F5")){
					bluebar.draw(g2, 75*11, 0, this);
				}else if(s.equals("G5")){
					bluebar.draw(g2, 75*12, 0, this);
				}else if(s.equals("A5")){
					bluebar.draw(g2, 75*13, 0, this);
				}else if(s.equals("B5")){
					bluebar.draw(g2, 75*14, 0, this);
				}
				else if(s.equals("C6")){
					bluebar.draw(g2, 75*15, 0, this);
				}
				while(bluebar.getY()<key.getY()){
					double y =bluebar.getY();
					y+=5;
				}
		
			}
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