package shuffleSeatSW;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ViewSeat extends JFrame {

    public static void main(String[] args) {
        JPanel panel = new JPanel();
        GridLayout layout = new GridLayout(6, 3, 5, 10);
        panel.setLayout(layout);
    }//main()

}//class
