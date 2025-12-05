package faculdade.service;

import faculdade.model.Aluno;
import faculdade.model.Avaliacao;
import faculdade.repository.AlunoRepository;
import java.util.List;

public class AvaliacaoService {

    private Avaliacao buscarAvaliacaoPorNome(Aluno aluno, String descricao) {
        for (Avaliacao aval : aluno.getAvaliacoes()) {
            if (aval.getDescricao().equalsIgnoreCase(descricao)) {
                return aval;
            }
        }
        return null;
    }

    public String registrarNota(String matriculaAluno, String nomeAvaliacao, double nota) {
        Aluno aluno = AlunoRepository.buscarPorMatricula(matriculaAluno);

        if (aluno == null) return "Falha: Aluno não encontrado.";

        Avaliacao avaliacao = buscarAvaliacaoPorNome(aluno, nomeAvaliacao);

        if (avaliacao == null) return "Falha: Avaliação '" + nomeAvaliacao + "' não encontrada para o aluno.";

        double notaAnterior = avaliacao.getNota();

        avaliacao.atribuirNota(nota);

        if (avaliacao.getNota() == notaAnterior && nota != notaAnterior) {
            return "Falha: Tentativa de nota inválida para '" + nomeAvaliacao + "'. Tente novamente (0 a 10).";
        }

        return "Sucesso: Nota " + String.format("%.1f", avaliacao.getNota()) + " registrada para " + aluno.getNome() + ".";
    }
}