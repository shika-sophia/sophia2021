package javaGoF.chap08AbstractFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainAbstractFactory {

    public static void main(String[] args) {
        //---- view selectList of Swing ----
        List<String> classNameList = new ArrayList<>(
            Arrays.asList("ListFactory", "TableFactory"));

        new SwingSelectList(classNameList);

        //---- ----
    }//main()



}//class
