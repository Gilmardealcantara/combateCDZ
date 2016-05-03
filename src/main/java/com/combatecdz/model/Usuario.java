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
public class Usuario {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    private int id;
    @Column(name = "nome", nullable = false, unique = true)
    private String nome;
    @Column(name = "senha", nullable = false, unique = false)
    private String senha;
    @Column(name = "cep", nullable = false, unique = false)
    private String cep;
    @Column(name = "rua", nullable = false, unique = false)
    private String rua;
    @Column(name = "cidade", nullable = false, unique = false)
    private String cidade;
    @Column(name = "estado", nullable = false, unique = false)
    private String estado;

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
    
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId_end() {
        return id_end;
    }

    public void setId_end(int id_end) {
        this.id_end = id_end;
    }


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    @Column(name = "email", nullable = false, unique = false)
    private String email;
    @Column(name = "id_end", nullable = false, unique = true)
    private int id_end; 
    @Column(name = "cpf", nullable = false, unique = false)
    private String cpf;

  
    public String getNome() {
        return nome;
    }

    public void setNome(String nomeUsuario) {
        this.nome = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    
}

/*
create database combatecdz;

use combatecdz;

show tables;

create table usuario(

id int auto_increment primary key,

nome varchar(250),

    senha varchar(20)

);

insert into usuario(nome,senha) values ('laura',123);

*/