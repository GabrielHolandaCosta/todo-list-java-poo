import java.io.Serializable;

public class Tarefa implements Serializable {
    private static final long serialVersionUID = 1L;

    private String descricao;
    private boolean concluida;

    public Tarefa(String descricao) {
        this.descricao = descricao;
        this.concluida = false;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void concluir() {
        this.concluida = true;
    }

    public void reverter() {
        this.concluida = false;
    }

    @Override
    public String toString() {
        return descricao + (concluida ? " (Concluída)" : " (Pendente)");
    }
}
