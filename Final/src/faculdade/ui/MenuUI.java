package faculdade.ui;

import faculdade.model.*;
import faculdade.repository.*;
import faculdade.service.*;
import java.util.Scanner;
import faculdade.interfaces.Relatavel;
import faculdade.interfaces.Autenticacao;

public class MenuUI {
    private Scanner scanner;
    private CadastroService cadastroService;
    private RelatorioService relatorioService;
    private AvaliacaoService avaliacaoService;
    private AutenticacaoService autenticacaoService;

    public MenuUI() {
        this.scanner = new Scanner(System.in);
        this.cadastroService = new CadastroService();
        this.relatorioService = new RelatorioService();
        this.avaliacaoService = new AvaliacaoService();
        this.autenticacaoService = new AutenticacaoService();
    }

    private int lerOpcao(String prompt) {
        System.out.print(prompt);
        if (scanner.hasNextInt()) {
            int opcao = scanner.nextInt();
            scanner.nextLine();
            return opcao;
        } else {
            System.out.println("Opção inválida. Digite um número.");
            scanner.nextLine();
            return -1;
        }
    }


    private void executarCenariosDeTeste() {
        System.out.println("\n#################################");
        System.out.println(">>> EXECUTANDO CENÁRIOS DE TESTE <<<");
        System.out.println("#################################");
        System.out.println("\n--- 1. SETUP DE DADOS PARA TESTE ---");
        System.out.println(cadastroService.cadastrarCurso("Design de Jogos", "C005", 2800, "E", "Unreal Engine"));
        System.out.println(cadastroService.cadastrarProfessor("Maria Silva", "Análise de Sistemas", "P5", "maria.silva", "secure123"));
        System.out.println(cadastroService.cadastrarAluno("João Teste", "30000000-0", "Design de Jogos", "joao.teste", "senhafacil"));
        System.out.println(cadastroService.criarTurma("T5_JOGOS", "P5", "C005"));
        System.out.println(cadastroService.associarAlunoTurma("30000000-0", "T5_JOGOS"));
        System.out.println("\n--- 2. TESTE DE CENÁRIOS DE FALHA (FAIL FAST) ---");
        System.out.println("TESTE FALHA (Matrícula): " + cadastroService.cadastrarAluno("João Duplicado", "30000000-0", "ADS", "dup", "senha"));
        System.out.println("TESTE FALHA (Turma/Professor): " + cadastroService.criarTurma("T9_INV", "P99", "C005"));
        System.out.println("\nTESTE FALHA (Nota > 10.0): " + avaliacaoService.registrarNota("30000000-0", "Prova Bimestral", 12.0));
        System.out.println("\nTESTE FALHA (Autenticação - Senha Incorreta):");

        autenticacaoService.tentarLogin("joao.teste", "senha_errada");

        System.out.println("\nTESTE FALHA (Autenticação - Login Inexistente):");

        autenticacaoService.tentarLogin("nao.existe", "qualquercoisa");

        System.out.println("\n--- 3. TESTE DE CENÁRIOS DE SUCESSO ---");

        System.out.println("TESTE SUCESSO (Nota): " + avaliacaoService.registrarNota("30000000-0", "Prova Bimestral", 8.5));

        System.out.println("\nTESTE SUCESSO (Autenticação - Senha Correta):");
        autenticacaoService.tentarLogin("joao.teste", "senhafacil");

        System.out.println("\n✅ Testes de Sucesso e Falha Concluídos. Os novos dados estão no sistema.");
        System.out.println("#################################");
    }

    private void menuCadastro() {
        }
    private void menuTurmas() {
        }
    private void menuNotas() {
        }
    private void menuRelatorios() {
        }

    public void iniciar() {
        int opcaoPrincipal = 0;

        System.out.println("#################################");
        System.out.println("Sistema de Gestão de Faculdade - Sprint FINAL");
        System.out.println("#################################");

        while (opcaoPrincipal != 6) {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1 - Cadastro (Alunos, Professores, Cursos)");
            System.out.println("2 - Gestão de Turmas");
            System.out.println("3 - Lançamento de Notas");
            System.out.println("4 - Geração de Relatórios");
            System.out.println("5 - Cenários de Teste (Sucesso e Falha)"); // NOVA OPÇÃO
            System.out.println("6 - Sair do Sistema"); // NOVA OPÇÃO DE SAÍDA
            opcaoPrincipal = lerOpcao("Escolha uma opção: ");

            switch (opcaoPrincipal) {
                case 1:
                    menuCadastro();
                    break;
                case 2:
                    menuTurmas();
                    break;
                case 3:
                    menuNotas();
                    break;
                case 4:
                    menuRelatorios();
                    break;
                case 5:
                    executarCenariosDeTeste();
                    break;
                case 6:
                    System.out.println("Sistema encerrado. Obrigado!");
                    break;
                default:
                    if (opcaoPrincipal != -1) System.out.println("Opção não reconhecida.");
            }
        }
        scanner.close();
    }
}