package com.belrose.microsvclistener.controller;

import com.belrose.microsvclistener.dto.TriggerEvent;
import com.belrose.microsvclistener.service.TriggerEventAsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TriggerListenerController {
  private  final TriggerEventAsyncService asyncService;

  public TriggerListenerController(TriggerEventAsyncService asyncService) {
    this.asyncService = asyncService;
  }


  @PostMapping(path = "/event")
  public  ResponseEntity<Void>  eventListener(@RequestBody TriggerEvent triggerEvent){
    try {
      asyncService.handleEvents(triggerEvent);
      return ResponseEntity.ok().build();
    }catch (Exception ex){
      throw new RuntimeException(ex.getMessage());
    }
  }
}
