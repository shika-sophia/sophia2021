package multiThread.chap02MT.directConstrutor;

public class LineImmutable {
    private final PointMutable start;
    private final PointMutable end;

    public LineImmutable(PointMutable start, PointMutable end) {
        //this.start = start;
        //this.end = end;
        this.start = new PointMutable(start.x, start.y);
        this.end = new PointMutable(end.x, end.y);
    }

    public LineImmutable(int startX, int startY, int endX, int endY) {
        this.start = new PointMutable(startX, startY);
        this.end = new PointMutable(endX, endY);
    }

    @Override
    public String toString() {
        return String.format("Line: %s-%s", start, end);
    }
    public int getStartX() { return start.getX();}
    public int getStartY() { return start.getY();}
    public int getEndX() { return end.getX();}
    public int getEndY() { return end.getY();}
}//class

/*
//====== Test LineUnsafe ======
before: Line: (0,0)-(100,0)
after:  Line: (150,150)-(250,250)

//====== Test LineImmutable ======
before: Line: (0,0)-(100,0)
after:  Line: (0,0)-(100,0)
*/