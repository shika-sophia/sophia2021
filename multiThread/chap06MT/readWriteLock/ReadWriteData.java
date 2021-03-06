package multiThread.chap06MT.readWriteLock;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReadWriteData {
    private String[] buffer;
    private final ReadWriteLock lock = new ReadWriteLock();

    public ReadWriteData(int size) {
        this.buffer = Stream.generate(() -> "*") //初期値「*」
                .limit(size)
                .toArray(String[]::new);

    }//constructor

    public String[] read() throws InterruptedException {
        lock.readLock();
        try {
            return doRead();

        } finally {
            lock.readUnlock();
        }
    }//read()


    public void write(String str) throws InterruptedException {
        lock.writeLock();
        try {
            doWrite(str);

        } finally {
            lock.writeUnlock();
        }
    }//write()

    private String[] doRead() {
        String[] newBuffer
            = Arrays.stream(buffer).toArray(String[]::new);
        slowly();

        return newBuffer;
    }//doRead()

    private void doWrite(String str) {
        buffer = IntStream.range(0, buffer.length)
                .boxed()
                .map(i -> {
                    buffer[i] = str;
                    slowly();
                    return buffer[i];
                }).toArray(String[]::new);
    }//doWrite()

    private void slowly() {
        try {
            Thread.sleep(50);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }//slowly()
}//class
