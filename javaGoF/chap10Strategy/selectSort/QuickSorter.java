package javaGoF.chap10Strategy.selectSort;

public class QuickSorter<T> implements ISorter<T> {
    private Comparable<T>[] data;

    @Override
    public void sort(Comparable<T>[] data) {
        this.data = data;
        quickSort(0, (data.length - 1));
    }//sort()

    @SuppressWarnings("unchecked")
    private void quickSort(int pre, int post) {
        int saved_pre = pre;
        int saved_post = post;
        Comparable<T> mid = data[(pre + post) / 2];

        do {
            while(data[pre].compareTo((T) mid) < 0) {
                pre++;
            }//while pre

            while(mid.compareTo((T) data[post]) < 0) {
                post--;
            }//while post

            if(pre <= post) {
                Comparable<T> temp = data[pre];
                data[pre] = data[post];
                data[post] = temp;
                pre++;
                post--;
            }
        } while(pre <= post);

        if(saved_pre < post) {
            quickSort(saved_pre, post);
        }

        if(pre < saved_post) {
            quickSort(pre, saved_post);
        }
    }//quickSort()

}//class
