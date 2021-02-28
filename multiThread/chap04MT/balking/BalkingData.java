package multiThread.chap04MT.balking;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BalkingData {
    private final String fileName;
    private String content;
    private boolean changed;

    public BalkingData(String fileName, String content) {
        this.fileName = fileName;
        this.content = content;
        this.changed = true;
    }

    public synchronized void change(String newContent) {
        this.content = newContent;
        this.changed = true;
    }//change()

    public synchronized void save() throws IOException {
        if(changed) {
            doSave();
            changed = false;
        } else {
            return;
        }
    }//save()

    private void doSave() {
        System.out.println(Thread.currentThread().getName()
            + " calls doSave(), content = " + content);

        try(var writer = Files.newBufferedWriter(Path.of(fileName))){
            writer.write(content);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }//doSave()

}//class
