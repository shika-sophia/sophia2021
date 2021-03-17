package multiThread.chap09MT.webReader;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class SyncContentImpl implements AbsContent {
    protected byte[] contentByteAry;

    public SyncContentImpl(String urlStr) {
        readContent(urlStr);
    }//constructor

    protected void readContent(String urlStr) {
    	System.out.printf(
			"%s: Getting form %s \n", Thread.currentThread().getName(), urlStr);
    	
        try {
            URL url = new URL(urlStr);
            DataInputStream in = new DataInputStream(url.openStream());

            byte[] buffer = new byte[1];
            int index = 0;

            try {
                while(true) {
                    int c = in.readUnsignedByte();

                    if(buffer.length <= index) {
                        byte[] largerBuffer = new byte[buffer.length * 2];
                        System.arraycopy(buffer, 0, largerBuffer, 0, index);
                        buffer = largerBuffer;
                        //System.out.println("Enlarging buffer to " + buffer.length);
                    }//if

                    buffer[index++] = (byte) c;
                    //System.out.printf("Getting %d bytes form %s \n", index, urlStr);
                }//while loop

            } catch(EOFException e) {
               // e.printStackTrace();
            } finally {
                in.close();
            }
            contentByteAry = new byte[index];
            System.arraycopy(buffer, 0, contentByteAry, 0, index);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//readContent

    @Override
    public byte[] getByteAry() {
        return contentByteAry;
    }

}//class
