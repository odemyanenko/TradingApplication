package de.olgadem.tradingapplication.service;

import de.olgadem.tradingapplication.model.Strategy;
import de.olgadem.tradingapplication.repository.StrategyRepository;
import de.olgadem.tradingapplication.service.impl.SignalHandlerImpl;
import de.olgadem.tradingapplication.util.ModelCreator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class SignalHandlerTest {
  @InjectMocks
  public SignalHandlerImpl signalHandler;
  @Mock
  StrategyRepository strategyRepository;

  @Test
  void handleSignalTest() {
    //given

    //when
    signalHandler.handleSignal(1);

    //then
    Mockito.verify(strategyRepository, Mockito.times(1)).findAll();
  }
}