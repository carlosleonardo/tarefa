package br.com.carlosleonardo;

import java.io.IOException;
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
        try {
            servicoTarefas.salvarTarefas();
            System.out.println("Tarefas salvas com sucesso.");
        } catch (IOException e) {
            System.out.printf("Erro ao salvar tarefas: %s%n", e.getMessage());
        }
    }

    public void carregarTarefas() {
        System.out.println("Carregando tarefas...");
        try {
            servicoTarefas.carregarTarefas();
            System.out.println("Tarefas carregadas com sucesso.");
        } catch (IOException e) {
            System.out.printf("Erro ao carregar tarefas: %s%n", e.getMessage());
        }
    }

    public void listarTarefas() {

        System.out.print("Mostrar: concluídas/não-concluídas/todas (c/n/t): ");
        var opcao = leitor.nextLine();
        while (!opcao.equals("c") && !opcao.equals("n") && !opcao.equals("t")) {
            System.out.println("Opção inválida. Tente novamente.");
            System.out.print("Mostrar: concluídas/não-concluídas/todas (c/n/t): ");
            opcao = leitor.nextLine();
        }
        var listaFiltrada = switch (opcao) {
            case "c" -> servicoTarefas.listarTarefas().stream().filter(TarefaRecord::feita).toList();
            case "n" -> servicoTarefas.listarTarefas().stream().filter( tarefa -> !tarefa.feita()).toList();
            case "t" -> servicoTarefas.listarTarefas();
            default -> servicoTarefas.listarTarefas();
        };
        var tamanho = listaFiltrada.size();
        if (tamanho == 0) {
            System.out.println("Nenhuma tarefa encontrada.");
            return;
        }
        System.out.println("Tarefas encontradas: " + tamanho);
        System.out.println("Listando tarefas...");
        for (var tarefa : listaFiltrada) {
            System.out.printf("ID: %d, Nome: %s, Feita: %b%n", tarefa.id(), tarefa.nome(), tarefa.feita());
        }
    }
}
