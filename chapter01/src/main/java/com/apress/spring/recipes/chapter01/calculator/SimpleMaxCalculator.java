package com.apress.spring.recipes.chapter01.calculator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimpleMaxCalculator implements MaxCalculator {
  @Override
  public double max(double a, double b) {
    var result = Math.max(a, b);
    log.info("max {},{} = {}", a, b, result);
    return result;
  }
}
