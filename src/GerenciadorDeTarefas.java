import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeTarefas {

    private List<Tarefas> listaDeTarefas = new ArrayList<>();
    // Variável que controla o próximo ID a ser atribuído.
    private int proximoId = 1;

    // UC02 - Adicionar tarefa
    public void adicionarTarefa(String titulo, String descricao, String data) {
        try {
            //Formatador de Data
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            //Converter Texto para Data
            LocalDate dataConvertida = LocalDate.parse(data, dtf);
            listaDeTarefas.add(new Tarefas(proximoId++, titulo, descricao, dataConvertida));
            System.out.println("Tarefa adicionada com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao adicionar tarefa! Formato de Data inválida! Use dd/MM/yyyy.");
        }
    }

    // UC03 - Editar tarefa
    public void editarTarefa(int id, String novoTitulo, String novaDescricao, String novaData) {
        Tarefas tarefa = buscarPorId(id);// Busca a tarefa pelo ID.
        if (tarefa != null) { // Verifica se a tarefa foi encontrada.
            // Atualiza os dados da tarefa.
            tarefa.setTitulo(novoTitulo);
            tarefa.setDescricao(novaDescricao);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            tarefa.setData(LocalDate.parse(novaData, dtf));
            System.out.println("\n Tarefa editada com sucesso!"); // Mensagem de sucesso.
        } else {
            System.out.println("\n Tarefa não encontrada."); // Mensagem caso o ID não exista.
        }
    }

    // Listagem
    public void listarTarefas() {
        // Verifica se a lista está vazia.
        if (listaDeTarefas.isEmpty()) {
            System.out.println("\nNenhuma tarefa cadastrada.");
            return;
        }
        System.out.println("\n===== LISTA DE TAREFAS =====");
        // Percorre a lista e imprime cada tarefa.
        for (Tarefas t : listaDeTarefas) {
            System.out.println("-----------------------------");
            System.out.println(t);
        }
        System.out.println("-----------------------------");
    }

    // UC05 - Concluir tarefa
    public void concluirTarefa(int id) {
        Tarefas tarefa = buscarPorId(id); // Busca a tarefa pelo ID.
        if (tarefa != null) {
            tarefa.marcarComoConcluida(); // Marca a tarefa como concluída.
            System.out.println("\n Tarefa concluída!");
        } else {
            System.out.println("\n Tarefa não encontrada."); // Mensagem caso o ID não exista.
        }
    }

    // UC04 - Excluir tarefa
    public void removerTarefa(int id) {
        // Verifica se existem tarefas cadastradas.
        if (listaDeTarefas.isEmpty()) {
            System.out.println("\n Nenhuma tarefa para remover.");
            return;
        }
        // Remove a tarefa usando expressão lambda (remove pelo ID).
        boolean removida = listaDeTarefas.removeIf(t -> t.getId() == id);
        // Verifica se a remoção ocorreu.
        if (removida) {
            System.out.println("\n Tarefa removida com sucesso.");
        } else {
            System.out.println("\n Tarefa não encontrada.");
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
        // Usa Stream para filtrar apenas tarefas não concluídas.
        listaDeTarefas.stream()
                .filter(t -> !t.isConcluida())// filtra pendentes.
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