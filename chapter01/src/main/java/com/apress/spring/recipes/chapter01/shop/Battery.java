package com.apress.spring.recipes.chapter01.shop;

import lombok.Getter;

@Getter
public class Battery extends Product {
  private final boolean rechargeable;
  public Battery(String name, double price, boolean rechargeable) {
    super(name, price);
    this.rechargeable = rechargeable;
  }
}
