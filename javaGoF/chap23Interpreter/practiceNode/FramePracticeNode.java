package javaGoF.chap23Interpreter.practiceNode;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class FramePracticeNode extends JFrame
        implements ActionListener {
    //---- field ----
    private Point position;
    private int x;
    private int y;
    private int direction;
    private String[] directionAry = new String[]
                {"North","East","South","West"};

    //---- component ----
    JPanel panel = new JPanel();
    JLabel label = new JLabel();
    JTextArea txArea = new JTextArea(5, 50);
    JButton buttonOk = new JButton("OK");
    JButton buttonReset = new JButton("Reset");
    Canvas canvas = new Canvas();

    public FramePracticeNode() {
        this.position = new Point(50, 50);
        this.x = (int)position.getX();
        this.y = (int)position.getY();
        this.direction = 0;
        viewFrame();
    }//constructor

    private void viewFrame() {
        txArea.setEditable(true);
        label.setText(String.format(
            "Position: (X %d,Y %d) / Direction: %s",
            x, y, directionAry[direction]));

        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(buttonOk);
        buttonBox.add(buttonReset);
        Box headBox = new Box(BoxLayout.Y_AXIS);
        headBox.add(label);
        headBox.add(txArea);
        headBox.add(buttonBox);
        buttonOk.addActionListener(this);
        buttonReset.addActionListener(this);

        panel.setLayout(new BorderLayout());
        panel.add(headBox, BorderLayout.NORTH);
        panel.add(canvas, BorderLayout.CENTER);
        //panel.add(label, BorderLayout.SOUTH);

        JScrollPane scroll = new JScrollPane(panel);
        this.getContentPane().add(scroll);
        this.setTitle("Frame Practice Node");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setVisible(true);
    }//viewFrame()

//    public void paint(Graphics g) {
//        g.fillOval(x, y, 5, 5);
//    }//paint()

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if(obj == buttonOk) {
            //String order = txArea.getText();

        } else if(obj == buttonReset) {
            txArea.setText("");
        }
    }//actionPerfomed()

    //====== Test main() ======
    public static void main(String[] args) {
        new FramePracticeNode();
    }//main()
}//class
