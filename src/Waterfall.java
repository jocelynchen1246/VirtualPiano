import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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
	private ArrayList<Note> notes;
	private String tune;
	/** 
	 * This constructor represents a song based on its note lengths in a waterfall format.
	 */
	public Waterfall(Song x){
		notes= new ArrayList<Note>();
		tune= x.printTune();
		int i=0;
		int space=0;
		Note note;
		while( i<tune.length()){
			
			space=tune.indexOf(' ', i);
			if(space==-1){
				note=new Note(tune.substring(i));
				i=tune.length();
			}
			else{
				note = new Note(tune.substring(i, space));
				i=space+1;
			}
			
			notes.add(note);
		}
	}
	
	
	public double getLength(int index){
		return notes.get(index).getDuration();
	}
	
	public ArrayList<Note> getNotes(){
		return notes;
	}
		 
	}
