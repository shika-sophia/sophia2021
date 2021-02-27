/**
 * @title webPractice / DBviewer / MetaData.java
 * @reference 山田祥寛 『独習 Java サーバーサイド編 第２版』 翔泳社, 2013
 * @content List 4.23 / p197 / DBの metaデータを取得
 * @author shika
 * @date 2021-02-27
 */
package webPractice.DBviewer;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MetaData {
    private final String JDBC_URL =
        "jdbc:mysql://localhost:3306/practice?characterEncoding=utf-8&serverTimezone=JST";
    private final String DB_USER = "root";
    private final String DB_PASS = "root";
    private Connection conn;
    //private PreparedStatement ps;

    public MetaData() throws SQLException {
        conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
    }//constructor

    @SuppressWarnings("unused")
    public void readMeta() throws SQLException {
        DatabaseMetaData meta = conn.getMetaData();

        //getTables(catalog, schemaPattern, tableNamePattern, types)
        //getColumns(catalog, schemaPattern, tableNamePattern, columnNamePattern)
        ResultSet showDb = meta.getCatalogs();
        ResultSet showTb = meta.getTables("practice", "%", "%", null);
        ResultSet showCol = meta.getColumns("practice","%", "%", "%");

        List<String> databaseList = printResult(showDb, "TABLE_CAT");
        List<String> tableList = printResult(showTb, "TABLE_NAME");
        List<String> clumnList = printResult(showCol, "COLUMN_NAME");
        List<String> typeList = printResult(showCol, "TYPE_NAME");
    }//readMeta()

    private List<String> printResult(ResultSet rs, String key)
            throws SQLException {
        List<String> list = new ArrayList<>();
        while(rs.next()) {
            list.add(rs.getString(key));
        }

        System.out.println(key + ": " + list);
        System.out.println();
        return list;
    }//printResult()

    public static void main(String[] args) {
        try {
            new MetaData().readMeta();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//main()
}//class

/*
TABLE_CAT: [information_schema, library, mysql,
performance_schema, practice, puzzle, sakila, sys, world]

TABLE_NAME: [calendar_memo, mutter, mutter_user, student_tb,
 個体識別, 入退室管理, 取引, 取引事由, 口座, 廃止口座, 成績表,
 支店, 気象観測, 社員, 部署, 都道府県, 頭数集計]

COLUMN_NAME: [ID, MEMO, DATE, MUTTER_ID, NAME, USER_ID,
 MUTTER, DATETIME, USER_ID, NAME, PASS, MAIL, id, name,
  gender, 個体識別番号, 出生日, 雌雄コード, 母牛番号, 品種コード,
   飼育県, 日付, 退室, 社員名, 事由区分, 取引番号, 取引事由ID,
   日付, 口座番号, 入金額, 出金額, 取引事由ID, 取引事由名, 口座番号,
   名義, 種別, 残高, 更新日, 口座番号, 名義, 種別, 解約時残高, 解約日,
   学籍番号, 学生名, 法学, 経済学, 哲学, 情報理論, 外国語, 総合成績,
   支店ID, 名前, 支店長ID, 月, 降水量, 最高気温, 最低気温, 湿度, 社員番号,
   名前, 生年月日, 部署ID, 上司ID, 勤務地ID, 部署ID, 名前, 本部拠点ID, コード,
   地域, 都道府県名, 県庁所在地, 面積, 飼育県, 頭数]

TYPE_NAME: []

【考察】 2021-02-27
show databases; show tables;まではいいとして、
列名は practiceデータベースの全tbの列が出てくる。

getColumns()の引数で tb名を指定すべき。
「%」はワイルドカードで 0文字以上の文字列を表す。

上記のように DriverManger経由で Connectすると、
javaスタートでもDBにアクセスできた。

"TYPE_NAME"は型名が出るはずだけど(p201)、
なぜか出てこない。
*/