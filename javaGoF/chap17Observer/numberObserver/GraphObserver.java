package javaGoF.chap17Observer.numberObserver;

import java.util.stream.Stream;

public class GraphObserver implements INumberObserver {

    @Override
    public void update(AbsNumberGenerator generator) {
        final int number = generator.getNumber();

        System.out.print("GraghObserver: ");
        Stream.generate(() -> "*")
            .limit(number)
            .forEach(System.out::print);
        System.out.println();

        try {
            Thread.sleep(100);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }//update()

}//class
