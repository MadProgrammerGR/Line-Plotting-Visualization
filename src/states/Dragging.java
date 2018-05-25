package states;

import core.LinePlotter;

public class Dragging implements State {
	private LinePlotter p;

	public Dragging(LinePlotter p) {
		this.p = p;
	}

	@Override
	public void draw() {
		p.drawCalculatedLine();
		p.drawRealLine();
	}

	@Override
	public void mousePressed() { }

	@Override
	public void mouseDragged() {
		p.pDrag.set(p.mouseX, p.mouseY);
		p.drawCircle(p.pDrag.x, p.pDrag.y);
	}

	@Override
	public void mouseReleased() {
		p.state = new Idle(p);
		p.redraw();
	}

}
