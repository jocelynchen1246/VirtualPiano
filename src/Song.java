import java.util.ArrayList;

import org.jfugue.pattern.Pattern;
import org.jfugue.theory.Note;
public class Song {
	
	private String title;
	private Pattern tune=new Pattern();
	public Song(String name){
		
		title=name;
		if(title.equalsIgnoreCase("Mary had a little lamb")){
					Pattern p1= new Pattern("E5q D5q C5q D5q E5q E5q E5h");
					tune.add(p1);
					tune.add("D5q D5q D5h E5q G5q G5h");
					tune.add(p1);
					tune.add("D5q D5q E5q D5q C5h");
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
			}
	

	public Pattern getTune(){
		return tune;
	}
	public String printTune(){
		return tune.toString();
	}
	public String getTitle(){
		return title;
	}
}
