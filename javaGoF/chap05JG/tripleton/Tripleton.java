package javaGoF.chap05JG.tripleton;

public final class Tripleton {
    private static int limit = 3;
    private static Tripleton tri;
    private int id;

    private Tripleton(int id) {
        this.id = id;
    }

    public static synchronized Tripleton getInstance(int id) {
        if(limit > 0) {
            tri = new Tripleton(id);
            limit--;
        }

        return tri;
    }//getInstance()

    public int getId() {
        return id;
    }
}//class
