package com.apress.spring.recipes.chapter01.config;


import com.apress.spring.recipes.chapter01.shop.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class ShopConfigurationMap {


  @Bean
  ProductCreatorMap createProductMap() {
    var battery = new Battery("AAA", 2.5, true);
    var cdrw = new Disc("CD-RW", 1.5, 700);
    var dvdrw = new Disc("DVD-RW", 3.0, 4700);
    return new ProductCreatorMap(Map.of("aaa", battery, "cdrw", cdrw, "dvdrw", dvdrw));
  }


  @Bean
  public Product aaa(ProductCreatorMap productCreatorMap) {
    return productCreatorMap.createProduct("aaa");
  }


  @Bean
  public Product cdrw(ProductCreatorMap productCreatorMap) {
    return productCreatorMap.createProduct("cdrw");
  }

  @Bean
  public Product dvdrw(ProductCreatorMap productCreatorMap) {
    return productCreatorMap.createProduct("dvdrw");
  }


}
