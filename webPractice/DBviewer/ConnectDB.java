/**
 * @title webPractice / DBviewer / ConnectDB.java
 * @reference 山田祥寛 『独習 Java サーバーサイド編 第２版』 翔泳社, 2013
 * @content List 4.13 / p117 / DBとの接続
 * @author shika
 * @date 2021-02-27
 */
package webPractice.DBviewer;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectDB {

    public void connectDB() {
        Connection conn = null;
        try {
            Context context = new InitialContext();
            DataSource source = (DataSource) context.lookup(
                    "java:comp/env/jdbc/practice");
            conn = source.getConnection();

        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }//connectDB()

    public static void main(String[] args) {
        new ConnectDB().connectDB();
    }//main()
}//class

/*
javax.naming.NoInitialContextException: Need to specify class name in environment or system property, or in an application resource file: java.naming.factory.initial
    at java.naming/javax.naming.spi.NamingManager.getInitialContext(NamingManager.java:685)
    at java.naming/javax.naming.InitialContext.getDefaultInitCtx(InitialContext.java:305)
    at java.naming/javax.naming.InitialContext.getURLOrDefaultInitCtx(InitialContext.java:342)
    at java.naming/javax.naming.InitialContext.lookup(InitialContext.java:409)
    at webPractice.DBviewer.ConnectDB.connectDB(ConnectDB.java:17)
    at webPractice.DBviewer.ConnectDB.main(ConnectDB.java:33)
Exception in thread "main" java.lang.NullPointerException
    at webPractice.DBviewer.ConnectDB.connectDB(ConnectDB.java:25)
    at webPractice.DBviewer.ConnectDB.main(ConnectDB.java:33)

【考察】
context.lookup():
    コンテナ(Tomcat)に登録されたデータソースを
        データベース名のキーで取得する。(p176)
    引数: "java:comp/env/jdbc/データベース名"

とあり、Tomcatの再起動が必要とのこと。
テキストのオリジナルは jspに記述しており、
Servletの「サーバーで実行」をしないと無理そう。

それを javaファイルに記述してみたが  NullPoになった。そりゃそうだ。
こんな接続方法があるのかと思い、書いてみたが・・
一応、残しておこう。
 */
