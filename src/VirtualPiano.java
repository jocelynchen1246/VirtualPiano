import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.midi.MidiUnavailableException;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfugue.realtime.RealtimePlayer;

public class VirtualPiano extends JFrame{

	private TitleScreen title;
	private SongScreen choose;
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
		setBounds(100, 100, 1200, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		player= new Player();
		realplayer = new RealtimePlayer();
		title = new TitleScreen(this);
		choose= new SongScreen(this);
		
		keyboard = new Keyboard(realplayer,this);
		

		instruction = new InstructionScreen(this);
		
		keyboard.setFocusTraversalKeysEnabled(false);

		addKeyListener(keyboard);
		
		cardPanel = new JPanel();
		CardLayout cl = new CardLayout();
		cardPanel.setLayout(cl);
		
		cardPanel.add(title, "1");
		cardPanel.add(keyboard, "2");
		cardPanel.add(instruction, "3");
		
	
		cardPanel.add(choose,"4");
		
		add(cardPanel);
		
		setVisible(true);
		setResizable(false);
		
		
	}

	
	public void changePanel(String name) {
		((CardLayout)cardPanel.getLayout()).show(cardPanel,name);
		requestFocus();
	}

	public static void main(String[] args) throws MidiUnavailableException
	{
		VirtualPiano v = new VirtualPiano("VirtualPiano");
	}
	public JPanel getPanels(){
		return cardPanel;
	}
}
