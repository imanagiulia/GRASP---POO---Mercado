package Model;
import java.time.LocalDate;

public class Limpeza extends Funcionario{

    public Limpeza(String nome, LocalDate data_nasc, String cpf, String sexo) {
        super(nome, data_nasc, cpf, sexo);
    }

    @Override
    public void realizarTrabalho() {
        System.out.println(this.nome + " está fazendo a limpeza do mercado...");
    }

}
