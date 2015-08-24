package com.study.data_structures;

/**
 * Created by Ash on 11/08/2015.
 */
public class MyLinkedList {

    private class Node {

        private Node next = null; //reference to the next node in the chain
        private Object data; // the data carried by this node

        public Node(Object data) {
            this.data = data;
            next = null;
        }

        //This constructor allows us to specify the next node to point to
        public Node(Node next, Object data) {
            this.next = next;
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }
    }

    private Node head;
    private int listCount;

    //Constructor for the MyLinkedList class
    public MyLinkedList() {
        //This is an empty linked list so the head is
        //created but no data is added to it.
        head = new Node(null);
        listCount = 0;
    }

    //Appends the element to the end of the list
    public void add(Object data) {
        Node temp = new Node(data);
        Node current = head;

        //Starting at the head iterate through the list until reaching the end.
        while (current.getNext() != null) {
            current = current.getNext();
        }

        //Current is now pointing to the end of the list
        //set the next variable to temp.
        //Increment the current size of the list.
        current.setNext(temp);
        listCount++;
    }

    //Adds the object to the specified position in the list
    public void add(Object data, int position) {
        Node temp = new Node(data);
        Node current = head;

        //Start at the first element. Continue to the position or the end of the list,
        //which ever comes first
        for (int i = 1; i < position && current.getNext() != null; i++) {
            current = current.getNext();
        }

        //Literally slides the temp between current and the next node
        temp.setNext(current.getNext());
        current.setNext(temp);
        listCount++;
    }

    public Object get(int index) {
        if (index < 1) {
            return null;
        }

        //start at the beginning of the link
        Node current = head.getNext();
        for (int i = 1; i < index; i++) {

            //Reached the end of the link
            if(current.getNext() == null){
                return null;
            }

            current = current.getNext();
        }

        return current.getData();
    }

    public boolean delete(int index){
        if (index < 1 || index > listCount) {
           throw new IndexOutOfBoundsException();
        }

        Node current = head;
        for(int i = 1; i < index; i++){
            if (current.getNext() == null){
                return false;
            }

            current = current.getNext();
        }

        //The next element is skipped in the chain.
        // Garbage collection will clear it later.

            current.setNext(current.getNext().getNext());

        listCount--;
        return true;
    }

    public int getListCount() {
        return listCount;
    }

    public String makeSentence(){

        Node current = head;

        StringBuilder sb = new StringBuilder();

        while(current.getNext() != null){
          current = current.getNext();
            sb.append(current.getData());
            sb.append(" ");
        }

        return sb.toString();
    }

    public void printReverse(Node head){

        if(head == null){
            return;
        }

        //Keeps getting the next element and adding them to the stack
        //A recursive solution to print the list in reverse.
        printReverse(head.getNext());

        //At this point the stack will unravel and call the system out method in reverse.
        if (head.data != null) {
            System.out.println(head.data);

        }
    }

    public Node getHead(){
        return this.head;
    }
}
