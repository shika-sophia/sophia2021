package javaGoF.chap16Mediator.loginFrame;

import java.awt.Color;
import java.awt.TextField;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class TextFieldCompo
        extends TextField implements IComponentLogin, TextListener {
    private IMediatorLogin mediator;

    public TextFieldCompo(String text, int size) {
        super(text, size);
    }

    @Override
    public void setMediator(IMediatorLogin mediator) {
        this.mediator = mediator;
    }

    //Mediatorから 有効/無効を指示される。
    @Override
    public void setEnableCompo(boolean enable) {
        super.setEnabled(enable); //super: java.awt.TextField
        super.setBackground(enable ? Color.white : Color.lightGray);
    }

    @Override
    //文字列が変化したら Mediatorに通知
    public void textValueChanged(TextEvent e) {
        mediator.changeCompo();
    }

}//class
