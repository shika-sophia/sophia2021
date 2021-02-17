/**
 * @title swing / sample / WebBrowse.java
 * @reference 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @content List 13.3 / p251 / Ｗｅｂページの表示
 * @author shika
 * @date 2021-02-17
 */
package swing.sample;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WebBrowse extends JFrame {
    WebBrowse() {
        JPanel panel = new JPanel();
        JTextField txField = new JTextField(20);
        JButton btnPage = new JButton("表示");
        JEditorPane htmlPane = new JEditorPane();

        btnPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = txField.getText();
                url.trim();
                if(url.length() < 3) {
                    return;
                }
                if(!url.startsWith("http")) {
                    url = "http://" + url;
                    txField.setText(url);
                }

                try {
                    htmlPane.setPage(url);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }//try-catch
            }
        });//addActionListener()

        this.setLayout(new BorderLayout());
        panel.setLayout(new FlowLayout());
        panel.add(txField);
        panel.add(btnPage);

        htmlPane.setEditable(false);
        htmlPane.setContentType("text/html; UTF-8");
        this.add(panel, "North");
        this.add(htmlPane, "Center");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("WebBrowse");
        this.setSize(450, 350);
        this.setVisible(true);
    }//constructor

    public static void main(String[] args) {
        new WebBrowse();
    }//main()

}//class

/*
====== WebBrowse / 2021-02-17 ======
Webページ出た。
画質良くない。
リンク飛べない。
ScrollPaneが必要。
*/