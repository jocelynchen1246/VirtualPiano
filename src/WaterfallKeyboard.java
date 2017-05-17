import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.jfugue.realtime.RealtimePlayer;
import org.jfugue.theory.Note;

public class WaterfallKeyboard extends Keyboard {
	
	
	private Key[] keys;
	private int[] sharpXVal;
	private ArrayList<Note> recordedNotes;
	
	public WaterfallKeyboard(RealtimePlayer player) {
		super(player);
		// TODO Auto-generated constructor stub
	}
	
	
	
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
	
	public ArrayList<Note> getRecord(){
		return recordedNotes;
	}
}
