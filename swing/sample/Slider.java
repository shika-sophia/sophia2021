/**
 * @title swing / sample / Slider.java
 * @reference 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @content List 12.1 / p235 / スライダー
 * @author shika
 * @date 2021-02-16
 */
package swing.sample;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Slider extends JFrame {
    JSlider redSlider = new JSlider(0, 255, 128);
    JSlider greenSlider = new JSlider(0, 255, 128);
    JSlider blueSlider = new JSlider(0, 255, 128);
    JPanel panel = new JPanel();

    Slider() {
        this.setLayout(new GridLayout(4, 1));
        ChangeListener listener = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int red = redSlider.getValue();
                int green = greenSlider.getValue();
                int blue = blueSlider.getValue();
                panel.setBackground(new Color(red, green, blue));
            }
        };//listener

        redSlider.addChangeListener(listener);
        greenSlider.addChangeListener(listener);
        blueSlider.addChangeListener(listener);
        add(redSlider);
        add(greenSlider);
        add(blueSlider);
        add(panel);
        listener.stateChanged(null); //初期値を表示

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Slider");
        this.setSize(250, 200);
        this.setVisible(true);
    }//constructor

    public static void main(String[] args) {
        new Slider();
    }//main()

}//class
