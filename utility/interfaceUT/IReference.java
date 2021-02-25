package utility.interfaceUT;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public interface IReference {
    //@referenceに記述する参考文献。<K,V>=<パッケージ名,書籍名>
    public static final Map<String,String>
        refMap = new HashMap<>(Map.of(
            "selfLearn",
            "山田祥寛 『独習 Java 新版』 翔泳社, 2019",
            "webPractice",
            "山田祥寛 『独習 Java サーバーサイド編 第２版』 翔泳社, 2013",
            "se11Violet",
            "山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021",
            "se08Black",
            "米山 学 『徹底攻略 Java Gold SE8 問題集 [1Z0-809]』 インプレス, 2020",
            "swing",
            "日向俊二 『JavaGUIプログラミング\r\n" +
            " *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020",
            "multiThread",
            "結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006"
        ));

    public static String seekRef(String className) {
        String reference = "";
        for(Entry<String,String> entry : refMap.entrySet()) {
            if(className.contains(entry.getKey())) {
                reference = entry.getValue();
                break;
            }//if
        }//for

        if(reference.isBlank()) {
            reference = "なし";
        }

        return reference;
    }//seekRef()

//    //====== Test main() ======
//    public static void main(String[] args) {
//        String reference = seekRef("selfLearn");
//        System.out.println("@reference " + reference);
//    }//main()
}//interface

/*
//====== Test main() ======
 * @reference 山田祥寛『独習 Java 新版』 翔泳社, 2019
 * @reference 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @reference なし
 */
/*
同内容の動作を Streamで実現したいけど、
Stream ギブアップです。再度挑戦。

    refMap.entrySet().stream()
    .filter(s -> className.contains(s));
*/