import java.awt.Dimension;

import javax.swing.JPanel;
/**
 * This class displays the title screen of the application (what shows up when the user runs the program)
 * @author Ivy Huang
 */
public class TitleScreen extends JPanel {

	private JPanel title;
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	
	
	/**
	 * Creates the title screen/main screen with the main menu and makes it visible to the user.
	 */
	public TitleScreen(){
		title = new JPanel();
		title.setMinimumSize(new Dimension(500,400));
		title.setSize(WIDTH, HEIGHT);
		title.setVisible(true);
		
		
	}
}