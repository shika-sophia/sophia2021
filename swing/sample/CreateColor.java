/**
 * @title swing / sample / CreateColor.java
 * @reference 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @content List 14.4 / p268 / 色の作成
 * @author shika
 * @date 2021-02-18
 */
package swing.sample;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class CreateColor extends JFrame {
    CreateColor() {
        JPanel panel = new JPanel();
        JSpinner spinRed = new JSpinner(
            new SpinnerNumberModel(127, 0, 255, 1));
        JSpinner spinGreen = new JSpinner(
                new SpinnerNumberModel(127, 0, 255, 1));
        JSpinner spinBlue = new JSpinner(
                new SpinnerNumberModel(127, 0, 255, 1));
        JButton button = new JButton("色作成");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = Integer.parseInt(
                    String.valueOf(spinRed.getValue()));
                int green = Integer.parseInt(
                    String.valueOf(spinGreen.getValue()));
                int blue = Integer.parseInt(
                    String.valueOf(spinBlue.getValue()));
                panel.setBackground(new Color(red, green, blue));
            }
        });//addActionListener()

        JPanel subPanel = new JPanel();
        subPanel.setLayout(new GridLayout(3, 2));

        JLabel lbRed = new JLabel("赤");
        subPanel.add(lbRed);
        subPanel.add(spinRed);

        JLabel lbGreen = new JLabel("緑");
        subPanel.add(lbGreen);
        subPanel.add(spinGreen);

        JLabel lbBlue = new JLabel("青");
        subPanel.add(lbBlue);
        subPanel.add(spinBlue);

        panel.add(subPanel);
        panel.setBorder(
            BorderFactory.createTitledBorder("RGBで色作成"));
        panel.add(button);
        this.add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("CreateColor");
        setSize(350, 150);
        setVisible(true);
    }//constructor

    public static void main(String[] args) {
        new CreateColor();
    }//main()

}//class
