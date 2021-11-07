package dev.renan;

import java.sql.ResultSet;
import java.sql.SQLException;


public class VeiculoService {

    MySQL mysqlr;

    public VeiculoService() {
        mysqlr = new MySQL();
    }


    public static void main(String[] args) {
        try {
            VeiculoService template = new VeiculoService();
            template.conectar();

            //template.inserir();


            //template.inserir();



            Veiculo pessoa = new Veiculo();
            /*
            pessoa.setNome();
            pessoa.setEmail();
            pessoa.setCidade();
            template.inserir();
            */

            //template.consultar();

            /*
            pessoa.setNome();
            pessoa.setEmail();
            pessoa.setCidade();

            template.alterar();
            template.consultar();
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
        boolean connected = mysqlr.connect("localhost", "8080", "Concessionaria", "root", "1234");
        if (connected) {
            System.out.println("Base de dados conectada.");
        } else {
            System.out.println("Base de dados não conectada.");
        }
    }

    public void inserir(){
        String query = "INSERT INTO Veiculo (nome, modelo, placa) "
                + "values ('Honda Civic', 'Hond', 'ABCD1234')";
        int status = mysqlr.executeUpdate(query);
        if (status == 1) {
            System.out.println("Dados inseridos com sucesso!");
        } else {
            System.out.println("Erro ao inserir dados!");
        }
    }

    public void inserir(String nome, String modelo, String placa){
        String query = "INSERT INTO Pessoa (nome, email, cidade) "
                + "values ('"+nome+"', '"+modelo+"', '"+placa+"')";
        int status = mysqlr.executeUpdate(query);
        if (status == 1) {
            System.out.println("Dados inseridos com sucesso!");
        } else {
            System.out.println("Erro ao inserir dados!");
        }
    }

    public void inserir(Veiculo veiculo){
        String query = "INSERT INTO Pessoa (nome, modelo, placa) "
                + "values ('"+veiculo.getNome()+"', '"+veiculo.getModelo()+"', '"+veiculo.getPlaca()+"')";
        int status = mysqlr.executeUpdate(query);
        if (status == 1) {
            System.out.println("Dados inseridos com sucesso!");
        } else {
            System.out.println("Erro ao inserir dados!");
        }
    }

    public void consultar(){
        ResultSet rs = mysqlr.executeQuery("SELECT * FROM Veiculo");
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
        status = mysqlr.executeUpdate(query);
        if (status == 1) {
            System.out.println("Dados alterados com sucesso!");
        } else {
            System.out.println("Erro ao alterar dados!");
        }
    }

    public void excluir(int ID){
        String query = "DELETE FROM Pessoa WHERE id=" + ID;
        int status = mysqlr.executeUpdate(query);
        if (status == 1) {
            System.out.println("Dados excluídos com sucesso!");
        } else {
            System.out.println("Erro ao excluir dados!");
        }
    }
}