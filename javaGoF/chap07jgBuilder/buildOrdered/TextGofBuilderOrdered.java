package javaGoF.chap07jgBuilder.buildOrdered;

import java.util.Arrays;

public class TextGofBuilderOrdered extends GofBuilderOrdered {
    private final StringBuffer buffer = new StringBuffer();

    @Override
    public void buildTitle(String title) {
        buffer.append("===================\n");
        buffer.append("『" + title + "』\n");
        buffer.append("\n");
    }//buildTitle()

    @Override
    public void buildString(String str) {
        buffer.append("■" + str + "\n");
        buffer.append("\n");
    }//buildString()

    @Override
    public void buildItem(String[] item) {
        Arrays.stream(item)
              .map(s -> s + "\n")
              .forEach(buffer::append);
        buffer.append("\n");
    }//buildItem()

    @Override
    public void buildDone() {
        buffer.append("===================\n");
    }//buildDone()

    public String getResult() {
        return buffer.toString();
    }//getResult()
}//class
