/**
 * @title swing / sample / Table.java
 * @reference 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @content List 11.1 / p219 / Tableの表示
 * @see utility / tableDiv / TableSW.java
 * @author shika
 * @date 2021-02-15
 */
package swing.sample;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;

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

public class Table extends JFrame implements TableModelListener {
    JTable table = null;
    JPanel panel = new JPanel();
    JLabel label = new JLabel("セルをＷクリックして変更してください。");
    JButton button = new JButton("印刷");

    String[] columnAry = {"氏名(姓)","氏名(名)","郵便番号","Ｅメール","年齢"};
    String[][] data = {
        {"山田","太郎","231-0011","taro@xx.ca.jp","17"},
        {"天井","香織","231-1011","amaikaori@xx.ca.jp","24"},
        {"神尾","睦月","212-0211","kamio@xx.ca.jp","38"},
        {"花岡","実太","122-0031","hanaoka@xx.ca.jp","52"},
        {"海野","浜子","101-0104","hamako@xx.ca.jp","21"},
    };

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

    Table() {
        table = new JTable(data, columnAry);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        table.getModel().addTableModelListener(this);

        this.setLayout(new BorderLayout());
        this.add(scroll, "Center");
        panel.setLayout(new FlowLayout());
        panel.add(label);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    table.print();
                } catch(PrinterException ex) {
                    JOptionPane.showMessageDialog(null, "< ! > 印刷できません。");
                }//try-catch
            }
        });//addActionListener()

        this.add(panel, "South");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Table");
        this.pack();
        this.setVisible(true);
    }//constructor

    public static void main(String[] args) {
        new Table();
    }//main()

}//class

