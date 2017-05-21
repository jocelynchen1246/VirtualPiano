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
	private RealtimePlayer realplayer;
	private Player player;
	private InstructionScreen instruction;
	
	private JPanel cardPanel;
	
	
	public VirtualPiano(String titl) throws MidiUnavailableException
	{
		super(titl);
		setBounds(100, 100, 1195, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		player= new Player();
		realplayer = new RealtimePlayer();
		title = new TitleScreen(this);

		waterfall = new WaterfallScreen(this);
		keyboard = new Keyboard(realplayer,this);
		score = new ScoreScreen(this,player, waterfall.getWaterfall(), waterfall.getKeyboard());

	

		instruction = new InstructionScreen(this);
		
		keyboard.setFocusTraversalKeysEnabled(false);

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
