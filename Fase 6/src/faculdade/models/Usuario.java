package faculdade.models;

import faculdade.interfaces.Autenticacao;
import faculdade.interfaces.Relatavel; // Novo

public abstract class Usuario implements Autenticacao, Relatavel {
    private String login;
    private String senha;
    private String nome;

    public Usuario(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    @Override
    public void gerarRelatorio() {
        System.out.println("--- Relatório Base do Usuário ---");
        System.out.println("Nome: " + this.getNome());
        System.out.println("Login: " + this.getLogin());
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