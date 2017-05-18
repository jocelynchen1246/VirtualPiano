import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;

import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;
import org.jfugue.theory.Note;

public class SongTester {
	   public static void main(String[] args) throws IOException, InvalidMidiDataException {
		// One voice of Bach’s Crab Canon
		   Pattern canon = new Pattern("D5h E5h A5h Bb5h C#5h Rq A5q "+
		    "A5q Ab5h G5q G5q F#5h F5q F5q E5q Eb5q D5q "+ 
		    "C#5q A3q D5q G5q F5h E5h D5h F5h A5i G5i A5i "+
		    "D6i A5i F5i E5i F5i G5i A5i B5i C#6i D6i F5i "+
		    "G5i A5i Bb5i E5i F5i G5i A5i G5i F5i E5i F5i "+
		    "G5i A5i Bb5i C6i Bb5i A5i G5i A5i Bb5i C6i D6i "+
		    "Eb6i C6i Bb5i A5i B5i C#6i D6i E6i F6i D6i "+
		    "C#6i B5i C#6i D6i E6i F6i G6i E6i A5i E6i D6i "+
		    "E6i F6i G6i F6i E6i D6i C#6i D6q A5q F5q D5q");
		 

		   // Combine the two patterns
		   Pattern pattern = new Pattern();
		   pattern.add("V0 " + canon);
		   
		   // Play Bach’s Crab Canon
		   Player player = new Player();
		   player.play(pattern);
		   
		   
		   
	    	Song x =new Song("Mary had a little lamb");
//	    	
//	    	Waterfall mary= new Waterfall(x);
//	    	System.out.println(mary.getLength(1));
//	    	
	    	
//	    	for (Note note : x.getNotes()) {
//	           player.play(mary.getNotes().get(2));
//	            System.out.println(mary.getNotes().get(2));
//	          }

//	        Pattern pattern = MidiFileManager.loadPatternFromMidi(new File("twinkle_twinkle.mid"));
//	      System.out.println(pattern);
	      //  player.play(x.getTune());
	        
	    
	}
}
