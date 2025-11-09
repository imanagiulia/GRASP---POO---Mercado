package Model;
/*
 * Principio High Cohesion 
 * 
 * Classe responsável por fazer apenas uma coisa: gerenciar os dados dos produtos
 * Ela não tenta se adicionar a um carrinho, nem calcular impostos, ou seja, 
 * sua responsabilidade é única e bem definida
 */

public class Produto {
    private String nome;
    private float preco;
    private String tipo;
    private String marca;
    private String codBarras;

    public Produto(String nome, String marca, float preco, String tipo, String cod) {
        this.nome = nome;
        this.marca = marca;
        this.preco = preco;
        this.tipo = tipo;
        this.codBarras = cod;
    }

    public String getCodBarras(){
        return codBarras;
    }

    public String getNome() {
        return nome;
    }

    public float getPreco() {
        return preco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getMarca() {
        return marca;
    }


    
}
