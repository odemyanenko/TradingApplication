package de.olgadem.tradingapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "de.olgadem.tradingapplication.repository")
public class TradingApplication {

  public static void main(String[] args) {
    SpringApplication.run(TradingApplication.class, args);
  }

}
