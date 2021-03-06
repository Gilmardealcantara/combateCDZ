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
import com.combatecdz.model.Usuario;

public class UsuarioDAO {

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistencia");
    private EntityManager em = factory.createEntityManager();

    public Usuario getUsuario(String nomeUsuario, String senha) {
        try {
            Usuario usuario = (Usuario) em.createQuery("SELECT u from Usuario u where u.nome = :nome and u.senha = :senha").setParameter("nome", nomeUsuario).setParameter("senha", senha).getSingleResult();
            return usuario;
        } catch (NoResultException e) {
            return null;
        }
    }

    public boolean inserirUsuario(Usuario usuario) {
        try {
            em.persist(usuario);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deletarUsuario(Usuario usuario) {
        try {
            em.remove(usuario);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
