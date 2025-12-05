package faculdade.repository;

import faculdade.model.Turma;
import faculdade.model.CursoEAD; // Assumindo que Turma usa subclasses de Curso
import faculdade.model.Professor;
import java.util.ArrayList;
import java.util.List;

public class TurmaRepository {
    private static final List<Turma> turmas = new ArrayList<>();

    static {
        Professor flavio = new Professor("Flávio Ceci", "Programação POO", "P1", "flavio.ceci", "java2024");
        CursoEAD software = new CursoEAD("Engenharia de Software", "C003", 3600, "Studeo");

        Turma turmaT1 = new Turma("T1_ADS_2024", flavio, software);
        turmas.add(turmaT1);
    }

    public static List<Turma> buscarTodas() {
        return turmas;
    }

    public static Turma buscarPorCodigo(String codigo) {
        for (Turma t : turmas) {
            if (t.getCodigo().equals(codigo)) { // Agora getCodigo() existe em Turma
                return t;
            }
        }
        return null;
    }
}