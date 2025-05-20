package br.com.carlosleonardo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestaoTarefas {
    private final Scanner leitor;
    private int indice = -1;
    private final List<TarefaRecord> tarefas = new ArrayList<>();

    public GestaoTarefas(Scanner leitor) {
        this.leitor = leitor;
    }

    public void adicionar() {
        System.out.print("Nome da tarefa: ");
        var nome = leitor.nextLine();
        while (nome.isBlank()) {
            System.out.println("Nome da tarefa não pode ser vazio.");
            System.out.print("Nome da tarefa: ");
            nome = leitor.nextLine();
        }
        var tarefa = new TarefaRecord(++indice, nome, false);
        tarefas.add(tarefa);
    }
    public void salvarTarefas() {
        System.out.println("Salvando tarefas...");
        // Implementar lógica de salvar tarefas
    }
    public void carregarTarefas() {
        System.out.println("Carregando tarefas...");
        // Implementar lógica de carregar tarefas
    }
}
