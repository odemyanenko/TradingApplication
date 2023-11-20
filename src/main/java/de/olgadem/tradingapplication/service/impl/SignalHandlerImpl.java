package de.olgadem.tradingapplication.service.impl;

import de.olgadem.tradingapplication.model.Strategy;
import de.olgadem.tradingapplication.repository.StrategyRepository;
import de.olgadem.tradingapplication.service.SignalHandler;
import de.olgadem.tradingapplication.service.TradingStrategy;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SignalHandlerImpl implements SignalHandler {

  private final StrategyRepository strategyRepository;
  private final Map<Integer, TradingStrategy> strategies;

  public SignalHandlerImpl(StrategyRepository strategyRepository) {
    this.strategyRepository = strategyRepository;
    this.strategies = new HashMap<>();
    initializeStrategies();
  }

  private void initializeStrategies() {
    List<Strategy> strategyList = strategyRepository.findAll();

    for (Strategy strategy : strategyList) {
      TradingStrategy tradingStrategy = createTradingStrategy(strategy);
      strategies.put(strategy.getId(), tradingStrategy);
    }
  }

  private TradingStrategy createTradingStrategy(Strategy strategy) {
    return new TradingStrategyImpl(strategy.getProcesses());
  }

  public void handleSignal(int signal) {
    System.out.println("Input Signal: " + signal);
    TradingStrategy strategy = strategies.getOrDefault(signal, new TradingStrategyImpl(null));
    strategy.execute();
  }

}
