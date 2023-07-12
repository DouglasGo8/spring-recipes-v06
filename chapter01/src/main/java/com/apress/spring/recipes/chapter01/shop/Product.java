package com.apress.spring.recipes.chapter01.shop;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Product {
  private final String name;
  private final double price;
  @Override
  public String toString() {
    return String.format("%s: name=%s, price=$%.2f",
            getClass().getSimpleName(), name, price);
  }
}
