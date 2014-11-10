/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mouralacerda.brigadeiro.DAO;

import br.com.mouralacerda.brigadeiro.Modelo.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author filip_000
 */
public class ClienteDAO {
    final EntityManagerFactory factory = Persistence.createEntityManagerFactory("bd_Brigadeiro");
    final EntityManager em = factory.createEntityManager();
    
    public void salvar(Cliente c){
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
    }
    
    public Cliente consultarCliente(int codigo){
        Cliente c = em.find(Cliente.class, codigo);
        return c;
    }
    
    public List<Cliente> consultarLista(){
        
        TypedQuery<Cliente> query = em.createQuery("select c from Cliente c", Cliente.class);
        List<Cliente> clientes = query.getResultList();
        return clientes;
    }
    
    public void excluir(Cliente c){
        em.getTransaction().begin();
        c = em.merge(c);
        em.remove(c);
        em.getTransaction().commit();
    }
}
