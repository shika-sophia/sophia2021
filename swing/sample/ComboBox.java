/**
 * @title swing / sample / ComboBox.java
 * @reference 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @content List 10.3 / p207 / コンボ・ボックス
 * @author shika
 * @date 2021-02-14
 */
package swing.sample;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ComboBox extends JFrame {
    String[] data = {"Dog","Cat","Pony","Cow","Fish"};
    JComboBox<String> combo = new JComboBox<>(data);
    JLabel label = new JLabel();

    ComboBox() {
        this.setLayout(new BorderLayout());
        combo.setEditable(true); //編集可能にする
        combo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = (String)combo.getSelectedItem();
                label.setText(str + " が選択されました。");
            }
        });//addActionListener()

        this.add(combo, "North");
        this.add(label, "South");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("ComboBox");
        this.pack();
        this.setSize(250, 180);
        this.setVisible(true);
    }//constructor

    public static void main(String[] args) {
        new ComboBox();
    }//main()
}//class

/*
//====== ComnboBox / 2021-02-14 ======
@see resultImage / ComboBox.jpg
選択すると編集可能だが、編集内容を保存しておくボタンや、その仕組みは書かれていない。
*/