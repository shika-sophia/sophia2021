package javaGoF.chap18Memento.fruitGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GamerFruit {
    private int money;
    private List<String> fruitList = new ArrayList<>();
    private Random random = new Random();
    private String[] fruitName = {
        "リンゴ","ぶどう","バナナ","みかん"
    };

    public GamerFruit(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    //サイコロ処理
    public void bet() {
        int dice = random.nextInt(6) + 1;

        String msg = "";
        if(dice == 1) {
            money += 100;
            msg = "所持金が増えました。";
        } else if (dice == 2) {
            money /= 2;
            msg = "所持金が半分になりました。";
        } else if (dice == 6) {
            String f = getFruit();
            msg = String.format("フルーツ( %s )をもらいました。", f);
            fruitList.add(f);
        } else {
            msg = "なにも起こりませんでした。";
        }

        System.out.println(msg);
    }//bet()

    //所持金と、「おいしい」フルーツだけ Mementoに保存
    public MementoFruit createMemento() {
        MementoFruit memento = new MementoFruit(money);
        this.fruitList.stream()
                .filter(f -> f.startsWith("おいしい"))
                .forEach(f -> memento.addFruit(f));

        return memento;
    }//createMemento()

    //保存しておいた Mementoに復帰
    public void restoreMemento(MementoFruit memento) {
        this.money = memento.money;
        this.fruitList = memento.getFruitList();
    }//resoreMemento()

    //フルーツ名をRandom生成
    private String getFruit() {
        String select =
            fruitName[random.nextInt(fruitName.length)];

        String prefix = "";
        if(random.nextBoolean()) {
            prefix = "おいしい";
        }

        return prefix + select;
    }//getFruit()

    //インスタンスの文字列表現
    public String toString() {
        return String.format(
            "[money =  %d, fruit = %s]", money, fruitList);
    }//toString()
}//class
