package javaGoF.chap16Mediator.loginFrame;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CheckboxCompo
        extends Checkbox implements IComponentLogin, ItemListener {
    private IMediatorLogin mediator;

    public CheckboxCompo(
            String caption, CheckboxGroup group, boolean state) {
        super(caption, group, state);
    }

    @Override
    public void setMediator(IMediatorLogin mediator) {
        this.mediator = mediator;
    }

    //Mediatorから 有効/無効を指示される。
    @Override
    public void setEnableCompo(boolean enable) {
        super.setEnabled(enable);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        mediator.changeCompo();
    }

}//class
