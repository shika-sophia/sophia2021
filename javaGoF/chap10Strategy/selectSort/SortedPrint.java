package javaGoF.chap10Strategy.selectSort;

import java.util.Arrays;

public class SortedPrint<T> {
    private Comparable<T>[] data;
    private ISorter<T> sorter;

    public SortedPrint(
            Comparable<T>[] data, ISorter<T> sorter) {
        this.data = data;
        this.sorter = sorter;
    }

    public void execute() {
        print();
        sorter.sort(data);
        print();
    }//execute()

    private void print() {
        Arrays.stream(data)
            .map(s -> s + ", ")
            .forEachOrdered(System.out::print);
        System.out.println();
    }//print()


}//class
