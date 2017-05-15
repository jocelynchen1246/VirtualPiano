import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tester  {

	 public static void main(String[] args)
	  {
	    JFrame w = new JFrame("Simple Window");
	    w.setBounds(100, 100, 800, 600);
	    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    JPanel panel = new JPanel();
	    w.add(panel);
	    w.setResizable(true);
	    w.setVisible(true);
	    Keyboard k= new Keyboard();
	    w.addKeyListener(k);
	    panel.addMouseListener(null);
	  }

}
