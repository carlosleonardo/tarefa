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

    public List<TarefaRecord> listarTarefas() {
        return new ArrayList<>(tarefas);
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
                tarefas.clear();
                tarefas.addAll(tarefasCarregadas);
                indice = tarefas.stream().mapToInt(TarefaRecord::id).max().orElse(-1);
            }
        } catch (IOException e) {
            throw e;
        }
    }
}
