/**
 * @title javaGoF / chap23Interpreter / practiceNode / MainPracticeNode.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content 第23章 / 練習問題 23-1
 * @content parseNodeのミニ言語を実行するプログラムを作成。
 * @class MainPracticeNode / ◆main()
 * @class MainFramePractice
 *            extends JFrame implements ActionListener
 *        / Point position, int x, int y,
 *        int direction, String[] directionAry[]
 *        JPanel panel, JLabel = label, JTetArea txArea,
 *        JButton buttonOk, JButton buttonReset /
 *        MainFramePractice(), veiwFrame(), actionPerfomed()

 * @author shika
 * @date 2021-07-02, 07-03
 */
package javaGoF.chap23Interpreter.practiceNode;

import java.awt.BorderLayout;
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

import javaGoF.chap23Interpreter.practiceNode.interpreter.AbsInterpreter;
import javaGoF.chap23Interpreter.practiceNode.interpreter.InterpreterContext;
import javaGoF.chap23Interpreter.practiceNode.interpreter.NodeParseException;
import javaGoF.chap23Interpreter.practiceNode.interpreter.ProgramInterpreter;

public class MainFramePractice extends JFrame
        implements ActionListener {
    private InterpreterContext context;
    private AbsInterpreter interpreter;

    //---- component ----
    JPanel panel = new JPanel();
    JLabel label = new JLabel();
    JTextArea txArea = new JTextArea(5, 50);
    JButton buttonOk = new JButton("OK");
    JButton buttonReset = new JButton("Reset");
    PracticeCanvas canvas = new PracticeCanvas();

    public MainFramePractice() {
        viewFrame();
    }//constructor

    private void viewFrame() {
        txArea.setEditable(true);
        label.setText(String.format(
            "Position: (X %d,Y %d) / Direction: %s",
            canvas.getX(), canvas.getY(),
            canvas.getDirectionAry()[canvas.getDirection()]));

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

    @Override
    public void actionPerformed(ActionEvent ev) {
        Object obj = ev.getSource();

        if(obj == buttonOk) {
            String order = txArea.getText();
            context = new InterpreterContext(order);
            interpreter = new ProgramInterpreter();
            try {
                interpreter.parse(context);

            } catch (NodeParseException e) {
                txArea.setText(e.toString());
                e.printStackTrace();
            }

        } else if(obj == buttonReset) {
            txArea.setText("");
        }
    }//actionPerfomed()

    public static void main(String[] args) {
        new MainFramePractice();
    }//main()
}//class
