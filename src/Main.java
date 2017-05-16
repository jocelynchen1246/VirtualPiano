import javax.sound.midi.MidiUnavailableException;
import javax.swing.JFrame;

import org.jfugue.realtime.RealtimePlayer;

public class Main {

	public static void main(String[] args) throws MidiUnavailableException {
		JFrame w = new JFrame("Virtual Piano");
		w.setBounds(100, 100, 800, 600);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		RealtimePlayer player = new RealtimePlayer();
		Keyboard board = new Keyboard(player);
		w.add(board);
		w.setResizable(true);
	    w.setVisible(true);
	    
	    w.addKeyListener(board);
	}

}
