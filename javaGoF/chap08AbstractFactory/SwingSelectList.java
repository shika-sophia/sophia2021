package javaGoF.chap08AbstractFactory;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SwingSelectList extends JFrame {
    private List<String> list;
    private String select;

    public SwingSelectList(List<String> list) {
        this.list = list;
        run();
    }

    public void run() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        JButton button = new JButton("決定");

        JList<String> jList = new JList<String>(list.toArray(new String[list.size()]));
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().setView(jList);

        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(jList.getSelectedIndices().length == 1) {
                    label.setText(jList.getSelectedValue());
                } else {
                    label.setText("<!> 選択できるのは１つだけです。");
                }
            }//valueChanged()
        });

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jList.getSelectedIndices().length == 1) {
                    select = jList.getSelectedValue();
                    System.exit(0);
                }
            }//actionPerformed()
        });

        this.getContentPane().add(panel);
        panel.setLayout(new BorderLayout());
        panel.add(scroll, "North");
        panel.add(label, "Center");
        panel.add(button,"South");

        this.setTitle("Select List");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }//run()

    public String getSelect() {
        return select;
    }

    public static void main(String[] args) {
        List<String> dataList = new ArrayList<>(
            Arrays.asList("A", "B", "C", "D", "E"));
        var swing = new SwingSelectList(dataList);
        String select = swing.getSelect();
        System.out.println(select);
    }//main()
}//class
