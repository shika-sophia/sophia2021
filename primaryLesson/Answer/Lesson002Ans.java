/**
 * @title primaryLesson / primaryAns / Lesson002Ans.java
 * @content 変数 String, int, System.out.println(str);
 * @author shika
 * @dete 2021-01-21
 */
package primaryLesson.Answer;

public class Lesson002Ans {

    public static void main(String[] args) {
        String name = "Your Name"; //文字列の変数
        int age = 24;              //整数の変数

        System.out.println(name); //変数なので""は不要
        System.out.println(age);  //数字も表示される
        System.out.println();

        System.out.println(name + " : " + age);
    }//main()

}//class

/*
//====== 実行結果 ======
Your Name
24

Your Name : 24
 */