/**
 * @title javaGoF / chap14ChainResponse / chainResponsibility / MainChainResponse.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content 第14章 Chain of Responsibility / List 14-1 ～ 14-7
 *          「責任のたらいまわし」のように次々と処理する者が変遷。
 *          依頼と処理の分離。
 *
 * @class MainChainResponse / ◆main()
 * @class TroubleChain / -number / +getNumber(), +toString()
 * @class AbsSupportChain
 *        / -name, -next / #abstract boolean resolve(Trouble)
 *        +setNext(), +support(), +toString(), #done(), #fail()
 * @class NoSupportChain extends AbsSupportChain
 *        / #resolve() 常に false
 * @class LimitSupportChain extends AbsSupportChain
 *        / #resolve() コンストラクタ指定 limitまでは true
 * @class OddSupportChain extends AbsSupportChain
 *        / #resolve() 奇数のみ true
 * @class SpecialSupportChain extends AbsSupportChain
 *        / #resolve() コンストラクタ指定 numberのみ true
 *
 * @author shika
 * @date 2021-06-14
 */
package javaGoF.chap14ChainResponse.chainResponsibility;

public class MainChainResponse {

    public static void main(String[] args) {
        AbsSupportChain alice = new NoSupportChain("Alice");
        AbsSupportChain bob = new LimitSupportChain("Bob", 100);
        AbsSupportChain charlie= new SpecialSupportChain("Charlie", 429);
        AbsSupportChain diana = new LimitSupportChain("Diana", 200);
        AbsSupportChain elmo = new OddSupportChain("Elmo");
        AbsSupportChain fred = new LimitSupportChain("Fred", 300);

        //build chain
        alice.setNext(bob).setNext(charlie)
        .setNext(diana).setNext(elmo).setNext(fred);

        //make Trouble
        for(int i = 0; i < 500; i += 33) {
            alice.support(new TroubleChain(i));
        }
    }//main()

}//class

/*
[Trouble 0] is resolved by [Bob]
[Trouble 33] is resolved by [Bob]
[Trouble 66] is resolved by [Bob]
[Trouble 99] is resolved by [Bob]
[Trouble 132] is resolved by [Diana]
[Trouble 165] is resolved by [Diana]
[Trouble 198] is resolved by [Diana]
[Trouble 231] is resolved by [Elmo]
[Trouble 264] is resolved by [Fred]
[Trouble 297] is resolved by [Elmo]
[Trouble 330] cannot be resolved
[Trouble 363] is resolved by [Elmo]
[Trouble 396] cannot be resolved
[Trouble 429] is resolved by [Charlie]
[Trouble 462] cannot be resolved
[Trouble 495] is resolved by [Elmo]
*/