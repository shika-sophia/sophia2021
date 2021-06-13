/**
 * @title javaGoF / chap13Visitor / MainVisitor.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content 第13章 Visitor / 練習問題 13-3
 *          ElementListVisitを追加。
 *          add(AbsEntryVisit), accept(AbsVisitor)
 *
 * @see MainVisitor / class summary
 * @author shika
 * @date 2021-06-13
 */
package javaGoF.chap13Visitor;

import javaGoF.chap13Visitor.entryElement.DirectoryVisit;
import javaGoF.chap13Visitor.entryElement.ElementListVisit;
import javaGoF.chap13Visitor.entryElement.FileTreatException;
import javaGoF.chap13Visitor.entryElement.FileVisit;
import javaGoF.chap13Visitor.visitor.ShowVisitor;

public class MainElementList {

    public static void main(String[] args) {
        try {
            var root1 = new DirectoryVisit("root1");
            root1.add(new FileVisit("diary.html", 10));
            root1.add(new FileVisit("index.html", 20));

            var root2 = new DirectoryVisit("root2");
            root2.add(new FileVisit("diary.html", 1000));
            root2.add(new FileVisit("index.html", 2000));

            var elementList = new ElementListVisit();
            elementList.add(root1);
            elementList.add(root1);
            elementList.add(new FileVisit("etc.html", 100));

            elementList.accept(new ShowVisitor());

        } catch (FileTreatException e) {
            e.printStackTrace();
        }
    }//main()

}//class

/*
/root1 (30)
/root1/diary.html (10)
/root1/index.html (20)
/root1 (30)
/root1/diary.html (10)
/root1/index.html (20)
/etc.html (100)

【解答】
これだけで良い。

class ElementListVisit extends ArrayList implements IElementVist {
    public void accept(AbsVisitor v)
        Iterator<AbsEntryVisit> itr = iterator();
        while(itr.hasNext()){
            IElement entry = itr.next();
            entry.accept(v)
        }//while
    }//accept()
}//class

【考察】
List<AbsEntryVisit>は superの ArrayListのものを利用している。
add()も同様。
これは、extends ArrayListすれば、そりゃ利用できるけど、
java.utilのフィールド(List)とメソッド add() を、
個別のプログラムで利用するぐらいなら、ここで改めて定義したほうが可読性がいいのでは。

ここの iterator()は何に対してなのか、対象オブジェクトが記述されていない。
取り出しているものが、 IElementであることから、this.iterator()と思われる。
thisは、このクラス ElementListだが、保持している List<IElement>.iterator()か。

whileで各Entryである File, Directoryの entry.accept(v)を呼出ているので、
オーバーロードの振り分け処理は必要なくなる。

私のは AbsVisitor.visit(AbsEntryVisit)を

   if(entry instaceof FileVisit){
       visit((FileVisit) entry);
   } else if( entry instanceof DirectoryVisit){
       visit((DirectoryVisit) entry);
   }
のようにvisit(File), visit(Directory)に振り分けており 、
オブジェクト指向的なコードではない。

||Composite|| の章で
entry.getSize()は entryの場合分けをすることなく、
entryが FileCompositeなら、そのクラスの getSize()
entryが DirectoryCompositeなら、そのクラスの getSize()と
とてもオブジェクト指向的なコード。

今回は visit()の引数が異なるため、
visit(AbsEntryVisit)が対象クラスに定義されていないとコンパイルエラー。
そのため両クラスの superである AbsVisitorに
visit(AbsEntryVisit)を設け、抽象メソッドにすれば、
そのままオブジェクト指向で振り分けが可能であったが、
AbsVisitorの各 subに visit(AbsEntryVisit)を実装しなければならず、
subでは必要ないメソッドなこともあり、
AbsVisitor内で、上記の if文となった。

*/