package br.edu.ifrs.riogrande.tads.ppa.ligaa.service;

import org.springframework.stereotype.Service;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.domain.Professor;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.repository.ProfessorJpaRepository;
import java.util.UUID;

@Service
public class ProfessorService {
    private final ProfessorJpaRepository professorRepository;

    public ProfessorService(ProfessorJpaRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public void cadastrarProfessor(NovoProfessor novoProfessor) {

        if (professorRepository.existsBySiape(novoProfessor.getSiape())) {
            throw new IllegalStateException("SIAPE já existe: " + novoProfessor.getSiape());
        }

        Professor professor = new Professor();

        professor.setId(UUID.randomUUID());
        professor.setNome(novoProfessor.getNome());
        professor.setSiape(novoProfessor.getSiape());
        professor.setFormacao(novoProfessor.getFormacao());

        professorRepository.save(professor);
    }

    public Iterable<Professor> findAll() {
        return professorRepository.findAll();
    }
}