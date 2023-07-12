package com.apress.spring.recipes.chapter01.shop;

import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class ProductCreatorMap {

  final Map<String,Product> products;

  public Product createProduct(String id) {
    var product = products.get(id);
     if (null == product)
       throw new IllegalArgumentException("Unknown Product '" + id + "'");
     return product;
  }
}
