package de.olgadem.tradingapplication.controller;

import de.olgadem.tradingapplication.service.SignalHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/receive-signal")
public class SignalReceiverController {
  private final SignalHandler signalHandler;

  public SignalReceiverController(SignalHandler signalHandler) {
    this.signalHandler = signalHandler;
  }

  @PostMapping("/{id}")
  public ResponseEntity<Void> receiveSignal(@PathVariable("id")  Integer signal){
    signalHandler.handleSignal(signal);
    return ResponseEntity.ok().build();
  }
}
