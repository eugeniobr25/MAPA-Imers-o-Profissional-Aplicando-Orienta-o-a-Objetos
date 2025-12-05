package faculdade;

import faculdade.model.Aluno;
import faculdade.model.Professor;
import faculdade.model.CursoEAD;
import faculdade.model.CursoPresencial;
import faculdade.service.CadastroService;
import faculdade.service.AvaliacaoService;
import faculdade.ui.MenuUI;

public class Main {

    public static void setupDadosIniciais() {
        System.out.println("--- SETUP INICIAL DE DADOS ---");

        CadastroService cs = new CadastroService();

        System.out.println(cs.cadastrarCurso("Arquitetura e Urbanismo", "C002", 4000, "P", "Bloco A - Labs"));
        System.out.println(cs.cadastrarProfessor("Flávio Ceci", "Programação POO", "P1", "flavio.ceci", "java2024"));
        System.out.println(cs.cadastrarAluno("Eugênio Lima", "24472636-5", "ADS", "eugenio.lima", "123mudar"));
        System.out.println(cs.criarTurma("T1_POO_2024", "P1", "C002"));
        System.out.println(cs.associarAlunoTurma("24472636-5", "T1_POO_2024"));
    }

    public static void testarCenarios() {
        CadastroService cs = new CadastroService();
        AvaliacaoService as = new AvaliacaoService();

        System.out.println("\n--- TESTE DE CENÁRIOS DE FALHA (FAIL FAST) ---");
        System.out.println(cs.cadastrarAluno("Eugênio Duplicado", "24472636-5", "ADS", "dup", "senha"));
        System.out.println(cs.criarTurma("T1_POO_2024", "P1", "C002"));
        System.out.println("--- Lançamento de Nota ---");
        System.out.println(as.registrarNota("24472636-5", "Prova Bimestral", 12.0));
        System.out.println(as.registrarNota("24472636-5", "Prova Bimestral", 8.5));
    }

    public static void main(String[] args) {
        MenuUI menu = new MenuUI();
        menu.iniciar();
    }
}