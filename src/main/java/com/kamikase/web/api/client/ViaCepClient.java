package com.kamikase.web.api.client;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.kamikase.web.api.dto.CepResponseDTO;


@FeignClient(value = "viacep", url = "https://viacep.com.br/ws/")
public interface ViaCepClient {

    @GetMapping("{cep}/json")
    CepResponseDTO consultaCep(@PathVariable("cep") String cep);

}
