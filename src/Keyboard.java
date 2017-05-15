import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import org.jfugue.realtime.RealtimePlayer;

/**
 * This class represents the keyboard of a piano that has different keys that can be played.
 * @author Jocelyn
 *
 */
public class Keyboard extends JPanel implements KeyListener{

	private Key[] keys;
	
	/**
	 * Creates a keyboard with two octaves.
	 */
	public Keyboard()
	{
		super();
	}

	/**
	 * Draws the keyboard onto the window
	 * @param g the Graphics component used to draw the keyboard
	 */
	public void paintComponent(Graphics g)
	{
		
	}
	
	/**
	 * Is called when a key is pressed on the keyboard.
	 * Plays the key corresponding to the key pressed.
	 * @param arg0 the KeyEvent representing the key that has been pressed
	 */
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Is called when a key that was previously pressed is released.
	 * Stops playing the key corresponding to the key released.
	 * @param arg0 the KeyEvent representing the key that has been released
	 */
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Is called after a key is typed (pressed and released).
	 * @param arg0 the KeyEvent representing the key that has been typed
	 */
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
