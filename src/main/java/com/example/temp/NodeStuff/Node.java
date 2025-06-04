package com.example.temp.NodeStuff;

public class Node<T> {
  private T value;
  private Node<T> next;

  public Node(T value) { this.value = value; }

  public Node<T> getNext() { return next; }
  public void setNext(Node<T> node) { this.next = node; }

  @Override
  public String toString() {
    return "Node [value=" + this.value + "]";
  }
}
