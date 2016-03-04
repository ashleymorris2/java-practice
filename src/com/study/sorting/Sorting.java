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
        quickSort(inputArray, 0, inputArray.length - 1);
        return inputArray;
    }


    private void quickSort(int [] inputArray, int left, int right){

        int pivot = inputArray[inputArray.length - 1];

        int i = left, j = right;

        //Starting from the left element while it's not at the right element.
        while (i <=  j) {

            /**
             * In each iteration,  identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (inputArray[i] < pivot) {
                i++;
            }
            while (inputArray[j] > pivot) {
                j--;
            }

            //Does the comparison between the two numbers and the swap.
            if (i <= j) {
                int temp = inputArray[i];

                inputArray[i] = inputArray[j];
                inputArray[j] = temp;

                i++;
                j--;
            }
        }

        if(left < j){
            quickSort(inputArray, left, j);
        }

        if(right > i){
            quickSort(inputArray, i, right);
        }
    }



}
