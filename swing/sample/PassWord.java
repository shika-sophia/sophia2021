/**
 * @title javaPractice / swing / sample / Password.java
 * @refernce 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @content List5.4 / PasswordDlg.java
 * @see swing / sample / resultImage / Password.jpg
 * @author shika
 * @date 2021-01-28
 */
package swing.sample;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class PassDialog extends JDialog {
    boolean fSuccess;

    PassDialog(Frame owner, String title, boolean modal) {
        super(owner, title, modal);

        JLabel label1 = new JLabel("ID");
        JTextField txtf = new JTextField(12);
        JLabel label2 = new JLabel("パスワード");
        JPasswordField passf = new JPasswordField(18);
            passf.setEchoChar('*');
        JButton buttonOk = new JButton("ＯＫ");
        JButton buttonCancel = new JButton("Cancel");

            buttonOk.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String pass = new String(passf.getPassword());

                    if (pass.equals("password")) {
                        fSuccess = true;
                    } else {
                        Toolkit.getDefaultToolkit().beep();
                        fSuccess = false;
                    }
                    getParent().setVisible(false);
                }
            });

            buttonCancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    getParent().setVisible(false);
                }
            });

            //JDialog
            this.setLayout(new GridLayout(3, 2));
            this.add(label1);
            this.add(txtf);
            this.add(label2);
            this.add(passf);
            this.add(buttonOk);
            this.add(buttonCancel);

            this.setSize(220, 120);
            this.setTitle("パスワード入力");
            this.setResizable(false);
            this.setVisible(true);
    }//constructor
}//class Password

public class PassWord extends JFrame {
    public PassWord() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("ログインしてください。");
        JButton button = new JButton("ログイン");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    PassDialog dlg = new PassDialog(null, "パスワード", true);

                    if(dlg.fSuccess == true) {
                        label.setText("ログインしました。");
                    } else {
                        label.setText("パスワードが不正です。");
                    }//if-else
                }//ActionListener
            });//addActionListener()

            panel.add(label);
            panel.add(button);
            this.getContentPane().add(panel);

            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setTitle("PassWord");
            this.setSize(380, 240);
            this.setVisible(true);
    }//constructor PassWord

    public static void main(String[] args) {
        new PassWord();
    }//main()

}//class
