package states;

import core.LinePlotter;
import processing.core.PVector;

public class PlacingSecond implements State {
	private LinePlotter p;
	
	public PlacingSecond(LinePlotter p) {
		this.p = p;
	}

	@Override
	public void draw() {
		p.drawCircle(p.p1.x, p.p1.y);
		p.drawCircle(p.mouseX, p.mouseY);
	}

	@Override
	public void mousePressed() {
		p.p2 = new PVector(p.mouseX,  p.mouseY);
		p.redraw();
		p.state = new Idle(p);
	}

	@Override
	public void mouseDragged() { }

	@Override
	public void mouseReleased() { }

}
