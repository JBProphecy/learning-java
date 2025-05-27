package com.example.temp;

import java.util.Iterator;

public class NodeStackIterator<T> implements Iterator<Node<T>> {
  private Node<T> cursor;

  public NodeStackIterator(NodeStack<T> stack) {
    this.cursor = stack.peek();
  }

  @Override
  public boolean hasNext() {
    return this.cursor != null ? true : false;
  }

  @Override
  public Node<T> next() {
    Node<T> node = this.cursor;
    this.cursor = node.getNext();
    return node;
  }
}
