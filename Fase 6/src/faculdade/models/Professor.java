package faculdade.models;

public class Professor extends Usuario {
    private String especialidade;
    private String registro;

    public Professor(String nome, String especialidade, String registro, String login, String senha) {
        super(nome, login, senha);
        this.especialidade = especialidade;
        this.registro = registro;
    }

    @Override
    public void gerarRelatorio() {
        super.gerarRelatorio();
        System.out.println("--- Detalhes do Professor ---");
        System.out.println("Registro: " + this.getRegistro());
        System.out.println("Especialidade: " + this.getEspecialidade());
        System.out.println("Status: Em exercício.");
        System.out.println("Detalhes: Acesso a diários e frequência.");
        System.out.println("-----------------------------");
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public String getRegistro() {
        return registro;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }
}