package com.apress.spring.recipes.chapter01.audit;

import com.apress.spring.recipes.chapter01.shop.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AuditCheckBeanPostProcessor implements BeanPostProcessor {
  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
    log.info("Class {}", bean.getClass().getName());
    return bean;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    if (bean instanceof Product product) {
      var name = product.getName();
      log.info(name);
    }
    return bean;
  }
}
