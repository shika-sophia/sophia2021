package javaGoF.chap17Observer.swingObserver;

import java.awt.Graphics;
import java.util.List;

import javax.swing.JFrame;

public class BarGraphObserver extends JFrame {
    private final int TIMES;
    //private final int RANGE;
    private List<Integer> dataList;

    public void paint(Graphics g) {
        super.paint(g);

        //横軸
        g.drawLine(50, 250, 250, 250);
        for(int i = 1; i <= TIMES; i++) {
            String str = String.format("%3d", i);
            g.drawString(str, (i * 20 + 30), 270);
        }//for

        //縦軸
        g.drawLine(50, 40, 50, 250);
        for(int i = 0; i < 11; i++) {
            String str = String.format("%3d", i * 10);
            g.drawString(str, 28, (254 - i * 20));
        }//for

        //データを描く
        for(int i = 0; i < TIMES; i++) {
            int x = i * 20 + 50;
            int y = 250 - dataList.get(i) * 2;
            int w = 20;
            int h = dataList.get(i) * 2;

            g.drawRect(x, y, w, h);
            g.drawString(dataList.get(i).toString(), x + 4, y - 5);
        }//for
    }//paint()

    BarGraphObserver(int TIMES, int RANGE, List<Integer> dataList){
        this.TIMES = TIMES;
        //this.RANGE = RANGE;
        this.dataList = dataList;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("BarGraph Observer");
        setSize(600, 300);
        setVisible(true);
    }//constructor

//    //====== Test main() ======
//    public static void main(String[] args) {
//        final List<Integer> dataList = new ArrayList<>();
//        final int TIMES = 20;
//        final int RANGE = 100;
//        new Random().ints(0, RANGE)
//            .limit(TIMES)
//            .forEach(dataList::add);
//
//        System.out.println("Drawing Swing Window...");
//        new BarGraphObserver(TIMES, RANGE, dataList);
//    }//main()
}//class

/*
Drawing Swing Window...
@see resultBarGraphObserver.jpg

*/