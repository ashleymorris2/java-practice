package com.study.coding_interview;

/**
 * Created by Ash on 24/08/2015.
 */
public class Main {
    public static void main(String[] args) {

        ArraysAndStrings test = new ArraysAndStrings();

        System.out.println(test.isUnique("Bacon"));
        System.out.println(test.isUnique("aconwl,s"));
        System.out.println( test.isUnique("aconws,s"));

        System.out.println(test.isPermutation("abcdefgh", "habcedfh"));
        System.out.println(test.urlIfy("Hello my name is barry"));
        System.out.println(test.iterativeReverse("22 racecar 44"));

        System.out.println(test.recursiveReverse("33 racecar 66"));

        System.out.println(" ");

        FizzBuzz fizzBuzz = new FizzBuzz();
        fizzBuzz.print();




    }
}
