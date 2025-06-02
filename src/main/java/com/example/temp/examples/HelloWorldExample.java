package com.example.temp.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.App;

public class HelloWorldExample
{
  private static final Logger logger = LoggerFactory.getLogger(App.class);
  
  public static void main() {
    System.out.println("Hello World");
    logger.info("Hello World");
  }
}
