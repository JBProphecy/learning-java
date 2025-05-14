package com.example.persistence.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AccountTest
{
  @Test
  public void testToString() {
    Account account = new Account("1", "Jack", "fj@gmail.com", "hey");
    String expected = "Account{id='1', name='Jack'}";

    assertEquals(expected, account.toString());
  }
  
  @Test
  public void testEquals() {
    Account account01 = new Account("1", "Jack", "fj@gmail.com", "hey");
    Account account02 = new Account("1", "Jack", "fj@gmail.com", "hey");
    Account account03 = new Account("2", "Jack", "fj@gmail.com", "hey");

    assertTrue(account01.equals(account02));
    assertFalse(account01.equals(account03));
    assertFalse(account02.equals(account03));
  }

  @Test
  public void testHashCode() {
    Account account01 = new Account("1", "Jack", "fj@gmail.com", "hey");
    Account account02 = new Account("1", "Jack", "fj@gmail.com", "hey");
    Account account03 = new Account("2", "Jack", "fj@gmail.com", "hey");

    assertEquals(account01.hashCode(), account02.hashCode());
    assertNotEquals(account01.hashCode(), account03.hashCode());
    assertNotEquals(account02.hashCode(), account03.hashCode());
  }
}
