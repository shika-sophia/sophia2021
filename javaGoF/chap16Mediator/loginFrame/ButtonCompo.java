package javaGoF.chap16Mediator.loginFrame;

import java.awt.Button;

public class ButtonCompo
        extends Button implements IComponentLogin {
    private IMediatorLogin mediator;

    public ButtonCompo(String caption) {
        super(caption);
    }

    @Override
    public void setMediator(IMediatorLogin mediator) {
        this.mediator = mediator;
    }

    //Mediatorから 有効/無効を指示される。
    @Override
    public void setEnableCompo(boolean enable) {
        super.setEnabled(enable); //super: java.awt.Button
    }

    public IMediatorLogin getMediator() {
        return mediator;
    }

}//class
