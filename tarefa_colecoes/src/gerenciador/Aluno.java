package gerenciador;

import java.util.Objects;

public class Aluno implements Comparable<Aluno> {
    private String nome;
    private String genero;

    public Aluno(String nome, String genero) {
        if (nome.charAt(0) == ' ') {
            this.nome = nome.substring(1);
        } else {
            this.nome = nome;
        }
        this.genero = genero;
    }

    public Aluno(String nome) {
        this(nome, null);
    }

    public String getGenero() {
        return genero;
    }

    public String toString() {
        return this.nome;
    }

    @Override
    public int compareTo(Aluno aluno) {
        return this.nome.compareTo((aluno.nome));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(nome, aluno.nome) && Objects.equals(genero, aluno.genero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, genero);
    }
}
