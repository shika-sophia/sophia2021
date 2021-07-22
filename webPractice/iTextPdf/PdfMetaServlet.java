/**
 * @title webPractice / iTextPdf / PdfMetaServlet.java
 * @reference 山田祥寛 『独習 Java サーバーサイド編 第２版』 翔泳社, 2013
 * @content 第９章 外部ライブラリ / List 9-9
 * @content PdfMetaServlet / PDF文書の属性を設定
 * @deploy 【iText】 /WEB-INF/lib/itextpdf-x.x.x.jar
 * @deploy 【iText】 /WEB-INF/lib/itextpdf-asian-x.x.x.jar
 *         https://itextpdf.com/en/resources/downloads
 * @deploy 【BouncyCastle】 /WEB-INF/lib/bcprov-jdk15on-xxx.jar
 *         https://bouncycastle.org/latest_releases.html
 *
 * @see resultPdfMeta.jpg
 * @author shika
 * @date 2021-07-22
 */

package webPractice.iTextPdf;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@WebServlet("/PdfMetaServlet")
public class PdfMetaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Document doc = new Document(
                    PageSize.A4, 50, 20, 270, 20);
            @SuppressWarnings("unused")
            PdfWriter writer = PdfWriter.getInstance(
                    doc, response.getOutputStream());
            doc.addTitle("iText Sample"); //ウインドウのTitle
            doc.addAuthor("shika");       //著者
            doc.addSubject("SubTitle");   //文書の主題
            doc.addCreator("iText");      //アプリケーション
            doc.addKeywords("iText, JSP, Servlet");
            doc.addCreationDate();        //現在の日時
            doc.open();
//            Font font = new Font(
//                    BaseFont.createFont(
//                        "HeiseiKakuGo-W5",
//                        "UniJIS-UCS2-H",
//                        BaseFont.NOT_EMBEDDED),
//                    18, Font.BOLD);
//            doc.add(new Paragraph("Hello, iText", font));
            doc.add(new Paragraph("Hello, iText"));
            doc.close();
        } catch (DocumentException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }

    }//doGet()

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }//doPost()

}//class
