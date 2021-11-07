package dev.renan;

import java.sql.ResultSet;
import java.sql.SQLException;


public class VeiculoService {

    MySQL mysql;

    public VeiculoService() {
        mysql = new MySQL();
    }


    public static void main(String[] args) {
        try {
            VeiculoService veiculoService = new VeiculoService();
            veiculoService.conectar();

            //veiculoService.inserir();


            //veiculoService.inserir();



            Veiculo pessoa = new Veiculo();
            /*
            veiculoService.setNome();
            veiculoService.setModelo();
            veiculoService.setPlaca();
            veiculoService.inserir();
            */

            //veiculoService.consultar();

            /*
            veiculo.setNome();
            veiculo.setModelo();
            veiculo.setPlaca();

            veiculoService.alterar();
            veiculoService.consultar();
            */

            template.excluir(1);
            template.consultar();



            //template.mysqlr.stmt.close();
            //template.mysqlr.conn.close();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }

    public void conectar(){
        boolean connected = mysql.connect("localhost", "8080", "Concessionaria", "root", "1234");
        if (connected) {
            System.out.println("Base de dados conectada.");
        } else {
            System.out.println("Base de dados não conectada.");
        }
    }

    public void inserir(){
        String query = "INSERT INTO Veiculo (nome, modelo, placa) "
                + "values ('Honda Civic', 'Hond', 'ABCD1234')";
        int status = mysql.executeUpdate(query);
        if (status == 1) {
            System.out.println("Dados inseridos com sucesso!");
        } else {
            System.out.println("Erro ao inserir dados!");
        }
    }

    public void inserir(String nome, String modelo, String placa){
        String query = "INSERT INTO Pessoa (nome, email, cidade) "
                + "values ('"+nome+"', '"+modelo+"', '"+placa+"')";
        int status = mysql.executeUpdate(query);
        if (status == 1) {
            System.out.println("Dados inseridos com sucesso!");
        } else {
            System.out.println("Erro ao inserir dados!");
        }
    }

    public void inserir(Veiculo veiculo){
        String query = "INSERT INTO Pessoa (nome, modelo, placa) "
                + "values ('"+veiculo.getNome()+"', '"+veiculo.getModelo()+"', '"+veiculo.getPlaca()+"')";
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
                    // É possível referenciar a coluna pelo índice
                    System.out.println("Id: " + rs.getString(1));
                    // Ou pelo nome
                    System.out.println("Nome: " + rs.getString("nome"));
                    System.out.println("Modelo: " + rs.getString("modelo"));
                    System.out.println("Placa: " + rs.getString("placa"));
                    System.out.println();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    public void alterar(Veiculo veiculo, int ID){
        int status;
        String query = "UPDATE Veiculo SET nome='" + veiculo.getNome() + "', "
                + "nome='" + veiculo.getNome() + "', modelo='" + veiculo.getModelo() + "'  "
                + "WHERE id=" + ID;
        status = mysql.executeUpdate(query);
        if (status == 1) {
            System.out.println("Dados alterados com sucesso!");
        } else {
            System.out.println("Erro ao alterar dados!");
        }
    }

    public void excluir(int ID){
        String query = "DELETE FROM Pessoa WHERE id=" + ID;
        int status = mysql.executeUpdate(query);
        if (status == 1) {
            System.out.println("Dados excluídos com sucesso!");
        } else {
            System.out.println("Erro ao excluir dados!");
        }
    }
}