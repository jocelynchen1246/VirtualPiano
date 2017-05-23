import java.awt.Graphics;
import java.awt.Image;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

/**
 * This class represents a single rectangular bar that falls in the waterfallscreen
 * @author Ivy Huang
 *
 */
public class Bars{
	
	public static final int WIDTH = 80;
	//public static final int HEIGHT = 100;
	
	private double xvel, yvel,y;
	private Waterfall synth;
	private int x, height;
	
	private String filename;
	BufferedImage img = null;

//	private ArrayList<Double> duration;
//	private ArrayList<String> note;
	
	public Bars(String name, int x, int y, double d, Waterfall w, String s) {
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
		name = filename;
		yvel = 0;
		xvel = 0;
		height= (int)(d*100);
		
	}
	
	public int setHeight(Waterfall w, int x){
		double j = w.getLength(x);
		height = (int)(j*200);
		return height;
		
	}
	
	public void setY(double y)
	{
		this.y = y;
	}
	public void setX(Waterfall w, int i){
		
		String s = (w.getNotes().get(i).toStringWithoutDuration());
		x = 80;
		if(s.equals("C3")){
			x = x*0;
		}else if(s.equals("D3")){
			x =  x*1;
		}else if(s.equals("E3")){
			x =  x*2;
		}else if(s.equals("F3")){
			x =  x*3;
		}else if(s.equals("G3")){
			x =  x*4;
		}else if(s.equals("A3")){
			x =  x*5;
		}else if(s.equals("B3")){
			x =  x*6;
		}else if(s.equals("C4")){
			x =  x*7;
		}else if(s.equals("D4")){
			x =  x*8;
		}else if(s.equals("E4")){
			x =  x*9;
		}else if(s.equals("F4")){
			x =  x*10;
		}else if(s.equals("G4")){
			x =  x*11;
		}else if(s.equals("A4")){
			x =  x*12;
		}else if(s.equals("B4")){
			x =  x*13;
		}
		else if(s.equals("C6")){
			x =  x*15;
		}else{
			x = 70;
		}
		
	}
	
	public void update() {
	//	yvel += 0.7;
		y+=0.5;
	}
	
	public int getX(){
		return x;
	}
	public double getY(){
		return y;
	}
	public void draw(Graphics g, ImageObserver io){
		g.drawImage(img, x, (int)y, 80, height, io); 
		
	}
	
}
