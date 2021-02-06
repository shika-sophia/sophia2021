package swing.sample;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MainMenu extends JFrame {
    MainMenu(){
        //メニュー
        JMenuBar menuBar = new JMenuBar();

        //[ファイル]メニュー
        JMenu fileMenu = new JMenu("ファイル");
        JMenu bkColorMenu = new JMenu("背景色");
        JMenuItem menuRed = new JMenuItem("赤");

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                String cmd = ev.getActionCommand();

                if(cmd.equals("Red")) {
                    getContentPane().setBackground(Color.RED);
                }

                if(cmd.equals("Blue")) {
                    getContentPane().setBackground(Color.BLUE);
                }

                if(cmd.equals("Exit")) {
                    System.exit(0);
                }

                if(cmd.equals("About")) {
                    JDialog dialog = new JDialog();
                    JLabel label1 = new JLabel("==== Main Menu ====");
                    JLabel label2 = new JLabel("ver 1.0");
                    JPanel panel = new JPanel();
                    panel.add(label1);
                    panel.add(label2);

                    dialog.setTitle("MainMenuについて");
                    dialog.setSize(150, 100);
                    dialog.getContentPane().add(panel);
                    dialog.setVisible(true);
                }
            }//actionPerfomed()
        };//listener

        menuRed.setActionCommand("Red");
        menuRed.addActionListener(listener);
        bkColorMenu.add(menuRed);

        JMenuItem menuBlue = new JMenuItem("青");
        menuBlue.setActionCommand("Blue");
        menuBlue.addActionListener(listener);
        bkColorMenu.add(menuBlue);

        fileMenu.add(bkColorMenu);
        fileMenu.addSeparator();

        JMenuItem menuExit = new JMenuItem("終了", KeyEvent.VK_X);
        menuExit.setActionCommand("Exit");
        menuExit.addActionListener(listener);

        fileMenu.add(menuExit);
        menuBar.add(fileMenu);

        //[ヘルプ]メニュー
        JMenu helpMenu = new JMenu("ヘルプ");
        JMenuItem menuAbout = new JMenuItem("MainMenuについて");
        menuAbout.setActionCommand("About");
        menuAbout.addActionListener(listener);
        menuBar.add(helpMenu);
        helpMenu.add(menuAbout);
        this.setJMenuBar(menuBar);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("MainMenu");
        this.setSize(250, 200);
        this.setVisible(true);
    }//constructor

    public static void main(String[] args) {
        new MainMenu();
    }//main()

}//class
