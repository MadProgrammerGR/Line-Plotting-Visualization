package states;

import core.LinePlotter;
import processing.core.PVector;

public class PlacingFirst implements State {
	private LinePlotter p;
	
	public PlacingFirst(LinePlotter p) {
		this.p = p;
	}

	@Override
	public void draw() {
		p.drawCircle(p.mouseX, p.mouseY);
	}

	@Override
	public void mousePressed() {
		p.p1 = new PVector(p.mouseX, p.mouseY);
		p.state = new PlacingSecond(p);
	}

	@Override
	public void mouseDragged() { }

	@Override
	public void mouseReleased() { }

}
