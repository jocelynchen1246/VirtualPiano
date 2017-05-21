import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.midi.MidiUnavailableException;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfugue.realtime.RealtimePlayer;

public class VirtualPiano extends JFrame{

	private TitleScreen title;
	private WaterfallScreen waterfall;
	private Keyboard keyboard;
	private ScoreScreen score;
	private RealtimePlayer player;
	private InstructionScreen instruction;
	
	private JPanel cardPanel;
	
	
	public VirtualPiano(String titl) throws MidiUnavailableException
	{
		super(titl);
		setBounds(100, 100, 1195, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		player = new RealtimePlayer();
		title = new TitleScreen(this);
		waterfall = new WaterfallScreen(this);
		keyboard = new Keyboard(player, this);
		score = new ScoreScreen();
		instruction = new InstructionScreen(this);
		
		addKeyListener(keyboard);
		
		cardPanel = new JPanel();
		CardLayout cl = new CardLayout();
		cardPanel.setLayout(cl);
		
		cardPanel.add(title, "1");
		cardPanel.add(keyboard, "2");
		cardPanel.add(instruction, "3");
		cardPanel.add(waterfall, "4");
		cardPanel.add(score, "5");
		
		add(cardPanel);
		
		setVisible(true);
		
		
	}

	
	public void changePanel(String name) {
		((CardLayout)cardPanel.getLayout()).show(cardPanel,name);
		requestFocus();
	}

	public static void main(String[] args) throws MidiUnavailableException
	{
		VirtualPiano v = new VirtualPiano("VirtualPiano");
	}
}
