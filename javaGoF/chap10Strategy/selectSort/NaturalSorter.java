package javaGoF.chap10Strategy.selectSort;

public class NaturalSorter<T> implements ISorter<T> {

    @Override
    @SuppressWarnings("unchecked")
    public void sort(Comparable<T>[] data) {

        for(int i = 0; i < (data.length - 1); i++) {
            int min = i;
            for(int j = (i + 1); j < data.length; j++) {
                if (data[min].compareTo((T) data[j]) > 0) {
                    min = j;
                }
            }//for j

            Comparable<T> temp = data[min];
            data[min] = data[i];
            data[i] = temp;
        }//for i
    }//sort()

}//class
