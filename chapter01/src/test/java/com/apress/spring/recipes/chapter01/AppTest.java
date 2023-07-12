package com.apress.spring.recipes.chapter01;

import com.apress.spring.recipes.chapter01.calculator.*;
import com.apress.spring.recipes.chapter01.config.CalculatorConfiguration;
import com.apress.spring.recipes.chapter01.config.ShopConfiguration;
import com.apress.spring.recipes.chapter01.config.ShopConfigurationGlobal;
import com.apress.spring.recipes.chapter01.config.ShopConfigurationMap;
import com.apress.spring.recipes.chapter01.shop.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@Slf4j
@ComponentScan
public class AppTest {


  @Test
  @Disabled
  public void createProduct() {
    try (var ctx = new AnnotationConfigApplicationContext(ShopConfiguration.class)) {
      var product = ctx.getBean("aaa", Product.class);
      log.info(product.toString());
    }
  }


  @Test
  @Disabled
  public void createProductMap() {
    try (var ctx = new AnnotationConfigApplicationContext(ShopConfigurationMap.class)) {
      var product = ctx.getBean("aaa", Product.class);
      log.info(product.toString());
    }
  }

  @Test
  @Disabled
  public void createProductBasedOnProfile() {
    try (var ctx = new AnnotationConfigApplicationContext()) {
      ctx.getEnvironment().setActiveProfiles("winter");
      ctx.register(ShopConfigurationGlobal.class);
      ctx.refresh();
      //var product = ctx.getBean("aaa", Product.class);
      //log.info(product.toString());
    }
  }

  @Test
  @Disabled
  public void testAspectJAutoProxy() {
    try (var context = new AnnotationConfigApplicationContext(CalculatorConfiguration.class)) {
      var arithmeticCalculator = context.getBean(ArithmeticCalculator.class);

      arithmeticCalculator.add(2, 2);
      arithmeticCalculator.sub(10, 2);

      var unitCalculator = context.getBean(UnitCalculator.class);
      unitCalculator.kilogramToPound(10);
    }
  }

  @Test
  @Disabled
  public void testDeclaredParents() {
    try (var context = new AnnotationConfigApplicationContext(CalculatorConfiguration.class)) {
      var arithmeticCalculator = context.getBean(ArithmeticCalculator.class);
      var maxCalculator = (MaxCalculator) arithmeticCalculator;
      maxCalculator.max(1, 2);
      var minCalculator = (MinCalculator) arithmeticCalculator;
      minCalculator.min(1, 2);
    }
  }

  @Test
  @Disabled
  public void testAdditionalBehavior() {
    try (var context = new AnnotationConfigApplicationContext(CalculatorConfiguration.class)) {
      var arithmeticCalculator = context.getBean(ArithmeticCalculator.class);
      arithmeticCalculator.add(1, 2);
      arithmeticCalculator.sub(4, 3);
      arithmeticCalculator.mul(2, 3);
      arithmeticCalculator.div(4, 2);
      //
      var unitCalculator = context.getBean(UnitCalculator.class);
      unitCalculator.kilogramToPound(10);
      unitCalculator.kilometerToMile(5);
      //
      var maxCalculator = (MaxCalculator) arithmeticCalculator;
      maxCalculator.max(1, 2);
      var minCalculator = (MinCalculator) arithmeticCalculator;
      minCalculator.min(1, 2);
      var arithmeticCounter = (Counter) arithmeticCalculator;
      //
      log.info("The counter was called {}", arithmeticCounter.getCount());
      var unitCounter = (Counter) unitCalculator;
      log.info("The counter was called {}", unitCounter.getCount());
    }
  }

  @Test
  @Disabled
  public void testWeavingBehavior() {
    try (var context = new AnnotationConfigApplicationContext(CalculatorConfiguration.class)) {
      var complexCalculator = context.getBean(ComplexCalculator.class);
      complexCalculator.add(new Complex(1, 2), new Complex(2, 3));
      complexCalculator.sub(new Complex(5, 8), new Complex(2, 3));
    }
  }

  @Test
  public void add() {

  }


}
