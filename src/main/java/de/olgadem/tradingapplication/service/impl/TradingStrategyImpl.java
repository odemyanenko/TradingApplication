package de.olgadem.tradingapplication.service.impl;

import de.olgadem.tradingapplication.library.Algo;
import de.olgadem.tradingapplication.service.TradingStrategy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class TradingStrategyImpl implements TradingStrategy {
  private final String PROCESS_SET_ALGO_PARAM = "setAlgoParam";
  private final List<String> processes;
  private final Algo algo;

  public TradingStrategyImpl(List<String> processes) {
    this.algo = new Algo();
    this.processes = processes;
  }

  public Algo getAlgo() {
    return algo;
  }

  @Override
  public void execute() {
    if ((processes != null) && !processes.isEmpty()) {
      callProcesses();
    } else {
      callDefaultProcess();
    }
    algo.doAlgo();
  }

  private void callProcesses() {
    for (String process : processes) {
      if (process.startsWith(PROCESS_SET_ALGO_PARAM)) {
        String[] params = process.split("\\(")[1].split(",");
        int param1 = Integer.parseInt(params[0].trim());
        int param2 = Integer.parseInt(params[1].split("\\)")[0].trim());

        try {
          Method method = Algo.class.getDeclaredMethod(PROCESS_SET_ALGO_PARAM, int.class, int.class);
          method.invoke(algo, param1, param2);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
          e.printStackTrace(); // log
        }
      } else {
        try {
          Method method = Algo.class.getDeclaredMethod(process);
          method.invoke(algo);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
          e.printStackTrace(); // log
        }
      }
    }
  }

  private void callDefaultProcess(){
    algo.cancelTrades();
  }

}

