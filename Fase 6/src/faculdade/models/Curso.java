package faculdade.models;

import faculdade.interfaces.Relatavel; // Novo

public abstract class Curso implements Relatavel {
    private String nome;
    private String codigo;
    private int cargaHoraria;

    public Curso(String nome, String codigo, int cargaHoraria) {
        this.nome = nome;
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
    }

    public abstract void detalharCurso();

    @Override
    public void gerarRelatorio() {
        System.out.println("--- Relatório Base do Curso ---");
        System.out.println("Nome: " + this.getNome());
        System.out.println("Código: " + this.getCodigo());
        System.out.println("Carga Horária: " + this.getCargaHoraria() + "h");
        System.out.println("Status: Reconhecido pelo MEC.");
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }
}