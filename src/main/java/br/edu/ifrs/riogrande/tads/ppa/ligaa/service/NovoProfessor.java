package br.edu.ifrs.riogrande.tads.ppa.ligaa.service;

public class NovoProfessor {
    private String nome;
    private String siape;
    private String formacao;

    public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "NovoProfessor [nome=" + nome + ", siape=" + siape + ", formacao=" + formacao + "]";
    }
}
