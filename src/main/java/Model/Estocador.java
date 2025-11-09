package Model;

import java.time.LocalDate;

public class Estocador extends Funcionario{

    public Estocador(String nome, LocalDate data_nasc, String cpf, String sexo) {
        super(nome, data_nasc, cpf, sexo);
    }

    @Override
    public void realizarTrabalho() {
        System.out.println(this.nome + "está estocando os produtos...");
    }

}
