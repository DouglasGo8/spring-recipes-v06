package com.apress.spring.recipes.chapter01.calculator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StandardComplexCalculator implements ComplexCalculator {
  @Override
  public Complex add(Complex a, Complex b) {
    var result = new Complex(a.real() + b.real(), a.imaginary() + b.imaginary());
    log.info("{} + {} = {}", a, b, result);
    return result;
  }

  @Override
  public Complex sub(Complex a, Complex b) {
    var result = new Complex(a.real() - b.real(), a.imaginary() - b.imaginary());
    log.info("{} + {} = {}", a, b, result);
    return result;
  }
}
