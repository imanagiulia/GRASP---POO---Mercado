package Model;

/*
 * Principio High Cohesion 
 * Essa classe só faz coisas relacionadas a "coisas de gerente"
 */


import java.time.LocalDate;

public class Gerente extends Funcionario{

    public Gerente(String nome, LocalDate data_nasc, String cpf, String sexo) {
        super(nome, data_nasc, cpf, sexo);    
    }

    @Override
    public void realizarTrabalho() {
        System.out.println(this.nome + "está gerenciando o mercado...");
    }

    public void alterarPreco(Produto produto, float novo_preco){
        produto.setPreco(novo_preco);
    }

}
