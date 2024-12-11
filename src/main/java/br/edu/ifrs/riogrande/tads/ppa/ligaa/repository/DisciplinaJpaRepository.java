package br.edu.ifrs.riogrande.tads.ppa.ligaa.repository;

import java.util.UUID;

import br.edu.ifrs.riogrande.tads.ppa.ligaa.domain.Disciplina;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaJpaRepository extends CrudRepository<Disciplina, UUID> {

    boolean existsByCodigo(String codigo);

    Disciplina findByCodigo(String codigo);
}