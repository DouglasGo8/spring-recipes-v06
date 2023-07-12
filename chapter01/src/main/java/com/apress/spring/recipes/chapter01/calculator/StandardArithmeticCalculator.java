package com.apress.spring.recipes.chapter01.calculator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static org.slf4j.helpers.MessageFormatter.format;

@Slf4j
@Component
public class StandardArithmeticCalculator implements ArithmeticCalculator {
  @Override
  public double add(double a, double b) {
    var result = a + b;
    log.info("{} + {} = {}", a, b, result);
    return result;
  }

  @Override
  public double sub(double a, double b) {
    var result = a - b;
    log.info("{} + {} = {}", a, b, result);
    return result;
  }

  @Override
  public double mul(double a, double b) {
    var result = a * b;
    log.info("{} + {} = {}", a, b, result);
    return result;
  }

  @Override
  public double div(double a, double b) {
    if (b == 0) throw new IllegalArgumentException("Division by Zero is not possible");
    var result = a / b;
    log.info("{} + {} = {}", a, b, result);
    return result;
  }
}
