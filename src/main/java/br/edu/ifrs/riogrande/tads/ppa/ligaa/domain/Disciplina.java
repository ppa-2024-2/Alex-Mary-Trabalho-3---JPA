package br.edu.ifrs.riogrande.tads.ppa.ligaa.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name = "disciplinas")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Disciplina extends Entidade {

    @Column(nullable = false)
    private String codigo;
    private String nome;
    private String ementa;
    private int cargaHoraria;
    private int aulasSemanais;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

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

    public int getAulasSemanais() {
        return aulasSemanais;
    }

    public void setAulasSemanais(int aulasSemanais) {
        this.aulasSemanais = aulasSemanais;
    }

    @Override
    public String toString() {
        return "Disciplina [codigo=" + codigo + ", nome=" + nome + ", ementa=" + ementa + ", cargaHoraria="
                + cargaHoraria + ", aulasSemanais=" + aulasSemanais + ", getId()=" + getId() + ", getDataHoraCriacao()="
                + getDataHoraCriacao() + ", getDataHoraAlteracao()=" + getDataHoraAlteracao() + ", isDesativado()="
                + isDesativado() + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((ementa == null) ? 0 : ementa.hashCode());
        result = prime * result + cargaHoraria;
        result = prime * result + aulasSemanais;
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
        Disciplina other = (Disciplina) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (ementa == null) {
            if (other.ementa != null)
                return false;
        } else if (!ementa.equals(other.ementa))
            return false;
        if (cargaHoraria != other.cargaHoraria)
            return false;
        if (aulasSemanais != other.aulasSemanais)
            return false;
        return true;
    }
}