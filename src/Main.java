import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		JFrame w = new JFrame("Virtual Piano");
		w.setBounds(100, 100, 800, 600);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Keyboard board = new Keyboard();
		w.add(board);
		w.setResizable(true);
	    w.setVisible(true);
	    
	    w.addKeyListener(board);
	}

}
