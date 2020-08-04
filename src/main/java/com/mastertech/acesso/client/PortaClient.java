package com.mastertech.acesso.client;

import com.mastertech.acesso.dto.PortaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="porta", configuration = PortaClientConfiguration.class)
public interface PortaClient {

        @GetMapping("/v1/porta/{id}")
        PortaDTO getPortaPorId(@PathVariable int id);
}
