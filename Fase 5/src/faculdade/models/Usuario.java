package faculdade.models;

import faculdade.interfaces.Autenticacao;

public abstract class Usuario implements Autenticacao {
    private String login;
    private String senha;
    private String nome;

    public Usuario(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    @Override
    public String autenticar(String login, String senha) {
        if (this.login.equals(login) && this.senha.equals(senha)) {
            return "Senha correta";
        } else {
            return "Senha incorreta, tente novamente";
        }
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }
}