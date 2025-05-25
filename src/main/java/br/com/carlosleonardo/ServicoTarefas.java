package br.com.carlosleonardo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ServicoTarefas {
    private int indice = -1;
    private final List<TarefaRecord> tarefas = new ArrayList<>();
    public void adicionar(String nome) {
        var tarefa = new TarefaRecord(++indice, nome, false);
        tarefas.add(tarefa);
    }
    public boolean remover(int chaveTarefa) {
        var tarefa = obterPorId(chaveTarefa);
        if (tarefa == null) {
            return false;
        }
        return tarefas.remove(tarefa);
    }
    public TarefaRecord obterPorId(int chaveTarefa) {
        var tarefa = tarefas.stream().findAny().filter(t -> t.id() == chaveTarefa);
        return tarefa.orElse(null);
    }
    public void finalizar(int chaveTarefa, boolean finalizada) {
        var tarefa = obterPorId(chaveTarefa);
        if (tarefa == null) {
            return;
        }
        var tarefaNova = new TarefaRecord(tarefa.id(), tarefa.nome(), finalizada);
        tarefas.set(tarefas.indexOf(tarefa), tarefaNova);
    }

    public List<TarefaRecord> listarTarefas() {
        return List.copyOf(tarefas);
    }
    public void salvarTarefas() throws IOException {
        var gson = new Gson();
        var json = gson.toJson(tarefas);
        try (var writer = new FileWriter("tarefas.json")) {
            writer.write(json);
        } catch (java.io.IOException e) {
            throw e;
        }

    }
    public void carregarTarefas() throws IOException {
        var gson = new Gson();
        try (var reader = new FileReader("tarefas.json")) {
            Type tipoItemLista = new TypeToken<List<TarefaRecord>>() {}.getType();
            List<TarefaRecord> tarefasCarregadas = gson.fromJson(reader, tipoItemLista);
            if (tarefasCarregadas != null) {
                tarefas.addAll(tarefasCarregadas);
                indice = tarefas.stream().mapToInt(TarefaRecord::id).max().orElse(-1);
            }
        } catch (IOException e) {
            throw e;
        }
    }
    public void alterarTarefa(int chaveTarefa, String novoNome) {
        var tarefa = obterPorId(chaveTarefa);
        if (tarefa == null) {
            return;
        }
        var tarefaNova = new TarefaRecord(tarefa.id(), novoNome, tarefa.feita());
        tarefas.set(tarefas.indexOf(tarefa), tarefaNova);
    }
}
