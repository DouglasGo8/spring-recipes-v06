package com.apress.spring.recipes.chapter01.shop;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Cashier {
  final String path;
  final String action;
}
