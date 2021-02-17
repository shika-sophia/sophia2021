/**
 * @title swing / sample / WebSource.java
 * @reference 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @content List 13.4 / p254 / Ｗｅｂページの HTMLソース表示
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
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class WebSource extends JFrame {
    WebSource() {
        WebSource frame = this;
        JPanel panel = new JPanel();
        JScrollPane scrollPage = new JScrollPane();
        JTextField txField = new JTextField(20);
        JButton btnPage = new JButton("表示");
        JButton btnSrc = new JButton("HTML");
        JEditorPane htmlPane = new JEditorPane();

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource().equals(btnPage)) {
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
                } else {
                    JTextArea txArea = new JTextArea(20, 80);
                    txArea.setText(htmlPane.getText());
                    JScrollPane scrollSrc = new JScrollPane(txArea);
                    JDialog dialog = new JDialog(frame, "HTML", true);
                    dialog.getContentPane().add(scrollSrc);
                    dialog.setSize(400, 360);
                    dialog.setVisible(true);
                }//if-else btn
            }
        };//listener

        btnPage.addActionListener(listener);
        btnSrc.addActionListener(listener);
        this.setLayout(new BorderLayout());
        panel.setLayout(new FlowLayout());
        panel.add(txField);
        panel.add(btnPage);
        panel.add(btnSrc);
        htmlPane.setEditable(false);
        htmlPane.setContentType("text/html; UTF-8");
        scrollPage.getViewport().setView(htmlPane);
        this.add(panel, "North");
        this.add(scrollPage, "Center");

         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("WebSource");
        this.setSize(450, 350);
        this.setVisible(true);
    }//constructor

    public static void main(String[] args) {
        new WebSource();
    }//main()

}//class
