/**
 * @title javaGoF / chap18Memento / fruitGame / MainFruitGame.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content 第18章 Memento / List 18-1, 18-2, 18-3
 *          状態を記録するインスタンス。
 *
 * @class MainFruitGame / ◆main() new GamerFruit
 * @class MementoFruit
 *        / ~int money, ~List<String> fruitList /
 *        ~MementoFruit(int)
 *        +getMoney(), ~addFruit(String), ~getFruitList()
 * @class GamerFruit
 *        / -int money, -List<String> fruitList,
 *          -Random random, -String[] fruitName /
 *        +GamerFruit(int)
 *        +getMoney(), +bet(),
 *        +createMemento(), +restoreMemento()
 *        -getFruit(), +toString()
 *
 * @author shika
 * @date 2021-06-22
 */
package javaGoF.chap18Memento.fruitGame;

public class MainFruitGame {

    public static void main(String[] args) {
        var gamer = new GamerFruit(100);
        var memento = gamer.createMemento();

        for(int i = 0; i < 100; i++) {
            System.out.println("==== " + i); //回数表示
            System.out.println("現状: " + gamer);

            gamer.bet(); //サイコロを振る

            System.out.println("所持金は " + gamer.getMoney() + " 円になりました。");

            //Mementoの処理
            if(gamer.getMoney() > memento.getMoney()) {
                System.out.println("　　　(だいぶ増えたので、現在の状態を保存しておこう)");
                memento = gamer.createMemento();
            } else if (gamer.getMoney() < memento.getMoney() / 2) {
                System.out.println("　　　(だいぶ減ったので、以前の状態に復帰しよう)");
                gamer.restoreMemento(memento);
            }

            //時間待ち
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println();
        }//for
    }//main()

}//class

/*
==== 0
現状: [money =  100, fruit = []]
なにも起こりませんでした。
所持金は 100 円になりました。

==== 1
現状: [money =  100, fruit = []]
フルーツ( みかん )をもらいました。
所持金は 100 円になりました。

==== 2
現状: [money =  100, fruit = [みかん]]
所持金が増えました。
所持金は 200 円になりました。
　　　(だいぶ増えたので、現在の状態を保存しておこう)

==== 3
現状: [money =  200, fruit = [みかん]]
なにも起こりませんでした。
所持金は 200 円になりました。

==== 4
現状: [money =  200, fruit = [みかん]]
フルーツ( おいしいリンゴ )をもらいました。
所持金は 200 円になりました。


==== 18
現状: [money =  200, fruit = [みかん, おいしいリンゴ, みかん]]
所持金が増えました。
所持金は 300 円になりました。
　　　(だいぶ増えたので、現在の状態を保存しておこう)

==== 19
現状: [money =  300, fruit = [みかん, おいしいリンゴ, みかん]]
フルーツ( おいしいバナナ )をもらいました。
所持金は 300 円になりました。

==== 20
現状: [money =  300, fruit = [みかん, おいしいリンゴ, みかん, おいしいバナナ]]
所持金が半分になりました。
所持金は 150 円になりました。

==== 21
現状: [money =  150, fruit = [みかん, おいしいリンゴ, みかん, おいしいバナナ]]
フルーツ( おいしいぶどう )をもらいました。
所持金は 150 円になりました。

==== 39
現状: [money =  187, fruit = [みかん, おいしいリンゴ, みかん, おいしいバナナ, おいしいぶどう, おいしいぶどう, おいしいリンゴ, おいしいみかん, おいしいリンゴ, おいしいリンゴ, おいしいリンゴ]]
所持金が半分になりました。
所持金は 93 円になりました。
　　　(だいぶ減ったので、以前の状態に復帰しよう)

==== 40
現状: [money =  375, fruit = [おいしいリンゴ, おいしいバナナ, おいしいぶどう, おいしいぶどう, おいしいリンゴ]]
なにも起こりませんでした。
所持金は 375 円になりました。

==== 41
現状: [money =  375, fruit = [おいしいリンゴ, おいしいバナナ, おいしいぶどう, おいしいぶどう, おいしいリンゴ]]
所持金が増えました。
所持金は 475 円になりました。
　　　(だいぶ増えたので、現在の状態を保存しておこう)

==== 42
現状: [money =  475, fruit = [おいしいリンゴ, おいしいバナナ, おいしいぶどう, おいしいぶどう, おいしいリンゴ]]
なにも起こりませんでした。
所持金は 475 円になりました。

==== 50
現状: [money =  237, fruit = [おいしいリンゴ, おいしいバナナ, おいしいぶどう, おいしいぶどう, おいしいリンゴ, バナナ, おいしいみかん]]
所持金が半分になりました。
所持金は 118 円になりました。
　　　(だいぶ減ったので、以前の状態に復帰しよう)

*/