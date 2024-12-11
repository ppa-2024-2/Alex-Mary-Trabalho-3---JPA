package br.edu.ifrs.riogrande.tads.ppa.ligaa.repository;

public class TurmaInexistenteException extends RuntimeException {

    public TurmaInexistenteException() {
        super("A turma não foi encontrada");
    }
}