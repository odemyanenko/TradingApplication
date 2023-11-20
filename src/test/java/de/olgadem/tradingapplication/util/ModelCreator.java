package de.olgadem.tradingapplication.util;

import de.olgadem.tradingapplication.model.Strategy;

import java.util.List;

public class ModelCreator {
  public static Strategy getStrategy1() {
    return new Strategy(
            "Strategy 1",
            List.of(
                    "setUp",
                    "setAlgoParam(1, 60)",
                    "performCalc",
                    "submitToMarket"
            ));
  }

  public static Strategy getStrategy2() {
    return new Strategy(
            "Strategy 2",
            List.of(
                    "reverse",
                    "setAlgoParam(1, 80)",
                    "submitToMarket"
            ));
  }

  public static Strategy getStrategy3() {
    return new Strategy(
            "Strategy 3",
            List.of(
                    "setAlgoParam(1, 90)",
                    "setAlgoParam(2, 15)",
                    "performCalc",
                    "submitToMarket"
            ));
  }

  public static Strategy getStrategyNew() {
    return new Strategy(
            "Strategy NEW",
            List.of(
                    "setUp",
                    "setAlgoParam(3, 50)",
                    "setAlgoParam(22, 115)",
                    "submitToMarket"
            ));
  }
}
