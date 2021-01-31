package utility.ioFileDiv;

public class BuildFilePage extends BuildJavaDoc {

    public void buildFilePage() {
        readPathFile(filePath);
        //buildJavaDoc(reference);を完了させてからここを起動する。

        if(javaDoc == null) {
            javaDoc = "/** \n * \n */";
        }

        var bld = new StringBuilder();
        bld.append(javaDoc);
        bld.append(readText);

        writePathFile(filePath, bld.toString());
    }//buildFilePage()
}//class
