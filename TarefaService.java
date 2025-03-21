import java.io.*;
import java.util.*;

public class TarefaService {
    private List<Tarefa> tarefas;
    private final String arquivoTarefas = "tarefas.dat";

    public TarefaService() {
        this.tarefas = new ArrayList<>();
        carregarTarefas();
    }

    public void adicionarTarefa(String descricao) {
        Tarefa tarefa = new Tarefa(descricao);
        tarefas.add(tarefa);
        salvarTarefas();
        System.out.println("Tarefa adicionada com sucesso!");
    }

    public void listarTarefas() {
        if (tarefas.isEmpty()) {
            System.out.println("Não há tarefas.");
            return;
        }
        for (Tarefa tarefa : tarefas) {
            System.out.println(tarefa);
        }
    }

    public void removerTarefa(String descricao) {
        Tarefa tarefa = buscarTarefa(descricao);
        if (tarefa != null) {
            tarefas.remove(tarefa);
            salvarTarefas();
            System.out.println("Tarefa removida com sucesso!");
        } else {
            System.out.println("Tarefa não encontrada.");
        }
    }

    public void concluirTarefa(String descricao) {
        Tarefa tarefa = buscarTarefa(descricao);
        if (tarefa != null) {
            tarefa.concluir();
            salvarTarefas();
            System.out.println("Tarefa marcada como concluída!");
        } else {
            System.out.println("Tarefa não encontrada.");
        }
    }

    public void reverterTarefa(String descricao) {
        Tarefa tarefa = buscarTarefa(descricao);
        if (tarefa != null) {
            tarefa.reverter();
            salvarTarefas();
            System.out.println("Tarefa revertida para pendente.");
        } else {
            System.out.println("Tarefa não encontrada.");
        }
    }

    private Tarefa buscarTarefa(String descricao) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getDescricao().equalsIgnoreCase(descricao)) {
                return tarefa;
            }
        }
        return null;
    }

    private void salvarTarefas() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivoTarefas))) {
            oos.writeObject(tarefas);
        } catch (IOException e) {
            System.out.println("Erro ao salvar tarefas: " + e.getMessage());
        }
    }

    private void carregarTarefas() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivoTarefas))) {
            tarefas = (List<Tarefa>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar tarefas: " + e.getMessage());
        }
    }
}
