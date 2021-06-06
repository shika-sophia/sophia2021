package javaGoF.chap10Strategy.selectSort;

public interface ISorter<T> {
    public abstract void sort(Comparable<T>[] data);
}//interface
