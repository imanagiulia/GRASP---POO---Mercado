package Model;

import java.util.*;

/*
 * Principio Information Expert 
 * Essa classe fica responsável por calcular o valor total do carrinho
 * pois é ela que contêm a informação da lista de produtos e sabe suas quantidades e preço.
 */

public class Carrinho {
    private Map<Produto, Integer> itens;

    public Carrinho(){
        this.itens = new HashMap<>();
    }

    public void adicionarItem(Produto produto, int quantidade){
        if (itens.containsKey(produto)){
            int qtdAtual = itens.get(produto);
            itens.put(produto, qtdAtual + quantidade);
        }else{
            itens.put(produto, quantidade);
        }
    }

    public void removerItem(Produto produto){
        itens.remove(produto);
    }

    public Map<Produto, Integer> getItens(){
        return itens;
    }

    public float calcularTotal(){
        float total = 0;
        for (Map.Entry<Produto, Integer> entry : itens.entrySet()){
            total += (entry.getKey().getPreco() * entry.getValue());
        }

        return total;
    }

    public void mostrarItens(){
        for (Map.Entry<Produto, Integer> entry : itens.entrySet()){
            System.out.println("Item: " + entry.getKey().getNome() + "| " + "Quantidade: " + entry.getValue());
        }

    }

    public List<String> getItensFormatado(){
        List<String> lista = new ArrayList<>();

        if (itens.isEmpty()){
            return lista;
        }

        for (Map.Entry<Produto, Integer> entry : itens.entrySet()){
            Produto p = entry.getKey();
            Integer qtd = entry.getValue();
            float subtotal = p.getPreco() * qtd;

            String itemString = String.format("%s (Qtd: %d) - R$ %.2f", p.getNome(), qtd, subtotal);
            lista.add(itemString);
        }

        return lista;
    }
}
