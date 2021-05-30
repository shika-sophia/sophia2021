package javaGoF.chap07jgBuilder.buildOrdered;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class HtmlGofBuilderOrdered extends GofBuilderOrdered {
    private String fileName;
    private String dir = "src/javaGoF/chap07jgBuilder/buildOrdered/";
    private PrintWriter writer;

    @Override
    public void buildTitle(String title) {
        fileName = title + ".html";
        try {
            writer = new PrintWriter(new FileWriter(dir + fileName));

        } catch(IOException e) {
            e.printStackTrace();
        }

        writer.println(
            "<html><head><title>" + title + "</title></head><body>");
        writer.println("<h1>" + title + "</h1>");
    }//buildTitle()

    @Override
    public void buildString(String str) {
        writer.println("<p>" + str + "</p>");
    }//buildString()

    @Override
    public void buildItem(String[] item) {
        writer.println("<ul>");
        Arrays.stream(item)
              .forEach(s -> writer.println("<li>" + s + "</li>"));
        writer.println("</ul>");
    }//buildItem()

    @Override
    public void buildDone() {
        writer.println("</body></html>");
        writer.close();
    }//buildDone()

    public String getResult() {
        return fileName;
    }//getResult()
}//class
