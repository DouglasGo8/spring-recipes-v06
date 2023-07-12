package com.apress.spring.recipes.chapter01.config;

import com.apress.spring.recipes.chapter01.shop.Product;
import com.apress.spring.recipes.chapter01.shop.ProductCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShopConfiguration {

  @Bean
  public Product aaa() {
    return ProductCreator.createProduct("aaa");
  }

  @Bean
  public Product cdrw() {
    return ProductCreator.createProduct("cdrw");
  }

  @Bean
  public Product dvdrw() {
    return ProductCreator.createProduct("dvdrw");
  }
}
