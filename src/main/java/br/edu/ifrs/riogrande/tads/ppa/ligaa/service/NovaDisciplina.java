package br.edu.ifrs.riogrande.tads.ppa.ligaa.service;

public class NovaDisciplina {

    private String nome;
    private String ementa;
    private int cargaHoraria;
    private int aulaSemanais;
    private String codigo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public int getAulaSemanais() {
        return aulaSemanais;
    }

    public void setAulaSemanais(int aulaSemanais) {
        this.aulaSemanais = aulaSemanais;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codeName) {
        this.codigo = codeName;
    }

    @Override
    public String toString() {
        return "NovaDisciplina [nome=" + nome + ", ementa=" + ementa + ", cargaHoraria=" + cargaHoraria
                + ", aulaSemanais=" + aulaSemanais + ", codigo=" + codigo + "]";
    }
}