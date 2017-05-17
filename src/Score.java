import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.sound.midi.MidiUnavailableException;

import org.jfugue.devices.MusicTransmitterToSequence;
import org.jfugue.realtime.RealtimeMidiParserListener;
import org.jfugue.realtime.RealtimePlayer;
import org.jfugue.theory.Note;
import org.staccato.StaccatoParserListener;
/**
* This class stores all the accuracy scores that the player has for a certain song.
* @author Natalie Tarn
*/
public class Score {
	private ArrayList<Double> scores;
	/**
	 * This constructor creates a list of scores that a player receives after playing a piece.
	 */
	public Score(){
		scores= new ArrayList<Double>();
	}
	
	/**
	 * This method calculates the accuracy of how accurate the player played the piano piece.
	 * @return score, the percentage of the accuracy
	 */
	public double calcScore(Waterfall song, WaterfallKeyboard keyboard){
		double score=0;
		for(int i =0; i<song.getNotes().size();i++){
			Note correct=song.getNotes().get(i);
			Note record=keyboard.getRecord().get(i);
			if(correct.toString().equals(record.toString())){
				double correctL= correct.getDuration();
				double recordL= record.getDuration();
				
				if(correctL==recordL){
					score=score+100;
				}
				else{
					if(recordL>correctL){
						score=score+100*(correctL/recordL);
					}
					else{
						score=score+100*(recordL/correctL);
					}
				}
			}
			
		}
		scores.add(score);
		return score/song.getNotes().size();
	}
	/**
	 * This method ranks all the player's scores in order in the score ArrayList.
	 */
	public void rankScore(){
		Collections.sort(scores);
	}
}
