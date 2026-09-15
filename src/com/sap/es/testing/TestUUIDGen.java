package com.sap.es.testing;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class TestUUIDGen {

  public static void main(String[] args) throws NoSuchAlgorithmException {
    //BigDecimal id = new BigDecimal(1725280);
    String s = generateDeterministicUUID("1725280");
    System.out.println(s);
  }

  public static String generateDeterministicUUID(String input) {

    try {
      // Hash the input using SHA-256
      MessageDigest digest = MessageDigest.getInstance("SHA-256");
      byte[] hashBytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));

      // Convert hash to hex string
      StringBuilder hexString = new StringBuilder();
      for (byte b : hashBytes) {
        hexString.append(String.format("%02x", b));
      }
      String hex = hexString.substring(0, 32).toLowerCase();

      // Format as UUID-like string: 8-4-4-4-12
      return String.format("%s-%s-%s-%s-%s",
          hex.substring(0, 8),
          hex.substring(8, 12),
          hex.substring(12, 16),
          hex.substring(16, 20),
          hex.substring(20, 32));
    } catch (NoSuchAlgorithmException e) {
      System.out.println(e);
      return null;
    }
  }
}
