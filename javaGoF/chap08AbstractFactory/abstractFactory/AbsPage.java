package javaGoF.chap08AbstractFactory.abstractFactory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbsPage {
    protected String title;
    protected String author;
    protected List<AbsItem> contentList = new ArrayList<>();

    public AbsPage(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void addContent(AbsItem item) {
        contentList.add(item);
    }//addContent()

    public void output() {
        String className = System.getProperty("sun.java.command");
        String dir = "src/"
                + className.substring(0, className.lastIndexOf("."))
                .replace('.', '/');
        String fileName = title.toLowerCase() + ".html";

        try(BufferedWriter writer = new BufferedWriter(
                new FileWriter(dir + fileName))){
            writer.write(makeHtml());
            System.out.printf("%s を作成しました。\n", fileName);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }//output()

    public abstract String makeHtml();
}//class

/*
//====== Test main() of String dir ======
public static void main(String[] args) {
    var here = new AbsPage("A", "B");
    here.output();
}//main()
//System.out.println(dir);
// src/javaGoF/chap08AbstractFactory/abstractFactory
*/