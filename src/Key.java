import org.jfugue.realtime.RealtimePlayer;
import org.jfugue.theory.Note;

/**
 * This class represents a key on the keyboard of a piano that can play a note.
 * @author Jocelyn
 *
 */
public class Key {
	
	private RealtimePlayer player;
	private Note note;
	private boolean isPlaying;
	
	/**
	 * Creates a key that plays the note with the midi number provided and plays the key using the player passed in.
	 * @param midi midi number correlating to the note
	 * @param play RealtimeaPlayer to be passed in that will play the key
	 */
	public Key(int midi, RealtimePlayer play)
	{
		player = play;
		note = new Note(midi);
		isPlaying = false;
	}
	
	/**
	 * Starts playing the note if it is not already playing. If the note is already playing, lets the note continue playing 
	 * but does not replay the note.
	 */
	public void play()
	{
		if(!isPlaying)
		{
			
		}
	}
	
	/**
	 * Stops playing the note if it is currently playing. 
	 */
	public void stop()
	{
		
	}

}
