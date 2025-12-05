package faculdade;

import faculdade.models.Aluno;
import faculdade.models.Professor;
import faculdade.models.Curso;
import faculdade.models.Turma;
import faculdade.models.Avaliacao;
import java.util.List;

public class Main {

    public static Avaliacao buscarAvaliacao(Aluno aluno, String descricao) {
        for (Avaliacao aval : aluno.getAvaliacoes()) {
            if (aval.getDescricao().equalsIgnoreCase(descricao)) {
                return aval;
            }
        }
        return null;
    }

    public static void lancarNotaObrigatoria(Aluno aluno, String avaliacaoDesc, double notaTentativa, double notaCorreta) {
        Avaliacao aval = buscarAvaliacao(aluno, avaliacaoDesc);
        if (aval == null) return;

        System.out.println("\n--- TENTATIVA DE LANÇAMENTO PARA " + aluno.getNome() + " (" + avaliacaoDesc + ") ---");
        aval.atribuirNota(notaTentativa);

        if (aval.getNota() == -1.0) {
            System.out.println("❗ SISTEMA OBRIGA RELANÇAMENTO DE NOTA VÁLIDA...");
            aval.atribuirNota(notaCorreta);
        }
    }

    public static void main(String[] args) {
        Curso ads = new Curso("Análise e Desenvolvimento de Sistemas", "0001", 2089);
        Professor flavio = new Professor("Flávio Ceci", "Programação POO", "P1");

        Aluno eugenio = new Aluno("Eugênio Brilhante Moraes Lima", "24472636-5", ads.getNome());
        Aluno maria = new Aluno("Maria Clara Silva", "24472637-6", ads.getNome());

        Turma turmaT1 = new Turma("T1_ADS_2024", flavio, ads);

        System.out.println("--- Início do Processo de Atribuição de Notas ---");

        buscarAvaliacao(eugenio, "Prova Bimestral").atribuirNota(8.5);

        buscarAvaliacao(eugenio, "Exercícios").atribuirNota(9.0);

        lancarNotaObrigatoria(maria, "Projeto Prático", 12.0, 7.5);

        lancarNotaObrigatoria(maria, "Participação", -1.0, 5.0);

        turmaT1.adicionarAluno(eugenio);
        turmaT1.adicionarAluno(maria);

        System.out.println("\n--- Resumo Final da Turma ---");
        turmaT1.mostrarResumo();
    }
}