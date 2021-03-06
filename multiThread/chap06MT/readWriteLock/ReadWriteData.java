package multiThread.chap06MT.readWriteLock;

import java.util.Arrays;
import java.util.stream.Stream;

public class ReadWriteData {
    protected String[] buffer;
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

    protected String[] doRead() {
        String[] newBuffer
            = Arrays.stream(buffer).toArray(String[]::new);
        slowly();

        return newBuffer;
    }//doRead()

    protected void doWrite(String str) {
        for(int i = 0; i < buffer.length; i++) {
            buffer[i] = str;
            slowly();
        }//for
    }//doWrite()

    private void slowly() {
        try {
            Thread.sleep(50);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }//slowly()
}//class

/*
====== doWrite() Stream version ======
protected void doWrite(String str) {
    buffer = IntStream.range(0, buffer.length)
            .boxed()
            .map(i -> {
                buffer[i] = str;
                slowly();
                return buffer[i];
            }).toArray(String[]::new);
}//doWrite()

【考察】
Streamによって、for文を使わずに bufferへ書き込めるけど、
new String[]をして代入する方法しかなさそう。
要素の代入であれば、毎回 新しい配列インスタンスを作るより、
for文を使うのがいいかも。

====== doWrite() Arrays.fill() version ======
protected void doWrite(String str) {
    Arrays.fill(buffer, str);
}//doWrite()

【考察】
同じ値の代入なら、Arrays.fill()を使うほうがシンプル。
ただし、値の代入ごとに slowly() を呼べないので、やっぱり for文にしよう。

    【◆Arrays.fill()】
    public static void fill(Object[] a, Object val) {
        for (int i = 0, len = a.length; i < len; i++)
            a[i] = val;
        }
    }//fill()
*/
