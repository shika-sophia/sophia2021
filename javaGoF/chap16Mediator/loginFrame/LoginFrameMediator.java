package javaGoF.chap16Mediator.loginFrame;

import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrameMediator
        extends Frame implements IMediatorLogin, ActionListener {
    private CheckboxCompo checkGuest;
    private CheckboxCompo checkLogin;
    private TextFieldCompo textUser;
    private TextFieldCompo textPass;
    private ButtonCompo buttonOk;
    private ButtonCompo buttonCancel;

    public LoginFrameMediator(String title) {
        super(title);
        super.setBackground(Color.lightGray);
        super.setLayout(new GridLayout(4, 2));

        //Component生成
        createCompo();

        //Compnent配置
        add(checkGuest);
        add(checkLogin);
        add(new Label("User Name"));
        add(textUser);
        add(new Label("Password"));
        add(textPass);
        add(buttonOk);
        add(buttonCancel);

        //有効/無効の初期設定
        changeCompo();

        //表示
        super.pack();
        super.setVisible(true);
    }//constructor

    //====== 各Compnentの生成 ======
    @Override
    public void createCompo() {
        //---- Checkbox ----
        CheckboxGroup group = new CheckboxGroup();
        checkGuest = new CheckboxCompo("Guest", group, true);
        checkLogin = new CheckboxCompo("Login", group, false);

        //---- TextField ----
        textUser = new TextFieldCompo("", 10);
        textPass = new TextFieldCompo("", 10);
        textPass.setEchoChar('*');

        //---- Button ----
        buttonOk = new ButtonCompo("OK");
        buttonCancel = new ButtonCompo("Cancel");

        //====== Mediator Setting ======
        checkGuest.setMediator(this);
        checkLogin.setMediator(this);
        textUser.setMediator(this);
        textPass.setMediator(this);
        buttonOk.setMediator(this);
        buttonCancel.setMediator(this);

        //====== Listener Setting ======
        checkGuest.addItemListener(checkGuest);
        checkLogin.addItemListener(checkLogin);
        textUser.addTextListener(textUser);
        textPass.addTextListener(textPass);
        buttonOk.addActionListener(this);
        buttonCancel.addActionListener(this);
    }//createCompo()

    //Componentからの通知で 有効/無効を判断
    @Override
    public void changeCompo() {
        //---- Guestモード ----
        if(checkGuest.getState()) {
            textUser.setEnableCompo(false);
            textPass.setEnableCompo(false);
            buttonOk.setEnableCompo(true);

        //---- Loginモード ----
        } else {
            textUser.setEnableCompo(true);
            passChanged();
        }
    }//changeComo()

    //textUser, textPassに変更があったら、有効/無効の判断
    private void passChanged() {
        if(textUser.getText().length() > 0) {
            textPass.setEnableCompo(true);

            if(textUser.getText().length() >= 4
                    && textPass.getText().length() >= 4) {
                buttonOk.setEnableCompo(true);
            } else {
                buttonOk.setEnableCompo(false);
            }
        } else {
            textPass.setEnableCompo(false);
            buttonOk.setEnableCompo(false);
        }
    }//passChanged()

    //ボタンアクション(ここでは終了するだけ）
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        System.exit(0);
    }//actionPerformed()

}//class
