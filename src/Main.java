import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        GerenciadorDeTarefas gerenciador = new GerenciadorDeTarefas();

        int opcao;

        // Loop do menu (executa até o usuário escolher sair).
        do {
            System.out.println("Gerenciador de Tarefas");
            System.out.println("1 - Adicionar tarefa");
            System.out.println("2 - Listar tarefas");
            System.out.println("3 - Concluir tarefa");
            System.out.println("4 - Remover tarefa");
            System.out.println("5 - Listar pendentes");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = input.nextInt();
            input.nextLine();

            // Estrutura de decisão baseada na opção escolhida.
            switch (opcao) {
                case 1:// UC02 - adicionar tarefas.
                    System.out.print("Título: ");
                    String titulo = input.nextLine();
                    System.out.print("Descrição: ");
                    String descricao = input.nextLine();
                    System.out.print("Data (formato dd/MM/yyyy): ");
                    String data = input.nextLine();
                    gerenciador.adicionarTarefa(titulo, descricao, data);
                    break;
                case 2:// listar tarefas.
                    gerenciador.listarTarefas();// Mostra tarefas antes de editar.
                    break;
                case 3:// UC03 - Editar tarefa
                    System.out.println("Adicione o Id da Tarefa: ");
                    gerenciador.concluirTarefa(Integer.parseInt(input.nextLine()));
                    break;
                case 4:// UC05 - Concluir tarefa.
                    System.out.println("Digite o ID da tarefa para remover: ");
                    gerenciador.removerTarefa(Integer.parseInt(input.nextLine()));
                    break;
                case 5:// UC04 - Remover tarefa.
                    gerenciador.listarPendentes();
                    break;
                case 0:// Encerrar o programa.
                    System.out.println("Encerrando Programa...");
                    break;
                default:
                    // Caso o usuário digite uma opção invalida.
                    System.out.println("Opção Inválida!");
            }

        } while (opcao != 0); // Continua até escolher sair.


        input.close();
    }
}