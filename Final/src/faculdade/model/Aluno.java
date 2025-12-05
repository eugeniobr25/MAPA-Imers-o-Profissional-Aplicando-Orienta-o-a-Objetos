package faculdade.model;

import java.util.ArrayList;
import java.util.List;
import faculdade.model.Usuario;

public class Aluno extends Usuario {
    private String matricula;
    private String curso;
    private List<Avaliacao> avaliacoes;

    private static final String[] AVALIACOES_PADRAO = {
            "Prova Bimestral",
            "Projeto Prático",
            "Exercícios",
            "Participação"
    };

    public Aluno(String nome, String matricula, String curso, String login, String senha) {
        super(nome, login, senha);
        this.matricula = matricula;
        this.curso = curso;
        this.avaliacoes = new ArrayList<>();
        inicializarAvaliacoesPadrao();
    }

    private void inicializarAvaliacoesPadrao() {
        for (String desc : AVALIACOES_PADRAO) {
            this.avaliacoes.add(new Avaliacao(desc));
        }
    }

    @Override
    public void gerarRelatorio() {
        super.gerarRelatorio(); // Chama Usuario.gerarRelatorio(), que usa getNome()
        System.out.println("--- Detalhes do Aluno ---");
        System.out.println("Matrícula: " + this.getMatricula());
        System.out.println("Curso Vinculado: " + this.getCurso());
        System.out.println("Status: Matrícula Ativa.");
        System.out.println("Total de Avaliações Registradas: " + this.avaliacoes.size());
        System.out.println("-------------------------");
    }

    public void adicionarAvaliacao(Avaliacao avaliacao) {
        if (avaliacao != null) {
            this.avaliacoes.add(avaliacao);
        }
    }

    public String getMatricula() {
        return matricula;
    }

    public String getCurso() {
        return curso;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }
}