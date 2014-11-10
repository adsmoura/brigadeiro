/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mouralacerda.brigadeiro.bean;

import br.com.mouralacerda.brigadeiro.Modelo.Cliente;
import br.com.mouralacerda.brigadeiro.DAO.ClienteDAO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author filip_000
 */
@ManagedBean
public class ClienteBean {
    
    private Cliente c = new Cliente();

    private List<Cliente> clientes = new ArrayList<Cliente>();
    
    private final ClienteDAO cDAO = new ClienteDAO();

    public void salvarCliente() {
        cDAO.salvar(c);
        c = new Cliente();
        carregaLista();
    }
    
    public void excluirCliente(Cliente c) {
        System.out.println("Excluindo");
        cDAO.excluir(c);
        System.out.println("Excluido");
        carregaLista();
    }
    
    @PostConstruct
    public void carregaLista(){
        clientes = cDAO.consultarLista();
    }

    public Cliente getCliente() {
        return c;
    }

    public void setCliente(Cliente c) {
        this.c = c;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}
