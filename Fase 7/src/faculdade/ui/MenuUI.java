package faculdade.ui;

import faculdade.model.Aluno;
import faculdade.model.Professor;
import faculdade.model.Curso;
import faculdade.repository.AlunoRepository;
import faculdade.repository.ProfessorRepository;
import faculdade.repository.CursoRepository;
import faculdade.service.RelatorioService;
import java.util.Scanner;

public class MenuUI {
    private Scanner scanner;
    private RelatorioService relatorioService;

    private Aluno alunoTeste;
    private Professor professorTeste;
    private Curso cursoTeste;

    public MenuUI(Aluno aluno, Professor professor, Curso curso) {
        this.scanner = new Scanner(System.in);
        this.relatorioService = new RelatorioService();
        this.alunoTeste = aluno;
        this.professorTeste = professor;
        this.cursoTeste = curso;
    }

    public void iniciar() {
        int opcao = 0;

        System.out.println("#################################");
        System.out.println("Sistema de Geração de Relatórios (Sprint 7)");
        System.out.println("#################################");

        while (opcao != 4) {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Gerar Relatório do Aluno: " + alunoTeste.getNome());
            System.out.println("2 - Gerar Relatório do Professor: " + professorTeste.getNome());
            System.out.println("3 - Gerar Relatório do Curso: " + cursoTeste.getNome());
            System.out.println("4 - Sair do Sistema");
            System.out.print("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        relatorioService.gerar(alunoTeste);
                        break;
                    case 2:
                        relatorioService.gerar(professorTeste);
                        break;
                    case 3:
                        relatorioService.gerar(cursoTeste);
                        break;
                    case 4:
                        System.out.println("Saindo do sistema...");
                        break;
                    default:
                        System.out.println("Opção não reconhecida. Tente novamente.");
                }
            } else {
                System.out.println("Opção inválida. Digite um número.");
                scanner.next();
            }
        }
        scanner.close();
    }
}