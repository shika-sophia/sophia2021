/**
 * @title webPractice / iTextPdf / PdfEncryptServlet.java
 * @reference 山田祥寛 『独習 Java サーバーサイド編 第２版』 翔泳社, 2013
 * @content 第９章 外部ライブラリ / List 9-10
 * @content PdfEncryptServlet / PDF文書のセキュリティ情報を設定
 * @deploy 【iText】 /WEB-INF/lib/itextpdf-x.x.x.jar
 * @deploy 【iText】 /WEB-INF/lib/itextpdf-asian-x.x.x.jar
 *         https://itextpdf.com/en/resources/downloads
 * @deploy 【BouncyCastle】 /WEB-INF/lib/bcprov-jdk15on-xxx.jar
 *         https://bouncycastle.org/latest_releases.html
 *
 * @see resultPdfEncrypt.jpg
 * @author shika
 * @date 2021-07-23
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

@WebServlet("/PdfEncryptServlet")
public class PdfEncryptServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Document doc = new Document(
                    PageSize.A4, 50, 20, 270, 20);
            PdfWriter writer = PdfWriter.getInstance(
                    doc, response.getOutputStream());
            writer.setEncryption("selfjsp".getBytes(), "selfjsp".getBytes(),
                PdfWriter.ALLOW_DEGRADED_PRINTING | PdfWriter.ALLOW_COPY,
                PdfWriter.STANDARD_ENCRYPTION_128);

            doc.open();
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
