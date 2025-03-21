import java.util.Scanner;

public class TarefaController {
    private TarefaService tarefaService;
    private Scanner scanner;

    public TarefaController() {
        this.tarefaService = new TarefaService();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcao;
        do {
            mostrarMenu();
            opcao = Util.lerInteiro("Escolha uma opção: ");
            switch (opcao) {
                case 1:
                    adicionarTarefa();
                    break;
                case 2:
                    tarefaService.listarTarefas();
                    break;
                case 3:
                    removerTarefa();
                    break;
                case 4:
                    concluirTarefa();
                    break;
                case 5:
                    reverterTarefa();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 6);
    }

    private void mostrarMenu() {
        System.out.println("\n*** To-Do List ***");
        System.out.println("1. Adicionar Tarefa");
        System.out.println("2. Listar Tarefas");
        System.out.println("3. Remover Tarefa");
        System.out.println("4. Concluir Tarefa");
        System.out.println("5. Reverter Tarefa");
        System.out.println("6. Sair");
    }

    private void adicionarTarefa() {
        String descricao = Util.lerString("Digite a descrição da tarefa: ");
        tarefaService.adicionarTarefa(descricao);
    }

    private void removerTarefa() {
        String descricao = Util.lerString("Digite a descrição da tarefa a ser removida: ");
        tarefaService.removerTarefa(descricao);
    }

    private void concluirTarefa() {
        String descricao = Util.lerString("Digite a descrição da tarefa a ser concluída: ");
        tarefaService.concluirTarefa(descricao);
    }

    private void reverterTarefa() {
        String descricao = Util.lerString("Digite a descrição da tarefa a ser revertida: ");
        tarefaService.reverterTarefa(descricao);
    }
}
