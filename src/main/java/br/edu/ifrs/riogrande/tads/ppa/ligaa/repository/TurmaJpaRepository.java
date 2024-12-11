package br.edu.ifrs.riogrande.tads.ppa.ligaa.repository;

import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifrs.riogrande.tads.ppa.ligaa.domain.Aluno;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.domain.Historico;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.domain.Turma;

@Repository
public interface TurmaJpaRepository extends ListCrudRepository<Turma, UUID> {

    Turma findByCodigo(String codigo);

    boolean existsByCodigo(String codigo);

    default List<Turma> findByAluno(Aluno aluno) {
        return findAll().stream().filter(t -> {
            return t.getMatriculas().stream()
                    .anyMatch(m -> m.getAluno().equals(aluno));
        }).toList();
    }

    default Historico findHistorico(Aluno aluno) {
        return new Historico(aluno, findByAluno(aluno));
    }
}