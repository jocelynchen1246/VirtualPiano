import java.io.File;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;

import org.jfugue.midi.MidiParser;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;
import org.staccato.StaccatoParserListener;

public class ParserDemo {
	
	    public static void main(String[] args) throws InvalidMidiDataException, IOException {
	        MidiParser parser = new MidiParser();
	        StaccatoParserListener listener = new StaccatoParserListener();
	        parser.addParserListener(listener);
	        parser.parse(MidiSystem.getSequence(new File("twinkle_twinkle.mid")));
	        Pattern staccatoPattern = listener.getPattern();
	        System.out.println(staccatoPattern);

	        Player player = new Player();
	        player.play(staccatoPattern);
	    }
	
}
