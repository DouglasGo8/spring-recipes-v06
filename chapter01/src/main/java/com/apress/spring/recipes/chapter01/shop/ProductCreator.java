package com.apress.spring.recipes.chapter01.shop;

public class ProductCreator {

  public static Product createProduct(String productId) {

    // Map.of(new Battery(....)) can be used

    return switch (productId) {
      case "aaa" -> new Battery("AAA", 2.5, true);
      case "cdrw" -> new Disc("CD-RW", 1.5, 700);
      case "dvdrw" -> new Disc("DVD-RW", 3.0, 4700);
      default -> throw new IllegalArgumentException("Unknown product '" + productId + "'");
    };
  }
}
