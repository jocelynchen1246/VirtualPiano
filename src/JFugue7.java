

import java.io.File;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.jfugue.midi.MidiFileManager;
import org.jfugue.midi.MidiParser;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;
import org.jfugue.theory.Note;
import org.staccato.StaccatoParserListener;

public class JFugue7 extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }
    
    TextArea text;
    Button button1, button2;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        button1 = new Button("JFugue7_1.mid");
        button2 = new Button("JFugue7_2.mid");
        
        button1.setPrefSize(150, 100);
        button2.setPrefSize(150, 100);
                
        button1.setOnAction(e->example1());
        button2.setOnAction(e->example2());
                
        VBox examples = new VBox(10, button1, button2);
        examples.setPadding(new Insets(10));
        
        text = new TextArea();
        text.setPrefRowCount(20);
        text.setPrefColumnCount(32);
        text.setFont(Font.font("Verdana", 20));
        text.setEditable(false);
        text.setWrapText(true);
        
        HBox root = new HBox(50,examples,text);
        
        Scene scene = new Scene(root, 900, 600);
        primaryStage.setTitle("JFugue 7. Patterns");
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void example1() {
        Player player = new Player();
        Pattern pattern = new Pattern();
        Note note1 = new Note(60, 0.25); // C5 qurter-note
        note1.setOnVelocity((byte)80);
        Note note2 = new Note(62, 0.25); // D5 qurter-note
        note2.setOnVelocity((byte)90);
        Note note3 = new Note(64, 0.5); // E5 half-note
        note3.setOnVelocity((byte)100);
        Note note4 = new Note(65, 0.5); // F5 half-note
        note4.setOnVelocity((byte)110);
        Note rest = Note.createRest(0.25);
        pattern.add(note1,rest,note2,rest,note3,rest,note4);
        try {
            MidiFileManager
                    .savePatternToMidi(pattern,
                            new File("JFugue7_1.mid"));
        } catch (IOException ex) {
        }
        player.play(pattern);
        text.appendText("\n\n1. "+pattern);
    }
    
    private void example2() {
    	MidiParser parser = new MidiParser();
        StaccatoParserListener listener = new StaccatoParserListener();
        parser.addParserListener(listener);
        Player player = new Player();
        Pattern pattern= null;
        try {
        	parser.parse(MidiSystem.getSequence(new File("twinkle_twinkle.mid")));
            pattern = listener.getPattern();
            
            

        } 
        catch(InvalidMidiDataException e){
        	
        }
        catch (IOException ex) {
        }
       // text.appendText("\n\n2. "+pattern);
       player.play(pattern);
       
    }
}
