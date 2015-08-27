package com.study.coding_interview;

/**
 * Created by Ash on 27/08/2015.
 */
public class FizzBuzz {

    public void print(){

        for(int i = 1; i <= 50; i++){

            if(i % 3 == 0 && i % 5 == 0){
                System.out.println("FizzBuzz: " + i + " is divisible by 3 and 5");
            }
            else if(i % 3 == 0){
                System.out.println("Fizz: " + i + " is divisible by 3");
            }
            else if( i % 5 == 0){
                System.out.println("Buzz: " + i + " is divisible by 5");
            }
        }
    }
}
