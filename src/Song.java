import java.util.ArrayList;

import org.jfugue.pattern.Pattern;
import org.jfugue.theory.Note;
/**
 * This class represents the songs that players can choose to play in the WaterfallScreen.
 * @author Natalie Tarn
 *
 */
public class Song {
	
	private String title;
	private Pattern tune=new Pattern();
	/**
	 * Creates a song based on the title of the song chosen.
	 * @param name, the title of the song.
	 */
	public Song(String name){
		
		title=name;
		if(title.equalsIgnoreCase("Mary had a little lamb")){
					Pattern p1= new Pattern("E4q D4q C4q D4q E4q E4q E4h");
					tune.add(p1);
					tune.add("D4q D4q D4h E4q G4q G4h");
					tune.add(p1);
					tune.add("D4q D4q E4q D4q C4h");
//					notes.add(new Note(75,0.24));
//					notes.add(new Note(74,0.24));
//					notes.add(new Note(72,0.24));
//					notes.add(new Note(74,0.24));
//					notes.add(new Note(75,0.24));
//					notes.add(new Note(75,0.24));
//					notes.add(new Note(75,0.4));
					
//					notes.add(new Note(74,0.24));
//					notes.add(new Note(74,0.24));
//					notes.add(new Note(74,0.4));
//					notes.add(new Note(75,0.24));
//					notes.add(new Note(79,0.24));
//					notes.add(new Note(79,0.4));
//					
//					notes.add(new Note(75,0.24));
//					notes.add(new Note(74,0.24));
//					notes.add(new Note(72,0.24));
//					notes.add(new Note(74,0.24));
//					notes.add(new Note(75,0.24));
//					notes.add(new Note(75,0.24));
//					notes.add(new Note(75,0.4));
//					notes.add(new Note(74,0.24));
//					notes.add(new Note(74,0.24));
//					notes.add(new Note(75,0.24));
//					notes.add(new Note(74,0.24));
//					notes.add(new Note(72,0.4));
				}
		else if(title.equalsIgnoreCase("Twinkle Twinkle little Star")){
			Pattern pattern1 = new Pattern("C4q C4q G4q G4q A4q A4q G4h");
			Pattern pattern2 = new Pattern("F4q F4q E4q E4q D4q D4q C4h");
			Pattern pattern3 = new Pattern("G4q G4q F4q F4q E4q E4q D4h");
			tune = new Pattern();
			tune.add(pattern1);
			tune.add(pattern2);
			tune.add(pattern3);
			tune.add(pattern3);
			tune.add(pattern1);
			tune.add(pattern2); 
		}
		else if(title.equalsIgnoreCase("Bach Crab Canon")){
			tune = new Pattern("D4h E4h A4h Bb4h C#4h Rq A4q "+
				    "A4q Ab4h G4q G4q F#4h F4q F4q E4q Eb4q D4q "+ 
				    "C#4q A3q D4q G4q F4h E4h D4h F4h A4i G4i A4i "+
				    "D5i A4i F4i E4i F4i G4i A4i B4i C#5i D5i F4i "+
				    "G4i A4i Bb4i E4i F4i G4i A4i G4i F4i E4i F4i "+
				    "G4i A4i Bb4i C5i Bb4i A4i G4i A4i Bb4i C5i D5i "+
				    "Eb5i C5i Bb4i A4i B4i C#5i D5i E5i F5i D5i "+
				    "C#5i B4i C#5i D5i E5i F5i G5i E5i A4i E5i D5i "+
				    "E5i F5i G5i F5i E5i D5i C#5i D5q A4q F4q D4q");
			tune.add("D4q F4q A4q D5q C#5i D5i E5i F5i G5i F5i E5i"    				
					+" D5i E5i A4i E5i G5i F5i E5i D5i C#5i B4i C#5i"    				
					+" D5i F5i E5i D5i C#5i B4i A4i Bb4i C5i Eb5i"    				
					+" D5i C5i Bb4i A4i G4i A4i Bb4i C5i Bb4i A4i G4i"    				
					+" F4i E4i F4i G4i A4i G4i F4i E4i Bb4i A4i G4i"    				
					+" F4i D5i C#5i B4i A4i G4i F4i E4i F4i A4i D5i"    				
					+" A4i G4i A4i F4h D4h E4h F4h G4q D4q A3q C#4h"    				
					+" D4q Eb4q E4q F4q F4q F#4h G4q G4q Ab4h A4q"    				
					+" A4q Rq C#4h Bb4h A4h E4h D4h");
				 
		}
		else if(title.equalsIgnoreCase("Fur Elise")){
			String patt1 ="E5s D#5s E5s D#5s E5s B4s D5s C5s ";
	        String patt2 = "A4i Rs C4s E4s A4s B4i Rs E4s ";
	        String patt3 = "G#4s B4s C5i Rs E4s ";
	        String patt4 = "C5s B4s A4i ";
	 
	        tune.add(patt1 +  patt2 + patt3   + patt1 + patt2 + patt4);
		}
			}
	
	/**
	 * Returns the song itself.
	 * @return the song tune
	 */
	public Pattern getTune(){
		return tune;
	}
	/**
	 * Returns the song written out in Staccato format.
	 * @return a String of the song written out in Staccato format.
	 */
	public String printTune(){
		return tune.toString();
	}
	/**
	 * Returns the title of the song
	 * @return written out in Staccato format.
	 */
	public String getTitle(){
		return title;
	}
}
