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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
