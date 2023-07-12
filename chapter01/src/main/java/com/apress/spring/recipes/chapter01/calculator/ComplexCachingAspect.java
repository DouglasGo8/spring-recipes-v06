package com.apress.spring.recipes.chapter01.calculator;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Aspect
public class ComplexCachingAspect {
  private final Map<String, Complex> cache = new ConcurrentHashMap<>();

  // must add aspect lib when loading jar
  @Around(value = "call(public com.apress.spring.recipes.chapter01.calculator.Complex.new(int, int)) && args(a,b)",
          argNames = "pjp,a,b")
  public Object cacheAround(ProceedingJoinPoint pjp, int a, int b) throws Throwable {
    var key = a + "," + b;
    return cache.compute(key, (key1, val) -> checkCacheOrCalculate(pjp, key1, val));
  }

  private Complex checkCacheOrCalculate(ProceedingJoinPoint pjp, String key, Complex
          current) {
    if (current == null) {
      try {
        System.out.println("Cache MISS for (" + key + ")");
        return (Complex) pjp.proceed();
      } catch (Throwable ex) {
        throw new IllegalStateException(ex);
      }
    } else {
      System.out.println("Cache HIT for (" + key + ")");
      return current;
    }
  }
}
