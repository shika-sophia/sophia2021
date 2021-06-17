package javaGoF.chap15Facade.facade;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DaoFacade extends PageMakerFacade {
    protected DaoFacade() { }

    public static Properties getProperty(String dataName) {
        Properties property = new Properties();
        String dir = "src/javaGoF/chap15Facade/facade/";
        String fileName = dataName + ".txt";

        try {
            property.load(new FileInputStream(dir + fileName));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return property;
    }//getProperty()
}//class
