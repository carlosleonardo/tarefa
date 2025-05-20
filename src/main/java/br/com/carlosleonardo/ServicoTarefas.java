package br.com.carlosleonardo;

import java.util.ArrayList;
import java.util.List;

public class ServicoTarefas {
    private int indice = -1;
    private final List<TarefaRecord> tarefas = new ArrayList<>();
    public void adicionar(String nome) {
        var tarefa = new TarefaRecord(++indice, nome, false);
        tarefas.add(tarefa);
    }
    public boolean remover(int indice) {
        if (indice < 0 || indice >= tarefas.size()) {
            return false;
        }
        tarefas.remove(indice);
        return true;
    }
    public TarefaRecord obterPorId(int indice) {
        if (indice < 0 || indice >= tarefas.size()) {
            return null;
        }
        var tarefa = tarefas.get(indice);
        return tarefa;
    }
    public void finalizar(int indice, boolean finalizada) {
        if (indice < 0 || indice >= tarefas.size()) {
            return;
        }
        var tarefa = tarefas.get(indice);
        var tarefaNova = new TarefaRecord(tarefa.id(), tarefa.nome(), finalizada);
        tarefas.set(indice, tarefaNova);
    }
}
