package swing.sample;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;

public class Popup extends JFrame {
    JPopupMenu pop;
    JMenuItem menuGreen;
    JMenuItem menuBlue;
    JTextArea output;

    class PopupListener extends MouseAdapter {
        public void mousePressed(MouseEvent ev) {
            maybeShowPopup(ev);
        }

        public void mouseReleased(MouseEvent ev) {
            maybeShowPopup(ev);
        }

        private void maybeShowPopup(MouseEvent ev) {
            if(ev.isPopupTrigger()) {
                pop.show(ev.getComponent(), ev.getX(), ev.getY());
            }
        }
    }//class PopupListener

    Popup() {
        output = new JTextArea(5, 30);
        JMenuBar menuBar = new JMenuBar();
        pop = new JPopupMenu();

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                JMenuItem source = (JMenuItem)(ev.getSource());

                if(source.equals(menuGreen)) {
                    output.setBackground(Color.GREEN);
                }

                if(source.equals(menuBlue)) {
                    output.setBackground(Color.BLUE);
                }

                String s = "イベントソース" + source.getText() + "\n";
                output.append(s);
                output.setCaretPosition(output.getDocument().getLength());
            }
        };

        menuGreen = new JMenuItem("背景をグリーンに");
        menuGreen.addActionListener(listener);
        pop.add(menuGreen);

        menuBlue = new JMenuItem("背景をブルーに");
        menuBlue.addActionListener(listener);
        pop.add(menuBlue);

        MouseListener popupListener = new PopupListener();
        output.addMouseListener(popupListener);
        menuBar.addMouseListener(popupListener);
        this.getContentPane().add(output);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Popup");
        this.setSize(250, 200);
        this.setVisible(true);
    }//constructor

    public static void main(String[] args) {
        new Popup();
    }//main()

}//class
