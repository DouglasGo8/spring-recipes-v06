package com.apress.spring.recipes.chapter01.config;

import com.apress.spring.recipes.chapter01.shop.Cashier;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class ShopConfigurationGlobal {

  @Bean
  public Cashier cashier() {
    return new Cashier("checkout", System.getProperty("java.io.tmpdir") + "/cashier");
  }
}
