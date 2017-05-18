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
	 * @param name, the title of the song
	 */
	public Song(String name){
		
		title=name;
		if(title.equalsIgnoreCase("Mary had a little lamb")){
					Pattern p1= new Pattern("E4q D4q C4q D4q E4q E4q E4h");
					tune.add(p1);
					tune.add("D4q D4q D4h E4q G4q G4h");
					tune.add(p1);
					tune.add("D4q D4q E4q D4q C4h");
//					notes.add(new Note(76,0.25));
//					notes.add(new Note(74,0.25));
//					notes.add(new Note(72,0.25));
//					notes.add(new Note(74,0.25));
//					notes.add(new Note(76,0.25));
//					notes.add(new Note(76,0.25));
//					notes.add(new Note(76,0.5));
					
//					notes.add(new Note(74,0.25));
//					notes.add(new Note(74,0.25));
//					notes.add(new Note(74,0.5));
//					notes.add(new Note(76,0.25));
//					notes.add(new Note(79,0.25));
//					notes.add(new Note(79,0.5));
//					
//					notes.add(new Note(76,0.25));
//					notes.add(new Note(74,0.25));
//					notes.add(new Note(72,0.25));
//					notes.add(new Note(74,0.25));
//					notes.add(new Note(76,0.25));
//					notes.add(new Note(76,0.25));
//					notes.add(new Note(76,0.5));
//					notes.add(new Note(74,0.25));
//					notes.add(new Note(74,0.25));
//					notes.add(new Note(76,0.25));
//					notes.add(new Note(74,0.25));
//					notes.add(new Note(72,0.5));
				}
		else if(title.equalsIgnoreCase("Twinkle Twinkle little Star")){
			Pattern pattern1 = new Pattern("C5q C5q G5q G5q A5q A5q Gh");
			Pattern pattern2 = new Pattern("F5q F5q E5q E5q D5q D5q C5h");
			Pattern pattern3 = new Pattern("G5q G5q F5q F5q E5q E5q D5h");
			tune = new Pattern();
			tune.add(pattern1);
			tune.add(pattern2);
			tune.add(pattern3);
			tune.add(pattern3);
			tune.add(pattern1);
			tune.add(pattern2); 
		}
		else if(title.equalsIgnoreCase("Bach Crab Canon")){
			tune = new Pattern("D5h E5h A5h Bb5h C#5h Rq A5q "+
				    "A5q Ab5h G5q G5q F#5h F5q F5q E5q Eb5q D5q "+ 
				    "C#5q A3q D5q G5q F5h E5h D5h F5h A5i G5i A5i "+
				    "D6i A5i F5i E5i F5i G5i A5i B5i C#6i D6i F5i "+
				    "G5i A5i Bb5i E5i F5i G5i A5i G5i F5i E5i F5i "+
				    "G5i A5i Bb5i C6i Bb5i A5i G5i A5i Bb5i C6i D6i "+
				    "Eb6i C6i Bb5i A5i B5i C#6i D6i E6i F6i D6i "+
				    "C#6i B5i C#6i D6i E6i F6i G6i E6i A5i E6i D6i "+
				    "E6i F6i G6i F6i E6i D6i C#6i D6q A5q F5q D5q");
			tune.add("D5q F5q A5q D6q C#6i D6i E6i F6i G6i F6i E6i"    				
					+" D6i E6i A5i E6i G6i F6i E6i D6i C#6i B5i C#6i"    				
					+" D6i F6i E6i D6i C#6i B5i A5i Bb5i C6i Eb6i"    				
					+" D6i C6i Bb5i A5i G5i A5i Bb5i C6i Bb5i A5i G5i"    				
					+" F5i E5i F5i G5i A5i G5i F5i E5i Bb5i A5i G5i"    				
					+" F5i D6i C#6i B5i A5i G5i F5i E5i F5i A5i D6i"    				
					+" A5i G5i A5i F5h D5h E5h F5h G5q D5q A3q C#5h"    				
					+" D5q Eb5q E5q F5q F5q F#5h G5q G5q Ab5h A5q"    				
					+" A5q Rq C#5h Bb5h A5h E5h D5h");
				 
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
