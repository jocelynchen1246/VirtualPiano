import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.midi.MidiUnavailableException;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfugue.realtime.RealtimePlayer;

public class VirtualPiano extends JFrame implements ActionListener{

	private TitleScreen title;
	private WaterfallScreen waterfall;
	private Keyboard keyboard;
	private ScoreScreen score;
	private RealtimePlayer player;
	
	private JPanel cardPanel;
	
	
	public VirtualPiano(String titl) throws MidiUnavailableException
	{
		super(titl);
		setBounds(100, 100, 1195, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		player = new RealtimePlayer();
		title = new TitleScreen();
		waterfall = new WaterfallScreen();
		keyboard = new Keyboard(player);
		score = new ScoreScreen();
		
		addKeyListener(keyboard);
		
		cardPanel = new JPanel();
		CardLayout cl = new CardLayout();
		cardPanel.setLayout(cl);
		
		
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void changePanel(String name) {
		((CardLayout)cardPanel.getLayout()).show(cardPanel,name);
		requestFocus();
	}

}
