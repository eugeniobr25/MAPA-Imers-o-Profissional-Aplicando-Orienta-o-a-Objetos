package faculdade.repository;

import faculdade.model.Usuario;
import faculdade.model.Professor;
import faculdade.model.Aluno;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository {
    private static final List<Usuario> usuarios = new ArrayList<>();

    static {
        usuarios.add(new Aluno("Eugênio Lima", "24472636-5", "ADS", "eugenio.lima", "123mudar"));
        usuarios.add(new Professor("Flávio Ceci", "Programação POO", "P1", "flavio.ceci", "java2024"));
    }

    public static Usuario buscarPorLogin(String login) {
        for (Usuario u : usuarios) {
            if (u.getLogin().equals(login)) {
                return u;
            }
        }
        return null;
    }
}