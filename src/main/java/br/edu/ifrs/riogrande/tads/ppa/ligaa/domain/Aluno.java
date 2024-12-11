package br.edu.ifrs.riogrande.tads.ppa.ligaa.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.InheritanceType;

@Entity // Notação Húngara (Hungarian Notation)
@Table(name = "tbl_alunos")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Aluno extends Entidade {
    @Column(nullable = false, length = 254) // VARCHAR(254)
    private String nome;

    @Column(name = "email", nullable = false, length = 254)
    private String enderecoEletronico;

    @Column(nullable = false, unique = true, length = 254)
    private String login; // e-mail

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @Transient // não-persistido
    private String dado;

    public String getEnderecoEletronico() {
        return enderecoEletronico;
    }

    public void setEnderecoEletronico(String enderecoEletronico) {
        this.enderecoEletronico = enderecoEletronico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Aluno [nome=" + nome + ", enderecoEletronico=" + enderecoEletronico + ", login=" + login + ", cpf="
                + cpf + ", dado=" + dado + ", getId()=" + getId() + ", getDataHoraCriacao()=" + getDataHoraCriacao()
                + ", getDataHoraAlteracao()=" + getDataHoraAlteracao() + ", isDesativado()=" + isDesativado() + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((enderecoEletronico == null) ? 0 : enderecoEletronico.hashCode());
        result = prime * result + ((login == null) ? 0 : login.hashCode());
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
        result = prime * result + ((dado == null) ? 0 : dado.hashCode());
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
        Aluno other = (Aluno) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (enderecoEletronico == null) {
            if (other.enderecoEletronico != null)
                return false;
        } else if (!enderecoEletronico.equals(other.enderecoEletronico))
            return false;
        if (login == null) {
            if (other.login != null)
                return false;
        } else if (!login.equals(other.login))
            return false;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        if (dado == null) {
            if (other.dado != null)
                return false;
        } else if (!dado.equals(other.dado))
            return false;
        return true;
    }
}