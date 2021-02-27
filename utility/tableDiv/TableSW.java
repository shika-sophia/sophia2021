/**
 * @title utility / tableDiv / TableSW.java
 * @reference 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @content columnList, valueListsを引数とする汎用テーブルを表示。
 * @see swing / sample / Table.java
 * @see TableSW.jpg 結果のテーブル画像
 * @author shika
 * @date 2021-02-27
 */
package utility.tableDiv;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class TableSW
        extends TableHTML implements TableModelListener {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JLabel label = new JLabel();
    JButton button = new JButton("印刷");
    JTable table;
    JScrollPane scroll;
    String[] columnAry;   //列配列: columnListから配列化
    String[][] valueArys; //値の配列: 要素に行配列。valueLists配列化

    public TableSW() { }

    public TableSW(
            List<String> columnList, List<List<String>> valueLists) {
        super(columnList, valueLists);
        buildAry(columnList, valueLists);
    }

    private void buildAry(
            List<String> columnList, List<List<String>> valueLists) {
        columnAry = columnList.toArray(
                new String[columnList.size()]);

        valueArys = valueLists.stream()
                .map(list -> list.stream().toArray(String[]::new))
                .toArray(String[][]::new);
    }//buildAry

    public void run() {
        //tableの定義
        table = new JTable(valueArys, columnAry);
        table.setPreferredScrollableViewportSize(
                new Dimension(500, 200));
        table.setFillsViewportHeight(true);
        table.getModel().addTableModelListener(this);
        scroll = new JScrollPane(table);

        //buttonの処理定義
        ActionListener listener = buildListener();
        button.addActionListener(listener);

        //---- add component ----
        frame.setLayout(new BorderLayout());
        frame.add(scroll, "Center");
        panel.setLayout(new FlowLayout());
        panel.add(label);
        panel.add(button);

        //frameの定義
        frame.add(panel, "South");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("tableDiv / TableSW");
        frame.pack();
        frame.setVisible(true);
    }//run()

    //====== マウスカーソルの合ったセル情報を表示するListener ======
    @Override
    public void tableChanged(TableModelEvent e) {
        int row = e.getFirstRow();
        int column = e.getColumn();
        TableModel model = (TableModel) e.getSource();
        String columnName = model.getColumnName(column);
        Object value = model.getValueAt(row, column);
        String str = String.format("[%d,%d(%s)] %s",
                row, column, columnName, (String) value);
        label.setText(str);
    }//tableChanged()

    //====== ボタンを押すと「印刷」設定ダイアログを開くListener ======
    private ActionListener buildListener() {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    table.print();
                } catch(PrinterException ex) {
                    JOptionPane.showMessageDialog(null, "< ! > 印刷できません。");
                }//try-catch
            }
        };
        return listener;
    }//buildListener()

//    //====== Test main(), run() ======
//    public static void main(String[] args) {
//        List<String> columnList = List.of("id", "name", "adress");
//        List<String> rowList1 = List.of("1", "Alice", "Alaska");
//        List<String> rowList2 = List.of("2", "Bobby", "Britain");
//        List<String> rowList3 = List.of("3", "Charry", "Canada");
//        List<List<String>> valueLists = List.of(
//                rowList1, rowList2, rowList3);
//
//        var here = new TableSW(columnList, valueLists);
//        here.run();
//
//        //---- Test buildAry() ----
//        System.out.println("columnAry: " + Arrays.toString(here.columnAry));
//        System.out.println();
//
//        System.out.println("valueArys: ");
//        for(String[] rowAry : here.valueArys) {
//            Arrays.stream(rowAry).map(s -> s + ", ")
//                .forEach(System.out::print);
//            System.out.println();
//        }
//    }//main()
}//class

/*
//====== Result buildAry() ======
columnAry: [id, name, adress]

valueArys:
1, Alice, Alaska,
2, Bobby, Britain,
3, Charry, Canada,

@see tableDiv / TableSW.jpg 結果のテーブル画像
*/