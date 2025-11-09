package Model;

import java.time.*;
public abstract class Funcionario {
    protected String nome;
    protected LocalDate dataNascimento;
    protected String CPF;
    protected String sexo;
    protected boolean ativo; 

    public Funcionario(String nome, LocalDate data_nasc, String cpf, String sexo){
        this.nome = nome;
        this.dataNascimento = data_nasc;
        this.CPF = cpf;
        this.sexo = sexo;
        this.ativo = true;
    }

    public abstract void realizarTrabalho();

}
