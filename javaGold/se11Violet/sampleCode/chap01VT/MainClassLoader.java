/**
 * @title javaGold / se11Violet / sampleCode / chap01VT / MainCalssLoader.java
 * @reference 米山 学 『徹底攻略 Java Gold SE8 問題集 [1Z0-809]』 インプレス, 2020
 * @content  第１章 Java Primary / p50
 * @content ClassLoader <クラス名>.class.getClassLoader());
 *          Class<?> Class.forName(
 *                       String className,
 *                       boolean initialize,
 *                       ClassLoader
 *                   );
 * @author shika
 * @date 2021-05-02
 */
package javaGold.se11Violet.sampleCode.chap01VT;

public class MainClassLoader {

    public static void main(String[] args) {
        //このクラスのディレクトリ構造を取得、クラス名を除去
        String here = System.getProperty("sun.java.command");
        here = here.substring(0, here.lastIndexOf("."));
        String dir = here + ".";

        try {
            System.out.println("[ClassLoading]");
            Class.forName(
                dir + "Foo", //String className
                true,        //boolean initialize
                MainClassLoader.class.getClassLoader());
                             //ClassLoader

            System.out.println("[Instantiation]");
            new Foo();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }//main()

}//class

class Foo {
    static {
        System.out.println("  static inializer");
    }

    {    System.out.println("  initializer"); }

    public Foo() {
        System.out.println("  constructor");
    }
}//class

/*
[ClassLoading]
  static inializer
[Instantiation]
  initializer
  constructor

static初期化子はクラスロード時に、JVMへ読み込み
*/
