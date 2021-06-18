package javaGoF.chap16Mediator.loginFrame;

public interface IComponentLogin {
    public abstract void setMediator(IMediatorLogin mediator);
    public abstract void setEnableCompo(boolean enable);
}//interface
