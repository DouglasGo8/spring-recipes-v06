package com.apress.spring.recipes.chapter01.calculator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static org.slf4j.helpers.MessageFormatter.format;

@Slf4j
@Component
public class StandardUnitCalculator implements UnitCalculator {
  @Override
  public double kilogramToPound(double kilogram) {
    var pound = kilogram * 2.2;
    log.info("{} kilogram = {} pound", format("%.03f", kilogram),
            format("%.03f", pound));
    return pound;
  }

  @Override
  public double kilometerToMile(double kilometer) {
    var mile = kilometer * 0.62;
    log.info("{} kilometer = {} mile", format("%.03f", kilometer),
            format("%.03f", mile));
    return mile;
  }
}
