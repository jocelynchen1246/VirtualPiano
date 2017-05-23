import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

import org.jfugue.theory.Note;
/**
* This class stores all the accuracy scores that the player has for a certain song.
* @author Natalie Tarn
*/
public class Player {
	private ArrayList<String> scoresM, scoresT, scoresB, scoresF; //M=mary had, T=twinkle, B=Bach
	private ArrayList<ArrayList<String>> song;
	/**
	 * This constructor creates a list of a list of scores that a player will receives after playing a piece.
	 */
	public Player(){
		scoresM= new ArrayList<String>();
		scoresT= new ArrayList<String>();
		scoresB= new ArrayList<String>();
		scoresF= new ArrayList<String>();
		song=new ArrayList<ArrayList<String>>(3);
		song.add(scoresM);
		song.add(scoresT);
		song.add(scoresB);
		song.add(scoresF);
	}
	
	/**
	 * This method calculates the accuracy of how accurate the player played the piano piece.
	 * @param x, which represents the song that the accuracy will be calculated on
	 * @param keyboard the keyboard with the recorded notes that the player has played.
	 * @return the percentage of the accuracy
	 */
	public String calcScore(Waterfall x, WaterfallKeyboard keyboard){
		double score=0;
		for(int i =0; i<x.getNotes().size();i++){
			Note correct=x.getNotes().get(i);
			Note record=keyboard.getRecord().get(i);
			if(correct.toString().equals(record.toString())){
				double correctL= correct.getDuration();
				double recordL= record.getDuration();
				score=score+100;
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
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.CEILING);
		score=score/x.getNotes().size();
		String score1=df.format(score);
		//0=mary, 1= twinkle, 2=crab
		if(x.getTitle().equalsIgnoreCase("Mary had a little lamb")){
			scoresM.add(score1);
			rankScore(0);
			song.set(0, scoresM);
		}
		else if(x.getTitle().equalsIgnoreCase("Twinkle twinkle little star")){
			scoresT.add(score1);
			rankScore(1);
			song.set(1, scoresT);
		}
		else if(x.getTitle().equalsIgnoreCase("Crab Canon")){
			scoresB.add(score1);
			rankScore(2);
			song.set(2, scoresB);
		}
		else if(x.getTitle().equalsIgnoreCase("Fur Elise")){
			scoresB.add(score1);
			rankScore(3);
			song.set(3, scoresF);
		}
		
		return score1;
	}
	/**
	 * @param i, which ranks the score of a certain song
	 * This method ranks all the player's scores in order in the score ArrayList.
	 */
	public void rankScore(int i){
		Collections.sort(song.get(i));
	}
	public ArrayList<String> getScores(int i){
		return song.get(i);
	}
}
