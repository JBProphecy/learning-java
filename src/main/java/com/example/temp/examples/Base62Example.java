package com.example.temp.Examples;

import java.util.UUID;

import com.example.utils.Base62;

public class Base62Example {
  public static void main() {
    UUID randomUUID = UUID.randomUUID();
    System.out.println("Random UUID: " + randomUUID);
    String base62 = Base62.encode(randomUUID);
    System.out.println("Base 62 Encoded: " + base62);
    System.out.println("UUID Decoded: " + Base62.decode(base62));
  }
}
