package com.apress.spring.recipes.chapter01.config;

import com.apress.spring.recipes.chapter01.shop.Battery;
import com.apress.spring.recipes.chapter01.shop.Disc;
import com.apress.spring.recipes.chapter01.shop.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("autumn")
public class ShopConfigurationAut {
  @Bean
  public Product aaa() {
    return new Battery("AAA", 2.5, true);
  }

  @Bean
  public Product cdrw() {
    return new Disc("CD-RW", 1.5, 700);
  }

  @Bean
  public Product dvdrw() {
    return new Disc("DVD-RW", 3.0, 4700);
  }
}
