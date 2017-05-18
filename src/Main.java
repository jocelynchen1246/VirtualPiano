import javax.sound.midi.MidiUnavailableException;
import javax.swing.JFrame;

import org.jfugue.realtime.RealtimePlayer;

public class Main {

	public static void main(String[] args) throws MidiUnavailableException {
		JFrame w = new JFrame("Virtual Piano");
		w.setBounds(100, 100, 1195, 400);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		RealtimePlayer player = new RealtimePlayer();
		Keyboard board = new Keyboard(player);
		
		board.setFocusTraversalKeysEnabled(false);
		
		w.add(board);
	    w.setVisible(true);
	    
	    w.addKeyListener(board);
	    
	}

}
