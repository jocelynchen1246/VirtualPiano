import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.KeyEventDispatcher;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.sound.midi.MidiDevice;
import javax.swing.JButton;
import javax.swing.JPanel;

import org.jfugue.devices.MidiParserReceiver;
import org.jfugue.devices.MusicTransmitterToParserListener;
import org.jfugue.devices.MusicTransmitterToSequence;
import org.jfugue.realtime.RealtimePlayer;

/**
 * This class represents the keyboard of a piano that has different keys that can be played.
 * @author Jocelyn
 *
 */
public class Keyboard extends JPanel implements KeyListener, KeyEventDispatcher, ActionListener{

	private Key[] keys;
	private int[] sharpXVal;
	private JButton back;
	VirtualPiano v;
	
	/**
	 * Creates a keyboard with two octaves.
	 * @param player the RealtimePlayer used to play the keyboard
	 */
	public Keyboard(RealtimePlayer player, VirtualPiano v)
	{
		super();
		setBackground(Color.WHITE);
		
		this.v = v;
		
		back = new JButton("Back");
		back.addActionListener(this);
		add(back);
		
	    setFocusTraversalKeysEnabled(false);
		keys = new Key[25];
		keys[0] = new Key(48, player);
		keys[1] = new Key(50, player);
		keys[2] = new Key(52, player);
		keys[3] = new Key(53, player);
		keys[4] = new Key(55, player);
		keys[5] = new Key(57, player);
		keys[6] = new Key(59, player);
		keys[7] = new Key(60, player);
		keys[8] = new Key(62, player);
		keys[9] = new Key(64, player);
		keys[10] = new Key(65, player);
		keys[11] = new Key(67, player);
		keys[12] = new Key(69, player);
		keys[13] = new Key(71, player);
		keys[14] = new Key(72, player);
		keys[15] = new Key(49, player);
		keys[16] = new Key(51, player);
		keys[17] = new Key(54, player);
		keys[18] = new Key(56, player);
		keys[19] = new Key(58, player);
		keys[20] = new Key(61, player);
		keys[21] = new Key(63, player);
		keys[22] = new Key(66, player);
		keys[23] = new Key(68, player);
		keys[24] = new Key(70, player);

		sharpXVal = new int[10];
		sharpXVal[0] = 50;
		sharpXVal[1] = 130;
		sharpXVal[2] = 290;
		sharpXVal[3] = 370;
		sharpXVal[4] = 450;
		sharpXVal[5] = 610;
		sharpXVal[6] = 690;
		sharpXVal[7] = 850;
		sharpXVal[8] = 930;
		sharpXVal[9] = 1010;
		
		
	}

