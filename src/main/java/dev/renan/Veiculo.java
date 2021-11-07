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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
