package utility.tableDiv;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TableSW extends TableHTML {
    JFrame frame;
    JPanel panel;
    JTable table;
    JButton button;
    JScrollPane scroll;

    {
        //---- instance ----
        frame = new JFrame();
        panel = new JPanel();
        table = new JTable();
        button = new JButton("印刷");
        scroll = new JScrollPane(table);

        //---- add component ----
        frame.getContentPane().add(panel);
        panel.add(scroll);
        panel.add(button);
        //scroll.add(table);
    }

    public TableSW() { }

    public TableSW(
            List<String> columnList, List<List<String>> valueLists) {
        super(columnList, valueLists);
    }
}//class
