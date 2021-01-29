/**
 * @title swing / sample / GridBag.java
 * @refernce 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @content List6.5 / p113 / GridBagLayout
 * @see swing/sample/resultImage/GridBagLayout.jpg
 * @author shika
 * @date 2021-01-29
 */
package swing.sample;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GridBag extends JFrame {
    public GridBag() {
        JPanel panel = new JPanel();
        JLabel labelId = new JLabel("ID: ");
        JTextField txtFldId = new JTextField(20);
        JLabel labelPass = new JLabel("PASS: ");
        JPasswordField fldPass = new JPasswordField(20);
        JButton btnOk = new JButton("ＯＫ");
        JButton btnCancel = new JButton("Cancel");

        GridBagLayout layout = new GridBagLayout();
        layout.columnWeights = new double[9];
        layout.columnWidths = new int[9];

        for (int i = 0; i < layout.columnWidths.length; i++) {
            layout.columnWeights[i] = 1.0d;
            layout.columnWidths[i] = 100;
        }

        layout.rowWeights = new double[5];
        layout.rowHeights = new int[5];

        for (int i = 0; i < layout.rowHeights.length; i++) {
            layout.rowWeights[i] = 1.0d;
            layout.rowHeights[i] = 100;
        }
        panel.setLayout(layout);

        GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 1;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;

        layout.setConstraints(labelId, gbc);
        panel.add(labelId);
        gbc.gridx = 5;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        layout.setConstraints(txtFldId, gbc);
        panel.add(txtFldId);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;

        layout.setConstraints(labelPass, gbc);
        panel.add(labelPass);
        gbc.gridx = 5;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        layout.setConstraints(fldPass, gbc);
        panel.add(fldPass);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;

        layout.setConstraints(btnOk, gbc);
        panel.add(btnOk);
        gbc.gridx = 5;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;

        layout.setConstraints(btnCancel, gbc);
        panel.add(btnCancel);

        this.getContentPane().add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("GridBagLayout");
        this.pack();
        this.setSize(220, 180);
        this.setVisible(true);
    }//constructor

    public static void main(String[] args) {
        new GridBag();
    }//main()

}//class
