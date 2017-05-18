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
public class Player {
	private ArrayList<Double> scores;
	private ArrayList<ArrayList<Double>> song;
	/**
	 * This constructor creates a list of a list of scores that a player receives after playing a piece.
	 */
	public Player(){
		scores= new ArrayList<Double>();
		song=new ArrayList<ArrayList<Double>>(3);
		song.add(scores);
		song.add(scores);
		song.add(scores);
	}
	
	/**
	 * This method calculates the accuracy of how accurate the player played the piano piece.
	 * @param x, which represents the song that the accuracy will be calculated on
	 * @param keyboard the keyboard with the recorded notes that the player has played.
	 * @return score, the percentage of the accuracy
	 */
	public double calcScore(Waterfall x, WaterfallKeyboard keyboard){
		double score=0;
		for(int i =0; i<x.getNotes().size();i++){
			Note correct=x.getNotes().get(i);
			Note record=keyboard.getRecord().get(i);
			if(correct.toString().equals(record.toString())){
				double correctL= correct.getDuration();
				double recordL= record.getDuration();
				score=score+100;
//				if(correctL==recordL){
//					score=score+100;
//				}
//				else{
//					if(recordL>correctL){
//						score=score+100*(correctL/recordL);
//					}
//					else{
//						score=score+100*(recordL/correctL);
//					}
//				}
			}
			
		}
		scores.add(score);
		if(x.getTitle().equalsIgnoreCase("Mary had a little lamb")){
			song.set(0, scores);
		}
		else if(x.getTitle().equalsIgnoreCase("Twinkle twinkle little star")){
			song.set(1, scores);
		}
		else if(x.getTitle().equalsIgnoreCase("Crab Canon")){
			song.set(2, scores);
		}
		
		return score/x.getNotes().size();
	}
	/**
	 * @param i, which ranks the score of a certain song
	 * This method ranks all the player's scores in order in the score ArrayList.
	 */
	public void rankScore(int i){
		Collections.sort(song.get(i));
	}
}
