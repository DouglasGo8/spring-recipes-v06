package com.apress.spring.recipes.chapter01.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"com.apress.spring.recipes.chapter01.calculator"})
public class CalculatorConfiguration {
}
