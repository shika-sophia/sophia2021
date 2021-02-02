package shuffleSeatSW;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ViewSeat extends JFrame {
    JPanel panel;
    GridLayout layout;
    JLabel[] labelAry;
    JButton button;

    ViewSeat() {
        panel = new JPanel();
        layout = new GridLayout(6, 3, 5, 10);
        panel.setLayout(layout);

        button = new JButton("席 替 え");
    }

    public void buildJLabelAry(List<String> list) {
        final int BOUND = list.size();
        labelAry = new JLabel[BOUND];

        for(int i = 0; i < BOUND; i++) {
            labelAry[i] = new JLabel(list.get(i));
        }//for
    }//buildJLabelAry

}//class
