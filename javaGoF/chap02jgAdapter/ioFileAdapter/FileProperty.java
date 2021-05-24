package javaGoF.chap02jgAdapter.ioFileAdapter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class FileProperty implements IFileIO {
    private final Properties property = new Properties();

    @Override
    public void readFile(String fileName) throws IOException {
        FileInputStream in = new FileInputStream(fileName);
        property.load(in);
        in.close();
    }//readFile

    @Override
    public void writeFile(String fileName) throws IOException {
        FileOutputStream out = new FileOutputStream(fileName);
        property.store(out, "written by FileProperty");
        out.close();
    }//writeFile()

    @Override
    public String getValue(String key) {
        return property.getProperty(key);
    }

    @Override
    public void setValue(String key, String value) {
        property.setProperty(key, value);
    }

}//class
