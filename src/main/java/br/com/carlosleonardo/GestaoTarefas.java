package br.com.carlosleonardo;

import java.util.Scanner;

public class GestaoTarefas {
    private final Scanner leitor;
    private final ServicoTarefas servicoTarefas = new ServicoTarefas();

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
        servicoTarefas.adicionar(nome);
    }
    public void salvarTarefas() {
        System.out.println("Salvando tarefas...");
        // Implementar lógica de salvar tarefas
    }
    public void carregarTarefas() {
        System.out.println("Carregando tarefas...");
        // Implementar lógica de carregar tarefas
    }
    public void listarTarefas() {
        System.out.println("Listando tarefas...");
        for (var tarefa : servicoTarefas.listarTarefas()) {
            System.out.printf("ID: %d, Nome: %s, Feita: %b%n", tarefa.id(), tarefa.nome(), tarefa.feita());
        }
    }
}
