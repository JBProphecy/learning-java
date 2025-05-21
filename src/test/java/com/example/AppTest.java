package com.example;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppTest 
{
  private static final Logger logger = LoggerFactory.getLogger(AppTest.class);

  @BeforeAll
  public static void beforeAllTests()
  { logger.info("Starting Tests for App.java"); }

  @BeforeEach
  public void beforeEachTest()
  { logger.info("Performing Test in AppTest.java"); }

  @AfterEach
  public void afterEachTest()
  { logger.info("Completed Test in AppTest.java"); }

  @AfterAll
  public static void afterAllTests()
  { logger.info("Finished Tests for App.java"); }

  @Test
  public void shouldAnswerWithTrue()
  { assertTrue( true ); }
}
