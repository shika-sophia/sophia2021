package javaGoF.chap07jgBuilder.abstractBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class HtmlGofBuilder extends GofBuilder {
    private String fileName;
    private String dir = "src/javaGoF/chap07jgBuilder/abstractBuilder/";
    private PrintWriter writer;

    @Override
    public void makeTitle(String title) {
        fileName = title + ".html";
        try {
            writer = new PrintWriter(new FileWriter(dir + fileName));

        } catch(IOException e) {
            e.printStackTrace();
        }

        writer.println(
            "<html><head><title>" + title + "</title></head><body>");
        writer.println("<h1>" + title + "</h1>");
    }//makeTitle()

    @Override
    public void makeString(String str) {
        writer.println("<p>" + str + "</p>");
    }//makeString()

    @Override
    public void makeItem(String[] item) {
        writer.println("<ul>");
        Arrays.stream(item)
              .forEach(s -> writer.println("<li>" + s + "</li>"));
        writer.println("</ul>");
    }//makeItem()

    @Override
    public void close() {
        writer.println("</body></html>");
        writer.close();
    }//close()

    public String getResult() {
        return fileName;
    }//getResult()
}//class
