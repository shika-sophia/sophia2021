package swing.sample;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuIcon extends JFrame implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if(cmd.equals("Exit")) {
            System.exit(0);
        }
    }//actionPerformed()

    MenuIcon() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("ファイル");
        JMenuItem menuExit = new JMenuItem("終了",
            new ImageIcon("WebContent/image/iconFraulein.jpg"));
        menuExit.setActionCommand("Exit");
        menuExit.addActionListener(this);

        fileMenu.add(menuExit);
        menuBar.add(fileMenu);
        this.setJMenuBar(menuBar);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("MenuIcon");
        this.setSize(250, 200);
        this.setVisible(true);
    }//constructor

    public static void main(String[] args) {
        new MenuIcon();
    }//main()

}//class
