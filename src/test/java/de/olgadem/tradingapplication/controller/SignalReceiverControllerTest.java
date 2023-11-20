package de.olgadem.tradingapplication.controller;

import de.olgadem.tradingapplication.service.SignalHandler;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SignalReceiverController.class)
class SignalReceiverControllerTest {
  @MockBean
  private SignalHandler signalHandler;
  @Autowired
  private MockMvc mockMvc;

  @Test
  void receiveSignalTest() throws Exception {
    //given
    Integer signalId = 1;

    //when
    mockMvc.perform(MockMvcRequestBuilders.post("/receive-signal/{i}", signalId))
            .andExpect(status().isOk())
            .andReturn()
    ;

    //then
    Mockito.verify(signalHandler, Mockito.times(1)).handleSignal(signalId);
    Mockito.verify(signalHandler).handleSignal(eq(signalId));
  }
}