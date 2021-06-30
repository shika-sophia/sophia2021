/**
 * @title javaGoF / chap22Command / MainDrawFrame.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content 第22章 Command / List 22-1 ～ 22-6
 *          命令をクラスにする。
 * @content 練習問題 22-1 / 色変更ができるようにする
 * @reference 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @see swing / sample / ColorDlg.java
 *          ColorCommandを追加。
 *          DrawCanvasに getColor(),setColor()を追加。
 *          Mainに buttonColorを追加。
 *          Main.actionPerformer()に buttonColorの処理を追加。
 *          => 以下【考察】へ
 * @content 練習問題 22-2 / undo()機能を追加。
 *          Mainに buttonUndoを追加、actionPerformed()にその処理を追加。
 *          MacroCommand history.undo()に飛ばすだけ。
 *          canvas.repaint()を追加。これしないと反映しない。
 * @content 練習問題 22-3 / MouseMotionAdapterを利用する。
 *          implements MouseMotionListenerを削除。
 *            addMouseMotionListener(
 *                new MouseMotionAdapter(){ }
 *            );の匿名クラス内に既存のmouseMoved()を移転。
 *          mouseDragged()は @Overrideしなくてもよくなり削除。
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
 * @class Colorommand implements ICommand
 *        / MacroCommand history, DrawCanvas canvas
 *          Color color /
 *        execute()
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
 *        getColor(), setColor(Color)
 *
 * @see resultDrawFrame.jpg
 * @see resultColorChooser.jpg
 * @see resultColorCommand.jpg
 * @author shika
 * @date 2021-06-29
 */

package javaGoF.chap22Command;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;

import javaGoF.chap22Command.command.ColorCommand;
import javaGoF.chap22Command.command.ICommand;
import javaGoF.chap22Command.command.MacroCommand;
import javaGoF.chap22Command.drawer.DrawCanvas;
import javaGoF.chap22Command.drawer.DrawCommand;

public class MainDrawFrame extends JFrame
        implements ActionListener {
    private MacroCommand history = new MacroCommand();
    private DrawCanvas canvas = new DrawCanvas(400, 400, history);
    private JButton buttonClear = new JButton("Clear");
    private JButton buttonColor = new JButton("Color");
    private JButton buttonUndo = new JButton("Undo");

    public MainDrawFrame(String title) {
        super(title);
        canvas.addMouseMotionListener(
            new MouseMotionAdapter() {
                public void mouseMoved(MouseEvent e) {
                    ICommand cmd = new DrawCommand(canvas, e.getPoint());
                    history.append(cmd);
                    cmd.execute();
                }//mouseMoved()
        });
        buttonClear.addActionListener(this);
        buttonColor.addActionListener(this);
        buttonUndo.addActionListener(this);

        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(buttonClear);
        buttonBox.add(buttonColor);
        buttonBox.add(buttonUndo);
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
        Object button = e.getSource();
        if(button == buttonClear) {
            history.clear();
            canvas.repaint();

        } else if (button == buttonColor) {
            Color color = JColorChooser.showDialog(
                this, "色の選択", canvas.getColor());
            ICommand cmd = new ColorCommand(color, canvas);
            history.append(cmd);
            cmd.execute();

        } else if (button == buttonUndo) {
            history.undo();
            canvas.repaint();
        }
    }//actionPerformed()

    public static void main(String[] args) {
        new MainDrawFrame("Command Pattern Sample");
    }//main()

}//class

/*
【考察】 練習問題 22-1
actionPerfomer()に下記を追加。
} else if (button == buttonColor) {
    Color color = JColorChooser.showDialog(
        this, "色の選択", canvas.getColor());
    new ColorCommand(color, canvas, history);
}

@see resultColorChooser.jpg
ColorChooserは、ちゃんと出るが、色選択しても描画に反映しない。
draw()内 Graphics.setColor(color)が
キャシュされているのか、原因は解らないので解答で確認。

【解答】
init(), setColor()を IDrawableに追加。
init()内で フィールドの Color, int radiusを初期化。

actionPerformed()内で new ColorCommand()後、
Command cmd.execute()をしている。ので、そのように修正。

new ColorCommand()内で setColor()をした後、
history.append(cmd);
cmd.execute()しないと、
フィールドの色変更しただけで描画の実行がされていなかった。
修正後、解決す。
*/