package br.edu.ifrs.riogrande.tads.ppa.ligaa.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.Table;
import jakarta.persistence.InheritanceType;

@Entity // Notação Húngara (Hungarian Notation)
@Table(name = "tbl_professores")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Professor extends Entidade {
    @Column(nullable = false, length = 254) // VARCHAR(254)
    private String nome;

    @Column(nullable = false, length = 254)
    private String formacao;

    @Column(nullable = false, unique = true, length = 7)
    private String siape;

    public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    @Override
    public String toString() {
        return "Professor [nome=" + nome + ", formacao=" + formacao + ", siape=" + siape + ", getId()=" + getId()
                + ", getDataHoraCriacao()=" + getDataHoraCriacao() + ", getDataHoraAlteracao()="
                + getDataHoraAlteracao() + ", isDesativado()=" + isDesativado() + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((formacao == null) ? 0 : formacao.hashCode());
        result = prime * result + ((siape == null) ? 0 : siape.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Professor other = (Professor) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (formacao == null) {
            if (other.formacao != null)
                return false;
        } else if (!formacao.equals(other.formacao))
            return false;
        if (siape == null) {
            if (other.siape != null)
                return false;
        } else if (!siape.equals(other.siape))
            return false;
        return true;
    }
}