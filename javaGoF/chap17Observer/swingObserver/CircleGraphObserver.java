package javaGoF.chap17Observer.swingObserver;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javaGoF.chap17Observer.numberObserver.AbsNumberGenerator;
import javaGoF.chap17Observer.numberObserver.INumberObserver;

public class CircleGraphObserver extends Frame implements INumberObserver, ActionListener {
    private GraphText textGr = new GraphText(60);     //自己定義 TextField
    private GraphCanvas canvasGr = new GraphCanvas(); //自己定義 Canvas
    private Button buttonClose = new Button("Close");

    public CircleGraphObserver() {
        super("CircleGraphObserver");
        setLayout(new BorderLayout());
        setBackground(Color.lightGray);

        textGr.setEditable(true);
        canvasGr.setSize(500, 500);
        buttonClose.addActionListener(this);

        add(textGr, BorderLayout.NORTH);
        add(canvasGr, BorderLayout.CENTER);
        add(buttonClose, BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }//constructor

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        System.exit(0);
    }//actionPerformed()

    @Override
    public void update(AbsNumberGenerator generator) {
        textGr.update(generator);
        canvasGr.update(generator);
    }//update()

}//class CircleGraphObserber

class GraphText extends TextField {

    public GraphText(int column) {
        super(column);
    }

    public void update(AbsNumberGenerator generator) {
        final int number = generator.getNumber();
        String str = number + ":";
        String aster = Stream.generate(() -> "*")
                .limit(number)
                .collect(Collectors.joining());
        super.setText(str + aster);
    }//update()
}//class GraphText

class GraphCanvas extends Canvas {
    private int number;

    public void update(AbsNumberGenerator generator) {
        number = generator.getNumber();
        repaint();
    }//update()

    public void paint(Graphics g) {
        int width = getWidth();
        int height = getHeight();
        g.setColor(Color.white);
        g.fillArc(0, 0, width, height, 0, 360);
        g.setColor(Color.red);
        g.fillArc(0, 0, width, height, 90, -number * 360 / 100);
    }//paint()
}//class GraphCanvas