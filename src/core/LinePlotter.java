package core;

import processing.core.PApplet;
import processing.core.PVector;
import states.PlacingFirst;
import states.State;


public abstract class LinePlotter extends PApplet {
	public State state = new PlacingFirst(this);
	public PVector p1, p2, pDrag;
	public int pixelSize;
	private Controller ctrl;
	
	public abstract void drawTitle(); 
	public abstract void drawCalculatedLine();
	
	public void settings() {
		size(600, 600);
	}

	public void setup() {
		textAlign(CENTER);
		ctrl = new Controller(this);
	}

	public void draw() {
		pixelSize = ctrl.getPixelSize();
		drawGrid();
		state.draw();
		drawTitle();
	}
	
	public void mousePressed(){
		state.mousePressed();
	}

	public void mouseDragged() {
		state.mouseDragged();
	}
	
	public void mouseReleased() {
		state.mouseReleased();
	}
	
	protected void drawPixel(int x, int y) {
		fill(200, 50, 50);
		rect(x * pixelSize, height - (y+1) * pixelSize, pixelSize, pixelSize);
	}

	public void drawCircle(float x, float y) {
		fill(200, 100, 200);
		noStroke();
		ellipse(x, y, 10, 10);
	}

	protected void titleTemplate(String title) {
		if(!ctrl.titleEnabled()) return;
		textSize(50);
		fill(10,10,10, 50);
		text(title, width/2, 50);
		fill(200, 100, 100, 150);
		text(title, width/2 - 2, 50 - 2);
	}

	public void drawHintText() {
		if(!ctrl.hintEnabled()) return;
		textSize(20);
		fill(10,10,10, 50);
		text("(drag points)", width/2, height - 10);
		fill(50, 50, 50, 200);
		text("(drag points)", width/2 - 2, height - 10 - 2);
	}

	public void drawRealLine() {
		if(!ctrl.realLineEnabled()) return;
		stroke(250, 100, 100, 100);
		strokeWeight(3);
		line(p1.x, p1.y, p2.x, p2.y);
		drawCircle(p1.x, p1.y);
		drawCircle(p2.x, p2.y);
	}

	private void drawGrid() {
		background(220, 220, 255);
		if(!ctrl.gridEnabled()) return;
		stroke(0);
		strokeWeight(0);
		for (int x = 0;  x < width; x += pixelSize) line(x, 0, x, height);
		for (int y = height%pixelSize;  y < height; y += pixelSize) line(0, y, width, y);
	}

}
