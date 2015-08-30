package com.study.sorting;

/**
 * Created by Ash on 30/08/2015.
 */
public class Main {

    public static void main(String[] args) {

        Sorting sorting = new Sorting();

        int testArray [] = {21, 5, 33, 55, 7, 22, 190, 11, 44, 58, 9 };

        sorting.bubbleSort(testArray);


        for(int i = 0; i < testArray.length; i ++){

            System.out.println(testArray[i]);
        }

    }

}
