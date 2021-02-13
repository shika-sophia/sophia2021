/**
 * @title swing / sample / RdoGroup.java
 * @reference 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @content List 9.3 / p194 / ラジオボタン・グループ (ChkGroupとほぼ同じ)
 * @author shika
 * @date 2021-02-13
 */
package swing.sample;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RdoGroup extends JFrame implements ItemListener {
    JPanel panel = new JPanel();
    ButtonGroup btnGp = new ButtonGroup();
    JRadioButton rdo1 = new JRadioButton("one", true);
    JRadioButton rdo2 = new JRadioButton("two", false);
    JRadioButton rdo3 = new JRadioButton("three", false);
    JLabel label = new JLabel("one が選択されています。");

    @Override
    public void itemStateChanged(ItemEvent e) {
        Object src = e.getSource();
        if(src.equals(rdo1)) {
            label.setText(String.format("%-5s","one が選択されました。"));
        }
        if(src.equals(rdo2)) {
            label.setText(String.format("%-5s","two が選択されました。"));
        }
        if(src.equals(rdo3)) {
            label.setText(String.format("%-5s","three が選択されました。"));
        }
    }//itemStateChanged()

    RdoGroup(){
        this.setLayout(new FlowLayout());
        panel.setLayout(new GridLayout(3, 1));
        btnGp.add(rdo1);
        btnGp.add(rdo2);
        btnGp.add(rdo3);
        panel.add(rdo1);
        panel.add(rdo2);
        panel.add(rdo3);
        rdo1.addItemListener(this);
        rdo2.addItemListener(this);
        rdo3.addItemListener(this);

        this.add(panel);
        this.add(label);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("RdoGroup");
        this.pack();
        this.setSize(250, 120);
        this.setVisible(true);
    }//constructor

    public static void main(String[] args) {
        new RdoGroup();
    }//main()
}//class

/*
//====== RdoGroup / 2021-02-13 ======
上記の ChkGroupのボタンより、ラジオボタンのほうが大きくてはっきりしている。
ただ、JLabel部分の文字列の後ろが少し欠ける。
*/