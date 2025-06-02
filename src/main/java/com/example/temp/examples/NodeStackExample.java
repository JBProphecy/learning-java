package com.example.temp.examples;

import java.util.Iterator;

import com.example.temp.Node;
import com.example.temp.NodeStack;

public class NodeStackExample
{
  public static void main() {
    // Node Stack
    NodeStack<Integer> stack = new NodeStack<Integer>();
    stack.push(12);
    stack.push(24);
    stack.push(36);
    stack.push(48);
    System.out.println("Enhanced For-Loop [NodeStack]");
    for (Node<Integer> node : stack) {
      System.out.println(node);
    }
    System.out.println("Iterator While-Loop [NodeStack]");
    Iterator<Node<Integer>> iterator = stack.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }
}
