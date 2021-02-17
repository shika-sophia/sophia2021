/**
 * @title swing / sample / TabPane.java
 * @reference 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @content List 13.1 / p246 / タブ付きペイン
 * @author shika
 * @date 2021-02-17
 */
package swing.sample;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TabPane extends JFrame {
    TabPane() {
        JTabbedPane tabPane = new JTabbedPane();
        tabPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                Toolkit.getDefaultToolkit().beep();
            }
        });//addChangeListener()

        JPanel panel1 = new JPanel();
        JTextArea txArea = new JTextArea(5, 10);
        txArea.setText("タブ１ページ");
        panel1.add(txArea);
        tabPane.addTab("Tab 1", panel1);

        JPanel panel2 = new JPanel();
        JLabel label = new JLabel("タブ１ページ");
        panel2.add(label);
        tabPane.addTab("Tab 2", panel2);

        JPanel panel3 = new JPanel();
        String[] ary = {"かつ丼","うどん","天丼","カレー","ラーメン"};
        JList<String> list = new JList<>(ary);
        panel3.add(list);
        tabPane.addTab("Tab 3", panel3);
        this.add(tabPane);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("TabPane");
        this.setSize(250, 160);
        this.setVisible(true);
    }//constructor

    public static void main(String[] args) {
        new TabPane();
    }//main()

}//class

