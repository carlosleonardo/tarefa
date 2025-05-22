package br.com.carlosleonardo;

import java.util.Scanner;

public class Tarefa {
    public static void main(String[] args) {

        boolean exibirMenu = true;
        var leitor = new Scanner(System.in);
        var gestorTarefas = new GestaoTarefas(leitor);
        gestorTarefas.carregarTarefas();
        do {
            System.out.println("Tarefas");
            System.out.println("=========================");
            System.out.println("Operações suportadas:");
            System.out.println("1 - Adicionar tarefa");
            System.out.println("2 - Alterar tarefa");
            System.out.println("3 - Remover tarefa");
            System.out.println("4 - Marcar/Desmarcar tarefa como feita");
            System.out.println("5 - Listar Tarefas");
            System.out.println("0 - Sair");
            System.out.println("=========================");
            System.out.print("Escolha uma operação: ");
            var opcao = leitor.nextLine();
            switch (opcao) {
                case "1" -> gestorTarefas.adicionar();
                case "2" -> gestorTarefas.alterarTarefa();
                case "3" -> gestorTarefas.removerTarefa();
                case "4" -> gestorTarefas.marcarDesmarcarTarefa();
                case "5" -> gestorTarefas.listarTarefas();
                case "0" -> {
                    exibirMenu = false;
                    gestorTarefas.salvarTarefas();
                    System.out.println("Saindo...");
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (exibirMenu);


    }
}
