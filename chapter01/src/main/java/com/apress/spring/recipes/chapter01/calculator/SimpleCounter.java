package com.apress.spring.recipes.chapter01.calculator;


import java.util.concurrent.atomic.AtomicInteger;

public class SimpleCounter implements Counter {

  final AtomicInteger counter = new AtomicInteger();

  @Override
  public void increase() {
    counter.incrementAndGet();
  }

  @Override
  public int getCount() {
    return counter.get();
  }
}
