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
    
    public Agente getAgente() {
        return agente;
    }

    public String prepararAdicionarAgente() {
        setAgente(new Agente());
        return "cadastrarAgente";
    }
    public String salvarAgente() {
        int flag = 0;
        if (agente.getEmail().isEmpty() || agente.getCpf().isEmpty()
                || agente.getSenha().isEmpty() || agente.getNome().isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Todos os campos sāo obrigatórios", "Erro no Cadastro!"));
            return null;
        } else {
            if (Pattern.matches("[0-9]+", agente.getCpf()) == false || agente.getCpf().length() != 11) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "CPF Inválido, apenas números permitidos", "Erro no Cadastro!"));
                flag = 1;
            }
            if (Pattern.matches("[0-9]+", agente.getPis()) != false || agente.getPis().length() != 11) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "PIS Inválido, apenas números permitidos", "Erro no Cadastro!"));
                flag = 1;
            }
            String email = agente.getEmail();
            Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
            Matcher m = p.matcher(email);
            boolean match = m.matches();
            if (!match) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email Inválido", "Erro no Cadastro!"));
                flag = 1;
            }
            if (flag == 1) {
                return null;
            } else {
                AgenteDAO u = new AgenteDAO();
                u.inserirAgente(this.getAgente());
                return "visualizarAgente";
            }
        }
    }
    
    public String excluirAgente(int ID) {
        AgenteDAO u = new AgenteDAO();
        //u.deletarUsuario(this.getUsuario());
        u.deletarAgente(ID);
        return "visualizarAgente";
    }
    //http://jamacedo.com/2010/06/crud-jsf-2-0-hibernate-exemplo-gerenciando-livros-2/

    public String prepararAlterarAgente(Agente us) {
        setAgente(us);
        return "alterarAgente";
    }
    
    public String alterarAgente() {
        Agente alt = new Agente();
        alt.setId(agente.getId());
        alt.setNome(agente.getNome());
        alt.setSenha(agente.getSenha());
        alt.setCpf(agente.getCpf());
        alt.setEmail(agente.getEmail());
        alt.setContratante(agente.getContratante());
        alt.setPis(agente.getPis());
        alt.setRegiao(agente.getRegiao());
        int flag = 0;
        if (alt.getRegiao().isEmpty() || alt.getContratante().isEmpty()
                || alt.getPis().isEmpty() || alt.getEmail().isEmpty() || alt.getCpf().isEmpty()
                || alt.getSenha().isEmpty() || alt.getNome().isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Todos os campos sāo obrigatórios", "Erro no Cadastro!"));
            return null;
        } else {
            if (Pattern.matches("[0-9]+", alt.getCpf()) == false || alt.getCpf().length() != 11) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "CPF Inválido, apenas números permitidos", "Erro no Cadastro!"));
                flag = 1;
            }
            if (Pattern.matches("[0-9]+", alt.getPis()) != false || alt.getPis().length() != 11) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "PIS Inválido, apenas números permitidos", "Erro no Cadastro!"));
                flag = 1;
            }
            String email = alt.getEmail();
            Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
            Matcher m = p.matcher(email);
            boolean match = m.matches();
            if (!match) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email Inválido", "Erro no Cadastro!"));
                flag = 1;
            }
            if (flag == 1) {
                return null;
            } else {

                AgenteDAO u = new AgenteDAO();
                u.deletarAgente(agente.getId());
                u.inserirAgente(alt);
                return "visualizarAgente";
            }
        }
    }
}
