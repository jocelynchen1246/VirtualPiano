import java.awt.Image;
import java.awt.Shape;
import java.util.ArrayList;

public class Bars extends MovingImage {
	
	public static final int WIDTH = 75;
	public static final int HEIGHT = 100;
	
	private double xvel, yvel;
	private String filename;
	
	
	public Bars(String name,int x, int y) {
		super(name, x, y, WIDTH, HEIGHT);
		name = filename;
		yvel = 0;
		xvel = 0;
	}
	

	public void fall() {
		yvel += 0.7;
		super.y+=yvel;
	}

}
