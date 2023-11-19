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
  private Map<Integer, TradingStrategy> strategies;

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
    TradingStrategyImpl tradingStrategy = new TradingStrategyImpl(strategy.getProcesses());

    /*
    Algo algo = tradingStrategy.getAlgo();

    List<String> processes = strategy.getProcesses();
    for (String process : processes) {
      if (process.startsWith("setAlgoParam")) {
        String[] tokens = process.split("\\(")[1].split(",");
        int param1 = Integer.parseInt(tokens[0].trim());
        int param2 = Integer.parseInt(tokens[1].split("\\)")[0].trim());

        try {
          Method method = Algo.class.getDeclaredMethod("setAlgoParam", int.class, int.class);
          method.invoke(algo, param1, param2);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
          e.printStackTrace(); // Handle the exception according to your needs
        }
      } else {
        try {
          Method method = Algo.class.getDeclaredMethod(process);
          method.invoke(algo);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
          e.printStackTrace(); // Handle the exception according to your needs
        }
      }
    }
*/
    return tradingStrategy;
  }

  public void handleSignal(int signal) {
    System.out.println("Input Signal: " + signal);
    TradingStrategy strategy = strategies.getOrDefault(signal, new TradingStrategyImpl(null));
    strategy.execute();
  }

}
