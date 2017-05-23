import java.awt.Graphics;
import java.awt.Image;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Bars{
	
	public static final int WIDTH = 75;
	//public static final int HEIGHT = 100;
	
	private double xvel, yvel;
	private Waterfall synth;
	private int x, y, height;
	private String filename;
	BufferedImage img = null;

//	private ArrayList<Double> duration;
//	private ArrayList<String> note;
	
	public Bars(String name, int x, int y, double d, Waterfall w, String s) {
		//super(name, x, y, WIDTH, HEIGHT);
		synth = w;
		filename = name;
		try {
			img = ImageIO.read(new File(name));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.x = x;
		this.y = y;
	//	name = filename;
		yvel = 0;
		xvel = 0;
		height= (int)(d*400);
		
	}
	
	public int getHeight(Waterfall w, int x){
		double j = w.getLength(x);
		return (int)(j*400);
		
	}
	
	public void setX(Waterfall w, int i){
		
		String s = (w.getNotes().get(i).toStringWithoutDuration());
		
		if(s.equals("C4")){
			x = 75;
		}else if(s.equals("D4")){
			x =  75*2;
		}else if(s.equals("E4")){
			x =  75*3;
		}else if(s.equals("F4")){
			x =  75*4;
		}else if(s.equals("G4")){
			x =  75*5;
		}else if(s.equals("A4")){
			x =  75*6;
		}else if(s.equals("B4")){
			x =  75*7;
		}else if(s.equals("C5")){
			x =  75*8;
		}else if(s.equals("D5")){
			x =  75*9;
		}else if(s.equals("E5")){
			x =  75*10;
		}else if(s.equals("F5")){
			x =  75*11;
		}else if(s.equals("G5")){
			x =  75*12;
		}else if(s.equals("A5")){
			x =  75*13;
		}else if(s.equals("B5")){
			x =  75*14;
		}
		else if(s.equals("C6")){
			x =  75*15;
		}else{
			x = 75;
		}
		
	}
	
	public void update() {
		yvel += 0.7;
		y+=yvel;
	}
	
	public void draw(Graphics g, ImageObserver io){
		g.drawImage(img, x, y, io );
	}
}
