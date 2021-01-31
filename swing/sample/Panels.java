/**
 * @title swing / sample / Panels.java
 * @refernce 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @content List6.10 / p128 / multi-Panels
 * @see swing/sample/resultImage/multiPanels.jpg
 * @author shika
 * @date 2021-01-31
 */
package swing.sample;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Panels extends JFrame {
    Panels(){
        JPanel mainPanel = new JPanel();
        JPanel inPanel = new JPanel();

        //---- yield Component ----
        JButton btn12 = new JButton("FontSize 12");
        btn12.setPreferredSize(new Dimension(120, 36));

        JButton btn16 = new JButton("FontSize 16");
        btn16.setPreferredSize(new Dimension(120, 36));

        JButton btn20 = new JButton("FontSize 20");
        btn20.setPreferredSize(new Dimension(120, 36));

        JTextArea txArea = new JTextArea();
        txArea.setText("サンプルテキスト\n２行目");

        //---- Locate Component ----
        mainPanel.setLayout(new BorderLayout(5, 5));
        mainPanel.add(inPanel, BorderLayout.WEST);
        mainPanel.add(txArea, BorderLayout.CENTER);

        inPanel.setLayout(new GridLayout(3, 1, 5, 5));
        inPanel.add(btn12);
        inPanel.add(btn16);
        inPanel.add(btn20);

        //---- Event Handlar ----
        btn12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txArea.setFont(new Font("Serif", Font.BOLD, 12));
            }
        });

        btn16.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txArea.setFont(new Font("Serif", Font.BOLD, 16));
            }
        });

        btn20.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txArea.setFont(new Font("Serif", Font.BOLD, 20));
            }
        });

        this.getContentPane().add(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("multi-Panels");
        this.pack();
        this.setSize(260, 160);
        this.setVisible(true);
    }//constructor

    public static void main(String[] args) {
        new Panels();
    }//main()

}//class
