package com.apress.spring.recipes.chapter01.shop;

import lombok.Getter;

@Getter
public class Disc extends Product {
  private final int capacity;
  public Disc(String name, double price, int capacity) {
    super(name, price);
    this.capacity = capacity;
  }
}
