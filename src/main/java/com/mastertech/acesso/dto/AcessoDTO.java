package com.mastertech.acesso.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AcessoDTO {

    @JsonProperty("cliente_id")
    private int idCliente;
    @JsonProperty("porta_id")
    private int idPorta;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdPorta() {
        return idPorta;
    }

    public void setIdPorta(int idPorta) {
        this.idPorta = idPorta;
    }
}
