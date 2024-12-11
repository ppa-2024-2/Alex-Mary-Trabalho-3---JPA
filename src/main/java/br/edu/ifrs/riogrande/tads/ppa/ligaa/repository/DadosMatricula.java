package br.edu.ifrs.riogrande.tads.ppa.ligaa.repository;

public class DadosMatricula {
    private String cpf;
    private String turmaCodeName;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTurmaCodeName() {
        return turmaCodeName;
    }

    public void setTurmaCodeName(String turmaCodeName) {
        this.turmaCodeName = turmaCodeName;
    }

    @Override
    public String toString() {
        return "DadosMatricula [cpf=" + cpf + ", turmaCodeName=" + turmaCodeName + "]";
    }
}