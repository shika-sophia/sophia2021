package swing.sample;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToolBar;

public class Toolbar extends JFrame {
    Toolbar() {
        JToolBar toolbar = new JToolBar(JToolBar.HORIZONTAL);
        JCheckBox chk = new JCheckBox("フローティング");
        JButton btnBlue = new JButton("");
        JButton btnRed = new JButton("");
        JButton btnGreen = new JButton("");
        JLabel label = new JLabel("ツールバーの色を選択してください。");

        chk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chk.isSelected()) {
                    toolbar.setFloatable(true);
                } else {
                    toolbar.setFloatable(false);
                }
            }
        });//addActionListener()

        btnBlue.setBackground(Color.BLUE);
        btnBlue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("選択されている色はブルー");
            }
        });
        toolbar.add(btnBlue);

        btnRed.setBackground(Color.RED);
        btnRed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("選択されている色は赤");
            }
        });
        toolbar.setFloatable(false);
        toolbar.add(btnRed);

        btnGreen.setBackground(Color.GREEN);
        btnGreen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("選択されている色はグリーン");
            }
        });
        toolbar.add(btnGreen);

        this.setLayout(new BorderLayout());
        this.add(toolbar, "North");
        this.add(chk, "Center");
        this.add(label, "South");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Toolbar");
        this.setSize(300, 200);
        this.setVisible(true);
    }//Toolbar()

    public static void main(String[] args) {
        new Toolbar();
    }//main()

}//class
