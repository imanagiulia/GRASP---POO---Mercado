package Model;

import java.time.LocalDate;

public class Caixa extends Funcionario{

    public Caixa(String nome, LocalDate dataNasc, String cpf, String sexo) {
        super(nome, dataNasc, cpf, sexo);
    }

    @Override
    public void realizarTrabalho() {
        System.out.println(this.nome + "está operando o caixa...");
    }


    public void registrarVenda(Carrinho compra){
        
        System.out.println("Itens comprados: ");
        compra.mostrarItens();
        
        System.out.println("O total da sua compra é: R$" + compra.calcularTotal());
    }

}
