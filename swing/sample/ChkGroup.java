/**
 * @title swing / sample / ChkGroup.java
 * @reference 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @content List 9.2 / p191 / チェックボックス・グループ
 * @author shika
 * @date 2021-02-13
 */
package swing.sample;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChkGroup extends JFrame implements ItemListener {
    JPanel panel = new JPanel();
    CheckboxGroup chkGp = new CheckboxGroup();
    Checkbox chk1 = new Checkbox("one", chkGp, true);
    Checkbox chk2 = new Checkbox("two", chkGp, false);
    Checkbox chk3 = new Checkbox("three", chkGp, false);
    JLabel label = new JLabel("one が選択されています。");

    @Override
    public void itemStateChanged(ItemEvent e) {
        Object src = e.getSource();
        if(src.equals(chk1)) {
            label.setText(String.format("%-5s","one が選択されました。"));
        }
        if(src.equals(chk2)) {
            label.setText(String.format("%-5s","two が選択されました。"));
        }
        if(src.equals(chk3)) {
            label.setText(String.format("%-5s","three が選択されました。"));
        }
    }//itemStateChanged()

    ChkGroup(){
        this.setLayout(new FlowLayout());
        panel.setLayout(new GridLayout(3, 1));
        panel.add(chk1);
        panel.add(chk2);
        panel.add(chk3);
        chk1.addItemListener(this);
        chk2.addItemListener(this);
        chk3.addItemListener(this);
        chkGp.setSelectedCheckbox(chk1);

        this.add(panel);
        this.add(label);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("ChkGroup");
        this.pack();
        this.setSize(280, 120);
        this.setVisible(true);
    }//constructor

    public static void main(String[] args) {
        new ChkGroup();
    }//main()
}//class

/*
//====== ChkGroup / 2021-02-13 ======
label.setText(String.format("%5s","one が選択されました。"));

ラベル内に String.format()で整形してみたが、
文字列だけ取って、format()の整形は無効の様子。

*/