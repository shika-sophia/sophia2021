/**
 * @title TemplateServlet.java
 * @reference 山田祥寛 『独習 Java サーバーサイド編 第２版』 翔泳社, 2013
 * @content 第９章 外部ライブラリ / List 9-11
 * @content PdfTemplateServlet / PDF文書をテンプレートとして読み込み表示
 *          PdfReader.getInportedPage()
 *          PdfWriter.getInstance()
 *          PdfImportedPage writer.getImportedPage(PdfReder, int page);
            PdfContentByte writer.getDirectContent();
            pcb.addTemplate(PdfImpotedPage, int x?, int y?);

 * @file   /WebContent/pdf/resultBasic.pdf
 * @deploy 【iText】 /WEB-INF/lib/itextpdf-x.x.x.jar
 * @deploy 【iText】 /WEB-INF/lib/itextpdf-asian-x.x.x.jar
 *         https://itextpdf.com/en/resources/downloads
 * @deploy 【BouncyCastle】 /WEB-INF/lib/bcprov-jdk15on-xxx.jar
 *         https://bouncycastle.org/latest_releases.html
 *
 * @see resultPdfTemplate.jpg
 * @author shika
 * @date 2021-07-25
 */
package webPractice.iTextPdf;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;

@WebServlet("/PdfTemplateServlet")
public class PdfTemplateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ServletContext app = this.getServletContext();
            Document doc = new Document(PageSize.A4, 50, 20, 290, 20);
            PdfWriter writer = PdfWriter.getInstance(doc, response.getOutputStream());
            doc.open();

            //pathの１ページ目を読み込み、テンプレートに適用
            PdfReader reader = new PdfReader(app.getRealPath("/pdf/resultPdfBasic.pdf"));
            PdfImportedPage imPage = writer.getImportedPage(reader, 1);
            PdfContentByte pcb = writer.getDirectContent();
            pcb.addTemplate(imPage, 0, 0);

            //新規文書
            doc.add(new Paragraph("new Text"));
            doc.close();

        } catch(DocumentException e) {
            e.printStackTrace();
            new ServletException(e);
        }

    }//doGet()

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }//doPost()

}//class

/*
【考察】
Path ServletContext.getRealPath(String path)
pathは "src/webPractice/iText/resultPdfBasic.pdf"は読み込めず
WebContent(=アプリルート)"/pdf/resultPdfBasic.pdf"で読み込みできた。

app.getRealPath()をなくして、
new PdfReader("src/webPractice/iText/resultPdfBasic.pdf");では不可。
getRealPath()で WebContentルートになる様子。

読み込んだPDFをテンプレートとして、新規文書を追加できる。
@see resultPdfTemplate.jpg
*/