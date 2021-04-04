/**
 * @title javaGold / se11Violet / sampleCode / chap05VT / MainEveryFunction.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第５章 FunctionalInterface, Lambda / p190 / List 5-7-1
 * @content Supplier, Function, BiFunction, Predicate, BiPredicate, Consumer
 * @author shika
 * @date 2021-04-04
 */

package javaGold.se11Violet.sampleCode.chap05VT;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MainEveryFunction {

    public static void main(String[] args) {
        Supplier<String> supply = () -> "shika";
        Function<String, Integer> func = s -> s.length();
        BiFunction<Integer, Integer, Integer> biFunc = (x, y) -> x * y;
        Predicate<List<String>> predicate = list -> "a".equals(list.get(0));
        BiPredicate<Integer, Integer> biPredicate = (a, b) -> a < b;
        Consumer<String> consumer = s -> System.out.println(s);

        System.out.println("supply.get(): " + supply.get());
        System.out.println(
            "func.apply(\"shika\"): " + func.apply("shika"));
        System.out.println("biFunc.apply(3, 4): " + biFunc.apply(3, 4));
        System.out.println(
            "predicate.test(Arrays.asList(\"a\", \"b\"): " +
            predicate.test(Arrays.asList("a", "b")));
        System.out.println("biPredicate.test(3, 4): " + biPredicate.test(3, 4));
        System.out.print("consumer.accept(supply.get() + \" poka\"): ");
        consumer.accept(supply.get() + " poka");
    }//main()
}//class

/*
supply.get(): shika
func.apply("shika"): 5
biFunc.apply(3, 4): 12
predicate.test(Arrays.asList("a", "b"): true
biPredicate.test(3, 4): true
consumer.accept(supply.get() + " poka"): shika poka

*/