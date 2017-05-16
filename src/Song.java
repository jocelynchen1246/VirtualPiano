import java.util.ArrayList;

import org.jfugue.pattern.Pattern;
import org.jfugue.theory.Note;
public class Song {
	private ArrayList<Note> notes;
	private String title;
	
	public Song(String name){
		notes= new ArrayList<Note>();
		title=name;
		if(title.equalsIgnoreCase("Mary had a little lamb")){
					
					notes.add(new Note(76,0.25));
					notes.add(new Note(74,0.25));
					notes.add(new Note(72,0.25));
					notes.add(new Note(74,0.25));
					notes.add(new Note(76,0.25));
					notes.add(new Note(76,0.25));
					notes.add(new Note(76,0.5));
					notes.add(new Note(74,0.25));
					notes.add(new Note(74,0.25));
					notes.add(new Note(74,0.5));
					notes.add(new Note(76,0.25));
					notes.add(new Note(79,0.25));
					notes.add(new Note(79,0.5));
					
					notes.add(new Note(76,0.25));
					notes.add(new Note(74,0.25));
					notes.add(new Note(72,0.25));
					notes.add(new Note(74,0.25));
					notes.add(new Note(76,0.25));
					notes.add(new Note(76,0.25));
					notes.add(new Note(76,0.5));
					notes.add(new Note(74,0.25));
					notes.add(new Note(74,0.25));
					notes.add(new Note(76,0.25));
					notes.add(new Note(74,0.25));
					notes.add(new Note(72,0.5));
				}
			}
	
	public void getLength(int index){
		notes.get(index).getDuration();
	}
	
	public ArrayList<Note> getNotes(){
		return notes;
	}
}
