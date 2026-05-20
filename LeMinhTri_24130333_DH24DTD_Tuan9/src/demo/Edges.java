package demo;

public class Edges {
	private int x;
	private int y;
	private int w;
	public Edges(int x, int y, int w) {
		super();
		this.x = x;
		this.y = y;
		this.w = w;
	}
	@Override
	public String toString() {
		return "(" + x + "," + y + ")" + "=" + w;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getW() {
		return w;
	}
	

}
