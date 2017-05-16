import java.io.File;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;

import org.jfugue.midi.MidiFileManager;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;
import org.jfugue.theory.Note;


/**
 * This class represents the note length (waterfall) that is shown on the WaterfallScreen when people play a song. 
 * @author Natalie Tarn 
 *
 */
public class Waterfall {
	
	/** 
	 * This constructor represents a song based on its note lengths in a waterfall format.
	 */
	public Waterfall(){
		
	}
		
		    public static void main(String[] args) throws IOException, InvalidMidiDataException {
//		    	Song x =new Song("Mary had a little lamb");
//		    	Player player = new Player();
//		    	for (Note note : x.getNotes()) {
//		            player.play(note);
//		            
//		          }
		        Pattern pattern = MidiFileManager.loadPatternFromMidi(new File("twinkle_twinkle.mid"));
		        System.out.println(pattern);
		    
		}
	}
