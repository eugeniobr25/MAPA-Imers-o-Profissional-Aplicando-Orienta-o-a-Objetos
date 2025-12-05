package faculdade.service;

import faculdade.interfaces.Relatavel;

public class RelatorioService {
    public void gerar(Relatavel item) {
        if (item != null) {
            System.out.println(">>> Processando relatório na camada de Serviço...");
            item.gerarRelatorio();
        } else {
            System.out.println("Erro: Item para relatório não encontrado.");
        }
    }
}