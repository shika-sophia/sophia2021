package javaGoF.chap23Interpreter.practiceNode;

import java.awt.BorderLayout;
import java.awt.Canvas;
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
    private String direction;

    //---- component ----
    JPanel panel = new JPanel();
    JTextArea txArea = new JTextArea(5, 50);
    JButton buttonOk = new JButton("OK");
    JButton buttonReset = new JButton("Reset");
    Canvas canvas = new Canvas();
    JLabel label = new JLabel();

    public FramePracticeNode() {
        this.direction = "North";
        viewFrame();
    }//constructor

    private void viewFrame() {
        txArea.setEditable(true);
        label.setText("Direction: " + direction);

        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(buttonOk);
        buttonBox.add(buttonReset);
        Box headBox = new Box(BoxLayout.Y_AXIS);
        headBox.add(txArea);
        headBox.add(buttonBox);
        buttonOk.addActionListener(this);
        buttonReset.addActionListener(this);

        panel.setLayout(new BorderLayout());
        panel.add(headBox, BorderLayout.NORTH);
        panel.add(canvas, BorderLayout.CENTER);
        panel.add(label, BorderLayout.SOUTH);

        JScrollPane scroll = new JScrollPane(panel);
        this.getContentPane().add(scroll);
        this.setTitle("Frame Practice Node");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setVisible(true);
    }//viewFrame()

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    //====== Test main() ======
    public static void main(String[] args) {
        new FramePracticeNode();
    }//main()
}//class
