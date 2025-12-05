package faculdade;

import faculdade.interfaces.Autenticacao;
import faculdade.models.Aluno;
import faculdade.models.Professor;
import faculdade.models.Administrador;

public class Main {

    public static void realizarTeste(Autenticacao usuario, String loginTentativa, String senhaTentativa, String descricao) {
        String resultado = usuario.autenticar(loginTentativa, senhaTentativa);

        String nomeUsuario = ((faculdade.models.Usuario)usuario).getNome();

        System.out.print("Teste (" + descricao + ") - Usuário " + nomeUsuario + ": ");

        if (resultado.equals("Senha correta")) {
            System.out.println("✅ SUCESSO");
        } else {
            System.out.println("❌ FALHA");
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Teste de Autenticação ---");

        Aluno aluno = new Aluno(
                "Eugênio Lima", "24472636-5", "ADS",
                "eugenio.lima", "123mudar"
        );

        Professor professor = new Professor(
                "Flávio Ceci", "Programação POO", "P1",
                "flavio.ceci", "java2024"
        );

        Administrador admin = new Administrador(
                "Root Admin",
                "root", "masterkey"
        );

        System.out.println("\n--- Aluno ---");
        realizarTeste(aluno, "eugenio.lima", "senhaerrada", "Falha (Senha errada)");
        realizarTeste(aluno, "eugenio.lima", "123mudar", "Sucesso (Correto)");

        System.out.println("\n--- Professor ---");
        realizarTeste(professor, "f.ceci", "java2024", "Falha (Login errado)");
        realizarTeste(professor, "flavio.ceci", "java2024", "Sucesso (Correto)");

        System.out.println("\n--- Administrador ---");
        realizarTeste(admin, "root", "chaveinvalida", "Falha (Senha errada)");
        realizarTeste(admin, "root", "masterkey", "Sucesso (Correto)");
    }
}