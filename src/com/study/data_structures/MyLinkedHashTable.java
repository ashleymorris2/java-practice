package com.study.data_structures;

import java.util.LinkedList;


/**
 * Created by Ash on 11/08/2015.
 */
public class MyLinkedHashTable {

    private class Element{

        String key;
        Object data;

        public Element(String key, Object data) {
            this.key = key;
            this.data = data;
        }
    }
    private int tableSize;
    private LinkedList<Element> [] hashTable;

    public MyLinkedHashTable(int tableSize) {
        this.tableSize = tableSize;
        hashTable = new LinkedList[tableSize];
    }

    public void put(String key, Object data){
        if(key == null){
            throw new NullPointerException("Key can't be null");
        }

        Element temp = new Element(key, data);

        int index = hash(key);

        if(hashTable[index] == null){
            //Make sure the list at this position is initialised before adding
            hashTable[index] = new LinkedList<>();
        }

        if (hashTable[index].size() > 0){
            //Means that there are more than 1 element at this index
            //time to check for duplicate keys and overwrite their data

          for (int i = 0; i< hashTable[index].size(); i ++){
              if(hashTable[index].get(i).key == key){

                  hashTable[index].remove(i);
                  hashTable[index].add(i, temp);

                  return;
              }
          }
        }
        hashTable[index].add(temp);
    }

    public int hash(String input){

        long hashValue = 0;

        //Time to try and write a hash function from the elements key.
        for(int i = 0; i < input.length(); i ++){
            int charVal = (int) input.charAt(i);
            hashValue += charVal * charVal * input.length();
        }

        return (int) hashValue % tableSize;
    }

    public Object get (String key){
        if(key == null){
            throw new NullPointerException("Key can't be null");
        }

        int index = hash(key);

        for (int i = 0; i < hashTable[index].size() ; i++) {
            if(hashTable[index].get(i).key == key){

                return hashTable[index].get(i).data;
            }
        }

        return -1;
    }
}
