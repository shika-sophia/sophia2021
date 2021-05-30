package javaGoF.chap07jgBuilder.interfaceBuilder;

import java.util.Arrays;

public class TextIGofBuilder implements IGofBuilder {
    private final StringBuffer buffer = new StringBuffer();

    @Override
    public void makeTitle(String title) {
        buffer.append("===================\n");
        buffer.append("『" + title + "』\n");
        buffer.append("\n");
    }//makeTitle()

    @Override
    public void makeString(String str) {
        buffer.append("■" + str + "\n");
        buffer.append("\n");
    }//makeString()

    @Override
    public void makeItem(String[] item) {
        Arrays.stream(item)
              .map(s -> s + "\n")
              .forEach(buffer::append);
        buffer.append("\n");
    }//makeItem()

    @Override
    public void close() {
        buffer.append("===================\n");
    }//close()

    public String getResult() {
        return buffer.toString();
    }//getResult()
}//class
