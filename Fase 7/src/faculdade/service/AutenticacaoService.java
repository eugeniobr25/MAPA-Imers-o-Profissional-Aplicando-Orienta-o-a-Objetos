package faculdade.service;

import faculdade.model.Usuario;
import faculdade.repository.UsuarioRepository;
import faculdade.interfaces.Autenticacao;

public class AutenticacaoService {
    private UsuarioRepository usuarioRepository;

    public AutenticacaoService() {
        this.usuarioRepository = new UsuarioRepository();
    }

    public boolean tentarLogin(String login, String senha) {
        Usuario usuario = usuarioRepository.buscarPorLogin(login);

        if (usuario == null) {
            System.out.println("❌ Login falhou: Usuário '" + login + "' não encontrado.");
            return false;
        }
        if (usuario instanceof Autenticacao) {
            Autenticacao autenticavel = (Autenticacao) usuario;
            String resultado = autenticavel.autenticar(login, senha);

            if (resultado.equals("Senha correta")) {
                System.out.println("✅ Autenticação bem-sucedida! Bem-vindo(a), " + usuario.getNome() + ".");
                return true;
            } else {
                System.out.println("❌ Login falhou: Senha incorreta.");
                return false;
            }
        } else {
            System.out.println("⚠️ Login falhou: O objeto " + usuario.getNome() + " não é um tipo de usuário autenticável.");
            return false;
        }
    }
}