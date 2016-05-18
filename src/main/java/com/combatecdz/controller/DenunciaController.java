/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.combatecdz.controller;

import com.combatecdz.dao.DenunciaDAO;
import com.combatecdz.model.Denuncia;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Aluno
 */
@ManagedBean
@SessionScoped
public class DenunciaController {

    private Denuncia denuncia;
    private DataModel denuncias;

    public DataModel getDenuncias() {
        List<Denuncia> lista = new DenunciaDAO().getTodasDenuncias();
        denuncias = new ListDataModel(lista);
        return denuncias;
    }

    public String prepararAdicionarDenuncia() {
        setDenuncia(new Denuncia());
        return "gerenciardenuncia";
    }
    
    public String salvarDenuncia() {
        denuncia.setStatus_den("Pendente");
        
        DenunciaDAO u = new DenunciaDAO();
        u.inserirDenuncia(this.getDenuncia());
        return "visualizardenuncia";
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



    public String alterarDenuncia() {
        Denuncia alt = new Denuncia();
        alt.setId(denuncia.getId());
        alt.setStatus_den(denuncia.getStatus_den());
        alt.setNum_apoio(denuncia.getNum_apoio());
        alt.setData_den(denuncia.getData_den());
        alt.setDescricao(denuncia.getDescricao());
        alt.setResposta(denuncia.getResposta());
        alt.setCep(denuncia.getCep());
        alt.setRua(denuncia.getRua());
        alt.setCidade(denuncia.getCidade());
        alt.setEstado(denuncia.getEstado());
        alt.setId_cid(denuncia.getId_cid());
        alt.setId_ag(denuncia.getId_ag());


        DenunciaDAO u = new DenunciaDAO();
        u.deletarDenuncia(denuncia.getId());
        u.inserirDenuncia(alt);
        return "visualizarcidadao";
    }

    
    
    public Denuncia getDenuncia() {
        return denuncia;
    }

    public void setDenuncia(Denuncia denuncia) {
        this.denuncia = denuncia;
    }  
}
