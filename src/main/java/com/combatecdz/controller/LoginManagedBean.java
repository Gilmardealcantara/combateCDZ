/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.combatecdz.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import com.combatecdz.dao.UsuarioDAO;
import com.combatecdz.dao.AgenteDAO;
import com.combatecdz.model.Agente;
import com.combatecdz.model.Usuario;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@ManagedBean(name = "LoginMB")
@ViewScoped
public class LoginManagedBean {
    private AgenteDAO agenteDAO = new AgenteDAO();
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private Usuario usuario = new Usuario();
    private Agente agente = new Agente();

    public String envia() {
        String nome = usuario.getNome();
        String senha = usuario.getSenha();
        usuario = usuarioDAO.getUsuario(nome,senha);
        agente = agenteDAO.getAgente(nome, senha);
        
        if (usuario == null && agente == null) {
            usuario = new Usuario();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!", "Erro no Login!"));
            return null;
        } else if(agente == null){
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);
            return "/cidadao";
        }else{
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            HttpSession session = request.getSession();
            session.setAttribute("usuario", agente);
            return "/agente";
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
