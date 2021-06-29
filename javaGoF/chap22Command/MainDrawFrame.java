/**
 * @title javaGoF / chap22Command / MainDrawFrame.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content 第22章 Command / List 22-1 ～ 22-6
 *          命令をクラスにする。
 *
 * @class MainDrawFrame extends JFrame
 *            implements ActionListener, MouseMotionListener
 *        / ◇MacroCommand history, ◇DrawCanvas canvas,
 *          JButton buttonClear /
 *        ◆main()
 *        MainDrawFrame(), actionPerformed(), mouseDraggd()
 *
 * @package ---- command ----
 * @interface ICommand / abstract void execute()
 * @class MacroCommand implements ICommand
 *        / ◇Deque<ICommand> cmdDeq /
 *        execute(), append(ICommand), undo(), clear()
 *
 * @package ---- drawer ----
 * @interface IDrawable / abstract void draw(int, int)
 * @class DrawCommand implements ICommand
 *        / ◇IDrawable drawable, Point position /
 *        execute()
 * @class DrawCanvas extends Canvas implements Drawable
 *        / ◇MacroCommand history,
 *        Color color, int radius /
 *        paint(Graphics), draw(int,int)
 *
 * @see resultDrawFrame.jpg
 * @author shika
 * @date 2021-06-29
 */

package javaGoF.chap22Command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import javaGoF.chap22Command.command.ICommand;
import javaGoF.chap22Command.command.MacroCommand;
import javaGoF.chap22Command.drawer.DrawCanvas;
import javaGoF.chap22Command.drawer.DrawCommand;

public class MainDrawFrame extends JFrame
        implements ActionListener, MouseMotionListener {
    private MacroCommand history = new MacroCommand();
    private DrawCanvas canvas = new DrawCanvas(400, 400, history);
    private JButton buttonClear = new JButton("Clear");

    public MainDrawFrame(String title) {
        super(title);
        canvas.addMouseMotionListener(this);
        buttonClear.addActionListener(this);

        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(buttonClear);
        Box panelBox = new Box(BoxLayout.Y_AXIS);
        panelBox.add(buttonBox);
        panelBox.add(canvas);
        this.getContentPane().add(panelBox);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }//constructor

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttonClear) {
            history.clear();
            canvas.repaint();
        }
    }//actionPerformed()

    @Override
    public void mouseDragged(MouseEvent e) { }

    @Override
    public void mouseMoved(MouseEvent e) {
        ICommand cmd = new DrawCommand(canvas, e.getPoint());
        history.append(cmd);
        cmd.execute();
    }//mouseMoved()

    public static void main(String[] args) {
        new MainDrawFrame("Command Pattern Sample");
    }//main()

}//class

