/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.combatecdz.controller;

import com.combatecdz.dao.AgenteDAO;
import com.combatecdz.model.Agente;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@SessionScoped
public class AgenteController {
    private Agente agente;
    private DataModel agentes;

    public DataModel getAgentes() {
        List<Agente> lista = new AgenteDAO().getTodosAgentes();
        agentes = new ListDataModel(lista);
        return agentes;
    }

    public void setAgente(Agente agente) {
        this.agente = agente;
    }

    public String prepararAdicionarAgente() {
        setAgente(new Agente());
        return "gerenciarUsuario";
    }
}
