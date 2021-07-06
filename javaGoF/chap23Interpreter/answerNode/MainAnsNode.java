/**
 * @title javaGoF / chap23Interpreter / answerNode / MainAnsNode.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content 第23章 Interpreter / 練習問題 23-1
 *          サンプルコードの parseNodeでミニ言語を解析
 *          それを実行するためのプログラム
 *
 * @class MainAnsNode extends Frame implements ActionListener
 *        / ◇DriveCanvas canvas,
 *          ◇InterpreterFacade facade /
 *        ◆main(), MainAnsNode(), actionPerfomed(), -parseAndExecute()
 *
 * @package ---- language ----
 * @interface INodeExecutor / abstract void execute()
 * @interface INodeExeFactory
 *            / abstract INodeExecutor createExecutor(String)
 * @class InterpreterFacade implements INodeExecutor
 *        / ◇INodeExeFactory factory,
 *          ◇NodeExeContext context,
 *          ◇AbsNode programExe /
 *        boolean parse(String), execute()
 * @class NodeExeContext implements INodeExeFactory
 *        / ◇INodeExeFactory factory,
 *          StringTokenizer tokenizer,
 *          String currentToken /
 *        nextToken(), currentToken(), skipToken(String), currentNumber()
 *        void setExecutorFactory(INodeExeFactory),
 *        INodeExecutor createExeCutor(String)
 * @class AbsNodeExe implements INodeExecutor
 *        / abstract void parse(NodeExeContext)
 * @class ProgramExe extends AbsNodeExe
 *        / ◇AbsNodeExe cmdListExe /
 *        parse(), toString(), execute()
 * @class CommandExe extends AbsNodeExe
 *        / ◇AbsNodeExe node /
 *        parse(), toString(), execute()
 * @class CommandListExe extends AbsNodeExe
 *        / ◇List<AnsNodeExe> cmdList /
 *        parse(), toString(), execute()
 * @class RepeatCommandExe extends AbsNodeExe
 *        / ◇AbsNodeExe cmdListExe, int number /
 *        parse(), toString(), execute()
 * @class PrimitiveCommandExe extends AbsNodeExe
 *        / ◇INodeExecutor executor, String current /
 *        parse(), toString(), execute()
 * @class NodeExeException extends Exception
 *
 * @package ---- driveFrame ----
 * @class DriveCanvas extends Canvas implements INodeExeFactory
 *        / ◇INodeExecutor executor,
 *          int direction, Point position /
 *        initalize(), paint(), setTurnDirection(), setDirection()
 *        go(), setExecutor(), createExecutor()
 * @class AbsDriveExecutor implements INodeExecutor
 *        / #◇DriveCanvas canvas /
 *        abstract void execute()
 * @class GoExecutor extends AbsDriveExecutor
 *        // execute()
 * @class DirectionExecutor extends AbsDriveExecutor
 *        / int turnDirection /
 *        execute()
 *
 * @see resultAnswerNode.jpg
 * @author shika
 * @date 2021-07-05, 07-06
 */
package javaGoF.chap23Interpreter.answerNode;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javaGoF.chap23Interpreter.answerNode.driveFrame.DriveCanvas;
import javaGoF.chap23Interpreter.answerNode.language.InterpreterFacade;

public class MainAnsNode
        extends Frame implements ActionListener {
    private DriveCanvas canvas = new DriveCanvas(400, 400);
    private InterpreterFacade facade = new InterpreterFacade(canvas);
    private TextField txField = new TextField(
            "program repeat 3 go right go left end end");

    public MainAnsNode(String title) {
        super(title);
        canvas.setExecutor(facade);
        this.setLayout(new BorderLayout());
        txField.addActionListener(this);

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                System.exit(0);
            }
        });

        this.add(txField, BorderLayout.NORTH);
        this.add(canvas, BorderLayout.CENTER);
        this.pack();
        parseAndExecute();
        this.setVisible(true);
    }//constructor

    @Override
    public void actionPerformed(ActionEvent ev) {
        if(ev.getSource() == txField) {
            parseAndExecute();
        }
    }//actionPerformed()

    private void parseAndExecute() {
        String order = txField.getText();
        System.out.println("order: " + order);

        facade.parse(order);
        canvas.repaint();
    }

    public static void main(String[] args) {
        new MainAnsNode("Interpreter Practice");
    }//main()

}//class

/*
@see resultAnswerNode.jpg

order: program repeat 3 go right go left end end
[program [[repeat 3 [go, right, go, left]]]]
order: program repeat 4 repeat 3 go right go left end right end end
[program [[repeat 4 [[repeat 3 [go, right, go, left]], right]]]]

*/