package com.apress.spring.recipes.chapter01.calculator;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class CalculatorPointcuts {
  @Pointcut("within(com.apress.spring.recipes.chapter01.calculator.ArithmeticCalculator)")
  public void arithmeticOperation(){}

  @Pointcut("within(com.apress.spring.recipes.chapter01.calculator.UnitCalculator+)")
  public void unitOperation(){}

  //@Pointcut("arithmeticOperation() || unitOperation()")
  //public void loggingOperation() {}
}
