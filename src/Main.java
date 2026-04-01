import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        GerenciadorDeTarefas gerenciador = new GerenciadorDeTarefas();

        int opcao;

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

            switch (opcao) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = input.nextLine();
                    System.out.print("Descrição: ");
                    String descricao = input.nextLine();
                    System.out.print("Data (formato dd/MM/yyyy): ");
                    String data = input.nextLine();
                    gerenciador.adicionarTarefa(titulo, descricao, data);
                    break;
                case 2:
                    gerenciador.listarTarefas();
                    break;
                case 3:
                    System.out.println("Adicione o Id da Tarefa: ");
                    gerenciador.concluirTarefa(Integer.parseInt(input.nextLine()));
                    break;
                case 4:
                    System.out.println("Digite o ID da tarefa para remover: ");
                    gerenciador.removerTarefa(Integer.parseInt(input.nextLine()));
                    break;
                case 5:
                    gerenciador.listarPendentes();
                    break;
                case 0:
                    System.out.println("Encerrando Programa...");
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }

        } while (opcao != 0);


        input.close();
    }
}