	/**
	 * Draws the keyboard onto the window
	 * @param g the Graphics component used to draw the keyboard
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);  // Call JPanel's paintComponent method to paint the background
	    int width = getWidth();
	    int height = getHeight();

	    double ratioX = width/1195.0;
	    double ratioY = height/400.0;
	    //multiply all X values by the x ratio and multiply all y values by the y ratio
	    //scale method in Graphics 2D
	    Graphics2D g2 = (Graphics2D)g;
	    g2.scale(ratioX, ratioY);
	    
	   
	    g2.setStroke(new BasicStroke(5));
	    for(int i = 0; i < 25; i++)
	    {
	    	if(keys[i].isPlaying())
	    	{
    			g.setColor(Color.magenta);
    			if(i < 15)
		    		g.drawRoundRect(i*80, -10, 75, 410, 20, 20);
    			else
    				g.fillRect(sharpXVal[i-15], 0, 50, 250);
	    	}
	    	else
	    	{
	    		g.setColor(Color.BLACK);
	    		if(i < 15)
	    			g.drawRoundRect(i*80, -10, 75, 410, 20, 20);
	    		else
    				g.fillRect(sharpXVal[i-15], 0, 50, 250);
	    	}
	    }
	    
	    /*
	    g.setColor(Color.BLACK);
	    g.fillRect(50, 0, 50, 250);
	    g.fillRect(130, 0, 50, 250);
	    g.fillRect(290, 0, 50, 250);
	    g.fillRect(370, 0, 50, 250);
	    g.fillRect(450, 0, 50, 250);
	    g.fillRect(610, 0, 50, 250);
	    g.fillRect(690, 0, 50, 250);
	    g.fillRect(850, 0, 50, 250);
	    g.fillRect(930, 0, 50, 250);
	    g.fillRect(1010, 0, 50, 250);
*/
	    
	   
	}
	
	/**
	 * Is called when a key is pressed on the keyboard.
	 * Plays the key corresponding to the key pressed.
	 * @param e the KeyEvent representing the key that has been pressed
	 */
	public void keyPressed(KeyEvent e) {
	
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_TAB)
		{
			keys[0].play();
		}
		else if(key == KeyEvent.VK_Q)
		{
			keys[1].play();
		}
		else if(key == KeyEvent.VK_W)
		{
			keys[2].play();
		}
		else if(key == KeyEvent.VK_E)
		{
			keys[3].play();
		}
		else if(key == KeyEvent.VK_R)
		{
			keys[4].play();
		}
		else if(key == KeyEvent.VK_T)
		{
			keys[5].play();
		}
		else if(key == KeyEvent.VK_Y)
		{
			keys[6].play();
		}
		else if(key == KeyEvent.VK_U)
		{
			keys[7].play();
		}
		else if(key == KeyEvent.VK_I)
		{
			keys[8].play();
		}
		else if(key == KeyEvent.VK_O)
		{
			keys[9].play();
		}
		else if(key == KeyEvent.VK_P)
		{
			keys[10].play();
		}
		else if(key == KeyEvent.VK_OPEN_BRACKET)
		{
			keys[11].play();
		}
		else if(key == KeyEvent.VK_CLOSE_BRACKET)
		{
			keys[12].play();
		}
		else if(key == KeyEvent.VK_ENTER)
		{
			keys[13].play();
		}
		else if(key == KeyEvent.VK_BACK_SLASH)
		{
			keys[14].play();
		}
		else if(key == KeyEvent.VK_1)
		{
			keys[15].play();
		}
		else if(key == KeyEvent.VK_2)
		{
			keys[16].play();
		}
		else if(key == KeyEvent.VK_4)
		{
			keys[17].play();
		}
		else if(key == KeyEvent.VK_5)
		{
			keys[18].play();
		}
		else if(key == KeyEvent.VK_6)
		{
			keys[19].play();
		}
		else if(key == KeyEvent.VK_8)
		{
			keys[20].play();
		}
		else if(key == KeyEvent.VK_9)
		{
			keys[21].play();
		}
		else if(key == KeyEvent.VK_MINUS)
		{
			keys[22].play();
		}
		else if(key == KeyEvent.VK_EQUALS)
		{
			keys[23].play();
		}
		else if(key == KeyEvent.VK_BACK_SPACE)
		{
			keys[24].play();
		}
		repaint();
	}

	/**
	 * Is called when a key that was previously pressed is released.
	 * Stops playing the key corresponding to the key released.
	 * @param e the KeyEvent representing the key that has been released
	 */
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_TAB)
		{
			keys[0].stop();
		}
		else if(key == KeyEvent.VK_Q)
		{
			keys[1].stop();
		}
		else if(key == KeyEvent.VK_W)
		{
			keys[2].stop();
		}
		else if(key == KeyEvent.VK_E)
		{
			keys[3].stop();
		}
		else if(key == KeyEvent.VK_R)
		{
			keys[4].stop();
		}
		else if(key == KeyEvent.VK_T)
		{
			keys[5].stop();
		}
		else if(key == KeyEvent.VK_Y)
		{
			keys[6].stop();
		}
		else if(key == KeyEvent.VK_U)
		{
			keys[7].stop();
		}
		else if(key == KeyEvent.VK_I)
		{
			keys[8].stop();
		}
		else if(key == KeyEvent.VK_O)
		{
			keys[9].stop();
		}
		else if(key == KeyEvent.VK_P)
		{
			keys[10].stop();
		}
		else if(key == KeyEvent.VK_OPEN_BRACKET)
		{
			keys[11].stop();
		}
		else if(key == KeyEvent.VK_CLOSE_BRACKET)
		{
			keys[12].stop();
		}
		else if(key == KeyEvent.VK_ENTER)
		{
			keys[13].stop();
		}
		else if(key == KeyEvent.VK_BACK_SLASH)
		{
			keys[14].stop();
		}
		else if(key == KeyEvent.VK_1)
		{
			keys[15].stop();
		}
		else if(key == KeyEvent.VK_2)
		{
			keys[16].stop();
		}
		else if(key == KeyEvent.VK_4)
		{
			keys[17].stop();
		}
		else if(key == KeyEvent.VK_5)
		{
			keys[18].stop();
		}
		else if(key == KeyEvent.VK_6)
		{
			keys[19].stop();
		}
		else if(key == KeyEvent.VK_8)
		{
			keys[20].stop();
		}
		else if(key == KeyEvent.VK_9)
		{
			keys[21].stop();
		}
		else if(key == KeyEvent.VK_MINUS)
		{
			keys[22].stop();
		}
		else if(key == KeyEvent.VK_EQUALS)
		{
			keys[23].stop();
		}
		else if(key == KeyEvent.VK_BACK_SPACE)
		{
			keys[24].stop();
		}
		repaint();
	}

	/**
	 * Is called after a key is typed (pressed and released).
	 * @param arg0 the KeyEvent representing the key that has been typed
	 */
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Is called to intercept key calls before they get consumed and makes sure the tab key functions 
	 * correctly for the keyboard.
	 * @param e the KeyEvent intercepted
	 */
	public boolean dispatchKeyEvent(KeyEvent e) {
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_TAB)
		{
			
		}
		return false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 String change= e.getActionCommand();
		 if(change.equals("Back")){
			 v.changePanel("1");
		 }
	}
	
}
