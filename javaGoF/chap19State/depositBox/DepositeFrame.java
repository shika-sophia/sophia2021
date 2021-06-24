package javaGoF.chap19State.depositBox;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepositeFrame
        extends Frame implements IContextDeposit, ActionListener {
    private TextField clock = new TextField(60);
    private TextArea screen = new TextArea(10, 60);
    private Button buttonUse = new Button("金庫使用");
    private Button buttonAlarm = new Button("非常ベル");
    private Button buttonPhone = new Button("通常通話");
    private Button buttonExit = new Button("終了");

    private IStateSecurity state = DayState.getInstance();

    //コンストラクタ
    public DepositeFrame(String title) {
        super(title);
        setBackground(Color.lightGray);
        setLayout(new BorderLayout());

        add(clock, BorderLayout.NORTH);
        add(screen, BorderLayout.CENTER);
        clock.setEditable(false);
        screen.setEditable(false);

        Panel panel = new Panel();
        panel.add(buttonUse);
        panel.add(buttonAlarm);
        panel.add(buttonPhone);
        panel.add(buttonExit);
        add(panel, BorderLayout.SOUTH);

        buttonUse.addActionListener(this);
        buttonAlarm.addActionListener(this);
        buttonPhone.addActionListener(this);
        buttonExit.addActionListener(this);

        //表示
        pack();
        setVisible(true);
    }//constructor

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        Object event = e.getSource();

        if(event == buttonUse) {
            state.doUse(this);
        } else if (event == buttonAlarm) {
            state.doAlarm(this);
        } else if (event == buttonPhone) {
            state.doPhone(this);
        } else if (event == buttonExit) {
            System.exit(0);
        } else {
            System.out.println("?");
        }

    }//actionPerformed()

    @Override
    public void setClock(int hour) {
        String clockStr =
            String.format("現在時刻は %02d:00", hour);
        System.out.println(clockStr);
        clock.setText(clockStr);
        state.doClock(this, hour);
    }//setClock()

    @Override
    public void changeState(IStateSecurity state) {
        System.out.println("状態変化: " + this.state + " -> " + state);
        this.state = state;
    }//changeState()

    @Override
    public void callCenter(String msg) {
        screen.append("call: " + msg + "\n");
    }//callCenter()

    @Override
    public void recordLog(String msg) {
        screen.append("record: " + msg + "\n");
    }//recordLog()

}//class
