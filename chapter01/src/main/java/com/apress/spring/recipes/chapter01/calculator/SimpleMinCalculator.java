package com.apress.spring.recipes.chapter01.calculator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimpleMinCalculator implements MinCalculator {
  @Override
  public double min(double a, double b) {
    var result = Math.min(a, b);
    log.info("min({},{}) = {}", a, b, result);
    return result;
  }
}
