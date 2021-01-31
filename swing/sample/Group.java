/**
 * @title swing / sample / Group.java
 * @refernce 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @content List6.6 / p117 / GroupLayout
 * @see swing/sample/resultImage/GroupLayout.jpg
 * @author shika
 * @date 2021-01-31
 */
package swing.sample;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Group extends JFrame {

    Group() {
        JPanel panel = new JPanel();
        JLabel labelId = new JLabel("ID: ");
        JLabel labelPass = new JLabel("Pass: ");
        JTextField txfId = new JTextField(20);
        JTextField txfPass = new JTextField(20);

        GroupLayout layout = new GroupLayout(panel);
        layout.setAutoCreateContainerGaps(true);
        panel.setLayout(layout);

        GroupLayout.SequentialGroup hgroup =
            layout.createSequentialGroup();
        hgroup.addGroup(layout.createParallelGroup()
            .addComponent(labelId).addComponent(labelPass));
        hgroup.addGroup(layout.createParallelGroup()
            .addComponent(txfId).addComponent(txfPass));
        layout.setHorizontalGroup(hgroup);

        GroupLayout.SequentialGroup vgroup =
            layout.createSequentialGroup();
        vgroup.addGroup(layout.createParallelGroup(
            GroupLayout.Alignment.BASELINE)
            .addComponent(labelId).addComponent(txfId));
        vgroup.addGroup(layout.createParallelGroup(
            GroupLayout.Alignment.BASELINE)
            .addComponent(labelPass).addComponent(txfPass));
        layout.setVerticalGroup(vgroup);

        this.getContentPane().add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("GroupLayout");
        this.pack();
        this.setSize(280, 105);
        this.setVisible(true);
    }//constructor

    public static void main(String[] args) {
        new Group();
    }//main()

}//class
