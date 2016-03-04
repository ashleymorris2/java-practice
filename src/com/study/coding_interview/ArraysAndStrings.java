package com.study.coding_interview;

import java.util.HashMap;

/**
 * Created by Ash on 24/08/2015.
 */
public class ArraysAndStrings {

    /**
     * Checks if all the characters in a string are unique.
     *
     * @param input the string that is to be checked.
     * @return true if the letters are unique, false if they are not.
     */
    public boolean isUnique(String input) {

        //Use a hashmap to keep a count
        HashMap<Character, Integer> countTable = new HashMap<>();

        //Check every letter of the input word.
        for (int i = 0; i < input.length(); i++) {

            int count = 0;

            //Get the current count of the current word if it already exists in the hashmap.
            if (countTable.get(input.charAt(i)) != null) {
                count = countTable.get(input.charAt(i));
            }

            //If the count is zero, then increment it. It should now be 1.
            if (count == 0) {
                count++;
                countTable.put(input.charAt(i), count);
            } else {
                //Else return false, because the current letter has already been found, meaning that it isn't unique.
                return false;
            }
        }

        return true;
    }

    /**Checks if two strings are permutations of each other
     *
     * @param firstString The first string to be compared
     * @param secondString The second string to be compared
     * @return True if the strings contain the same letters as each other false if not.
     */
    public boolean isPermutation(String firstString, String secondString) {
        if (firstString.length() != secondString.length()) {
            return false;
        }

        HashMap<Character, Integer> countTable = new HashMap<>();

        for (int i = 0; i < firstString.length(); i++) {
            int counter = 0;

            if (countTable.get(firstString.charAt(i)) != null) {
                //The character is already in the hash map, get the stored value.
                counter = countTable.get(firstString.charAt(i));
            }

            counter++;
            countTable.put(firstString.charAt(i), counter);
        }

        for (int i = 0; i < secondString.length(); i++) {

            if (countTable.get(secondString.charAt(i)) == null) {
                //This letter hasn't been found so they are not permutations
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

        //Similar to counting semaphores.
        //If we are back to empty then the two words
        //contain the same characters
        return countTable.isEmpty();
    }

    public String urlIfy(String inputString) {

        int spaceCount = 0, newLength;
        char[] charString = inputString.toCharArray();

        for (char aCharString : charString) {
            if (aCharString == ' ') {
                //Count the number of spaces
                spaceCount++;
            }
        }

        //Make space for the additional characters in a new array.
        newLength = inputString.length() + spaceCount * 2;

        char[] newString = new char[newLength];

        for (int i = charString.length -1; i >= 0; i--) {

            //Working from the end to the beginning place %20 where spaces are found
            //and the original character where no space is found.
            if (charString[i] == ' ') {
                newString[newLength - 1] = '0';
                newString[newLength - 2] = '2';
                newString[newLength - 3] = '%';

                newLength -= 3;
            }
            else {
                newString[newLength - 1] = charString[i];
                newLength--;
            }
        }

        return new String(newString);
    }

    public String iterativeReverse(String input){

        char [] string = new char [input.length()];
        int index = 0;

        for (int i = input.length() -1 ; i >= 0; i--) {
            string[index] = input.charAt(i);
            index++;
        }

        return new String(string);
    }

    public String recursiveReverse(String input){
        if(input.length() <= 1){
            //Base case down to string of length one
            return input;
        }

        return recursiveReverse(input.substring(1)) + input.charAt(0);
    }




}
