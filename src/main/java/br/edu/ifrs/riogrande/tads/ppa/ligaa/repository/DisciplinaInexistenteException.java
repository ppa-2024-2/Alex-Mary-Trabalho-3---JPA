package br.edu.ifrs.riogrande.tads.ppa.ligaa.repository;

public class DisciplinaInexistenteException extends RuntimeException {

    public DisciplinaInexistenteException() {
        super("A disciplina não foi encontrada");
    }
}