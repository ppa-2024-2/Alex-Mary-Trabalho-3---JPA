package br.edu.ifrs.riogrande.tads.ppa.ligaa.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Inheritance;
import jakarta.persistence.Table;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
@Table(name = "tbl_turmas")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Turma extends Entidade {

    @Column(nullable = false)
    private String codigo; // ppa-2024-2
    private String semestre; // 2024-2
    private String sala;
    private int vagas;
    private boolean fechada;

    @ManyToOne(optional = false)
    private Disciplina disciplina;

    // this -> @ManyToOne -> professor
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Professor professor;

    @OneToMany
    private List<Matricula> matriculas = new ArrayList<>();

    public void turmaEstaAberta() {
        if (this.isFechada()) {
            throw new DomainException("Turma " + this.codigo + " está fechada");
        }
    }

    public void haVagas(Historico historico) {
        int qtdAlunosTurma = this.getMatriculas().size();

        int qtdVagas = this.getVagas();

        if (qtdAlunosTurma >= qtdVagas) { // não
            // turmas anteriores da disciplina
            var turmasAnterioresDaDisciplina = historico.turmasAnteriores(this);

            boolean reprovadoAnteriormente = historico.reprovadoAnteriormente(turmasAnterioresDaDisciplina);

            // se nunca foi reprovado, não pode matricular-se
            if (!reprovadoAnteriormente) {
                throw new DomainException("Não há vagas na turma " + this.getCodigo());
            }
        }
    }

    public void estaMatriculado(Aluno aluno) {
        boolean estaMatriculado = this.getMatriculas()
                .stream()
                .anyMatch(m -> m.getAluno().equals(aluno));
        if (estaMatriculado) {
            throw new DomainException("Aluno " + aluno.getCpf() + " já está matriculado na turma " + this.codigo);
        }
    }

    public Matricula matricularAluno(Aluno aluno, Historico historico) {
        this.turmaEstaAberta();
        this.estaMatriculado(aluno);
        historico.alunoAprovadoEm(this, aluno);
        historico.alunoAproveitouAnteriormente(this, aluno);
        this.haVagas(historico);

        Matricula matricula = new Matricula(aluno);
        matricula.setId(UUID.randomUUID());
        this.getMatriculas().add(matricula);

        return matricula;
    }

    public boolean isFechada() {
        return fechada;
    }

    public void setFechada(boolean fechada) {
        this.fechada = fechada;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    @Override
    public String toString() {
        return "Turma [codigo=" + codigo + ", semestre=" + semestre + ", sala=" + sala + ", vagas=" + vagas
                + ", fechada=" + fechada + ", disciplina=" + disciplina + ", professor=" + professor + ", matriculas="
                + matriculas + ", getId()=" + getId() + ", getDataHoraCriacao()=" + getDataHoraCriacao()
                + ", getDataHoraAlteracao()=" + getDataHoraAlteracao() + ", isDesativado()=" + isDesativado() + "]";
    }
}