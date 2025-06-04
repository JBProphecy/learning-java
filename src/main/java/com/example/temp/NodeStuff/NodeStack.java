package com.example.temp.NodeStuff;

import java.util.Iterator;

public class NodeStack<T> implements Iterable<Node<T>> {
  private Node<T> head;

  // Accept a Value, Create a Node with the Provided Value, Append it to the Stack
  public void push(T value) {
    Node<T> node = new Node<T>(value);
    push(node);
  }
  // Accept a Node, Append it to the Stack
  public void push(Node<T> node) {
    node.setNext(head);
    this.head = node;
  }

  // Reassign the Head of the Stack and Return the Previous Head
  public Node<T> pop() {
    Node<T> node = this.head;
    this.head = this.head.getNext();
    node.setNext(null);
    return node;
  }

  // Return the Head of the Stack
  public Node<T> peek() {
    return this.head;
  }

  @Override
  public Iterator<Node<T>> iterator() {
    return new NodeStackIterator<T>(this);
  }
}
