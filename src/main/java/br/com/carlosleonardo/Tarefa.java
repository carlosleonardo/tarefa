package br.com.carlosleonardo;

import java.util.Scanner;

public class Tarefa {
    public static void main(String[] args) {

        boolean exibirMenu = true;
        var leitor = new Scanner(System.in);
        var gestorTarefas = new GestaoTarefas(leitor);
        do {
            System.out.println("Tarefas");
            System.out.println("=========================");
            System.out.println("Operações suportadas:");
            System.out.println("1 - Adicionar tarefa");
            System.out.println("2 - Listar tarefas");
            System.out.println("3 - Remover tarefa");
            System.out.println("4 - Marcar tarefa como feita");
            System.out.println("5 - Desmarcar tarefa como feita");
            System.out.println("6 - Listar tarefas feitas");
            System.out.println("7 - Listar tarefas não feitas");
            System.out.println("8 - Listar todas as tarefas");
            System.out.println("9 - Salvar tarefas");
            System.out.println("10 - Carregar tarefas");
            System.out.println("0 - Sair");
            System.out.println("=========================");
            System.out.print("Escolha uma operação: ");
            var opcao = leitor.nextLine();
            switch (opcao) {
                case "1" -> gestorTarefas.adicionar();
                case "2" -> System.out.println("Listar tarefas");
                case "3" -> System.out.println("Remover tarefa");
                case "4" -> System.out.println("Marcar tarefa como feita");
                case "5" -> System.out.println("Desmarcar tarefa como feita");
                case "6" -> System.out.println("Listar tarefas feitas");
                case "7" -> System.out.println("Listar tarefas não feitas");
                case "8" -> gestorTarefas.listarTarefas();
                case "9" -> gestorTarefas.salvarTarefas();
                case "10" -> gestorTarefas.carregarTarefas();
                case "0" -> {
                    exibirMenu = false;
                    System.out.println("Saindo...");
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (exibirMenu);


    }
}
