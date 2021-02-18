/**
 * @title swing / sample / IconButton.java
 * @reference 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @content List 14.2 / p261 / ボタンにアイコンを表示
 * @see sample / ImageButton
 * @author shika
 * @date 2021-02-18
 */
package swing.sample;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class IconButton extends JFrame {
    JButton button;
    ImageIcon icon;
    JTextArea txArea;

    IconButton() {
        icon = new ImageIcon("WebContent/image/iconFraulein.jpg");
        button = new JButton("クリック", icon);
        txArea = new JTextArea(50, 30);
        txArea.setText("* Memo *");
        run();
    }

    private void run() {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(button.getText().equals("クリック")) {
                    ImageIcon iconClock = new ImageIcon(
                            "WebContent/image/clock.gif");

                    button.setText(" Wait  ");
                    button.setIcon(iconClock);
                } else {
                    button.setText("クリック");
                    button.setIcon(icon);
                }//if-else button
            }
        };//listener
        button.addActionListener(listener);

        this.setLayout(new BorderLayout());
        this.add(txArea, "Center");
        this.add(button, "South");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("IconButton");
        setSize(250, 250);
        setVisible(true);
    }//run()

    public static void main(String[] args) {
        new IconButton();
    }//main()

}//class

/*
//====== ImageButton / 2021-02-18 ======
クリックすると、アイコンとボタンの文字が変化する仕様で自作してみた。

Button のテキストが半角英数字のとき、後半少し文字が切れるので、
後ろに半角スペース２つ入れて、ちょうど良い。

button.setText()/setIcon()ではなく、
フィールドの button = new JButton("Wait", icon);だと反映しなかった。

else節
コンストラクタの仕様に戻そうと思い、new IconButton();をしたら、
新しいウィンドウができた。そりゃそうか。これは納得。
今ある buttonの内容を変更するには、
button.setText()/setIcon()でするべし。

*/