/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mouralacerda.brigadeiro.bean;

import br.com.mouralacerda.brigadeiro.Modelo.Produto;
import br.com.mouralacerda.brigadeiro.DAO.ProdutoDAO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class ProdutoBean {
    
    private Produto p = new Produto();
    
    private List<Produto> Produtos = new ArrayList<Produto>();
    
    private final  ProdutoDAO pDAO = new ProdutoDAO();
    
       public void salvarProduto() {
        pDAO.salvar(p);
        p = new Produto();
        carregaLista();
    }
    
    public void excluirProduto(Produto p) {
        System.out.println("Excluindo");
        pDAO.excluir(p);
        System.out.println("Excluido");
        carregaLista();
    }
    
    @PostConstruct
    public void carregaLista(){
        Produtos = pDAO.ListarProdutos();
    }

    public Produto getProduto() {
        return p;
    }

    public void setProduto(Produto p) {
        this.p = p;
    }

    public List<Produto> getProdutos() {
        return Produtos;
    }

    public void setProdutos(List<Produto> Produtos) {
        this.Produtos = Produtos;
    }
    
}
