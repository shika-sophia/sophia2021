package swing.sample;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ChangeMenu extends JFrame implements ActionListener {
    JMenuItem menuColor;

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.equals("Color")) {
            if (getContentPane().getBackground() == Color.GREEN) {
                getContentPane().setBackground(Color.BLUE);
                menuColor.setText("背景色を緑に");
            } else {
                getContentPane().setBackground(Color.GREEN);
                menuColor.setText("背景色を青に");
            }//if-else
        }//if

        if(cmd.equals("Exit")) {
            System.exit(0);
        }
    }//actionPerformed()

    ChangeMenu() {
        JMenuBar menubar = new JMenuBar();
        JMenu fileMenu = new JMenu("ファイル");
        menuColor = new JMenuItem("背景色を緑に");
        menuColor.setActionCommand("Color");
        menuColor.addActionListener(this);

        fileMenu.add(menuColor);
        fileMenu.addSeparator();

        JMenuItem menuExit = new JMenuItem("終了", KeyEvent.VK_X);
        menuExit.setActionCommand("Exit");
        menuExit.addActionListener(this);
        fileMenu.add(menuExit);

        menubar.add(fileMenu);
        this.setJMenuBar(menubar);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("ChangeMenu");
        this.setSize(250, 200);
        this.setVisible(true);
    }//constructor

    public static void main(String[] args) {
        new ChangeMenu();
    }//main()

}//class
