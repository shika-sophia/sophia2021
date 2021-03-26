package multiThread.chap12MT.activeObjectPattern.activeObject;

class Servant implements ActObj {

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

}//class
