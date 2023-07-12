package com.apress.spring.recipes.chapter01.calculator;

import org.springframework.stereotype.Component;

@Component
public class ComplexFormatter {

  private String pattern = "(a + bi)";

  public void setPattern(String pattern) {
    this.pattern = pattern;
  }

  public String format(ComplexTwo complex) {
    return pattern.replaceAll("a", Integer.toString(complex.getReal()))
            .replaceAll("b", Integer.toString(complex.getImaginary()));
  }
}
