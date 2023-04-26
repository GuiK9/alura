package br.com.loja.modelo.teste;

import br.com.loja.DAO.CategoriaDAO;
import br.com.loja.DAO.ClienteDAO;
import br.com.loja.DAO.PedidoDAO;
import br.com.loja.DAO.ProdutoDAO;
import br.com.loja.modelo.*;
import br.com.loja.util.JPAUtil;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.List;

public class CadastroDePedido {
    public static void main(String[] args) {
        cadastrarProduto();

        EntityManager em = JPAUtil.getEntityManager();

        ProdutoDAO produtoDAO = new ProdutoDAO(em);
        Produto produto = produtoDAO.buscarPorId(1L);

        em.getTransaction().begin();

        Cliente cliente = new Cliente("Rodrigo", "233234");

        ClienteDAO clienteDAO = new ClienteDAO(em);
        clienteDAO.cadastrar(cliente);

        Pedido pedido = new Pedido(cliente);
        pedido.adicionarItem(new ItemPedido(10, pedido, produto));

        PedidoDAO pedidoDAO = new PedidoDAO(em);
        pedidoDAO.cadastrar(pedido);

        em.getTransaction().commit();

    }

    private static void cadastrarProduto() {
        Categoria celulares = new Categoria("CELULARES");
        Produto celular = new Produto("xiaomi", "Muito Legal", new BigDecimal("800"), celulares);


        EntityManager em = JPAUtil.getEntityManager();
        CategoriaDAO categoriaDAO= new CategoriaDAO(em);
        ProdutoDAO produtoDAO = new ProdutoDAO(em);
        em.getTransaction().begin();
        produtoDAO.cadastrar(celular);
        categoriaDAO.cadastrar(celulares);
        em.getTransaction().commit();
        System.out.println(produtoDAO.buscarTodos() + "==== FLAG ====");
        em.close();
    }
}