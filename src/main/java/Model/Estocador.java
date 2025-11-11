package Model;

import java.time.LocalDate;


/*
 * Principio High Cohesion 
 * 
 * Classe onde os atributos e os métodos são apenas sobre o funcionário estocador, não misturando com outros funcionários e nem fazendo tarefas que não pertence a ele.
 */

public class Estocador extends Funcionario{

    public Estocador(String nome, LocalDate data_nasc, String cpf, String sexo) {
        super(nome, data_nasc, cpf, sexo);
    }

    @Override
    public void realizarTrabalho() {
        System.out.println(this.nome + "está estocando os produtos...");
    }

}
