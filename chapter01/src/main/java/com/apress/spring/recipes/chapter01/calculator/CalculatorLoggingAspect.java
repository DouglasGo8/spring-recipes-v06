package com.apress.spring.recipes.chapter01.calculator;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Slf4j
@Aspect
@Component
public class CalculatorLoggingAspect {

  // JoinPoint
  @Before("execution(* ArithmeticCalculator.add(..))")
  public void logBefore() {
    log.info("The method add() begins");
  }

  @Before("execution (* *.*(..))")
  public void logBefore(JoinPoint joinPoint) {
    var name = joinPoint.getSignature().getName();
    var args = Arrays.toString(joinPoint.getArgs());
    //
    log.info("The method {}() begins with {}", name, args);
  }

  @After("execution(* *.*(..))")
  public void logAfter(JoinPoint joinPoint) {
    var name = joinPoint.getSignature().getName();
    log.info("The method {}() ends", name);
  }

  @AfterReturning("execution(* *.*(..))")
  public void logAfterReturning(JoinPoint joinPoint) {
    var name = joinPoint.getSignature().getName();
    log.info("The method {}() has ended.", name);
  }

  @AfterReturning(pointcut = "execution(* *.*(..))", returning = "result")
  public void logAfterReturning(JoinPoint joinPoint, Object result) {
    var name = joinPoint.getSignature().getName();
    log.info("The method {}() ends with {}.", name, result);
  }

  @AfterThrowing("execution(* *.*(..))")
  public void logAfterThrowing(JoinPoint joinPoint) {
    var name = joinPoint.getSignature().getName();
    log.error("The method {}() has ended.", name);
  }

  @AfterThrowing(pointcut = "execution(* *.*(..))", throwing = "ex")
  public void logAfterThrowing(JoinPoint joinPoint, Throwable ex) {
    var name = joinPoint.getSignature().getName();
    log.error("An exception {} has been thrown in {}()", ex, name);
  }

  @AfterThrowing(pointcut = "execution(* *.*(..))", throwing = "ex")
  public void logAfterThrowing(JoinPoint joinPoint, IllegalArgumentException ex) {
    var args = Arrays.toString(joinPoint.getArgs());
    var name = joinPoint.getSignature().getName();
    log.error("Illegal argument {} in {}()", args, name);
  }

  @SneakyThrows
  @Around("execution (* *.*(..))")
  public Object logAround(ProceedingJoinPoint joinPoint) {
    var name = joinPoint.getSignature().getName();
    var args = Arrays.toString(joinPoint.getArgs());
    log.info("The method {}() begins with {}.", name, args);
    try {
      var result = joinPoint.proceed();
      log.info("The method {}() ends with {}.", name, result);
      return result;
    } catch (Throwable ex) {
      log.error("Illegal argument {} in {}()", args, name);
      throw ex;
    }
  }

  @Before("execution(* *.*(..))")
  public void logJoinPoint(JoinPoint jp) {
    log.info("Join point kind : {}", jp.getKind());
    log.info("Signature declaring type : {}", jp.getSignature().getDeclaringTypeName());
    log.info("Signature name : {}", jp.getSignature().getName());
    log.info("Arguments : {}", Arrays.toString(jp.getArgs()));
    log.info("Target class : {}", jp.getTarget().getClass().getName());
    log.info("This class : {}", jp.getThis().getClass().getName());
  }

  @Before("execution(* *.*(double, double))")
  public void validateBefore(JoinPoint joinPoint) {
    for (var arg : joinPoint.getArgs()) {
      validate((Double) arg);
    }
  }

  private void validate(double a) {
    if (a < 0) {
      throw new IllegalArgumentException("Positive numbers only");
    }
  }

  //@Before(value = "execution(* *.*(..)) && target(target) && args(a,b)", argNames = "target,a,b")
  //public void logParameter(Object target, double a, double b) {
  //  log.info("Target class : {}", target.getClass().getName());
  ///  log.info("Arguments : {},{}", a, b);
  //}

  // for reusable aspects
  // can be separated in a specific class
  //@Pointcut("execution (* *.*(..))")
  //private void loggingOperation() {}

  //@Before("loggingOperation()")

  //@Target({ ElementType.METHOD, ElementType.TYPE })
  //@Retention(RetentionPolicy.RUNTIME)
  //@Documented
  //public @interface LoggingRequired { }
  //@Pointcut("@annotation(com.apress.spring6recipes.calculator.LoggingRequired)")

  //matches all the method execution join points within the com.apress.spring6recipes.calculator package
  //within(com.apress.spring6recipes.calculator.*)

  // Package and subpackage
  //within(com.apress.spring6recipes.calculator..*)

  //target class is located in the same package as this aspect, the package name can be omitted:
  //within(StandardArithmeticCalculator)
}
