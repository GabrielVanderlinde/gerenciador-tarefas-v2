import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeTarefas {

    private List<Tarefas> listaDeTarefas = new ArrayList<>();
    private int proximoId = 1;

    // UC02 - Adicionar tarefa
    public void adicionarTarefa(String titulo, String descricao, String data) {
        listaDeTarefas.add(new Tarefas(proximoId++, titulo, descricao, data));
        System.out.println("\n✔ Tarefa adicionada com sucesso!");
    }

    // UC03 - Editar tarefa
    public void editarTarefa(int id, String novoTitulo, String novaDescricao, String novaData) {
        Tarefas tarefa = buscarPorId(id);
        if (tarefa != null) {
            tarefa.setTitulo(novoTitulo);
            tarefa.setDescricao(novaDescricao);
            tarefa.setData(novaData);
            System.out.println("\n✔ Tarefa editada com sucesso!");
        } else {
            System.out.println("\n✘ Tarefa não encontrada.");
        }
    }

    // Listagem
    public void listarTarefas() {
        if (listaDeTarefas.isEmpty()) {
            System.out.println("\nNenhuma tarefa cadastrada.");
            return;
        }
        System.out.println("\n===== LISTA DE TAREFAS =====");
        for (Tarefas t : listaDeTarefas) {
            System.out.println("-----------------------------");
            System.out.println(t);
        }
        System.out.println("-----------------------------");
    }

    // UC05 - Concluir tarefa
    public void concluirTarefa(int id) {
        Tarefas tarefa = buscarPorId(id);
        if (tarefa != null) {
            tarefa.marcarComoConcluida();
            System.out.println("\n✔ Tarefa concluída!");
        } else {
            System.out.println("\n✘ Tarefa não encontrada.");
        }
    }

    // UC04 - Excluir tarefa
    public void removerTarefa(int id) {
        if (listaDeTarefas.isEmpty()) {
            System.out.println("\n✘ Nenhuma tarefa para remover.");
            return;
        }
        boolean removida = listaDeTarefas.removeIf(t -> t.getId() == id);
        if (removida) {
            System.out.println("\n✔ Tarefa removida com sucesso.");
        } else {
            System.out.println("\n✘ Tarefa não encontrada.");
        }
    }

    // Listar apenas pendentes
    public void listarPendentes() {
        boolean temPendentes = listaDeTarefas.stream().anyMatch(t -> !t.isConcluida());

        if (!temPendentes) {
            System.out.println("\nNão há tarefas pendentes.");
            return;
        }

        System.out.println("\n===== TAREFAS PENDENTES =====");
        listaDeTarefas.stream()
                .filter(t -> !t.isConcluida())
                .forEach(t -> {
                    System.out.println("-----------------------------");
                    System.out.println(t);
                });
        System.out.println("-----------------------------");
    }

    // Auxiliar interno
    private Tarefas buscarPorId(int id) {
        return listaDeTarefas.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null);
    }
}