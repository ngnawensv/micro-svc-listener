package com.belrose.microsvclistener.service;

import com.belrose.microsvclistener.dto.TriggerEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TriggerEventAsyncService {

  @Async("asyncExecutor")
  public void handleEvents(TriggerEvent triggerEvent){
    log.info("Inside Async method, Treatment according the trigger event {} :",triggerEvent);
  }

}
