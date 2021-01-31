/**
 * @title swing / sample / Card.java
 * @refernce 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @content List6.8 / p122 / CardLayout
 * @see swing/sample/resultImage/CardLayout.jpg
 * @author shika
 * @date 2021-01-31
 */
package swing.sample;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Card extends JFrame {
    Card() {
        //---- 2 inner panel ----
        JPanel upperPanel = new JPanel();
        JPanel underPanel = new JPanel();

        CardLayout layout = new CardLayout(5, 5);
        upperPanel.setLayout(layout);

        //---- build Array of JPanel, JLabel, JButton ----
        JPanel[] pnlAry = new JPanel[5];
        JLabel[] lblAry = new JLabel[5];
        JButton[] btnAry = new JButton[5];

        for(int i = 0; i < pnlAry.length; i++) {
            pnlAry[i] = new JPanel();
            lblAry[i] = new JLabel("Label: " + (i + 1));
            btnAry[i] = new JButton("Button: "+ (i + 1));

            pnlAry[i].setLayout(new BoxLayout(pnlAry[i], BoxLayout.Y_AXIS));
            pnlAry[i].add(lblAry[i]);
            pnlAry[i].add(btnAry[i]);

            upperPanel.add("p" + (i + 1), pnlAry[i]);
        }//for

        //---- underPanel ----
        JButton btnPrev = new JButton("≪ Previous");
        btnPrev.setMinimumSize(new Dimension(240, 72));
        btnPrev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layout.previous(upperPanel);
            }
        });

        JButton btnNext = new JButton("Next ≫");
        btnNext.setMinimumSize(new Dimension(240, 72));
        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layout.next(upperPanel);
            }
        });

        //---- Locate Component ----
        upperPanel.setBorder(
            BorderFactory.createRaisedBevelBorder());
        underPanel.add(btnPrev);
        underPanel.add(btnNext);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(upperPanel);
        panel.add(underPanel);

        //---- JFrame condition ----
        this.getContentPane().add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("CardLayout");
        this.pack();
        this.setSize(240, 160);
        this.setVisible(true);
    }//constructor

    public static void main(String[] args) {
        new Card();
    }//main()

}//class
