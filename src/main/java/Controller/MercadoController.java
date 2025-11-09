package Controller;
import Model.*;
import View.*;

import java.util.ArrayList;
import java.util.List;

public class MercadoController {
    private List<Produto> catalogoProdutos;
    private Carrinho carrinhoAtual;
    private Main view;
 

    public MercadoController(Main view){
        this.view = view;
            this.carrinhoAtual = new Carrinho();
            this.catalogoProdutos = new ArrayList<>();
            
            
            catalogoProdutos.add(new Produto("Arroz ", "Tio Jõao", 10.0f, "Grãos", "0001"));
            catalogoProdutos.add(new Produto("Feijão ", "Urbano", 4.99f, "Grãos", "6654"));
            catalogoProdutos.add(new Produto("Leite Desnatado", "Itambé", 5.50f, "Laticineos", "56547"));
            catalogoProdutos.add(new Produto("Pão de Forma", "Bauduco", 8.99f, "Pães", "0005"));
    }
    
    public void iniciar(){
        while (true){
            int escolha = view.exibirMenuPrincipal();
            switch (escolha) {
                case 1: // adicionar item
                    String codigo = view.solicitarCodigo();
                    Produto p = buscarProdutoPorCodigo(codigo);
                    
                    if (p != null){
                        carrinhoAtual.adicionarItem(p, 1);
                        view.exibirMensagem(p.getNome() + " adicionado ao carrinho com sucesso!");
                    }
                    else {
                        view.exibirMensagem("Produto não encontrado! ");
                    }
                    break;
                case 2: // ver carrinho
                    float total = getTotalCarrinho();
                    List<String> itens = carrinhoAtual.getItensFormatado();
                    view.exibirCarrinho(itens, total);
                    break;
                case 3: // remover item
                    String codRemover = view.solicitarCodigo();
                    Produto produtoRemover = buscarProdutoPorCodigo(codRemover);

                    if (produtoRemover != null){
                        carrinhoAtual.removerItem(produtoRemover);
                        view.exibirMensagem(produtoRemover.getNome() + " removido do carrinho com sucesso!");
                    }
                    else {
                        view.exibirMensagem("Produto não encontrado! ");
                    }
                    break;
                case 0: // sair
                    view.exibirMensagem("Saindo do sistema... ");
                    break;
                default:
                    view.exibirMensagem("Opção Inválida. Tente novamente!");
                    break;
            }
        }

    }
        
    public float getTotalCarrinho(){
        return this.carrinhoAtual.calcularTotal();
    }

    private Produto buscarProdutoPorCodigo(String cod){
        for (Produto p : catalogoProdutos){
            if (p.getCodBarras().equals(cod)){
                return p;
            }
        }
        return null;
    }
}    