package com.apress.spring.recipes.chapter01.calculator;

import lombok.ToString;


public record Complex(int real, int imaginary) {
  @Override
  public String toString() {
    return "(" + real + " + " + imaginary + "i)";
  }
}
