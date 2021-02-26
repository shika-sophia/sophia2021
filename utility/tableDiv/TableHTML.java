package utility.tableDiv;

import java.util.List;

public class TableHTML extends AbsTableData {

    public TableHTML() { }

    public TableHTML(
            List<String> columnList, List<List<String>> valueLists) {
        super(columnList, valueLists);
    }

    public String buildTableHTML() {
        var bld = new StringBuilder(dataLength);
        bld.append("<table border='1'> \n");

        //---- build columnName ----
        bld.append("<tr> \n  ");
        columnList.stream()
            .map(s -> "<th>" + s + "</th>")
            .forEach(s -> bld.append(s));
        bld.append("\n</tr> \n");

        // ---- build rowValues ----
        for (List<String> rowList : valueLists) {
            bld.append("<tr> \n  ");
            rowList.stream()
                .map(s -> "<td>" + s + "</td>")
                .forEach(bld::append);
            bld.append("\n</tr> \n");
        }//for valueLists

        bld.append("</table>");
        System.out.println("dataLength: " + dataLength);
        System.out.println("length: " + bld.length());
        setTableHtml(bld.toString());
        return bld.toString();
    }//buildTableHTML

    @Override
    protected void setTableHtml(String tableHtml) {
        super.tableHtml = tableHtml;
    }

    //====== Test main() ======
    public static void main(String[] args) {
        List<String> columnList = List.of("id", "name", "adress");
        List<String> rowList1 = List.of("1", "Alice", "Alaska");
        List<String> rowList2 = List.of("2", "Bobby", "Britain");
        List<String> rowList3 = List.of("3", "Charry", "Canada");
        List<List<String>> valueLists = List.of(
                rowList1, rowList2, rowList3);

        var here = new TableHTML(columnList, valueLists);
        String tableHtml = here.buildTableHTML();
        System.out.println(tableHtml);
    }//main()
}//class

/*
//====== Test columnList.stream() ======
dataLength: 276
length: 251
<table  border='1'>
<tr>
  <th>id</th><th>name</th><th>adress</th>
</tr>
<tr>
  <td>1</td><td>Alice</td><td>Alaska</td>
</tr>
<tr>
  <td>2</td><td>Bobby</td><td>Britain</td>
</tr>
<tr>
  <td>3</td><td>Charry</td><td>Canada</td>
</tr>
</table>

*/
