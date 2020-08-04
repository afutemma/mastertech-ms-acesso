package com.mastertech.acesso.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Acesso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idAcesso;
    private int idCliente;
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
