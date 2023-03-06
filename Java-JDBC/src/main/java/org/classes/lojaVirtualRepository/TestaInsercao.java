package org.classes.lojaVirtualRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection con = factory.recuperarconexao();

        Statement stm = con.createStatement();
        stm.execute("INSERT INTO PRODUTO (nome, descricao) VALUES ('MOUSE', 'MOUSE SEM FIO')", Statement.RETURN_GENERATED_KEYS);
       ResultSet rst = stm.getGeneratedKeys();
       while(rst.next()) {
           int id = rst.getInt(1);
           System.out.println("o id criado foi " + id);
       }
    }
}
