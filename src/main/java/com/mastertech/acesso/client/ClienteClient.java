package com.mastertech.acesso.client;


import com.mastertech.acesso.dto.ClienteDTO;
import com.mastertech.acesso.dto.PortaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="usuario", configuration = ClienteClientConfiguration.class)
public interface ClienteClient {


    @GetMapping("/v1/cliente/{id}")
    ClienteDTO getClientePorId(@PathVariable int id);

}
