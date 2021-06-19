/**
 * @title javaGoF / chap16Mediator / loginFrame / MainLoginFrame.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content 第16章 Mediator / List 16-1 ～ 16-7
 *          司令塔 Mediatorと 各構成要素 Component
 *          各クラスへの指示は Mediatorのみが行い、
 *          各クラスからの通知も Madiatorに対してのみ行う。
 *
 *          Guest, Loginのラジオボックス
 *          Guestのときは userName, userPassは無効、OKボタンは有効。
 *          Listのとき、userName有効、４文字以上で userPassも有効
 *          どちらか４文字以下の場合 OKボタンは無効
 *          Cancelボタンは常に有効。
 *
 * @class MainLoginFrame / ◆main()
 * @interface IMediatorLogin /
 *            abstract void createCompo(), abstrsct void changeCompo()
 * @interface IComponentLogin /
 *            abstract void setMediator(IMediatorLogin)
 *            abstract void setEnableCompo(boolean)
 * @class LoginFrameMediator extends Frame
 *            implements IMediatorLogin, ActionListener
 *        / CheckboxCompo checkGuest, CheckboxCompo checkLogin,
 *        TextFieldCompo textUser, TextFieldCompo textPass,
 *        ButtonCompo buttonOk, ButtonCompo buttonCancel
 *        / LoginFrameMediator(String title)
 *        createCompo(), changeCompo(),
 *        -passChanged(), actionPerformed(ActionEvent)
 * @class CheckboxCompo extends Checkbox
 *            implements IComponentLogin, ItemListener
 *        / IMediatorLogin mediator /
 *        setMediator(IMediatorLogin),
 *        setEnableCompo(boolean),
 *        itemStateChanged(ItemEvent)
 * @class TextFieldCompo extends TextField
 *            implements IComponentLogin, TextListener
 *        / ImediatorLogin mediator /
 *        setMediator(IMediatorLogin),
 *        setEnableCompo(boolean),
 *        textValueChanged(TextEvent)
 * @class Button extends Button
 *            implements IComponentLogin
 *        / IMediatorLogin mediator /
 *        setMediator(IMediatorLogin),
 *        setEnableCompo(boolean)
 *
 * @see loginFrameResult.jpg
 * @author shika
 * @date 2021-06-18
 */
package javaGoF.chap16Mediator.loginFrame;

public class MainLoginFrame {

    public static void main(String[] args) {
        new LoginFrameMediator("Mediator Sample");
    }//main()

}//class

/*
java.awt.event.ActionEvent[
  ACTION_PERFORMED,cmd=OK,when=1623991087545,modifiers=]
  on button0

*/