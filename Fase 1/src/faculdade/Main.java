package faculdade;

import faculdade.models.Aluno;
import faculdade.models.Professor;
import faculdade.models.Curso;

public class Main {
    public static void main(String[] args) {
        Curso cursoADS = new Curso(
                "SUPERIOR DE TECNOLOGIA EM ANÁLISE E DESENVOLVIMENTO DE SISTEMAS",
                "0001",
                2089
        );

        Aluno aluno = new Aluno(
                "Eugênio Brilhante Moraes Lima",
                "24472636-5",
                cursoADS.getNome()
        );

        Professor professor = new Professor(
                "Flávio Ceci",
                "PROGRAMAÇÃO ORIENTADA A OBJETOS",
                "P1"
        );

        System.out.println("Aluno: " + aluno.getNome());
        System.out.println("Matrícula: " + aluno.getMatricula());
        System.out.println("Curso: " + aluno.getCurso());
        System.out.println("---");
        System.out.println("Professor: " + professor.getNome());
        System.out.println("Especialidade: " + professor.getEspecialidade());
        System.out.println("Registro: " + professor.getRegistro());
        System.out.println("---");
        System.out.println("Curso Código: " + cursoADS.getCodigo());
        System.out.println("Carga Horária: " + cursoADS.getCargaHoraria() + "h");
    }
}