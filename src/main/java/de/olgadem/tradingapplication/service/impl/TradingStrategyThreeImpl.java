package de.olgadem.tradingapplication.service.impl;

import de.olgadem.tradingapplication.library.Algo;
import de.olgadem.tradingapplication.service.TradingStraregy;

public class TradingStrategyThreeImpl implements TradingStraregy {
  @Override
  public void execute() {
    Algo algo = new Algo();
    algo.setAlgoParam(1, 90);
    algo.setAlgoParam(2, 15);
    algo.performCalc();
    algo.submitToMarket();
    algo.doAlgo();
  }
}
