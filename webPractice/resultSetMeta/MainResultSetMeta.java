/**
 * @title webPractice / resultSetMeta / MainResultSetMeta.java
 * @reference 山田祥寛 『独習 Java サーバーサイド編 第２版』 翔泳社, 2013
 * @content 第４章 DBとの連携 / p202 / List 4-24
 * @content ResultSetMetaDataによるメタデータの抽出により、
 *          個別のテーブルに依存しない、汎用的なテーブルを扱うプログラム
 * @content ResultSet.CONCUR_UPDATE
 *          rs.updateString(), rs.updateRow()によって DBの PASS値を更新
 *          tel値 -> hashCode() -> Integer.toHexString() -> PASS列の更新
 * @see imageResultSetMeta.jpg
 * @relevant javaGold.se11Violet.sampleCode.chap10VT
 * @author shika
 * @date 2021-04-16
 */
package webPractice.resultSetMeta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javaGold.se11Violet.sampleCode.chap10VT.DbAccess;
import utility.tableDiv.TableSW;

public class MainResultSetMeta {

    public static void main(String[] args) {
        String sql = "SELECT * FROM SELFLEARN ORDER BY ID";

        //---- connection DB, prepare add execute SQL ----
        try(Connection conn = DbAccess.getConnect();
            PreparedStatement ps = conn.prepareStatement(
                    sql,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery(); ) {

            //---- definition ----
            ResultSetMetaData rsMeta = rs.getMetaData();
            int columnNum =rsMeta.getColumnCount();
            int rowNum = rs.getRow();
            List<String> columnList = new ArrayList<>(columnNum);
            List<List<String>> valueLists = new ArrayList<>(rowNum);

            //---- build columnList ----
            for(int i = 1; i <= columnNum; i++) {
                columnList.add(rsMeta.getColumnName(i));
            }//for

            //---- build rowList, valueLists ----
            while(rs.next()) {
                //update pass as hashCode
                buildPass(rs);

                //build rawList
                List<String> rowList = new ArrayList<>(columnNum);

                for(int i = 1; i <= columnNum; i++) {
                    rowList.add(rs.getString(i));
                }//for

                valueLists.add(rowList);
            }//while

//            //---- test print ----
//            System.out.println("columnList: " + columnList);
//            for (List<String> rowList : valueLists) {
//                System.out.println("rowList: " + rowList);
//            }//for

            //---- print table ----
            TableSW table = new TableSW(columnList, valueLists);
            table.run();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//main()

    //while(rs.next){ }内から、PASSを更新
    private static void buildPass(ResultSet rs) throws SQLException {
        //telを hashCodeの16進数に変更
        String tel = rs.getString("TEL");
        String telCode = Integer.toHexString(tel.hashCode());

        //ResultSet経由で 元のDBを更新。PASS列の値を変更
        if(telCode != rs.getString("PASS")) {
            rs.updateString("PASS", telCode);
            rs.updateRow();
        }
    }//buildPass()

}//class

/*
//====== Result Main ======
@see imageResultSetMata.jpg

columnList: [ID, NAME, PASS, ADDRESS, TEL, EMAIL]
rowList: [1, 山田太郎, 1111, 東京都東京市, 03-9999-xxxx, yamada@wings.masn.to]
rowList: [2, 鈴木浩二, 1111, 神奈川県横浜市, 045-1111-xxxx, suzuki@wings.msn.to]
rowList: [3, 井上春子, 1111, 埼玉県浦安市, 04-2222-xxxx, inoue@wings.msn.to]
rowList: [4, 佐々木のぞみ, 1111, 千葉県松戸市, 04-3333-xxxx, sasaki@wings.msn.to]
rowList: [5, 川本健三, 1111, 埼玉県本庄市, 04-4444-xxxx, kawamoto@wings.msn.to]
rowList: [6, 佐藤洋一, 1111, 東京都東京市, 03-5555-xxxx, satou@wings.msn.to]
rowList: [7, 田中洋子, 1111, 埼玉県武蔵野市, 04-6666-xxxx, tanaka@wings.msn.to]
rowList: [8, 中川洋一, 1111, 神奈川県横浜市, 04-7777-xxxx, nakagawa@wings.msn.to]
rowList: [9, 松原ゆり, 1111, 東京都町田市, 04-8888-xxxx, matsubara@wings.msn.to]
rowList: [10, 香原美穂, 1111, 神奈川県横浜市, 04-9999-xxxx, kouhara@wings.msn.to]
 */
/*
//====== Test buildPass() ======
columnList: [ID, NAME, PASS, ADDRESS, TEL, EMAIL]
rowList: [1, 山田太郎, 5b612223, 東京都東京市, 03-9999-xxxx, yamada@wings.masn.to]
rowList: [2, 鈴木浩二, c67cd751, 神奈川県横浜市, 045-1111-xxxx, suzuki@wings.msn.to]
rowList: [3, 井上春子, 8d0106a4, 埼玉県浦安市, 04-2222-xxxx, inoue@wings.msn.to]
rowList: [4, 佐々木のぞみ, bfc1b664, 千葉県松戸市, 04-3333-xxxx, sasaki@wings.msn.to]
rowList: [5, 川本健三, f2826624, 埼玉県本庄市, 04-4444-xxxx, kawamoto@wings.msn.to]
rowList: [6, 佐藤洋一, 905e6323, 東京都東京市, 03-5555-xxxx, satou@wings.msn.to]
rowList: [7, 田中洋子, 5803c5a4, 埼玉県武蔵野市, 04-6666-xxxx, tanaka@wings.msn.to]
rowList: [8, 中川洋一, 8ac47564, 神奈川県横浜市, 04-7777-xxxx, nakagawa@wings.msn.to]
rowList: [9, 松原ゆり, bd852524, 東京都町田市, 04-8888-xxxx, matsubara@wings.msn.to]
rowList: [10, 香原美穂, f045d4e4, 神奈川県横浜市, 04-9999-xxxx, kouhara@wings.msn.to]

select * from selflearn;
+----+--------------------+----------+-----------------------+---------------+------------------------+
| ID | NAME               | PASS     | ADDRESS               | TEL           | EMAIL                  |
+----+--------------------+----------+-----------------------+---------------+------------------------+
|  1 | 山田太郎           | 5b612223 | 東京都東京 市          | 03-9999-xxxx  | yamada@wings.masn.to   |
|  2 | 鈴木浩二           | c67cd751 | 神奈川県横 浜市        | 045-1111-xxxx | suzuki@wings.msn.to    |
|  3 | 井上春子           | 8d0106a4 | 埼玉県浦安 市          | 04-2222-xxxx  | inoue@wings.msn.to     |
|  4 | 佐々木のぞみ       | bfc1b664 | 千葉県松戸 市          | 04-3333-xxxx  | sasaki@wings.msn.to    |
|  5 | 川本健三           | f2826624 | 埼玉県本庄 市          | 04-4444-xxxx  | kawamoto@wings.msn.to  |
|  6 | 佐藤洋一           | 905e6323 | 東京都東京 市          | 03-5555-xxxx  | satou@wings.msn.to     |
|  7 | 田中洋子           | 5803c5a4 | 埼玉県武蔵 野市        | 04-6666-xxxx  | tanaka@wings.msn.to    |
|  8 | 中川洋一           | 8ac47564 | 神奈川県横 浜市        | 04-7777-xxxx  | nakagawa@wings.msn.to  |
|  9 | 松原ゆり           | bd852524 | 東京都町田 市          | 04-8888-xxxx  | matsubara@wings.msn.to |
| 10 | 香原美穂           | f045d4e4 | 神奈川県横 浜市        | 04-9999-xxxx  | kouhara@wings.msn.to   |
+----+--------------------+----------+-----------------------+---------------+------------------------+
*/

/*
//====== 失敗作 / failure code ======
//---- build columnList ----
for(int i = 1; i < columnNum; i++) {
    columnList.add(rsMeta.getColumnName(i));
}//for

と同様の処理を Streamで試みるが
IntStream.range(1, columnNum)
    .mapToObj(i -> rsMeta.getColumnName(i))
    .forEach(columnList::add);

【考察】
rsMeta.getColumnName()は thows SQLException
Streamの外側に 同例外のcatch節があるが、Stream内にないとダメらしい。
mapToObj()内に try-catchすればコンパイル通るが
for文より長くなっては Streamを利用する意味がなくなるので不採用。
*/
/*
//---- build rowList, valueLists ----
while(rs.next()) {
    rowList.clear();

    for(int i = 1; i <= columnNum; i++) {
        rowList.add(rs.getString(i));
    }//for

    valueLists.add(rowList);
}//while

columnList: [ID, NAME, PASS, ADDRESS, TEL]
rowList: [10, 香原美穂, 1111, 神奈川県横浜市, 04-9999-xxxx]
rowList: [10, 香原美穂, 1111, 神奈川県横浜市, 04-9999-xxxx]
rowList: [10, 香原美穂, 1111, 神奈川県横浜市, 04-9999-xxxx]
rowList: [10, 香原美穂, 1111, 神奈川県横浜市, 04-9999-xxxx]
rowList: [10, 香原美穂, 1111, 神奈川県横浜市, 04-9999-xxxx]
rowList: [10, 香原美穂, 1111, 神奈川県横浜市, 04-9999-xxxx]
rowList: [10, 香原美穂, 1111, 神奈川県横浜市, 04-9999-xxxx]
rowList: [10, 香原美穂, 1111, 神奈川県横浜市, 04-9999-xxxx]
rowList: [10, 香原美穂, 1111, 神奈川県横浜市, 04-9999-xxxx]
rowList: [10, 香原美穂, 1111, 神奈川県横浜市, 04-9999-xxxx]

【考察】
rowList.clear()をして毎回 新しい rowListを buildしているが、
valueLists.add(rowList); に代入しているのは
「同一の rowList参照先」なので、最終回のdataが 10行分入ることになる。
while内で毎回 new rowListすれば、解決。
*/