package javaGoF.chap02jgAdapter.ioFileAdapter;

import java.io.IOException;

public interface IFileIO {
    public abstract void
        readFile(String fileName) throws IOException;

    public abstract void
        writeFile(String fileName) throws IOException;

    public abstract String getValue(String key);
    public abstract void setValue(String key, String value);
}//interface
