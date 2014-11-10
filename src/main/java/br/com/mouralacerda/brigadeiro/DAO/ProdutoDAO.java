/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mouralacerda.brigadeiro.DAO;

import br.com.mouralacerda.brigadeiro.Modelo.Produto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author filip_000
 */
public class ProdutoDAO {
    final EntityManagerFactory factory = Persistence.createEntityManagerFactory("db_Brigadeiro");
    final EntityManager em = factory.createEntityManager();
    
    public void salvar(Produto p){
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }
    
    public List<Produto> ListarProdutos(){
        TypedQuery<Produto> query = em.createQuery("Select p from Produto p", Produto.class);
        List<Produto> Produto = query.getResultList();
        return Produto;
    }
    public void excluir(){
        
    }
}

