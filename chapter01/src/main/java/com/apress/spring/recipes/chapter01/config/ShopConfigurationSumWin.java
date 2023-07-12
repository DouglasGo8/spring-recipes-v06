package com.apress.spring.recipes.chapter01.config;

import com.apress.spring.recipes.chapter01.shop.Battery;
import com.apress.spring.recipes.chapter01.shop.Product;
import com.apress.spring.recipes.chapter01.shop.ProductCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"summer", "winter"})
public class ShopConfigurationSumWin {
  @Bean
  public Product aaa() {
    return new Battery("AAA from Winter/Summer", 2.0, true);
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
