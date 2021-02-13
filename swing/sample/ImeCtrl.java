/**
 * @title swing / sample / ImeCtrl.java
 * @reference 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @content List 8.9 / p181 / IMEの制御
 * @see resultImage / ImeCtrl.jpg {@link ImeCtrl#jpg}
 * @author shika
 * @date 2021-02-13
 */
package swing.sample;

import java.awt.GridLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.im.InputSubset;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class FocusImeCtrl extends FocusAdapter {
    //フォーカスを得たら全角入力にする
    public void focusGained(FocusEvent e) {
        JTextField compo = (JTextField)(e.getSource());
        compo.getInputContext().setCharacterSubsets(
            new Character.Subset[] {InputSubset.KANJI});
    }//focusGained()

    //フォーカスを失ったら全角入力にする
    public void focusLost(FocusEvent e) {
        JTextField compo = (JTextField)(e.getSource());
        compo.getInputContext().setCharacterSubsets(null);
    }//focusLost()
}//class FocusImeCtrl

class ImeCtrl extends JFrame {
    JLabel label1 = new JLabel("住所: ");
    JTextField txF1 = new JTextField(25);
    JLabel label2 = new JLabel("氏名: ");
    JTextField txF2 = new JTextField(25);
    JLabel label3 = new JLabel("TEL: ");
    JTextField txF3 = new JTextField(18);
    ImeCtrl() {
        this.setLayout(new GridLayout(3, 2));
        add(label1);
        add(txF1);
        txF1.addFocusListener(new FocusImeCtrl());
        add(label2);
        add(txF2);
        txF2.addFocusListener(new FocusImeCtrl());
        add(label3);
        add(txF3);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("ImeCtrl");
        this.pack();
        this.setSize(300, 120);
        this.setVisible(true);
    }//constructor

    public static void main(String[] args) {
        new ImeCtrl();
    }//main()

}//class
