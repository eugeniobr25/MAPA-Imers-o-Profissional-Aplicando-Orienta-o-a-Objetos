package faculdade;

import faculdade.model.Aluno;
import faculdade.model.Professor;
import faculdade.model.CursoEAD;
import faculdade.ui.MenuUI;

public class Main {
    public static void main(String[] args) {
        CursoEAD cursoTeste = new CursoEAD(
                "Engenharia de Software",
                "C003",
                3600,
                "Studeo"
        );

        Professor professorTeste = new Professor(
                "Flávio Ceci", "Programação POO", "P1",
                "flavio.ceci", "java2024"
        );

        Aluno alunoTeste = new Aluno(
                "Eugênio Lima", "24472636-5", cursoTeste.getNome(),
                "eugenio.lima", "123mudar"
        );

        MenuUI menu = new MenuUI(alunoTeste, professorTeste, cursoTeste);
        menu.iniciar();
    }
}