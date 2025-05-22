package br.com.carlosleonardo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServicoTarefasTest {

    @Test
    void adicionar() {
        var servicoTarefas = new ServicoTarefas();
        servicoTarefas.adicionar("Tarefa 1");
        var tarefa = servicoTarefas.obterPorId(0);
        assertNotNull(tarefa);
    }

    @Test
    void remover() {
        var servicoTarefas = new ServicoTarefas();
        servicoTarefas.adicionar("Tarefa 1");
        servicoTarefas.remover(0);
        var tarefa = servicoTarefas.obterPorId(0);
        assertNull(tarefa);
    }

    @Test
    void obterPorId() {
        var servicoTarefas = new ServicoTarefas();
        servicoTarefas.adicionar("Tarefa 1");
        var tarefa = servicoTarefas.obterPorId(0);
        assertNotNull(tarefa);
    }

    @Test
    void finalizar() {
        var servicoTarefas = new ServicoTarefas();
        servicoTarefas.adicionar("Tarefa 1");
        servicoTarefas.finalizar(0, true);
        var tarefa = servicoTarefas.obterPorId(0);
        assertTrue(tarefa.feita());
    }
    @Test
    void salvarTarefas() {
        var servicoTarefas = new ServicoTarefas();
        servicoTarefas.adicionar("Tarefa 1");
        assertDoesNotThrow(servicoTarefas::salvarTarefas);
    }
    @Test
    void carregarTarefas() {
        var servicoTarefas = new ServicoTarefas();
        servicoTarefas.adicionar("Tarefa 1");
        assertDoesNotThrow(servicoTarefas::carregarTarefas);
    }
    @Test
    void alterarTarefa() {
        var servicoTarefas = new ServicoTarefas();
        String valorEsperado = "Tarefa Alterada";

        servicoTarefas.adicionar("Tarefa 1");
        servicoTarefas.alterarTarefa(0, valorEsperado);
        var tarefa = servicoTarefas.obterPorId(0);
        assertEquals(valorEsperado, tarefa.nome());
    }
}