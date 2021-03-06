import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.sound.midi.MidiUnavailableException;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * This class creates a JPanel that allows the player to choose a song before continuing onto the waterfall game
 * @author Natalie Tarn
 *
 */
public class SongScreen extends JPanel implements ActionListener {
	
	VirtualPiano v;
	private JButton crab, twinkle, mary, furElise;
	private JButton back;
	private Song chosen;
	
	/**
	 * This constructor creates a song panel that includes the songs that they can play.
	 */
	public SongScreen(VirtualPiano v){
		this.v=v;
		this.setSize(1195,600);
		crab=new JButton("Bach Crab Canon");
		twinkle =new JButton ("Twinkle Twinkle Little Star");
		mary= new JButton("Mary Had a Little Lamb");
		furElise= new JButton("Fur Elise");
		back = new JButton("Back");
		
		crab.addActionListener(this);
		twinkle.addActionListener(this);
		mary.addActionListener(this);
		furElise.addActionListener(this);
		back.addActionListener(this);
		add(crab);
		add(twinkle);
		add(mary);
		add(furElise);
		add(back);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		WaterfallScreen waterfall = null;
		 String change= arg0.getActionCommand();
		 if(change.equalsIgnoreCase("Bach Crab Canon")){
			 chosen=new Song("Bach Crab Canon");
			 
			try {
				waterfall = new WaterfallScreen(v, chosen);
			} catch (MidiUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 v.getPanels().add(waterfall, "6");
			 v.changePanel("6");
		 }
		 else if(change.equalsIgnoreCase("Twinkle Twinkle Little Star")){
			 chosen=new Song("Twinkle Twinkle Little Star");
			 try {
					waterfall = new WaterfallScreen(v, chosen);
				} catch (MidiUnavailableException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 v.getPanels().add(waterfall, "6");
				 v.changePanel("6"); 
			 
		 }
		 else if(change.equalsIgnoreCase("Mary had a little lamb")){
			 chosen=new Song("Mary had a little lamb");
			 try {
					waterfall = new WaterfallScreen(v, chosen);
				} catch (MidiUnavailableException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 v.getPanels().add(waterfall, "6");
				v.changePanel("6");
		 }
		 else if(change.equalsIgnoreCase("Fur Elise")){
			 chosen=new Song("Fur Elise");
			 try {
					waterfall = new WaterfallScreen(v, chosen);
				} catch (MidiUnavailableException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				v.getPanels().add(waterfall, "6");
				v.changePanel("6");
		 }
		 else if(change.equalsIgnoreCase("Back"))
		 {
			 v.changePanel("1");
		 }
		
	}



}
