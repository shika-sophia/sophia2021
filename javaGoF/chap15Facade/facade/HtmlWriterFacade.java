package javaGoF.chap15Facade.facade;

import java.io.IOException;
import java.io.Writer;

public class HtmlWriterFacade {
    private Writer writer;

    public HtmlWriterFacade(Writer writer) {
        this.writer = writer;
    }

    public void header(String title) throws IOException {
        var bld = new StringBuilder();
        bld.append("<html>");
        bld.append("<head>");
        bld.append(String.format("<title> %s </title>", title));
        bld.append("</head>");
        bld.append("<body> \n");
        bld.append(String.format("<h1> %s </h1> \n", title));

        writer.write(bld.toString());
    }//header()

    public void message(String msg) throws IOException {
        writer.write("<p>" + msg + "</p>");
    }//message()

    public void link(
            String url, String caption) throws IOException {
        message(String.format(
            "<a href='%s'>%s</a>", url, caption) );
    }//link()

    public void mailto(
            String mailAd, String userName) throws IOException {
        link("mailto:" + mailAd, userName);
    }//mailto()

    public void footer() throws IOException {
        writer.write("</body>");
        writer.write("</html> \n");

        writer.close();
    }//footer
}//class
