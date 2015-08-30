package com.study.sorting;

/**
 * Created by Ash on 30/08/2015.
 */
public class Sorting {

    public int [] bubbleSort (int [] inputArray){

        for(int i = 0; i < inputArray.length; i++){
            for(int y = 0; y < inputArray.length - 1; y++){
                if(inputArray[y] > inputArray[y+1] ){
                    //Do swap if y is greater than the next element
                    int temp = inputArray[y+1];
                    inputArray[y+1] = inputArray[y];
                    inputArray[y] = temp;
                }
            }
        }

        return inputArray;
    }



    public int [] quickSort(int [] inputArray){



        return inputArray;
    }


}
