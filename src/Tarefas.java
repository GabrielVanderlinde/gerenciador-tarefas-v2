import java.time.LocalDate;

public class Tarefas {

    // Atributos
    private int id;
    private String titulo;
    private String descricao;
    private LocalDate data;
    private boolean concluida;

    // Construtor
    public Tarefas(int id, String titulo, String descricao, LocalDate data) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.data = data;
        // Por padrão, toda tarefa começa como não concluída.
        this.concluida = false;
    }

    // Método do diagrama de classes
    public void marcarComoConcluida() {
        this.concluida = true;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public boolean isConcluida() {
        return concluida;
    }

    // Setters para edição

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("Título não pode ficar em branco!.");
        }
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setData(LocalDate data) {
        if (data == null) {
            throw new IllegalArgumentException("Data não pode ficar em branco");
        }
        this.data = data;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    // toString - Define como a tarefa será exibida ao imprimir o objeto.
    @Override
    public String toString() {
        String status = concluida ? "[TAREFA CONCLUÍDA]" : "[TAREFA PENDENTE]";
        String dataFormatada = data.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return status + " ID: " + id +
                " | " + titulo +
                " | " + descricao +
                " | Data: " + dataFormatada;
    }
}