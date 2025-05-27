package com.example.examples;

import java.util.LinkedList;

public class LinkedListExample
{
  public static void main() {
    // Create Linked List
    LinkedList<Integer> myLinkedList = new LinkedList<Integer>();

    // Add Items to Linked List
    myLinkedList.add(12);
    myLinkedList.add(24);
    myLinkedList.add(36);
    myLinkedList.add(48);

    // Display Linked List
    System.out.println(myLinkedList);

    // Get Items from Linked List
    System.out.println(myLinkedList.getFirst()); // get first item
    System.out.println(myLinkedList.getLast()); // get last item
    System.out.println(myLinkedList.get(2)); // get by index

    // Set Items in Linked List
    myLinkedList.set(2, 365);

    // Remove Items from Linked List
    myLinkedList.remove(1);
    myLinkedList.remove(Integer.valueOf(365));

    // Get Size of Linked List
    System.out.println(myLinkedList.size());

    // Empty Linked List
    myLinkedList.clear();
  }
}
