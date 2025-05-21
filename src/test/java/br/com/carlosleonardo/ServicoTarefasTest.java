package br.com.carlosleonardo;

import static org.junit.jupiter.api.Assertions.*;

class ServicoTarefasTest {

    @org.junit.jupiter.api.Test
    void adicionar() {
        var servicoTarefas = new ServicoTarefas();
        servicoTarefas.adicionar("Tarefa 1");
        var tarefa = servicoTarefas.obterPorId(0);
        assertNotNull(tarefa);
    }

    @org.junit.jupiter.api.Test
    void remover() {
        var servicoTarefas = new ServicoTarefas();
        servicoTarefas.adicionar("Tarefa 1");
        servicoTarefas.remover(0);
        var tarefa = servicoTarefas.obterPorId(0);
        assertNull(tarefa);
    }

    @org.junit.jupiter.api.Test
    void obterPorId() {
        var servicoTarefas = new ServicoTarefas();
        servicoTarefas.adicionar("Tarefa 1");
        var tarefa = servicoTarefas.obterPorId(0);
        assertNotNull(tarefa);
    }

    @org.junit.jupiter.api.Test
    void finalizar() {
        var servicoTarefas = new ServicoTarefas();
        servicoTarefas.adicionar("Tarefa 1");
        servicoTarefas.finalizar(0, true);
        var tarefa = servicoTarefas.obterPorId(0);
        assertTrue(tarefa.feita());
    }
    @org.junit.jupiter.api.Test
    void salvarTarefas() {
        var servicoTarefas = new ServicoTarefas();
        servicoTarefas.adicionar("Tarefa 1");
        assertDoesNotThrow(servicoTarefas::salvarTarefas);
    }
    @org.junit.jupiter.api.Test
    void carregarTarefas() {
        var servicoTarefas = new ServicoTarefas();
        servicoTarefas.adicionar("Tarefa 1");
        assertDoesNotThrow(servicoTarefas::carregarTarefas);
    }
}