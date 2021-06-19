package javaGoF.chap17Observer.numberObserver;

public class DigitObserver implements INumberObserver {

    @Override
    public void update(AbsNumberGenerator generator) {
        System.out.println(
            "DigitObserver: " + generator.getNumber());

        try {
            Thread.sleep(100);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }//update()

}//class
