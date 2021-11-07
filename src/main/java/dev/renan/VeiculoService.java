package dev.renan;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VeiculoService {

    MySQL mysql;

    public VeiculoService() {
        mysql = new MySQL();
    }

    public void conectar(){
        boolean connected = mysql.connect("localhost", "3306", "Concessionaria", "root", "1234");
        if (connected) {
            System.out.println("Base de dados conectada.");
        } else {
            System.out.println("Base de dados não conectada.");
        }
    }

    public void inserir(Veiculo veiculo){
        String query = "INSERT INTO Veiculo (nome, modelo, placa, ano, preco) "
                + "values ('"+veiculo.getNome()+"', '"+veiculo.getModelo()+"', '"+veiculo.getPlaca()+
                "', '"+veiculo.getAno()+"', '"+veiculo.getPreco()+"');";
        int status = mysql.executeUpdate(query);
        if (status == 1) {
            System.out.println("Dados inseridos com sucesso!");
        } else {
            System.out.println("Erro ao inserir dados!");
        }
    }

    public void consultar(){
        ResultSet rs = mysql.executeQuery("SELECT * FROM Veiculo");
        if (rs != null) {
            try {
                while (rs.next()) {

                    JOptionPane.showMessageDialog(null,
                            "Nome: "+rs.getString("nome")
                            +"\nModelo: "+rs.getString("modelo")
                            +"\nPlaca: "+rs.getString("placa")
                            +"\nAno: "+rs.getString("ano")
                            +"\nPreço: "+rs.getString("preco")
                            );
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    public void alterar(Veiculo veiculo, int ID){
        int status;
        String query = "UPDATE Veiculo SET nome='"+veiculo.getNome()+"', "
                +"modelo='"+veiculo.getModelo()+"', placa='"+veiculo.getPlaca()
                +"', ano="+veiculo.getAno()+", preco="+veiculo.getPreco()
                +" WHERE id="+ID+";";
        status = mysql.executeUpdate(query);
        if (status == 1) {
            System.out.println("Dados alterados com sucesso!");
        } else {
            System.out.println("Erro ao alterar dados!");
        }
    }

    public void excluir(Integer ID){
        String query = "DELETE FROM Veiculo WHERE id="+ID+";";
        int status = mysql.executeUpdate(query);
        if (status == 1) {
            System.out.println("Dados excluídos com sucesso!");
        } else {
            System.out.println("Erro ao excluir dados!");
        }
    }
}