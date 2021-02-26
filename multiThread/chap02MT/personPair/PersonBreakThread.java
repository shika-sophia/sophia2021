package multiThread.chap02MT.personPair;

public class PersonBreakThread extends Thread {
    private final PersonMutable mutable;

    public PersonBreakThread(PersonMutable mutable) {
        this.mutable = mutable;
    }

    public void run() {
        while(true) {
            var immutable = new PersonImmutable(mutable);

            if(immutable.getName().equals(immutable.getAddress())) {
                ;
            } else {
                System.out.printf("%s **** BROKEN **** %s \n",
                    currentThread().getName(), immutable.toString());
            }
        }//while
    }//run()
}//class PersonBreakThread
