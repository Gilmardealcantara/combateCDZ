/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.combatecdz.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import com.combatecdz.model.Denuncia;
import java.util.List;

public class DenunciaDAO {

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistencia");
    private EntityManager em = factory.createEntityManager();

    public boolean inserirDenuncia(Denuncia denuncia) {
        try {
            em.getTransaction().begin();
            em.persist(denuncia);
            
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deletarDenuncia(int Id) {
        try {
            em.getTransaction().begin();
            Denuncia d = em.find(Denuncia.class, Id);
            em.remove(d);
            em.getTransaction().commit();
            System.out.println("teste2");
            return true;
        } catch (Exception e) {
            System.out.println("teste1");
            e.printStackTrace();
            return false;
        }
    }

    public List<Denuncia> getTodasDenuncias() {        
        return em.createQuery("from Denuncia d", Denuncia.class).getResultList();        
    }
    
    public List<Denuncia> getTodasDenunciasUsuario(int id) {
        return em.createQuery("from Denuncia d where d.id_cid=:id", Denuncia.class).setParameter("id", id).getResultList();        
    }    
    
    
    
}
