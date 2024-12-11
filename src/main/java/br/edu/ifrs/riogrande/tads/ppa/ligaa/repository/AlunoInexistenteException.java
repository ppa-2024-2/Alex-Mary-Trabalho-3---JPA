package br.edu.ifrs.riogrande.tads.ppa.ligaa.repository;

public class AlunoInexistenteException extends RuntimeException {

    public AlunoInexistenteException() {
        super("O Aluno não foi encontrado");
    }
}