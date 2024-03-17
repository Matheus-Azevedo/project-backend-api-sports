package com.kamikase.web.api.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.kamikase.web.api.dto.ClubeDTO;

@FeignClient(value = "clube", url = "https://api.api-futebol.com.br/v1/times/")
public interface ClubeClient {
  
  @GetMapping("{time_id}")
  ClubeDTO consultaClube(@PathVariable("id") Integer time_id);
}
