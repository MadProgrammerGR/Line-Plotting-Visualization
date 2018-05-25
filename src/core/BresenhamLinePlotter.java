package core;
import java.util.function.BiConsumer;

public class BresenhamLinePlotter extends LinePlotter{

	@Override
	public void drawTitle() {
		titleTemplate("Bresenham Line");
	}
	
	@Override
	public void drawCalculatedLine() {
		int x0 = (int)p1.x/pixelSize;
		int x1 = ((int)p2.x)/pixelSize;
		int y0 = (height - (int)p1.y)/pixelSize;
		int y1 = (height - (int)p2.y)/pixelSize;
		
		//let x0, y0 be the leftmost pixel
		if(x0 < x1) bresenhamOctants(x0, y0, x1, y1);
		else bresenhamOctants(x1, y1, x0, y0);
	}
	
	private void bresenhamOctants(final int x0, final int y0, final int x1, final int y1) {
		int dy = y1 - y0, dx = x1 - x0;
		if(0<dy && dy<=dx){ //1st octant
			bresenham(x0, y0, x1, y1, (x, y) -> drawPixel(x, y));
		}else if(dx < dy) { //2nd octant
			bresenham(y0, x0, y1, x1, (x, y) -> drawPixel(y, x));
		}else if(dy<=-dx) { //7th octant
			bresenham(x0, y0, y0-y1+x0, x1-x0+y0, (x, y) -> drawPixel(y+x0-y0, y0+x0-x));
		}else{ //8th octant
			bresenham(x0, y0, x1, 2*y0-y1, (x, y) -> drawPixel(x, 2*y0-y));
		}
	}

	private void bresenham(int x0, int y0, int x1, int y1, BiConsumer<Integer, Integer> setPixel) {
		int dy = y1 - y0, dx = x1 - x0;
		int iE = 2*dy, iNE = 2*(dy - dx);
		int d = 2*dy - dx;
		for(int x=x0, y=y0; x<=x1; x++){
			setPixel.accept(x, y);
			if(d<0){
				d += iE;
			}else{
				d += iNE;
				y++;
			}
		}
	}


}
