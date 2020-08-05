package com.mastertech.acesso.service;

import com.mastertech.acesso.client.ClienteClient;
import com.mastertech.acesso.client.PortaClient;
import com.mastertech.acesso.dto.AcessoDTO;
import com.mastertech.acesso.dto.ClienteDTO;
import com.mastertech.acesso.dto.PortaDTO;
import com.mastertech.acesso.exceptions.ClienteNaoEncontradoException;
import com.mastertech.acesso.exceptions.PortaNaoEncontradaException;
import com.mastertech.acesso.log.AcessoLog;
import com.mastertech.acesso.log.AcessoProducer;
import com.mastertech.acesso.model.Acesso;
import com.mastertech.acesso.repository.AcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

@Service
public class AcessoService {

    @Autowired
    private AcessoRepository repository;
    @Autowired
    private ClienteClient clienteClient;
    @Autowired
    private PortaClient portaClient;
    @Autowired
    private AcessoProducer acessoProducer;



    public String getAcessoLog(int clienteId, int portaId){
        AcessoLog log = new AcessoLog();

        log.setIdCliente(clienteId);
        log.setIdPorta(portaId);
        log.setAutorizado(Math.random() < 0.5);
        log.setData(LocalDateTime.now());

        acessoProducer.enviarAoKafka(log);

        if(!log.isAutorizado()){
            return "Acesso negado";
        }

        return "Acesso autorizado";
    }

    public AcessoDTO getAcesso(int clienteId, int portaId){
        AcessoDTO response = new AcessoDTO();
        ClienteDTO cliente = clienteClient.getClientePorId(clienteId);
        if(cliente == null){
            throw new ClienteNaoEncontradoException();
        }

        PortaDTO porta = portaClient.getPortaPorId(portaId);
        if(porta == null){
            throw new PortaNaoEncontradaException();
        }
        Acesso acesso = repository.findAcessoByIdClienteAndIdPorta(cliente.getId(), porta.getId());

        response.setIdCliente(acesso.getIdCliente());
        response.setIdPorta(acesso.getIdPorta());
        return response;
    }

    public AcessoDTO postAcesso(AcessoDTO acessoDTO){
        Acesso acesso = new Acesso();

        ClienteDTO cliente = clienteClient.getClientePorId(acessoDTO.getIdCliente());
        if(cliente == null){
            throw new ClienteNaoEncontradoException();
        }

        PortaDTO porta = portaClient.getPortaPorId(acessoDTO.getIdPorta());
        if(porta == null){
            throw new PortaNaoEncontradaException();
        }

        acesso.setIdCliente(cliente.getId());
        acesso.setIdPorta(porta.getId());

        repository.save(acesso);

        return acessoDTO;
    }

    public void deleteAcesso(int clienteId, int portaId){
        repository.delete(repository.findAcessoByIdClienteAndIdPorta(clienteId, portaId));
    }

}
