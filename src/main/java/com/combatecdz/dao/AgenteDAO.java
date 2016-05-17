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
import com.combatecdz.model.Agente;
import java.util.List;

public class AgenteDAO {
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistencia");
    private EntityManager em = factory.createEntityManager();

    public Agente getAgente(String nomeAgente, String senha) {
        try {
            Agente agente = (Agente) em.createQuery("SELECT u from Agente u where u.nome = :nome and u.senha = :senha").setParameter("nome", nomeAgente).setParameter("senha", senha).getSingleResult();
            return agente;
        } catch (NoResultException e) {
            return null;
        }
    }
    public boolean inserirAgente(Agente agente) {
        try {
            em.getTransaction().begin();
            em.persist(agente);
            
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean deletarAgente(int Id) {
        try {
            em.getTransaction().begin();
            Agente u = em.find(Agente.class, Id);
            em.remove(u);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public List<Agente> getTodosAgentes() {        
        return em.createQuery("from Agente u", Agente.class).getResultList();        
    }
}
