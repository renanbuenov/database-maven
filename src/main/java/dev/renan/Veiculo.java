package dev.renan;

public class Veiculo {

    private String nome;
    private String modelo;
    private Integer ano;
    private String place;
    private Double preco;

    public Veiculo() {
    }

    public Veiculo(String nome, String modelo, Integer ano, String place, Double preco) {
        this.nome = nome;
        this.modelo = modelo;
        this.ano = ano;
        this.place = place;
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
