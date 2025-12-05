package faculdade;

import faculdade.models.Curso;
import faculdade.models.CursoPresencial;
import faculdade.models.CursoEAD;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Informações do Curso ---");

        CursoPresencial civil = new CursoPresencial(
                "Engenharia Civil",
                "C002",
                3600,
                "101-B"
        );

        CursoEAD software = new CursoEAD(
                "Engenharia de Software",
                "C003",
                3600,
                "Studeo"
        );

        System.out.println("\n---");

        civil.detalharCurso();

        System.out.println("\n---");

        software.detalharCurso();

        System.out.println("\n---");
    }
}