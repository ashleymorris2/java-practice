package com.study.coding_interview;

import java.util.HashMap;

/**
 * Created by Ash on 24/08/2015.
 */
public class ArraysAndStrings {

    boolean isUnique(String input) {

        HashMap<Character, Integer> countTable = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {

            int count = 0;

            if (countTable.get(input.charAt(i)) != null) {
                count = countTable.get(input.charAt(i));
            }

            if (count == 0) {
                count++;
                countTable.put(input.charAt(i), count);
            } else {
                return false;
            }
        }

        return true;
    }

    boolean isPermutation
            (String firstString, String secondString) {
        if (firstString.length() != secondString.length()) {
            return false;
        }

        HashMap<Character, Integer> countTable = new HashMap<>();

        for (int i = 0; i < firstString.length(); i++) {
            int counter = 0;

            if (countTable.get(firstString.charAt(i)) != null) {
                counter = countTable.get(firstString.charAt(i));
            }

            counter++;
            countTable.put(firstString.charAt(i), counter);
        }

        for (int i = 0; i < secondString.length(); i++) {

            if (countTable.get(secondString.charAt(i)) == null) {
                //This letter hasn't been found so they are not the same.
                return false;
            }

            int counter = countTable.get(secondString.charAt(i));
            counter--;

            if (counter == 0) {
                //Remove from the table when there are 0 characters
                countTable.remove(secondString.charAt(i));
            } else {
                //decrement in the table until it's at 0
                countTable.put(secondString.charAt(i), counter);
            }
        }

        if (countTable.isEmpty()) {
            return true;
        }

        return false;
    }


}
