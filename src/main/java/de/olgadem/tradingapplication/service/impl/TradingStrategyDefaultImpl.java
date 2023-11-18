package de.olgadem.tradingapplication.service.impl;

import de.olgadem.tradingapplication.library.Algo;
import de.olgadem.tradingapplication.service.TradingStraregy;

public class TradingStrategyDefaultImpl implements TradingStraregy {
  @Override
  public void execute() {
    Algo algo = new Algo();
    algo.cancelTrades();
    algo.doAlgo();
  }
}
