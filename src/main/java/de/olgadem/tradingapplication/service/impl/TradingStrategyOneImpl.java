package de.olgadem.tradingapplication.service.impl;

import de.olgadem.tradingapplication.library.Algo;
import de.olgadem.tradingapplication.service.TradingStraregy;

public class TradingStrategyOneImpl implements TradingStraregy {
  @Override
  public void execute() {
    Algo algo = new Algo();
    algo.setUp();
    algo.setAlgoParam(1, 60);
    algo.performCalc();
    algo.submitToMarket();
    algo.doAlgo();
  }
}
