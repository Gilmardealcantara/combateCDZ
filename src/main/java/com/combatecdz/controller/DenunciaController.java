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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
import org.primefaces.json.JSONObject;

/**
 *
 * @author Aluno
 */
@ManagedBean
@SessionScoped
public class DenunciaController {

    private Denuncia denuncia;
    private DataModel denuncias;
    private DataModel denuncias_loc;

    public DataModel getDenuncias_loc() {
        return denuncias_loc;
    }

    public void setDenuncias_loc(DataModel denuncias_loc) {
        this.denuncias_loc = denuncias_loc;
    }

    public String getDenuncias_json() {
        return denuncias_json;
    }

    public void setDenuncias_json(String denuncias_json) {
        this.denuncias_json = denuncias_json;
    }

    public DataModel getDenunciasUsuario() {
        return denunciasUsuario;
    }

    public void setDenunciasUsuario(DataModel denunciasUsuario) {
        this.denunciasUsuario = denunciasUsuario;
    }

    public List<JSONObject> getJson_list() {
        return json_list;
    }

    public void setJson_list(List<JSONObject> json_list) {
        this.json_list = json_list;
    }
    private String denuncias_json;
    public DataModel denunciasUsuario;
    List<JSONObject> json_list = new ArrayList<JSONObject>();

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
    
    
    public Map<String, String> mapaIinit(){
        Map<String, String> mapa = new HashMap<String, String>();
        mapa.put("RO","Rondônia");
        mapa.put("AC","Acre");
        mapa.put("AM","Amazonas");
        mapa.put("RR","Roraima");
        mapa.put("PA","Pará");
        mapa.put("AP","Amapá");
        mapa.put("TO","Tocantins");
        mapa.put("MA","Maranhāo");
        mapa.put("PI","Piauí");
        mapa.put("CE","Ceará");
        mapa.put("RN","Rio Grande do Norte");
        mapa.put("PB","Paraíba");
        mapa.put("PE","Pernambuco");
        mapa.put("AL","Alagoas");
        mapa.put("SE","Sergipe");
        mapa.put("BA","Bahia");
        mapa.put("MG","Minas Gerais");
        mapa.put("ES","Espírito Santo");
        mapa.put("RJ","Rio de Janeiro");
        mapa.put("SP","Sāo Paulo");
        mapa.put("PR","Paraná");
        mapa.put("SC","Santa Catarina");
        mapa.put("RS","Rio Grande do Sul");
        mapa.put("MS","Mato Grosso do Sul");
        mapa.put("MT","Mato Grosso");
        mapa.put("GO","Goiás");
        mapa.put("DF","Distrito Federal");
      
        return mapa;
    }
    
    public String grafico() {
        List<Denuncia> lista = new DenunciaDAO().getTodasDenuncias();
        String s="";
        
        //query
        //List<String> lista = Arrays.asList("MG1", "MG2", "MG3", "MG1", "MG2", "MG3", "MG1", "MG2", "MG3", "MG1", "MG2", "SP3", "SP1", "SP2", "SP3", "SP1", "SP2", "SP3", "SP1", "SP2", "SP3", "SP1", "SP2", "SP3", "MG1", "MG2", "MG3", "MG1", "MG2", "RO3", "RO1", "RO2", "RO3", "RO1", "RO2", "RO3", "RO1", "RO2", "RO3", "RO1", "RO2", "RO3", "RO1", "RO2", "AM3", "AM1", "AM2", "AM3", "AM1", "AM2", "AM3", "AM1", "AM2", "AM3", "AM1", "AM2", "AM3", "AM1", "AM2", "AM3");
        Map<String, Integer> mapa = new HashMap<String, Integer>();
        Map<String, String> mapa2  =  mapaIinit();
        //faz calculos no mapa
        for(int i = 0; i < lista.size(); i++){
            int count = mapa.containsKey(lista.get(i).getEstado()) ? mapa.get(lista.get(i).getEstado()) : 0;
            //int count = mapa.containsKey(lista.get(i)) ? mapa.get(lista.get(i)) : 0;
            mapa.put(lista.get(i).getEstado(), count + 1);
        }
        
        //cria jason
        Set<String> chaves = mapa.keySet();
        for(String chave : chaves ){
            //System.out.println(chave +" : "+ mapa.get(chave));
            JSONObject json = new JSONObject();
            json.put("value", mapa.get(chave));
            json.put("name", mapa2.get(chave));
            this.json_list.add(json);
            System.out.printf( "JSON: %s\n", json.toString());
        }
        System.out.printf( "JSON: %s", this.json_list);
        return "graficoCDZ";
    }

    
    public String prepararAdicionarDenuncia() {
        setDenuncia(new Denuncia());
        return "gerenciardenuncia";
    }
    
    
    public DataModel getDenunciasUsuario(int id) {
        List<Denuncia> lista = new DenunciaDAO().getTodasDenunciasUsuario(id);
        denunciasUsuario = new ListDataModel(lista);
        return denunciasUsuario;
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
        if (Pattern.matches("[A-Z][A-Z]", denuncia.getEstado()) == false || denuncia.getEstado().length() != 2) {
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
