package dev.renan;

public class Veiculo {

    private String nome;
    private String modelo;
    private String placa;
    private Integer ano;
    private Double preco;

    public Veiculo() {
    }

    public Veiculo(String nome, String modelo, String placa, Integer ano, Double preco) {
        this.nome = nome;
        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public String getModelo() {
        return modelo;
    }

    public Integer getAno() {
        return ano;
    }

    public String getPlaca() {
        return placa;
    }

    public Double getPreco() {
        return preco;
    }
}
