package com.mastertech.acesso.controller;

import com.mastertech.acesso.dto.AcessoDTO;
import com.mastertech.acesso.service.AcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AcessoController {

    @Autowired
    private AcessoService service;

    @GetMapping("/acesso/aulapassada/{clienteId}/{portaId}")
    public AcessoDTO getAcesso(@PathVariable int clienteId, @PathVariable int portaId){
        return service.getAcesso(clienteId, portaId);
    }
    @GetMapping("/acesso/{clienteId}/{portaId}")
    public String getAcessoLog(@PathVariable int clienteId, @PathVariable int portaId){
        return service.getAcessoLog(clienteId, portaId);
    }

    @PostMapping("/acesso")
    public AcessoDTO postAcesso(@RequestBody AcessoDTO acesso){
        return service.postAcesso(acesso);
    }

    @DeleteMapping("/acesso/{clienteId}/{portaId}")
    public void deleteAcesso(@PathVariable int clienteId, @PathVariable int portaId){
        service.deleteAcesso(clienteId, portaId);
    }


}
