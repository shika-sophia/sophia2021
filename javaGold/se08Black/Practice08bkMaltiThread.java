/**
 * @title javaGold / se08Black / Practice08bkMaltiThread.java
 * @reference 米山 学 『徹底攻略 Java Gold SE8 問題集 [1Z0-809]』 インプレス, 2020
 * @content  第８章 MaltiThread
 * @author shika
 * @date 2021-05-10
 */
/* Appendix 2021-05-10
 * @costTime 14:35 - 14:54 ( 18 分)
 * @correctRate 正答率 52.63 ％ ( 〇10問 / 全19問 )
 */
package javaGold.se08Black;

import javaGold.PracticeEditor;

public class Practice08bkMaltiThread {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-05-10 ======
 第８章 MaltiThread
Ｘ （1） A, D, E, F -> A, B, D, E
       => ◆「並行処理ユーティリティ」 concurrent utilities
           * java.util.concurrent/.atomic/.locks
           * ＊スレッドプール / Executorフレームワーク
           * 	・スレッド生成のオーバーヘッド軽減
           * 	・スレッド管理の生産性向上
           *
           * ＊並行コレクション / ConcurrentCollection
           * 	・従来の同期化コレクションは、状態へのアクセスを直列化することで
           * 		スレッドセーフを実現。だがパフォーマンスを劣化させる要因になる。
           * 		全てsynchronizedしている。 Hashtableなど
           *
           *	・ 内部データ構造を分割し、synchronizedせずにスレッドセーフを実現。
           *		パフォーマンスを向上。 ConcurrentHashMapなど
           *
           * ＊アトミック変数
           * 	・アトミックとして扱われる一連の処理は
           * 		「完全に完了している」
           * 		「未着手である」
           * 	の いづれかでなければならない。
           *
           * 	・リード・モディファイ・ライト read-modify-write
           * 		ステートの読み込み
           * 		値の変更
           * 		ステートの書き込み
           *
           * ＊カウンティング・セマフォ
           * 	Semaphore [英]信号装置
           * 	・バイナリーセマフォ
           * 		可能・不可能の値を取る
           * 	カウンティングセマフォ
           * 		java.util.concurrent.Semaphoreクラス
           * 		new Semphore(int) 並行アクセス可能なスレッド数を設定
           *		void acquire() リソース確保。空きがない場合はロック
           *		void release() リソース解放
           *		int availablePermits() 利用可能なリソース数
           *		boolean tryAcquire() 取得可能か
           *
           * 「スレッドの優先順位の動的な調整」
           * 	java.lang.Threadクラス
           * 		setPriority(int)など
           * 「同期化ラッパー」
           * 	java.util.Collectionsクラス
           * 		synchronizedSet(), synchronizedMap()など

〇 （2） B
〇 （3） A, C, D
Ｘ （4） A, D, E -> A, B, D
    => ◆ConcurrentHashMap
    => ロック・ストライピング: ロックの細分化
    => マップ全体をロックせず、パフォーマンス向上のトレードオフとして、
        size(), isEmpty()は必ずしも厳密ではない。
    => Iteratorで ConncurentModificationExceptionが出されることはない。(変更が可能)

Ｘ （5） C, D -> B, C
    => ◆ CopyOnWriteArrayList
        * ・add(), set(), remove()のたびに内部の配列へコピーされる。
        * ・変更処理中に他スレッドの読み込みはブロックせず、
        * 他スレッドはコピー前の状態が返される。
        * Iteratorで ConcurrentModificationExceptionは出ない

〇 （6） C
Ｘ （7） B, D -> A, D
    => ◆Thread
        * A: スレッドの上限は環境や物理メモリ量で決められ、設定できない。
        * 	上限を越えると java.lang.OutOfMemmoryErrorで異常終了の可能性。
        * C: スレッド管理は困難
        * D: スレッド生成と破棄にオーバーヘッドが掛かる。
        *
Ｘ （8） C, D, E -> B, D, E
    => ◆ Executorフレームワーク
        * 〇B: タスクのライフサイクルの管理や監視
        * 〇D: スレッドプール
        * 〇E: 遅延開始や周期的実行
        *
        * Ｘ A: read-write-lock: Executorではなく、
        * 	java.util.concurrent.locks.ReadWriteLockインターフェイス
        * Ｘ C: スレッド・スタックが使用するメモリアドレス空間のサイズ変更
        * 	java.lang.Threadのコンストラクタ
        * 	JVMの実行パラメタで制御
〇 （9） B, D
〇 （10） C
Ｘ （11） B, C -> B, D
    => ◆Runnable, Callable
        * 〇B: Runnableは戻り値を返さない。Callableは返す。
        * 〇D: Runnableは チェック例外を返せない。
        * 	 Callableは Future<?>に Exceptionを入れて返すことが可能。

〇 （12） B, C
〇 （13） C, D
〇 （14） B, C
    => ◆ Fork(分割)/Join(結合)フレームワーク
        * 〇B: 大きなタスクを小さく分割し、複数スレッドで同時並行処理
        * 〇C: 「Working-Stealing」(=仕事盗み)
〇 （15） B
    => FolkJoinPool
    => FolkJoinTask<T>

〇 （16） B, C, E?
    => ◆FolkJoinPoolクラスのメソッド
         * void execute(FolkJoinTask<?>) 非同期でタスクを実行。戻り値なし。
         * <T> invoke(FolkJoinTask<T>) タスク終了まで待機。戻り値を受け取る。
         * <T> submit(FolkJoinTask<T>) 非同期でタスクを実行。戻り値を受け取る。

Ｘ （17） C? -> A, B
    => FolkJoinTask<T>
        * ┗ RecursiveAction
        * ┗ RecursiveTask<T>
Ｘ （18） D -> C
    => 〇C: 並行処理が常にパフォーマンスに優れているわけではない。
    => Ｘ D: 中間処理や終端処理で、開発者はスレッドセーフなコードを書く責任がある
Ｘ （19） A -> C
    => findAny()の結果が常に同じになるとは限らない。
    *  findFirst()は常に同じ結果となる。

開始時刻 14:35
終了時刻 14:54
所要時間 18 分
正答率 52.63 ％ ( 〇10問 / 全19問 )
*/

