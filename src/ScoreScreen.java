import java.awt.Dimension;

import javax.swing.JPanel;
/**
 * Displays the users scores ranked from highest to lowest
 * 
 * @author IvyHuang
 *
 */
public class ScoreScreen extends JPanel {

	private JPanel score;
	public static final int WIDTH = 300;
	public static final int HEIGHT = 500;
	
	/**
	 * Creates a JPanel that displays the users high scores.
	 */
	public ScoreScreen(){
		score = new JPanel();
		score.setMinimumSize(new Dimension(100, 300));
		score.setSize(WIDTH, HEIGHT);
		score.setVisible(true);
		
	}
}