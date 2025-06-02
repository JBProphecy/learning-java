package com.example.utils;

import java.math.BigInteger;
import java.util.UUID;

public class Base62 {
  private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

  private static byte[] fromUUID(UUID uuid) {
    byte[] bytes = new byte[16];
    long msb = uuid.getMostSignificantBits();
    long lsb = uuid.getLeastSignificantBits();
    for (int i = 0; i < 8; i++) { bytes[i] = (byte) ((msb >> (8 * (7 - i))) & 0xff); }
    for (int i = 8; i < 16; i++) { bytes[i] = (byte) ((lsb >> (8 * (15 - i))) & 0xff); }
    return bytes;
  }

  private static UUID toUUID(byte[] bytes) {
    long msb = 0; // for the 64 most significant bits
    long lsb = 0; // for the 64 least significant bits
    for (int i = 0; i < 8; i++) { msb = (msb << 8) | (bytes[i] & 0xff); }
    for (int i = 8; i < 16; i++) { lsb = (lsb << 8) | (bytes[i] & 0xff); }
    return new UUID(msb, lsb);
  }

  public static String encode(UUID uuid) {
    byte[] bytes = fromUUID(uuid);
    BigInteger number = new BigInteger(1, bytes);
    StringBuilder sb = new StringBuilder();
    while (number.compareTo(BigInteger.ZERO) > 0) {
      BigInteger[] divmod = number.divideAndRemainder(BigInteger.valueOf(62));
      number = divmod[0];
      int remainder = divmod[1].intValue();
      sb.append(ALPHABET.charAt(remainder));
    }
    return sb.reverse().toString();
  }

  public static UUID decode(String base62) {
    BigInteger number = BigInteger.ZERO;
    for (char c : base62.toCharArray()) {
      int index = ALPHABET.indexOf(c);
      if (index == -1) { throw new IllegalArgumentException("Invalid Character: " + c); }
      number = number.multiply(BigInteger.valueOf(62)).add(BigInteger.valueOf(index));
    }
    byte[] bytes = number.toByteArray();
    byte[] uuidBytes = new byte[16];
    int offset = bytes.length > 16 ? bytes.length - 16 : 0;
    int length = Math.min(16, bytes.length);
    System.arraycopy(bytes, offset, uuidBytes, 16 - length, length);
    return toUUID(uuidBytes);
  }
}
