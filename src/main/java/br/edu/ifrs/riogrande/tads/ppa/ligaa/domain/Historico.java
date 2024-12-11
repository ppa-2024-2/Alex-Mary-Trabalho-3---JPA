package br.edu.ifrs.riogrande.tads.ppa.ligaa.domain;

import java.util.List;

import br.edu.ifrs.riogrande.tads.ppa.ligaa.domain.Matricula.Situacao;

// Value Object => Objeto de Valor 
// DTO => VO => DTO
public record Historico(Aluno aluno, List<Turma> turmas) {

    public List<Turma> turmasAnteriores(Turma turma) {
        return turmas.stream()
                .filter(t -> t.getDisciplina().equals(turma.getDisciplina()))
                .toList();
    }

    public boolean reprovadoAnteriormente(List<Turma> turmasAnterioresDaDisciplina) {
        return turmasAnterioresDaDisciplina.stream()
                .flatMap(t -> t.getMatriculas().stream())
                .anyMatch(m -> m.getAluno().equals(aluno) && m.getSituacao().equals(Situacao.REPROVADO));
    }

    public void alunoAproveitouAnteriormente(Turma turma, Aluno aluno) {
        boolean aproveitamentoAnteriormente = this.turmasAnteriores(turma).stream()
                .flatMap(t -> t.getMatriculas().stream())
                .anyMatch(m -> m.getAluno().equals(aluno) && m.getSituacao().equals(Situacao.APROVEITAMENTO));

        if (aproveitamentoAnteriormente) {
            throw new DomainException(
                    "Aluno " + aluno.getCpf() + " já aproveitou a disciplina " + turma.getDisciplina().getNome());
        }
    }

    public void alunoAprovadoEm(Turma turma, Aluno aluno) {
        boolean aprovadoAnteriormente = this.turmasAnteriores(turma).stream().flatMap(t -> t.getMatriculas().stream())
                .anyMatch(m -> m.getAluno().equals(aluno) && m.getSituacao().equals(Situacao.APROVADO));

        if (aprovadoAnteriormente) {
            throw new DomainException(
                    "Aluno " + aluno.getCpf() + " já aprovado na disciplina " + turma.getDisciplina().getNome());
        }
    }
}