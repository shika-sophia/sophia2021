/**
 * @title javaPractice / swing / sample / SampleLabel.java
 * @refernce 日向俊二『JavaGUIプログラミング』カットシステム, 2020
 * @content List4.1 / SmplLbl.java
 * @see swing/sample/resultImage/SampleLabel.jpg
 * @date 2021-01-26
 */
package swing.sample;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class SampleLabel extends JFrame {

    SampleLabel(){
        JLabel label = new JLabel("Sample Label");
            label.setPreferredSize(new Dimension(220, 40));
            label.setBackground(Color.LIGHT_GRAY);
            label.setOpaque(true);

        LineBorder border = new LineBorder(Color.BLUE, 2, true);
            label.setBorder(border);
            label.setHorizontalAlignment(JLabel.CENTER);

        JPanel panel = new JPanel();
            panel.add(label);

        //JFrame
        setTitle("SampleLabel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(panel);
        setSize(300, 200);
        setVisible(true);
    }//constructor

    public static void main(String[] args) {
        new SampleLabel();
    }//main()

}//class

/*
@see sample/resultImage/SampleLabel.jpg
*/