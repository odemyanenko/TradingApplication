package de.olgadem.tradingapplication.service.impl;

import de.olgadem.tradingapplication.library.Algo;
import de.olgadem.tradingapplication.service.TradingStraregy;

public class TradingStrategyTwoImpl implements TradingStraregy {
  @Override
  public void execute() {
    Algo algo = new Algo();
    algo.reverse();
    algo.setAlgoParam(1, 80);
    algo.submitToMarket();
    algo.doAlgo();
  }
}
