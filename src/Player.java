import java.util.ArrayList;

import org.jfugue.realtime.RealtimePlayer;

/**
 * Represents someone playing the keyboard or game and stores personal scores.
 * @author Jocelyn Chen
 *
 */
public class Player {
	
	private RealtimePlayer player;
	private ArrayList<Score> scores;
	
	/**
	 * Creates a player.
	 * @param play the RealtimePlayer used by the player
	 */
	public Player(RealtimePlayer play)
	{
		
	}
	
	/**
	 * Adds a score to the player's personal scores.
	 * @param sc the score to be added
	 */
	public void addScore(Score sc)
	{
		
	}
	
	/**
	 * Gets the personal scores of the player.
	 * @return the personal scores of the player in an array list
	 */
	public ArrayList<Score> getScores()
	{
		return null;
	}
	
	/**
	 * Gets the RealtimePlayer associated with the player.
	 * @return the RealtimePlayer of the player
	 */
	public RealtimePlayer getPlayer()
	{
		return null;
	}

}
