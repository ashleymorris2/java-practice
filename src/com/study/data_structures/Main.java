package com.study.data_structures;



/**
 * Created by Ash on 11/08/2015.
 */
public class Main {
    public static void main(String[] args) {

        MyDoublyLinkedList doublyLinkedList = new MyDoublyLinkedList();

        String test = "1: This is the first string that needs to be added to the linked list.";
        String test2 = "2 :With this doubly linked list we should be able to do some pretty cool stuff.";
        String test3 = "3: I won't give any examples, that's what this tester program is for.";
        String test4 = "4: I don't see why a lot of people dislike Java, it isn't actually that bad.";

        doublyLinkedList.add(test);

        doublyLinkedList.add(test2);
        doublyLinkedList.add(test3);
        doublyLinkedList.add(test4);

        System.out.println(doublyLinkedList.makeSentence());

        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add("monkey");
        linkedList.add("chicken");
        linkedList.add("greek");
        linkedList.add("frog");
        linkedList.add("bacon");

        linkedList.printReverse(linkedList.getHead());

        MyLinkedHashTable hashTable = new MyLinkedHashTable(12);
        hashTable.put("ian", 34);
        hashTable.put("john", 83);
        hashTable.put("paul", 98);
        hashTable.put("susan,", 19);
        hashTable.put("lucy", 94);
        hashTable.put("culy", 74);

        System.out.println(hashTable.get("lucy"));
        hashTable.put("lucy", 44);
        hashTable.put("culy", 22);
        hashTable.put("kath", 999);

        System.out.println(hashTable.get("lucy"));


    }
}
