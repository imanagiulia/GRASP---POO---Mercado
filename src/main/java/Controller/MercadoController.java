package Controller;
import Model.*;
import View.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MercadoController {
    private List<Produto> catalogoProdutos;
    private Carrinho carrinhoAtual;
    private List<Funcionario> funcionarios;
    private Main view;
 

    public MercadoController(Main view){
        this.view = view;
        this.carrinhoAtual = new Carrinho();
        this.catalogoProdutos = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
            
        // produtos do mercado
        catalogoProdutos.add(new Produto("Arroz", "Tio Jõao", 10.0f, "Grãos", "0001"));
        catalogoProdutos.add(new Produto("Feijão", "Urbano", 4.99f, "Grãos", "6654"));
        catalogoProdutos.add(new Produto("Leite Desnatado", "Itambé", 5.50f, "Laticineos", "56547"));
        catalogoProdutos.add(new Produto("Pão de Forma", "Bauduco", 8.99f, "Pães", "0005"));

        // funcionarios do mercado
        funcionarios.add(new Gerente("Maria Silva", LocalDate.of(1985, 3, 12), "123.456.789-00", "Feminino"));
        funcionarios.add(new Estocador("João Souza", LocalDate.of(1998, 10, 25), "987.654.321-00", "Masculino"));
        funcionarios.add(new Estocador("Ana Lima", LocalDate.of(2000, 5, 7), "456.789.123-00", "Feminino"));
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
                case 4: // ver funcionarios
                    List<String> listaFormatada = new ArrayList<>();
                    for (Funcionario f : funcionarios) {
                        listaFormatada.add(f.getClass().getSimpleName() + ": " + f.getNome() + " (" + f.getCPF() + ")");
                    }
                    view.exibirFuncionarios(listaFormatada);
                    break;
                case 0: // sair
                    view.exibirMensagem("Saindo do sistema... ");
                    return;
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