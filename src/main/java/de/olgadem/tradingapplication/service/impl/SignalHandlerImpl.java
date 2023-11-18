package de.olgadem.tradingapplication.service.impl;

import de.olgadem.tradingapplication.service.SignalHandler;
import de.olgadem.tradingapplication.service.TradingStraregy;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SignalHandlerImpl implements SignalHandler {
  private final Map<Integer, TradingStraregy> strategies;

  public SignalHandlerImpl() {
    this.strategies = new HashMap<>();
    strategies.put(1, new TradingStrategyOneImpl());
    strategies.put(2, new TradingStrategyTwoImpl());
    strategies.put(3, new TradingStrategyThreeImpl());
  }

  public void handleSignal(int signal) {
    System.out.println("Input Signal: " + signal);
    TradingStraregy strategy = strategies.getOrDefault(signal, new TradingStrategyDefaultImpl());
    strategy.execute();
  }
}

