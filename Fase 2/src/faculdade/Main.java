package faculdade;

import faculdade.models.Aluno;
import faculdade.models.Professor;
import faculdade.models.Curso;
import faculdade.models.Turma;

public class Main {
    public static void main(String[] args) {

        Curso ads = new Curso(
                "SUPERIOR DE TECNOLOGIA EM ANÁLISE E DESENVOLVIMENTO DE SISTEMAS",
                "0001",
                2089
        );

        Professor flavio = new Professor(
                "Flávio Ceci",
                "PROGRAMAÇÃO ORIENTADA A OBJETOS",
                "P1"
        );

        Aluno eugenio = new Aluno(
                "Eugênio Brilhante Moraes Lima",
                "24472636-5",
                ads.getNome()
        );

        Aluno maria = new Aluno(
                "Maria Clara Silva",
                "24472637-6",
                ads.getNome()
        );


        Turma turmaT1 = new Turma("T1_ADS_2024", flavio, ads);

        turmaT1.adicionarAluno(eugenio);
        turmaT1.adicionarAluno(maria);

        turmaT1.mostrarResumo();

        turmaT1.removerAluno(eugenio);

        System.out.println("\n*** Após remoção do Eugênio ***");
        turmaT1.mostrarResumo();
    }
}