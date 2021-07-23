/**
 * @title webPractice / iTextPdf / PdfTableServlet.java
 * @reference 山田祥寛 『独習 Java サーバーサイド編 第２版』 翔泳社, 2013
 * @content 第９章 外部ライブラリ / List 9-11
 * @content PdfTableServlet / PDF文書に Tableを表示
 *          Table タイトル行
 *          Table データ行 / DBからデータ取得(未配置)
 *
 * @deploy 【iText】 /WEB-INF/lib/itextpdf-x.x.x.jar
 * @deploy 【iText】 /WEB-INF/lib/itextpdf-asian-x.x.x.jar
 *         https://itextpdf.com/en/resources/downloads
 * @deploy 【BouncyCastle】 /WEB-INF/lib/bcprov-jdk15on-xxx.jar
 *         https://bouncycastle.org/latest_releases.html
 *
 * @author shika
 * @date 2021-07-24
 */

package webPractice.iTextPdf;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@WebServlet("/PdfTableServlet")
public class PdfTableServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Document doc = new Document(
                    PageSize.A4, 50, 20, 50, 20);
            @SuppressWarnings("unused")
            PdfWriter writer = PdfWriter.getInstance(
                    doc, response.getOutputStream());
            doc.open();
//	        Font fontTitle = new Font(
//	            BaseFont.createFont(
//	                "HeiseiKakuGo-W5",
//	                "UniJIS-UCS2-H",
//	                BaseFont.NOT_EMBEDDED),
//	            11, Font.BOLD);
//
//	        Font fontData = new Font(
//            BaseFont.createFont(
//                "HeiseiKakuGo-W5",
//                "UniJIS-UCS2-H",
//                BaseFont.NOT_EMBEDDED),
//            10, Font.BOLD);

            //---- Table タイトル行 ----
            PdfPTable table = new PdfPTable(4);
            int[] widthAry = {55, 10, 20, 15};
            String[] thAry = {"書名","価格","出版社","刊行日"};
            table.setWidths(widthAry);

            for(int i = 0; i < thAry.length; i++) {
                PdfPCell cell = new PdfPCell(new Phrase(thAry[i]));
                //PdfPCell cell = new PdfPCell(new Phrase(thAry[i], fontTitle));
                cell.setHorizontalAlignment(PdfPTable.ALIGN_CENTER);
                table.addCell(cell);
            }//for
            table.setHeaderRows(1);

            //---- Table データ行 / DBからデータ取得(未配置) ----
            String sql = "SELECT title, price, publish, date "
                    + "FROM book_tb ORDER BY date DESC";
            Context context = new InitialContext();
            DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/selfjsp");
            conn = ds.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();

            while(rs.next()) {
                for(int i = 0; i < meta.getColumnCount(); i++) {
                    PdfPCell cellData = new PdfPCell(new Phrase(rs.getString(i)));
                    //PdfPCell cellData = new PdfPCell(new Phrase(rs.getString(i), fontData));
                    table.addCell(cellData);
                }//for
            }//while

            doc.add(table);
            doc.close();

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(rs != null) { rs.close(); }
                if(ps != null) { ps.close(); }
                if(conn != null) { conn.close(); }
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }//try-catch-finally

    }//doGet()

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }//doPost()

}//class
