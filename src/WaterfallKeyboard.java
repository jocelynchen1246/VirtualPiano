import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.jfugue.realtime.RealtimePlayer;
import org.jfugue.theory.Note;
/**
 * This class represents the keyboard on the WaterfallScreen, recording what the player has played to compare it with the correct song.
 * @author Natalie Tarn
 *
 */
public class WaterfallKeyboard extends Keyboard {
	
	

	private ArrayList<Note> recordedNotes;
	/**
	 * This constructor creates a keyboard with two octaves.
	 * @param player, the recording player 
	 */
	public WaterfallKeyboard(RealtimePlayer player, VirtualPiano v) {
		super(player, v);
		recordedNotes = new ArrayList<Note>();
		setSize(1195, 200);
	}
	
	/**
	 * Draws the keyboard onto the window
	 * @param g the Graphics component used to draw the keyboard
	 */
	public void paintComponent(Graphics g){
		//super.paintComponent(g);  // Call JPanel's paintComponent method to paint the background
	    int width = getWidth();
	    int height = getHeight();

	    double ratioX = width/1195.0;
	    double ratioY = height/200.0;
	    //multiply all X values by the x ratio and multiply all y values by the y ratio
	    //scale method in Graphics 2D
	    Graphics2D g2 = (Graphics2D)g;
	    //g2.scale(ratioX, ratioY);
	    
	   
	    g2.setStroke(new BasicStroke(5));
	    for(int i = 0; i < 25; i++)
	    {
	    	if(getKeys()[i].isPlaying())
	    	{
    			g.setColor(Color.magenta);
    			if(i < 15)
		    		g.drawRoundRect(i*80, -10, 75, 280, 20, 20);
    			else
    				g.fillRect(getSharpXVals()[i-15], 0, 50, 150);
	    	}
	    	else
	    	{
	    		g.setColor(Color.BLACK);
	    		if(i < 15)
	    			g.drawRoundRect(i*80, -10, 75, 280, 20, 20);
	    		else
    				g.fillRect(getSharpXVals()[i-15], 0, 50, 150);
	    	}
	    }
	}
	
	
	/**
	 * Is called when a key is pressed on the keyboard.
	 * Plays the key corresponding to the key pressed, and also adds it to the recordedNotes field.
	 * @param e the KeyEvent representing the key that has been pressed
	 */
	public void keyPressed(KeyEvent e) {
		super.keyPressed(e);
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_TAB)
		{
			recordedNotes.add(new Note(48));
		}
		else if(key == KeyEvent.VK_Q)
		{
			recordedNotes.add(new Note(50));
		}
		else if(key == KeyEvent.VK_W)
		{
			recordedNotes.add(new Note(52));
		}
		else if(key == KeyEvent.VK_E)
		{
			recordedNotes.add(new Note(53));
		}
		else if(key == KeyEvent.VK_R)
		{
			recordedNotes.add(new Note(55));
		}
		else if(key == KeyEvent.VK_T)
		{
			recordedNotes.add(new Note(57));
		}
		else if(key == KeyEvent.VK_Y)
		{
			recordedNotes.add(new Note(59));
		}
		else if(key == KeyEvent.VK_U)
		{
			recordedNotes.add(new Note(60));
		}
		else if(key == KeyEvent.VK_I)
		{
			recordedNotes.add(new Note(62));
		}
		else if(key == KeyEvent.VK_O)
		{
			recordedNotes.add(new Note(64));
		}
		else if(key == KeyEvent.VK_P)
		{
			recordedNotes.add(new Note(65));
		}
		else if(key == KeyEvent.VK_OPEN_BRACKET)
		{
			recordedNotes.add(new Note(67));
		}
		else if(key == KeyEvent.VK_CLOSE_BRACKET)
		{
			recordedNotes.add(new Note(69));
		}
		else if(key == KeyEvent.VK_ENTER)
		{
			recordedNotes.add(new Note(71));
		}
		else if(key == KeyEvent.VK_BACK_SLASH)
		{
			recordedNotes.add(new Note(72));
		}
		else if(key == KeyEvent.VK_1)
		{
			recordedNotes.add(new Note(49));
		}
		else if(key == KeyEvent.VK_2)
		{
			recordedNotes.add(new Note(51));
		}
		else if(key == KeyEvent.VK_4)
		{
			recordedNotes.add(new Note(54));
		}
		else if(key == KeyEvent.VK_5)
		{
			recordedNotes.add(new Note(56));
		}
		else if(key == KeyEvent.VK_6)
		{
			recordedNotes.add(new Note(58));
		}
		else if(key == KeyEvent.VK_8)
		{
			recordedNotes.add(new Note(61));
		}
		else if(key == KeyEvent.VK_9)
		{
			recordedNotes.add(new Note(63));
		}
		else if(key == KeyEvent.VK_MINUS)
		{
			recordedNotes.add(new Note(66));
		}
		else if(key == KeyEvent.VK_EQUALS)
		{
			recordedNotes.add(new Note(68));
		}
		else if(key == KeyEvent.VK_BACK_SPACE)
		{
			recordedNotes.add(new Note(70));
		}
		repaint();
	}
	/**
	 *  Returns the notes that the player played.
	 * @return The recorded notes in a ArrayList
	 */
	public ArrayList<Note> getRecord(){
		return recordedNotes;
	}
	
}
