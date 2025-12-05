package faculdade;

import faculdade.interfaces.Relatavel;
import faculdade.models.Aluno;
import faculdade.models.Professor;
import faculdade.models.CursoEAD;
import java.util.Scanner;

public class Main {

    public static void exibirMenuRelatorios(Aluno aluno, Professor professor, CursoEAD curso) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        System.out.println("\n#################################");
        System.out.println("Sistema de Geração de Relatórios");
        System.out.println("#################################");

        while (opcao != 4) {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Gerar Relatório do Aluno: " + aluno.getNome());
            System.out.println("2 - Gerar Relatório do Professor: " + professor.getNome());
            System.out.println("3 - Gerar Relatório do Curso: " + curso.getNome());
            System.out.println("4 - Sair do Menu de Relatórios");
            System.out.print("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine();

                Relatavel relatorio = null;
                String tipoRelatorio = "";

                switch (opcao) {
                    case 1:
                        relatorio = aluno;
                        tipoRelatorio = "Aluno";
                        break;
                    case 2:
                        relatorio = professor;
                        tipoRelatorio = "Professor";
                        break;
                    case 3:
                        relatorio = curso;
                        tipoRelatorio = "Curso";
                        break;
                    case 4:
                        System.out.println("Saindo do Menu de Relatórios...");
                        break;
                    default:
                        System.out.println("Opção não reconhecida. Tente novamente.");
                }

                if (relatorio != null) {
                    System.out.println("\n>>> Gerando Relatório de " + tipoRelatorio + "...");
                    relatorio.gerarRelatorio();
                }

            } else {
                System.out.println("Opção inválida. Digite um número.");
                scanner.next();
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {

        CursoEAD software = new CursoEAD(
                "Engenharia de Software",
                "C003",
                3600,
                "Studeo"
        );

        Professor professor = new Professor(
                "Flávio Ceci", "Programação POO", "P1",
                "flavio.ceci", "java2024"
        );

        Aluno aluno = new Aluno(
                "Eugênio Lima", "24472636-5", software.getNome(),
                "eugenio.lima", "123mudar"
        );

        exibirMenuRelatorios(aluno, professor, software);
    }
}