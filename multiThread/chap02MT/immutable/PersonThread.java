package multiThread.chap02MT.immutable;

public class PersonThread extends Thread {
    private PersonFinal person;

    public PersonThread(PersonFinal person) {
        this.person = person;
    }

    public void run() {
        while(true) {
            System.out.println(
                Thread.currentThread().getName() + person.toString());
        }//while loop
    }//run()
}//class
