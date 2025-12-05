package faculdade.model;

public class CursoPresencial extends Curso {
    private String salaDeAula;

    public CursoPresencial(String nome, String codigo, int cargaHoraria, String salaDeAula) {
        super(nome, codigo, cargaHoraria);
        this.salaDeAula = salaDeAula;
    }

    @Override
    public void detalharCurso() {
        System.out.println("Nome: " + this.getNome());
        System.out.println("Tipo: Presencial");
        System.out.println("Código: " + this.getCodigo());
        System.out.println("Carga Horária: " + this.getCargaHoraria() + "h");
        System.out.println("Sala de Aula: " + this.salaDeAula);
    }

    @Override
    public void gerarRelatorio() {
        super.gerarRelatorio();
        System.out.println("Modalidade: Presencial");
        System.out.println("Sala de Aula Padrão: " + this.getSalaDeAula());
        System.out.println("---------------------------------");
    }

    public String getSalaDeAula() {
        return salaDeAula;
    }

    public void setSalaDeAula(String salaDeAula) {
        this.salaDeAula = salaDeAula;
    }
}