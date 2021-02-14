/**
 * @title swing / sample / ListIcon.java
 * @reference 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @content List 10.2 / p203 / アイコン付きのリストボックス
 * @author shika
 * @date 2021-02-14
 */
package swing.sample;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class MyCellRenderer extends JLabel
    implements ListCellRenderer<Object> {

    @Override
    public Component getListCellRendererComponent(
            JList<? extends Object> list, //リスト
            Object value,                 //表示する値 (文字列)
            int index,                    //セルのインデックス
            boolean isSelected,           //セルが選択されたら true
            boolean cellHasFocus) {       //フォーカスされていたら true

        String str = value.toString();
        setText(str);

        String fileName = "WebContent/image/icon" + Integer.toBinaryString(index);
        ImageIcon icon = new ImageIcon(fileName + ".gif");
        setIcon(icon);

        if(isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        setEnabled(list.isEnabled());
        setFont(list.getFont());
        setOpaque(true);

        return this;
    }//getListCellRendererComponent()
}//class MyCellRenderer

public class ListIcon extends JFrame implements ActionListener {
    String data[] = {"Pochi","Tama","Lucky","太郎","Kitty"};
    JList<String> list = new JList<>(data);
    JScrollPane scroll = new JScrollPane();
    JPanel panel = new JPanel();
    JPanel topPanel = new JPanel();
    JButton btnAll = new JButton("全選択");
    JButton btnNon = new JButton("選択解除");
    JLabel label = new JLabel(" ");

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(btnAll)) {
            list.setSelectionInterval(0, 4);
        }
        if(e.getSource().equals(btnNon)) {
            list.clearSelection();
        }
    }//actionPerformed()

    ListIcon() {
        list.setCellRenderer(new MyCellRenderer());
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
        this.setTitle("ListIcon");
        this.pack();
        this.setSize(260, 220);
        this.setVisible(true);
    }//constructor

    public static void main(String[] args) {
        new ListIcon();
    }//main()
}//class ListIcon
