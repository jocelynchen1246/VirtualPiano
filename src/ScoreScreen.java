import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;

import javax.swing.JPanel;
/**
 * Displays the users scores ranked from highest to lowest
 * 
 * @author Natalie Tarn
 *
 */
public class ScoreScreen extends JPanel implements MouseListener {

	
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	VirtualPiano v;
	private MovingImage titleBack, replay; 
	private int width, height;
	private boolean isInReplay;
	private Player p;
	private Waterfall waterfall;
	private WaterfallKeyboard keyboard;
	
	/**
	 * Creates a JPanel that displays the users high scores.
	 */
	public ScoreScreen(VirtualPiano piano, Player p, Waterfall waterfall, WaterfallKeyboard keyboard){
		v=piano;
		this.p=p;
		this.waterfall=waterfall;
		this.keyboard=keyboard;
		isInReplay=false;

		
		setBackground(Color.WHITE);
		
		titleBack = new MovingImage("titleButton.png", 120, 350, 50, 50);
		replay = new MovingImage("replayButton.png", 420, 350, 50, 50);
		setMinimumSize(new Dimension(100, 300));
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		
	}
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		
		double ratioX = getWidth() / 800.0; 
		double ratioY = getHeight() / 600.0; 
		
		AffineTransform at = g2.getTransform();
		
		//g2.scale(ratioX, ratioY);
		
		titleBack.draw(g2, this);
		replay.draw(g2, this);
		
		String s1 = "SCORE FOR " + waterfall.getTitle();
		
	    g.drawString(s1,40,30);
	    String score =p.calcScore(waterfall, keyboard);
	    g.drawString(score,30,40);
	    int i=0;
//	    if(waterfall.getTitle().equalsIgnoreCase("Mary had a little lamb")){
//			for(i=0; p.getScores(0).get(i)!=null;i++){
//				g.drawString(i+" "+p.getScores(0).get(i),30,40+10*(i+1));
//				i++;
//			}
//		}
//		else if(waterfall.getTitle().equalsIgnoreCase("Twinkle twinkle little star")){
//			for(i=0; p.getScores(1).get(i)!=null;i++){
//				g.drawString(i+" "+p.getScores(1).get(i),30,40+10*(i+1));
//				i++;
//			}
//		}
//		else if(waterfall.getTitle().equalsIgnoreCase("Crab Canon")){
//			for(i=0; p.getScores(2).get(i)!=null;i++){
//				g.drawString(i+" "+p.getScores(2).get(i),30,40+10*(i+1));
//				i++;
//			}
//		}
//		else if(waterfall.getTitle().equalsIgnoreCase("Fur Elise")){
//			for(i=0; p.getScores(3).get(i)!=null;i++){
//				g.drawString(i+" "+p.getScores(3).get(i),30,40+10*(i+1));
//				i++;
//			}
//		}
	    
	    
	    
	
		
		
		g2.setTransform(at);
		repaint();
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
		int x = e.getX();
		int y = e.getY();

		width = getWidth();
		height = getHeight();

		double ratioX = (double)width/800;
		double ratioY = (double)height/600;
		
		int unscaledX = (int)(x/ratioX);
		int unscaledY = (int)(y/ratioY);
		
		if (titleBack.isPointInImage(unscaledX, unscaledY) && !isInReplay){
			
			v.changePanel("1");
		} 
		if (replay.isPointInImage(unscaledX, unscaledY)){
			v.changePanel("4");
			
			isInReplay = true;

		repaint();
		}

	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}