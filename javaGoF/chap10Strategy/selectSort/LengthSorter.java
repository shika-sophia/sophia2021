package javaGoF.chap10Strategy.selectSort;

public class LengthSorter<T> implements ISorter<T> {

    @Override
    //文字列長の昇順にソート
    public void sort(Comparable<T>[] data) {
        if(data == null || !(data[0] instanceof String)) {
            System.out.println("<!> このデータは扱えません。Stringのみ可。");
            System.exit(0);
        }

        for(int i = 0; i < (data.length - 1); i++) {
            int min = i;
            for(int j = (i + 1); j < data.length; j++) {
                if(data[min].toString().length() >
                        data[j].toString().length()) {
                    min = j;
                }
            }//for j

            Comparable<T> temp = data[min];
            data[min] = data[i];
            data[i] = temp;
        }//for i
    }//sort()

}//class

/*
//###### javaGoF/selsctSort/LengthSorter ###### 2021-06-06
public void sort(final Comparable<T>[] data) {
    Arrays.stream(data)
        .sorted((Comparator<? super Comparable<T>>) new Comparator<T>() {
            @Override
            public int compare(T s1, T s2) {
                return ((String) s1).length() - ((String) s2).length();
            }//compare()
        })
        .map(s -> s + ", ")
        .forEach(System.out::print);
    System.out.println();
}//sort()

Alice, Bob, Carrolline, Dumpty, Elfland,
Bob, Alice, Dumpty, Elfland, Carrolline,
Alice, Bob, Carrolline, Dumpty, Elfland,

【考察】sort()の中で sorted()して表示までしてるやん。
んで、もとの配列は変わっていない。
無理やりキャストまでして、なんとか表示はできたけど、
お題みたいに、配列を入れ替える sort()の中身のアルゴリズムを自作せなあかんねん。
sort()の中で sorted()したらあかん。

それと、toArray()で 配列に代入も考えたが、Object[]になる。
toArray(Compararble<T>[]::new)もしてみたが
ジェネリックの総称型の配列は生成不可だって。
ジェネリックを外して Comparable[]はいけるかもだけど、
すると Camparableは raw型です(=ジェネリック付けよう）という警告が出る。

元のサンプルがジェネリック以前の raw型 <Object>の時代のコードなんで、
ジェネリック対応で書いてみたが

いずれにしても、sort()は、お題みたいに for文で配列の要素を調べて
配列の順番を入れ替えるコードを書かなあかんねん。

【考察】 for文で配列入替を作ってみた。
おそらく、Arrays.sort()/Collection.sort()の中身もこうなっているのかも。

やっていることは for i で (data.length-1)まで全ての配列を調べる
int minで最小値の indexを保持。
for j で data[i] と　次の要素 data[i + 1]を比較
Comparable.compareTo(T)
  A.compareTo(B) A > B なら 1, A == Bなら 0, A < Bなら -1
A < B || A == B なら  順番そのまま。
A > B のときだけ、最小 index を jとし、(jは i + 1で iの次の要素)

入れ替え処理
Comparable<T> tempは、２つのものを入れ替えるとき、
仮に３つめに値をいれておく必要があるので作る。
temp = data[min];

data[min] = data[i]; 最小indexに data[i]を代入
data[i] = temp; data[i]に元の data[min]の値を代入。
先ほどの j検査で、indexに変更がなければ、min = iのまま。要素順に変更なし
j検査で data[i]より、data[i+1]の値が小さければ
min = j = i + 1になっており、上記の入れ替え処理で要素順が変わる。

んで、for iに戻って i++でも検査。
 */