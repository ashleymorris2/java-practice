package com.study.sorting;

/**
 * Created by Ash on 30/08/2015.
 */
public class Main {

    public static void main(String[] args) {

        Sorting sorting = new Sorting();

        int testArray [] = {21, 5, 33, 55, 7, 22, 190, 11, 44, 58, 9 };
        int testArray2 [] = {21, 5, 33, 55, 7 };

        sorting.bubbleSort(testArray);


        for(int i = 0; i < testArray.length; i ++){
            System.out.println(testArray[i]);
        }

        System.out.println(" ");

        sorting.quickSort(testArray2);

        for(int i = 0; i < testArray2.length; i ++){
            System.out.println(testArray2[i]);
        }


    }

}
