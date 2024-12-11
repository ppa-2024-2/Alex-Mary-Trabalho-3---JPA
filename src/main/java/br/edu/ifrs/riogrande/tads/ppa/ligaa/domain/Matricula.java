package br.edu.ifrs.riogrande.tads.ppa.ligaa.domain;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.Table;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "tbl_matriculas")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Matricula extends Entidade {

    public enum Situacao {
        REGULAR,
        APROVEITAMENTO,
        CANCELADO,
        APROVADO,
        REPROVADO
    }

    @ManyToOne(optional = false)
    private Aluno aluno;
    @Enumerated(EnumType.STRING)
    private Situacao situacao;
    private int numero;

    public Matricula(Aluno aluno) {
        this.setNumero(++numero);
        this.setSituacao(Situacao.REGULAR);
        this.setAluno(aluno);
    }

    Matricula() {
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    @Override
    public String toString() {
        return "Matricula [numero=" + numero + ", aluno=" + aluno + ", situacao=" + situacao + ", getId()=" + getId()
                + ", getDataHoraCriacao()=" + getDataHoraCriacao() + ", getDataHoraAlteracao()="
                + getDataHoraAlteracao() + ", isDesativado()=" + isDesativado() + "]";
    }
}