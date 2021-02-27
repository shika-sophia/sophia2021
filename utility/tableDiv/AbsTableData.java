/**
 * @title utility / tableDiv / AbsTableData.java
 * @content 列リスト、値リスト(行リスト)から HTMLや swingのテーブルを作成
 *
 * @class AbsTableData //columnList, valueListsなど全体のフィールド
 *            |
 * @class TableHTML extends AbsTableData
 *            |        //HTML＜table＞形式の表を作成
 * @class TableSW extends TableHTML
 *                implements TableModelListener
 *                     //swing.JTable の表を作成
 * @author shika
 * @date 2021-02-26
 * */
package utility.tableDiv;

import java.util.ArrayList;
import java.util.List;

public abstract class AbsTableData {
    protected List<String> columnList;
    protected List<String> rowList;
    protected List<List<String>> valueLists;
    protected int columnNum;
    protected int rowNum;
    protected int dataLength;
    protected String tableHtml;

    {
        columnList = new ArrayList<String>();
        rowList = new ArrayList<String>();
        valueLists = new ArrayList<List<String>>();
    }

    public AbsTableData() { }

    public AbsTableData(
            List<String> columnList, List<List<String>> valueLists) {
        this.columnList = columnList;
        this.valueLists = valueLists;
        this.columnNum = columnList.size();
        this.rowNum = valueLists.size();
        this.dataLength = calcDataLength(valueLists);
    }

    private int calcDataLength(List<List<String>> valueLists2) {
        int rowContentSize = 0;
        if(valueLists.isEmpty()) {
            ;
        } else {
            rowList = valueLists.get(0);
            rowContentSize = rowList.stream()
                    .mapToInt(s -> s.length())
                    .sum();
        }
        //データサイズ概算  = (行数 + カラム行) * １行当たりの文字数
        dataLength = (rowNum + 1) * rowContentSize;
        //HTML<table>の文字数概算 = <table> + <tr>*行数 + <td>*列数
        int htmlLength = 30 + (15 * rowNum) + (15 * columnNum);

        dataLength += htmlLength;
        dataLength *= 2; //謎の「*2」, 改行分や余裕を持たせる分
        return dataLength ;
    }//calcDataLength

//==== Test dataLength ====
//dataLength: 336
//length: 251

    //====== getter ======
    public List<String> getColumnList() {
        return columnList;
    }

    public List<String> getRowList() {
        return rowList;
    }

    public List<List<String>> getValueLists() {
        return valueLists;
    }

    public int getColumnNum() {
        return columnNum;
    }

    public int getRowNum() {
        return rowNum;
    }

    public String tableHtml() {
        return tableHtml;
    }

    //====== abstract ======
    protected abstract void setTableHtml(String tableHtml);

}//class
