/**
 * @title utility / ioFileDiv / BuildJavaDoc.java
 * @content javaDocを自動生成
 * @reference 結城浩『Java言語プログラミングレッスン(下)』SB Creative,2012 / p237
 * @author shika
 * @date 2021-02-01
 */
package utility.ioFileDiv;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BuildJavaDoc extends WriteFile {

    public BuildJavaDoc() {}

    public void buildJavaDoc(String reference, String content) {
        var bld = new StringBuilder(100);

        bld.append("/** \n");
        bld.append(String.format(" * @title %s \n"
            ,filePath.substring(filePath.indexOf("src") + 4)
            .replace("\\", " / ")));
        bld.append(" * @reference ").append(reference).append("\n");
        bld.append(" * @content ").append(content).append("\n");
        bld.append(" * @author shika \n");
        bld.append(String.format(" * @date %s \n"
            , LocalDate.now()
            .format(DateTimeFormatter.ofPattern("y-MM-dd"))));
        bld.append(" */ \n");

        setJavaDoc(bld.toString());
    }//buildJavaDoc()

    //====== setter ======
    @Override
    protected void setJavaDoc(String javaDoc) {
        super.javaDoc = javaDoc;
    }//setJavaDoc()

    public void appendJavaDoc(String appendix) {
        super.javaDoc = javaDoc + appendix;
    }//appendJavaDoc
}//class
