package com.apress.spring.recipes.chapter01.calculator;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Slf4j
@Getter
@Component
@Configurable
@Scope("prototype")
public class ComplexTwo {
  private final int real;
  private final int imaginary;
  private ComplexFormatter formatter;

  public ComplexTwo(int real, int imaginary) {
    this.real = real;
    this.imaginary = imaginary;
  }

  @Autowired
  public void setFormatter(ComplexFormatter formatter) {
    this.formatter = formatter;
  }

  @Override
  public String toString() {
    return formatter.format(this);
  }
}
