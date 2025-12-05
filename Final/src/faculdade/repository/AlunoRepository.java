package faculdade.repository;

import faculdade.model.Aluno;
import java.util.ArrayList;
import java.util.List;

public class AlunoRepository {
    private static final List<Aluno> alunos = new ArrayList<>();

    static {
        alunos.add(new Aluno("Eugênio Lima", "24472636-5", "Engenharia de Software", "eugenio.lima", "123mudar"));
    }

    public static void salvar(Aluno aluno) {
        Aluno existente = buscarPorMatricula(aluno.getMatricula());
        if (existente == null) {
            alunos.add(aluno);
        } else {

        }
    }

    public static List<Aluno> buscarTodos() {
        return alunos;
    }

    public static Aluno buscarPorMatricula(String matricula) {
        for (Aluno a : alunos) {
            if (a.getMatricula().equals(matricula)) {
                return a;
            }
        }
        return null;
    }
}