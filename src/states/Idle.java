package states;

import core.LinePlotter;

public class Idle implements State {
	private LinePlotter p;
	
	public Idle(LinePlotter p) {
		this.p = p;
	}

	@Override
	public void draw() {
		p.drawCalculatedLine();
		p.drawRealLine(); 
		p.drawHintText();
	}

	@Override
	public void mousePressed() {
		if(intersectCircle(p.mouseX, p.mouseY, (int)p.p1.x, (int)p.p1.y)){
			p.pDrag = p.p1;
			p.loop();
			p.state = new Dragging(p);
		} else if(intersectCircle(p.mouseX, p.mouseY, (int)p.p2.x, (int)p.p2.y)) {
			p.pDrag = p.p2;
			p.loop();
			p.state = new Dragging(p);
		}
	}

	@Override
	public void mouseDragged() { }

	@Override
	public void mouseReleased() { }
	
	private boolean intersectCircle(int x, int y, int cx, int cy) {
		return (x-cx)*(x-cx) + (y-cy)*(y-cy) <= 10*10;
	}

}
