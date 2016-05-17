/* http://www.devmedia.com.br/java-web-criando-uma-tela-de-login-com-jpa-jsf-primefaces-e-mysql/32456
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
public class Agente {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    private int id;
    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;
    @Column(name = "nome", nullable = false, unique = false)
    private String nome;
    @Column(name = "senha", nullable = false, unique = false)
    private String senha;
    @Column(name = "email", nullable = false, unique = false)
    private String email;
    @Column(name = "contratante", nullable = false, unique = false)
    private String contratante;
    @Column(name = "pis", nullable = false, unique = true)
    private String pis;
    @Column(name = "regiao", nullable = false, unique = false)
    private String regiao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContratante() {
        return contratante;
    }

    public void setContratante(String contratante) {
        this.contratante = contratante;
    }

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }
}