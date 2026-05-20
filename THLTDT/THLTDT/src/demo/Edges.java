package demo;

public class Edges {
    private int x;
    private int y;
    private int w;

    public Edges(int x, int y, int w) {
        this.x = x;
        this.y = y;
        this.w = w;
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

    @Override
    public String toString() {
        return "(" +( x +1)+ ", " + (y+1) + ")= " + w;
    }


}

