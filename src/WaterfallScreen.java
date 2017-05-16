import java.awt.Dimension;

import javax.swing.JPanel;
/**
 * This class displays the "waterfall" functioning of the app, and implements the 
 * 
 * @author IvyHuang
 *
 */
public class WaterfallScreen extends JPanel{

	private JPanel waterfall;
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	
	
	/**
	 * Creates a JPanel that displays the waterfall formatting of the 
	 */
	public WaterfallScreen(){
		waterfall = new JPanel();
		waterfall.setMinimumSize(new Dimension(500,400));
		waterfall.setSize(WIDTH, HEIGHT);
		waterfall.setVisible(true);
	}
	
}