package com.study.data_structures;

/**
 * Created by Ash on 11/08/2015.
 */
public class MyDoublyLinkedList {

    private class Node {
        Node next = null; // The next node in the chain
        Node prev = null; // The previous node in the chain
        Object data; // The data that this node is carrying

        //Constructor, specifies its data at creation time but not the adjacent nodes.
        public Node(Object data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;

    private int listCount;

    public MyDoublyLinkedList() {
        head = new Node(null);
        tail = new Node(null);

        //Head and tail points to each other
        head.next = tail;
        tail.prev = head;

        //Heads previous and tails next are null
        head.prev = null;
        tail.next = null;

        listCount = 0;
    }

    public int size() {
        return listCount;
    }

    public void add(Object data) {

        Node temp = new Node(data);
        Node current = tail.prev;

        current.next = temp;
        temp.prev = current;

        temp.next = tail;
        tail.prev = temp;

        listCount++;
    }

    public boolean delete(int index) {
        if (index < 1 || index > listCount) {
            //Index is out of range return false.
            throw new IndexOutOfBoundsException();
        }

        Node current = head;
        for (int i = 1; i < index; i++) {
            current = current.next;
        }

        //The new next node skips the next node and moves to the node after that.
        Node next = current.next.next;
        current.next = next;

        if (next != null) {
            //Check that the next node isn't null.
            next.prev = current;
        }

        listCount--;
        return true;
    }

    public String makeSentence(){

        Node current = head;

        StringBuilder sb = new StringBuilder();

        while(current.next.data != null){
            current = current.next;
            sb.append(current.data);
            sb.append(" ");
        }

        return sb.toString();
    }

    //Starts from the tail and then continues to the start to make a sentence
    public String makeReverseSentence(){

        Node current = tail;

        StringBuilder sb = new StringBuilder();

        while(current.prev.data != null){
            current = current.prev;
            sb.append(current.data);
            sb.append(" ");
        }

        return sb.toString();
    }

    public Object get (int index){
        if (index < 1 || index > listCount) {
            throw new IndexOutOfBoundsException();
        }

        int half = listCount /2;
        Node current;

        if( index > half){
            //If the index is a higher value than half of the elements in the list
            //We will decrement to find the value.
            current = tail.prev;
            for(int i = listCount; i > index; i --){
             if( current.prev == null){
                 return null;
             }
                current = current.prev;
            }
        }
        else{
            //Else we will increment from the head.
            current = head.next;
            for(int i = 1; i < index; i ++){
                if(current.next == null){
                    return null;
                }
                current = current.next;
            }
        }

        return current.data;
    }

    /**
     * Returns the first index of the object specified
     * @param data The data that is to be searched for in the linked list
     * @return The index of the object in the list or -1 if the object isn't found
     */
    public int indexOf (Object data){
        if(data == null){
            throw new NullPointerException("The object to be searched for can not be null");
        }

        Node current = head.next;

        for(int index = 1; index <= listCount; index++){

            if(current.data.equals(data)){
                return index;
            }

            current = current.next;

        }

        return -1;
    }

    public boolean removeFirstIndexOf(Object data){
        if (data == null){
            throw new NullPointerException("The object to be searched for can not be null");
        }

        //First we need to find the first index of the element that is to be removed
        Node current = head.next;

        for (int index = 1; index <= listCount; index++){
            if(current.data.equals(data)){

                //Now re-arrange the pointers so that current is no longer in the list. Later to be garbage collected
                Node prev = current.prev;
                Node next = current.next;

                prev.next = next;
                next.prev = prev;

                current.next = null;
                current.prev = null;

                return true;

            }
            current = current.next;
        }

        return false;
    }


}
