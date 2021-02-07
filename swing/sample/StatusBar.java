package swing.sample;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusBar extends JFrame {
    StatusBar() {
        JPanel upperPanel = new JPanel();
        JPanel statusPanel = new JPanel();
        JButton btn = new JButton("クリック");
        JCheckBox chk = new JCheckBox("チェック");
        JLabel labelSt = new JLabel("ステータスバー");

        upperPanel.add(btn);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelSt.setText("ボタンがクリックされました。");
            }
        });//addActionListener()

        this.setLayout(new BorderLayout());
        upperPanel.add(chk);
        chk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelSt.setText("チェックボックスが変更されました。");
            }
        });
        this.add(upperPanel, "Center");

        statusPanel.setBorder(BorderFactory.createEtchedBorder());
        statusPanel.setLayout(new FlowLayout());
        statusPanel.add(labelSt);
        this.add(statusPanel, "South");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("StatusBar");
        this.setSize(250, 200);
        this.setVisible(true);
    }//constructor

    public static void main(String[] args) {
        new StatusBar();
    }//main()

}//class
