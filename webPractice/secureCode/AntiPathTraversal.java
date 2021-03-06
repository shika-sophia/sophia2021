/**
 * @title WebContent / secureCode / AntiPathTreversal.java
 * @reference 山田祥寛 『独習 Java サーバーサイド編 第２版』 翔泳社, 2013
 * @content 第10章 Security / p505 / List 10-5, 10-6
 * @content Path Traversal:
 *              Pathを遡ってより上位のディレクトリにアクセスされてしまう攻撃
 *              直接 Pathを入力させると、
 *              「http://localhost:8080/selfjsp/chap10/
 *              	ShowServlet?path=../../../../../conf/server.xml」
 *              などと入力される可能性があり、
 *              server.xmlというサーバ設定ファイルを入手できてしまう脆弱性
 * @content クエリ情報を ホワイトリスト(=公開可能なファイルのリスト)に照会し flagを立てる
 * @see PathTraversal.java
 * @author shika
 * @date 2021-05-04
 */
/*
package webPractice.secureCode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PathTraversal")
public class AntiPathTraversal extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //ファイルを格納したフォルダ
        String root = "WEB-INF/data";
        ServletContext application =this.getServletContext();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //クエリ情報 pathを取得
        String pathStr = application.getRealPath(
            root + request.getParameter("path"));

        //公開ファイル内に指定されたファイルが存在するかをチェック
        boolean flag = false;
        File fileRoot = new File(application.getRealPath("root"));

        //「/WEB-INF/data」内の全てのファイルを順に取得
        for(File f : fileRoot.listFiles()) {
            //クエリ pathと同じファイルが存在するときのみ true
            if(f.isFile() &&
                f.getName().equals(
                    request.getParameter("path"))) {
                flag = true;
                break;
            }
        }//for

        //flag == falseなら、不正と判断し例外throw
        if(!flag) {
            throw new ServletException("不正な要求です。");
        }

        try(BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(pathStr), "UTF-8")); ){

            //ファイル内容を読み込み、そのまま書き出す
            while(reader.ready()) {
                out.println(reader.readLine() + "<br />");
            }//while

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//doGet()


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }//doPost()

}//class
*/