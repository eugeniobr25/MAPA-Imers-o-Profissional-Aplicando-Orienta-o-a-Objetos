package faculdade.repository;

import faculdade.model.Professor;
import java.util.ArrayList;
import java.util.List;

public class ProfessorRepository {
    private static final List<Professor> professores = new ArrayList<>();

    static {
        professores.add(new Professor("Flávio Ceci", "Programação POO", "P1", "flavio.ceci", "java2024"));
        professores.add(new Professor("Ana Souza", "Circuitos Digitais", "P2", "ana.souza", "digi123"));
        professores.add(new Professor("Carlos Santos", "Gestão de Projetos", "P3", "carlos.santos", "projxyz"));
    }

    public static List<Professor> buscarTodos() {
        return professores;
    }

    public static Professor buscarPorRegistro(String registro) {
        for (Professor p : professores) {
            if (p.getRegistro().equals(registro)) {
                return p;
            }
        }
        return null;
    }
}