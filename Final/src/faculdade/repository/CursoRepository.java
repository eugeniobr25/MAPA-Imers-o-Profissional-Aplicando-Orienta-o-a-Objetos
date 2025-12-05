package faculdade.repository;

import faculdade.model.Curso;
import faculdade.model.CursoEAD; // Subclasse
import faculdade.model.CursoPresencial; // Subclasse
import java.util.ArrayList;
import java.util.List;

public class CursoRepository {
    private static final List<Curso> cursos = new ArrayList<>();

    static {
        cursos.add(new CursoEAD("Engenharia de Software", "C003", 3600, "Plataforma Studeo"));
        cursos.add(new CursoEAD("Análise e Desenvolvimento de Sistemas", "C001", 2400, "AVA Moodle"));
        cursos.add(new CursoPresencial("Arquitetura e Urbanismo", "C002", 4000, "Bloco A - Labs"));
        cursos.add(new CursoPresencial("Direito", "C004", 4500, "Auditório Central"));
    }

    public static void salvar(Curso curso) {
        if (buscarPorCodigo(curso.getCodigo()) == null) {
            cursos.add(curso);
        } else {
        }
    }

    public static List<Curso> buscarTodos() {
        return cursos;
    }

    public static Curso buscarPorCodigo(String codigo) {
        for (Curso c : cursos) {
            if (c.getCodigo().equals(codigo)) {
                return c;
            }
        }
        return null;
    }
}