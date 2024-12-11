package br.edu.ifrs.riogrande.tads.ppa.ligaa.repository;

public class NovaTurma {
    private String codigo;
    private String disciplinaCodeName;
    private String siape;
    private String semestre;
    private String sala;
    private int vagas;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codeName) {
        this.codigo = codeName;
    }

    public String getDisciplinaCodeName() {
        return disciplinaCodeName;
    }

    public void setDisciplinaCodeName(String disciplinaCodeName) {
        this.disciplinaCodeName = disciplinaCodeName;
    }

    public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    @Override
    public String toString() {
        return "NovaTurma [codigo=" + codigo + ", disciplinaCodeName=" + disciplinaCodeName + ", siape=" + siape
                + ", semestre=" + semestre + ", sala=" + sala + ", vagas=" + vagas + "]";
    }
}