package dev.renan;

import javax.swing.*;

public class GUI {

    public void menuConcessionaria() {

        VeiculoService veiculoService = new VeiculoService();
        Veiculo veiculo;
        String menu = "";
        String entrada;
        int opc1;
        do {
            menu = "Concessionária Bueno\n"+
                    "CRUD Veículos:\n"+
                    "1. Create veículo\n"+
                    "2. Read veículo\n"+
                    "3. Update veículo\n"+
                    "4. Delete veículo\n"+
                    "5. Sair";

            entrada = JOptionPane.showInputDialog(menu + "\n\n");
            opc1 = Integer.parseInt(entrada);
            switch (opc1) {
                case 1:
                    JOptionPane.showMessageDialog(null, "Entre com os dados do veículo\n");

                    String nome = JOptionPane.showInputDialog("Nome\n");
                    String modelo = JOptionPane.showInputDialog("Modelo\n");
                    String placa = JOptionPane.showInputDialog("Placa\n");
                    String ano = JOptionPane.showInputDialog("Ano\n");
                    String preco = JOptionPane.showInputDialog("Preço\n");

                    veiculo = new Veiculo(nome, modelo, placa, Integer.parseInt(ano), Double.parseDouble(preco));
                    veiculoService.conectar();
                    veiculoService.inserir(veiculo);
                    JOptionPane.showMessageDialog(null, "Veículo inserido com sucesso!");
                    break;
                case 2:
                    veiculoService.conectar();
                    veiculoService.consultar();
                    break;
                case 3:
                    String id = JOptionPane.showInputDialog("Entre com o ID do veículo a ser alterado");
                    nome = JOptionPane.showInputDialog("Nome\n");
                    modelo = JOptionPane.showInputDialog("Modelo\n");
                    placa = JOptionPane.showInputDialog("Placa\n");
                    ano = JOptionPane.showInputDialog("Ano\n");
                    preco = JOptionPane.showInputDialog("Preço\n");
                    veiculo = new Veiculo(nome, modelo, placa, Integer.parseInt(ano), Double.parseDouble(preco));
                    veiculoService.conectar();
                    veiculoService.alterar(veiculo, Integer.parseInt(id));
                    JOptionPane.showMessageDialog(null, "Veículo alterado com sucesso!");
                    break;
                case 4:
                    id = JOptionPane.showInputDialog("Entre com o ID do veículo a ser deletado");
                    veiculoService.conectar();
                    veiculoService.excluir(Integer.parseInt(id));
                    JOptionPane.showMessageDialog(null, "Veículo deletado com sucesso!");
                    break;
            }
        } while (opc1 != 5);
    }
}