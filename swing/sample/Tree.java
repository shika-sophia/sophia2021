/**
 * @title swing / sample / Tree.java
 * @reference 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @content List 11.2 / p229 / 階層ツリーの表示
 * @author shika
 * @date 2021-02-16
 */
package swing.sample;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

public class Tree extends JFrame {
    JTree tree = null;
    JLabel label = new JLabel("ノードをクリック");

    Tree() {
        DefaultMutableTreeNode top =
            new DefaultMutableTreeNode("Top node");
        tree = new JTree(top);
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node =
                    (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                if(node == null) {
                    return;
                }
                if(node.isLeaf()) { //isLeaf(): 末端かどうか
                    label.setText(node.toString());
                } else {
                    label.setText("子ノードがあります: " + node.toString());
                }
            }
        });//addTreeSelectionListener()

        DefaultMutableTreeNode sub1 =
            new DefaultMutableTreeNode("サブノード１");
        top.add(sub1);

        DefaultMutableTreeNode sub2 =
                new DefaultMutableTreeNode("サブノード２");
        top.add(sub2);

        DefaultMutableTreeNode sub11 =
                new DefaultMutableTreeNode("サブノード11");
        sub1.add(sub11);

        DefaultMutableTreeNode sub12 =
                new DefaultMutableTreeNode("サブノード12");
        sub1.add(sub12);

        tree.expandRow(0);
        this.setLayout(new BorderLayout());
        this.add(tree, "Center");
        this.add(label, "South");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Tree");
        this.setSize(320, 200);
        this.setVisible(true);
    }//construtor

    public static void main(String[] args) {
        new Tree();
    }//main()

}//class

