package com.example.data.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;

import org.junit.jupiter.api.Test;

public class AccountTest
{
  @Test
  public void testToString() {
    UUID uuid = UUID.randomUUID();
    Account account = Account.construct(uuid, "Jack", "fj@gmail.com", "hey");
    String expected = "Account{id='" + uuid + "', name='Jack'}";

    assertEquals(expected, account.toString());
  }
  
  @Test
  public void testEquals() {
    UUID uuid1 = UUID.randomUUID();
    UUID uuid2 = UUID.randomUUID();
    Account account01 = Account.construct(uuid1, "Jack", "fj@gmail.com", "hey");
    Account account02 = Account.construct(uuid1, "Jack", "fj@gmail.com", "hey");
    Account account03 = Account.construct(uuid2, "Jack", "fj@gmail.com", "hey");

    assertTrue(account01.equals(account02));
    assertFalse(account01.equals(account03));
    assertFalse(account02.equals(account03));
  }

  @Test
  public void testHashCode() {
    UUID uuid1 = UUID.randomUUID();
    UUID uuid2 = UUID.randomUUID();
    Account account01 = Account.construct(uuid1, "Jack", "fj@gmail.com", "hey");
    Account account02 = Account.construct(uuid1, "Jack", "fj@gmail.com", "hey");
    Account account03 = Account.construct(uuid2, "Jack", "fj@gmail.com", "hey");

    assertEquals(account01.hashCode(), account02.hashCode());
    assertNotEquals(account01.hashCode(), account03.hashCode());
    assertNotEquals(account02.hashCode(), account03.hashCode());
  }
}
