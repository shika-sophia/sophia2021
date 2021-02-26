/**
 * @title multiThread / chap02MT / directConstructor / MainChangePoint.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第２章 Immutable / 練習問題 2-5
 * @content コンストラクタの値をそのままフィールドに代入すると改変されてしまうケース。
 * @author shika
 * @date 2021-02-26
 */
package multiThread.chap02MT.directConstrutor;

public class MainChangePoint {

    public static void main(String[] args) {
        //インスタンス生成
        var p1 = new PointMutable(0, 0);
        var p2 = new PointMutable(100, 0);
        //var line = new LineUnsafe(p1, p2);
        var line = new LineImmutable(p1, p2);

        //インスタンス表示
        System.out.println("before: " + line);

        //Pointを変更
        p1.x = 150;
        p1.y = 150;
        p2.x = 250;
        p2.y = 250;

        //インスタンスを再表示
        System.out.println("after:  " + line);

    }//main()

}//class

/*
//====== Test LineUnsafe ======
before: Line: (0,0)-(100,0)
after:  Line: (150,150)-(250,250)

//====== Test LineImmutable ======
before: Line: (0,0)-(100,0)
after:  Line: (0,0)-(100,0)

コンストラクタ Line(Point, Point)を そのままフィールド代入ではなく、
新たに Pointインスタンスを作って代入するようにしたら、
その後のフィールドの改変の影響を受けなくなった。
<?> この理由が考えても よう解らん。疑問点として残しておこう。
*/