package multiThread.chap12MT.activeObjectPattern.activeObject;

import java.math.BigInteger;

public class Servant implements ActObj {

    @Override
    public AbsResult<String> makeString(int count, char fillchar) {
        char[] buffer = new char[count];

        for(int i = 0; i < count; i++) {
            buffer[i] = fillchar;

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }//for

        return new RealResult<String>(new String(buffer)) ;
    }//makeString()

    @Override
    public void showString(String str) {
        System.out.println("showString(): " + str);

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }//showString()

    @Override
    public AbsResult<String> add(String x, String y) {
        String z = "";
        try {
            var xBig = new BigInteger(x);
            var yBig = new BigInteger(y);
            var resultXY = xBig.add(yBig);
            z = resultXY.toString();
        } catch (NumberFormatException e) {
            z = null;
        }

        return new RealResult<String>(z) ;
    }//add()

}//class
