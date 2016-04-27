/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.combatecdz.controller;

import com.combatecdz.dao.UsuarioDAO;
import com.combatecdz.model.Usuario;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Aluno
 */
@ManagedBean
@SessionScoped
public class UsuarioController {

    private Usuario usuario;
    private DataModel usuarios;

    public DataModel getUsuarios() {
        List<Usuario> lista = new UsuarioDAO().getTodosUsuarios();
        usuarios = new ListDataModel(lista);
        return usuarios;
    }

    public String prepararAdicionarUsuario() {
        setUsuario(new Usuario());
        return "gerenciarUsuario";
    }
    
    public String salvarUsuario()
    {
        
      UsuarioDAO u = new UsuarioDAO();
      u.inserirUsuario(this.getUsuario());
      return "visualizarcidadao";
    }
    
    public String excluirUsuario(int ID)
    {
      UsuarioDAO u = new UsuarioDAO();
      //u.deletarUsuario(this.getUsuario());
      u.deletarUsuario(ID);
      return "visualizarcidadao";  
    }
    //http://jamacedo.com/2010/06/crud-jsf-2-0-hibernate-exemplo-gerenciando-livros-2/
    
    public String prepararAlterarUsuario(Usuario us)
    {
      setUsuario(us);
      return "alterarUsuario";
      
    }
    
    public String alterarUsuario()
    {
      Usuario alt = new Usuario();
      alt.setId(usuario.getId());
      alt.setNome(usuario.getNome());
      alt.setSenha(usuario.getSenha());
      UsuarioDAO u = new UsuarioDAO();
      u.deletarUsuario(usuario.getId());
      u.inserirUsuario(alt);
      return "visualizarcidadao";
    }
    
    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
