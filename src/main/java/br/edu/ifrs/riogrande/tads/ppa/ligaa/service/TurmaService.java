package br.edu.ifrs.riogrande.tads.ppa.ligaa.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.domain.Turma;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.domain.Matricula.Situacao;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.domain.Aluno;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.domain.Disciplina;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.domain.Historico;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.domain.Matricula;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.domain.Professor;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.repository.AlunoInexistenteException;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.repository.AlunoJpaRepository;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.repository.DisciplinaInexistenteException;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.repository.DisciplinaJpaRepository;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.repository.MatriculaJpaRepository;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.repository.NovaTurma;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.repository.ProfessorInexistenteException;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.repository.ProfessorJpaRepository;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.repository.TurmaInexistenteException;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.repository.TurmaJpaRepository;

@Service
public class TurmaService {

    int numero;
    private final TurmaJpaRepository turmaRepository;
    private final AlunoJpaRepository alunoRepository;
    private final ProfessorJpaRepository professorRepository;
    private final DisciplinaJpaRepository disciplinaRepository;
    private final MatriculaJpaRepository matriculaRepository;

    public TurmaService(
            TurmaJpaRepository turmaRepository,
            AlunoJpaRepository alunoRepository,
            ProfessorJpaRepository professorRepository,
            DisciplinaJpaRepository disciplinaRepository,
            MatriculaJpaRepository matriculaRepository) {
        this.turmaRepository = turmaRepository;
        this.alunoRepository = alunoRepository;
        this.professorRepository = professorRepository;
        this.disciplinaRepository = disciplinaRepository;
        this.matriculaRepository = matriculaRepository;
    }

    public void cadastrarTurma(NovaTurma novaTurma) {
        if (turmaRepository.existsByCodigo(novaTurma.getCodigo())) {
            throw new IllegalStateException("Turma já existe: " + novaTurma.getCodigo());
        }

        Professor professor = new Professor();
        Disciplina disciplina = new Disciplina();

        String siape = novaTurma.getSiape();
        String disciplinaCodeName = novaTurma.getDisciplinaCodeName();

        if (!professorRepository.existsBySiape(siape)) {
            throw new ProfessorInexistenteException();
        }
        professor = professorRepository.findBySiape(siape);

        if (!disciplinaRepository.existsByCodigo(disciplinaCodeName)) {
            throw new DisciplinaInexistenteException();
        }
        disciplina = disciplinaRepository.findByCodigo(disciplinaCodeName);

        Turma turma = new Turma();

        turma.setId(UUID.randomUUID());
        turma.setCodigo(novaTurma.getCodigo());
        turma.setDisciplina(disciplina);
        turma.setProfessor(professor);
        turma.setSemestre(novaTurma.getSemestre());
        turma.setSala(novaTurma.getSala());
        turma.setVagas(novaTurma.getVagas());

        turmaRepository.save(turma);
    }

    public Matricula matricular(String cpf, String codigoTurma) {
        // turma existe?
        if (!turmaRepository.existsByCodigo(codigoTurma)) {
            throw new NotFoundException();
        }
        var turma = turmaRepository.findByCodigo(codigoTurma);

        // aluno existe?
        if (!alunoRepository.existsByCpf(cpf)) {
            throw new NotFoundException();
        }
        var aluno = alunoRepository.findByCpf(cpf);

        Historico historico = turmaRepository.findHistorico(aluno);

        return turma.matricularAluno(aluno, historico);
    }

    // public Iterable<Turma> findAll() {
    // return turmaRepository.findAll();
    // }

    public void setAprovado(String cpf, String codigoTurma) {
        Turma turma = new Turma();
        Aluno aluno = new Aluno();

        if (!turmaRepository.existsByCodigo(codigoTurma)) {
            throw new TurmaInexistenteException();
        }
        turma = turmaRepository.findByCodigo(codigoTurma);

        if (!alunoRepository.existsByCpf(cpf)) {
            throw new AlunoInexistenteException();
        }
        aluno = alunoRepository.findByCpf(cpf);

        List<Matricula> matriculas = turma.getMatriculas();

        for (Matricula matricula : matriculas) {
            if (matricula.getAluno().getCpf().equals(aluno.getCpf())) {
                matricula.setSituacao(Situacao.APROVADO);
                matriculaRepository.save(matricula);
            }
        }
    }
}