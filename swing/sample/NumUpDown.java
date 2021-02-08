/**
 * @title swing / sample / NumUpDown.java
 * @refernce 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @content List8.6 / p171 / NumUpDown
 * @see swing/sample/resultImage/NumUpDown.jpg
 * @author shika
 * @date 2021-02-08
 */
package swing.sample;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class NumUpDown extends JFrame {
    JSpinner spinh = new JSpinner();
    JSpinner spinw = new JSpinner();
    JLabel labelh = new JLabel("身長（cm）:");
    JLabel labelw = new JLabel("体重（kg）:");
    JLabel labelBmi = new JLabel("BMI:");

    class MyChangeListener implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            int h = (Integer)(spinh.getValue());
            int w = (Integer)(spinh.getValue());
            double bmi = w / (h * h / 1000.0);
            String str = String.format("BMI = %5.2f", bmi);
            labelBmi.setText(str);
        }
    }//class MyChangeListener

    NumUpDown() {
        SpinnerModel modelh = new SpinnerNumberModel(0, 0, 210, 1);
        SpinnerModel modelw = new SpinnerNumberModel(55, 0, 120, 1);
        spinh.setModel(modelh);
        spinw.setModel(modelw);
        spinh.addChangeListener(new MyChangeListener());
        spinw.addChangeListener(new MyChangeListener());

        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        layout.setConstraints(labelh, gbc);
        add(labelh);

        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.gridwidth = 4;
        gbc.gridheight = 1;
        layout.setConstraints(spinh, gbc);
        add(spinh);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        layout.setConstraints(labelw, gbc);
        add(labelw);

        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.gridwidth = 4;
        gbc.gridheight = 1;
        layout.setConstraints(spinw, gbc);
        add(spinw);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 6;
        gbc.gridheight = 1;
        layout.setConstraints(labelBmi, gbc);
        add(labelBmi);

        //初期値を得るためにイベントを発生させる
        spinh.setValue(160);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("NumUpDown");
        this.setSize(280, 150);
        this.setVisible(true);
    }//constructor

    public static void main(String[] args) {
        new NumUpDown();
    }//main()

}//class
