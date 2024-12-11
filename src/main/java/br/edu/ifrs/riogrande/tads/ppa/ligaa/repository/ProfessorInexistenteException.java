package br.edu.ifrs.riogrande.tads.ppa.ligaa.repository;

public class ProfessorInexistenteException extends RuntimeException {

    public ProfessorInexistenteException() {
        super("O Professor não foi encontrado");
    }
}