/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.combatecdz.controller;

import com.combatecdz.dao.DenunciaDAO;
import com.combatecdz.model.Denuncia;
import com.combatecdz.model.Usuario;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Aluno
 */
@ManagedBean
@SessionScoped
public class DenunciaController {

    private Denuncia denuncia;
    private DataModel denuncias;
    private DataModel denunciasUsuario;

    public Usuario getUsuario() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession();
        Usuario u = (Usuario) session.getAttribute("usuario");
        
        System.out.println("nome: " + u.getNome());
        return u;
    }

    public DataModel getDenuncias() {
        List<Denuncia> lista = new DenunciaDAO().getTodasDenuncias();
        denuncias = new ListDataModel(lista);
        return denuncias;
    }
    
    

    public DataModel getDenunciasUsuario(int id) {
        List<Denuncia> lista = new DenunciaDAO().getTodasDenunciasUsuario(id);
        denunciasUsuario = new ListDataModel(lista);
        return denunciasUsuario;
    }

    public String prepararAdicionarDenuncia() {
        setDenuncia(new Denuncia());
        return "gerenciardenuncia";
    }

    public String prepararCidadao() {
        return "cidadao";
    }

    public String salvarDenuncia() {
        
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Date today = Calendar.getInstance().getTime(); 
	 
      
        denuncia.setStatus_den("Pendente");
        
        denuncia.setId_cid(this.getUsuario().getId());
        String data = dateFormat.format(today);
        denuncia.setData_den(data);
        int flag = 0;
        if (denuncia.getEstado().isEmpty() || denuncia.getCidade().isEmpty() || denuncia.getRua().isEmpty()
                || denuncia.getCep().isEmpty() || denuncia.getDescricao().isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Todos os campos sāo obrigatórios", "Erro no Cadastro!"));
            return null;
        }
        if (Pattern.matches("[a-zA-Z][a-zA-Z]", denuncia.getEstado()) == false || denuncia.getEstado().length() != 2) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Estado Inválido", "Erro no Cadastro!"));
                flag = 1;
            }
        if (Pattern.matches("[0-9]+", denuncia.getCep()) == false || denuncia.getCep().length() != 8) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "CEP Inválido", "Erro no Cadastro!"));
                flag = 1;
        }
        if (flag == 1) {
                return null;
        } else {
            DenunciaDAO u = new DenunciaDAO();
            u.inserirDenuncia(this.getDenuncia());
            return "cidadao";
        }
    }

    public String excluirDenuncia(int ID) {
        DenunciaDAO u = new DenunciaDAO();
        //u.deletarDenuncia(this.getDenuncia());
        u.deletarDenuncia(ID);
        return "visualizardenucia";
    }

    public String prepararAlterarDenuncia(Denuncia den) {
        setDenuncia(den);
        return "alterarDenuncia";
    }

    public String responderDenuncia() {
        DenunciaDAO u = new DenunciaDAO();
        u.alterarResposta(denuncia.getId(), denuncia.getResposta(), denuncia.getStatus_den());
        return "agente";
    }

    public Denuncia getDenuncia() {
        return denuncia;
    }

    public void setDenuncia(Denuncia denuncia) {
        this.denuncia = denuncia;
    }
    
    public String apoio(Denuncia d){
        DenunciaDAO u = new DenunciaDAO();
        this.denuncia = d;
        this.denuncia.setNum_apoio(denuncia.getNum_apoio() +1);
        u.deletarDenuncia(d.getId());
        u.inserirDenuncia(this.denuncia);
        return "listartodasdenuncias";
    }
    
    public String prepararResponderDenuncia(Denuncia d) {
        setDenuncia(d);
        return "responderDenuncia";
    }
}
