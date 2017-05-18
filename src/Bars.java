import java.awt.Shape;
import java.util.ArrayList;

public class Bars extends MovingImage {
	public static final int MARIO_WIDTH = 40;
	public static final int MARIO_HEIGHT = 60;
	
	private double xvel, yvel;
	
	public Bars(int x, int y) {
		super("mario.png", x, y, MARIO_WIDTH, MARIO_HEIGHT);
		yvel = 0;
		xvel = 0;
	}
	
	public void fall(ArrayList<Shape> obstacles) {
		yvel += 0.7;
		super.y+=yvel;
	}


}
