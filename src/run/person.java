package rungame;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import rungame.GamePanel;
import rungame.GameFrame;

public class Person {
	private Image image;
	private Image[] images;
	
	public static final int WIDTH = 120;
	public static final int HEIGHT = 120;
	
	private int x,y;
	int index;
    public int v=7;
    private float g=9.8f;
    private float t=1.1f;
    int s=0;
	private int score;
	private int distance;
	private int totalScore;

	public Person() {
		init();
	
		image = images[0];
		
		x = 90;
		y = 580;
		index = 0;
		score = 0;
		distance = 0;
	}
	public void drop() {
		
		 s=(int)(v*t+g*t*t/2);
	        y=y+s;
		if(y>=580){
			y = 580;
		}
	}
	public void step(){
		image = images[index ++ /3%images.length];
		distance += 2;
	}

	public void paintPerson(Graphics g){
		g.drawImage(image, x, y, WIDTH, HEIGHT, null);
	}

	
	public boolean outOfBounds(){
		return this.x >= GameFrame.WIDTH || this.x <= -WIDTH;
	}
	private void init() {
		images = new Image[9];
		for(int i = 0; i<images.length; i++){
			try {
				images[i] = ImageIO.read(new File("Image/"+(i+1) + ".png"));//2.4
			} catch (IOException e) {//2.5
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Image[] getImages() {
		return images;
	}

	public void setImages(Image[] images) {
		this.images = images;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public static int getWidth() {
		return WIDTH;
	}

	public static int getHeight() {
		return HEIGHT;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public int getTotalScore() {
		return (int) (score * 10 + distance * 0.6);
	}
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
	
	
}