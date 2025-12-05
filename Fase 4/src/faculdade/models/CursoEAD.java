package faculdade.models;

public class CursoEAD extends Curso {
    private String plataformaVirtual;

    public CursoEAD(String nome, String codigo, int cargaHoraria, String plataformaVirtual) {
        super(nome, codigo, cargaHoraria);
        this.plataformaVirtual = plataformaVirtual;
    }

    @Override
    public void detalharCurso() {
        System.out.println("Nome: " + this.getNome());
        System.out.println("Tipo: EAD (Ensino à Distância)");
        System.out.println("Código: " + this.getCodigo());
        System.out.println("Carga Horária: " + this.getCargaHoraria() + "h");
        System.out.println("Plataforma Virtual: " + this.plataformaVirtual);
    }

    public String getPlataformaVirtual() {
        return plataformaVirtual;
    }

    public void setPlataformaVirtual(String plataformaVirtual) {
        this.plataformaVirtual = plataformaVirtual;
    }
}