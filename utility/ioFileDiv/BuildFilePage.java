package utility.ioFileDiv;

import utility.interfaceUT.IReference;

public class BuildFilePage extends BuildJavaDoc {
    public BuildFilePage() { }

    //====== javaDocの書き込み時にだけ利用 ======
    public BuildFilePage(String docContent) {
        String reference = IReference.seekRef(className);
        buildJavaDoc(reference, docContent);
        buildFilePage();
        System.out.println(className + " / javaDoc完了");
    }

    //====== javaDocの書き込み時にだけ利用 ======
    public void buildFilePage() {
        //【註】buildJavaDoc(reference);を完了させてからここを起動する。
        if(javaDoc == null) {
            javaDoc = "/** \n * \n */";
        }

        readPathFile(filePath);

        var bld = new StringBuilder();
        bld.append(javaDoc);
        bld.append(readText);

        writePathFile(filePath, bld.toString());
    }//buildFilePage()

    public void buildFilePage(String fileContent) {
        //【註】buildJavaDoc();を完了させてからここを起動する。
        if(javaDoc == null) {
            javaDoc = "/** \n * \n */";
        }

        //fileContentは引数から取得
        //readPathFile(filePath);

        var bld = new StringBuilder();
        bld.append(javaDoc);
        bld.append(readText);
        bld.append(fileContent);

        writePathFile(filePath, bld.toString());
    }//buildFilePage(String)

}//class
