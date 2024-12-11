package br.edu.ifrs.riogrande.tads.ppa.ligaa.service;

import java.util.UUID;

import org.springframework.stereotype.Service;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.domain.Disciplina;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.repository.DisciplinaJpaRepository;

@Service
public class DisciplinaService {
    private final DisciplinaJpaRepository disciplinaRepository;

    public DisciplinaService(DisciplinaJpaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }

    public void cadastrarDisciplina(NovaDisciplina novaDisciplina) {

        if (disciplinaRepository.existsByCodigo(novaDisciplina.getCodigo())) {
            throw new IllegalStateException("Disciplina já existe: " + novaDisciplina.getCodigo());
        }

        Disciplina disciplina = new Disciplina();
        disciplina.setEmenta(novaDisciplina.getEmenta());
        disciplina.setNome(novaDisciplina.getNome());
        disciplina.setCargaHoraria(novaDisciplina.getCargaHoraria());
        disciplina.setCodigo(novaDisciplina.getCodigo());
        disciplina.setAulasSemanais(novaDisciplina.getAulaSemanais());
        disciplina.setId(UUID.randomUUID());

        disciplinaRepository.save(disciplina);
    }

    public Iterable<Disciplina> findAll() {
        return disciplinaRepository.findAll();
    }
}