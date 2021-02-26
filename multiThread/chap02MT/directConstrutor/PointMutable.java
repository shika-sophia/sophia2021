package multiThread.chap02MT.directConstrutor;

public class PointMutable {
    public int x;
    public int y;

    public PointMutable(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("(%d,%d)", x, y);
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}//class
