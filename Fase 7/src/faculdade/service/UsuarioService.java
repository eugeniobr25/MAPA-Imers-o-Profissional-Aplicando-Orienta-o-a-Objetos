package faculdade.service;

import faculdade.model.Usuario; // Classe base
import faculdade.interfaces.Autenticacao;

public class UsuarioService {

    public boolean autenticarUsuario(Autenticacao usuario, String login, String senha) {
        if (usuario == null) {
            System.out.println("Usuário não encontrado.");
            return false;
        }

        String resultado = usuario.autenticar(login, senha);

        if (resultado.equals("Senha correta")) {
            System.out.println("✅ Autenticação bem-sucedida para: " + ((Usuario)usuario).getNome());
            return true;
        } else {
            System.out.println("❌ Falha na autenticação: Credenciais inválidas.");
            return false;
        }
    }
}