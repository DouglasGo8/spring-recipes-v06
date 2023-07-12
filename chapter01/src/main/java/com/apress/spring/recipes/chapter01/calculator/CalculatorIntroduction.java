package com.apress.spring.recipes.chapter01.calculator;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CalculatorIntroduction {
  @DeclareParents(value = "com.apress.spring.recipes.chapter01.calculator.StandardArithmeticCalculator",
          defaultImpl = SimpleMaxCalculator.class)
  public MaxCalculator maxCalculator;

  @DeclareParents(value = "com.apress.spring.recipes.chapter01.calculator.StandardArithmeticCalculator",
          defaultImpl = SimpleMinCalculator.class)
  public MinCalculator minCalculator;

  @DeclareParents(value = "com.apress.spring.recipes.chapter01.calculator.Standard*Calculator",
          defaultImpl = SimpleCounter.class)
  public Counter counter;

  @After(value = "execution(* com.apress.spring.recipes.chapter01.calculator.*Calculator.*(..)) && this(counter)",
          argNames = "counter")
  public void increaseCounter(Counter counter) {
    counter.increase();
  }
}
