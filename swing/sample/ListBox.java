/**
 * @title swing / sample / ListBox.java
 * @reference 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @content List 10.1 / p200 / リストボックス
 * @author shika
 * @date 2021-02-14
 */
package swing.sample;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListBox extends JFrame implements ActionListener {
    String[] data = {"Dog","Cat","Pony","Cow","Fish"};
    JList<String> list = new JList<>(data);
    JScrollPane scroll = new JScrollPane();
    JPanel panel = new JPanel();
    JPanel topPanel = new JPanel();
    JButton btnAll = new JButton("全選択");
    JButton btnNon = new JButton("選択解除");
    JLabel label = new JLabel(" ");

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if(src.equals(btnAll)) {
            list.setSelectionInterval(0, 4);
        }
        if(src.equals(btnNon)) {
            list.clearSelection();
        }
    }//actionPerformed()

    ListBox() {
        scroll.getViewport().setView(list);
        btnAll.addActionListener(this);
        btnNon.addActionListener(this);

        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(list.getSelectedIndices().length == 1) {
                    label.setText(list.getSelectedValue());
                } else {
                    label.setText(list.getSelectedValuesList().toString());
                }
            }//valueChanged()
        });//addListSelectionListener()

        panel.setLayout(new BorderLayout());
        topPanel.setLayout(new GridLayout(1, 2));
        topPanel.add(btnAll);
        topPanel.add(btnNon);
        panel.add(topPanel, "North");
        panel.add(scroll, "Center");
        panel.add(label, "South");
        this.add(panel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("ListBox");
        this.pack();
        this.setSize(260, 160);
        this.setVisible(true);
    }//constructor

    public static void main(String[] args) {
        new ListBox();
    }//main()
}//class

