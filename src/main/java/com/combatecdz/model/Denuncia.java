/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.combatecdz.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Denuncia {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private int id;
    @Column(name = "status_den", nullable = false, unique = true)
    private String status_den;
    @Column(name = "num_apoio", nullable = false, unique = false)
    private int num_apoio;

    @Column(name = "data_den", nullable = false, unique = false)
    private String data_den;
    @Column(name = "descricao", nullable = false, unique = false)
    private String descricao;
    @Column(name = "resposta", nullable = false, unique = false)
    private String resposta;    
    
    
    @Column(name = "cep", nullable = false, unique = false)
    private String cep;
    @Column(name = "rua", nullable = false, unique = false)
    private String rua;
    @Column(name = "cidade", nullable = false, unique = false)
    private String cidade;
    @Column(name = "estado", nullable = false, unique = false)
    private String estado;

    @Column(name = "id_cid", nullable = false, unique = true)
    private int id_cid;
    @Column(name = "id_ag", nullable = false, unique = true)
    private int id_ag;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus_den() {
        return status_den;
    }

    public void setStatus_den(String status_den) {
        this.status_den = status_den;
    }

    public int getNum_apoio() {
        return num_apoio;
    }

    public void setNum_apoio(int num_apoio) {
        this.num_apoio = num_apoio;
    }

    public String getData_den() {
        return data_den;
    }

    public void setData_den(String data_den) {
        this.data_den = data_den;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId_cid() {
        return id_cid;
    }

    public void setId_cid(int id_cid) {
        this.id_cid = id_cid;
    }

    public int getId_ag() {
        return id_ag;
    }

    public void setId_ag(int id_ag) {
        this.id_ag = id_ag;
    }
}
