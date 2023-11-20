package de.olgadem.tradingapplication.service;

import de.olgadem.tradingapplication.library.Algo;
import de.olgadem.tradingapplication.model.Strategy;
import de.olgadem.tradingapplication.service.impl.SignalHandlerImpl;
import de.olgadem.tradingapplication.service.impl.TradingStrategyImpl;
import de.olgadem.tradingapplication.util.ModelCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Method;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TradingStrategyTest {
  private TradingStrategyImpl tradingStrategy;

  @BeforeEach
  void setUp() {
    Strategy strategy = ModelCreator.getStrategy1();
    tradingStrategy = new TradingStrategyImpl(strategy.getProcesses());
  }

  @Test
  void executeTest() throws NoSuchMethodException {
    //given
    tradingStrategy = new TradingStrategyImpl(Collections.singletonList("setAlgoParam(1, 60)"));
    Method method = Algo.class.getDeclaredMethod("setAlgoParam", int.class, int.class);

    //when
    // when(tradingStrategy.getAlgo().getClass().getDeclaredMethod("setAlgoParam", int.class, int.class)).thenReturn(method);
    tradingStrategy.execute();

    //then
    //verify(tradingStrategy.getAlgo(), times(1)).setAlgoParam(1, 60);
  }
}