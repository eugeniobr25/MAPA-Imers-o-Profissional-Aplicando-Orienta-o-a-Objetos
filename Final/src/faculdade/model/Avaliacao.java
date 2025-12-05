package faculdade.model;

public class Avaliacao {
    private double nota;
    private String descricao;

    public Avaliacao(String descricao) {
        this.descricao = descricao;
        this.nota = -1.0;
    }

    public void atribuirNota(double valor) {
        if (valor < 0.0 || valor > 10.0) {
            System.out.println("❌ ERRO: Nota " + valor + " inválida para '" + this.descricao + "'. Valor deve ser entre 0 e 10. O lançamento deve ser refeito.");
        } else {
            this.nota = valor;
            System.out.println("✅ SUCESSO: Nota " + String.format("%.1f", valor) + " atribuída à avaliação '" + this.descricao + "'.");
        }
    }

    public double getNota() {
        return nota;
    }

    public String getDescricao() {
        return descricao;
    }
}