package faculdade.models;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private String codigo;
    private Professor professor;
    private Curso curso;
    private List<Aluno> listaAlunos;

    public Turma(String codigo, Professor professor, Curso curso) {
        this.codigo = codigo;
        this.professor = professor;
        this.curso = curso;
        this.listaAlunos = new ArrayList<>();
    }

    public void adicionarAluno(Aluno aluno) {
        if (aluno != null) {
            this.listaAlunos.add(aluno);
        }
    }

    public void removerAluno(Aluno aluno) {
        if (aluno != null) {
            this.listaAlunos.remove(aluno);
        }
    }

    public void mostrarResumo() {
        System.out.println("--- Resumo da Turma ---");
        System.out.println("Código da Turma: " + this.codigo);
        System.out.println("Curso: " + this.curso.getNome());
        System.out.println("Professor: " + this.professor.getNome() + " (" + this.professor.getEspecialidade() + ")");
        System.out.println("Total de Alunos Matriculados: " + this.listaAlunos.size());
        System.out.println("------------------------");
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public void setListaAlunos(List<Aluno> listaAlunos) {
        this.listaAlunos = listaAlunos;
    }
}