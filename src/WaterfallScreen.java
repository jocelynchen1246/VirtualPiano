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
		barpos = 0;
		interval = 0;
		notenum = 0;
		duration = 0.0;
		waterfall = new JPanel();
		b = new ArrayList<Bars>();
	//	wf = new JPanel();
		setLayout(new BorderLayout());
		key = new WaterfallKeyboard(new RealtimePlayer(), v);
		synth = new Waterfall( new Song ("Twinkle Twinkle little Star"));
		bluebar = new Bars(75,0,1.0,synth,"0");
		greenbar = new Bars(0,0,0.0,synth,"0");
		this.v = v;

		setMinimumSize(new Dimension(500,400));
		setSize(WIDTH, HEIGHT);
		key.setBounds(75, 600, 725, 50 );
		add(key, BorderLayout.SOUTH); 

		int g = 0;
		g = key.getHeight()/2;

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
	    	g2.drawRect(75+(interval*count),0, 70, 650);
	    	interval = (1195-75)/15;
	    	count++;
	    }
	    
	    for (int i = 0; i<synth.getNotes().size(); i++){
	    	bluebar.getHeight(synth, i);
	    	bluebar.setX(synth, i);
	    	bluebar.draw(g2, this);
	    	bluebar.update();
	    }
	/*    for (int i = 0; i<synth.getNotes().size(); i++){
			duration = synth.getLength(i);
			if(duration == 1.0){
				bluebar = new Bars("bluerect.png",70,400, duration,);
				greenbar = new Bars("greenrect.png", 70, 400,duration,);
			}else if (duration == 0.5){
				bluebar = new Bars("bluerect.png",70,200,duration,);
				greenbar = new Bars("greenrect.png", 70, 200,duration,);
			}else if (duration == 0.25){
				bluebar = new Bars("bluerect.png",70,100,duration,);
				greenbar = new Bars("greenrect.png", 70, 100,duration,);
			}else if (duration == 0.125){
				bluebar = new Bars("bluerect.png",70,50,duration,);
				greenbar = new Bars("greenrect.png", 70, 50,duration,);
			}else{
				bluebar = new Bars("bluerect.png",70,100, duration,);
				greenbar = new Bars("greenrect.png", 70, 100,duration,);
				
			}
			
	    //long startTime = System.currentTimeMillis();
			for(int j = 0; j< synth.getNotes().size(); j++){
				String s = (synth.getNotes().get(j).toStringWithoutDuration());
				if(s.equals("C4")){
					b.get(i).draw(g2,this);
					
				}else if(s.equals("D4")){
					bluebar.draw(g2, this);
				}else if(s.equals("E4")){
					bluebar.draw(g2, this);
				}else if(s.equals("F4")){
					bluebar.draw(g2,this);
				}else if(s.equals("G4")){
					bluebar.draw(g2, this);
				}else if(s.equals("A4")){
					bluebar.draw(g2, this);
				}else if(s.equals("B4")){
					bluebar.draw(g2, this);
				}else if(s.equals("C5")){
					bluebar.draw(g2,this);
				}else if(s.equals("D5")){
					bluebar.draw(g2,this);
				}else if(s.equals("E5")){
					bluebar.draw(g2,this);
				}else if(s.equals("F5")){
					bluebar.draw(g2,this);
				}else if(s.equals("G5")){
					bluebar.draw(g2, this);
				}else if(s.equals("A5")){
					bluebar.draw(g2,this);
				}else if(s.equals("B5")){
					bluebar.draw(g2,this);
				}
				else if(s.equals("C6")){
					bluebar.draw(g2,this);
				}
				bluebar.update();
			
			}
	    }
	    */
			repaint();  
	
	}	
	public WaterfallKeyboard getKeyboard(){
		return key;
	}
	public Waterfall getWaterfall(){
		return synth;
	}
	
}