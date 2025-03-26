package gerenciador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.Map;
import java.util.HashSet;
import java.util.List;

public class GerenciadorDeAlunos {
    private String input;
    private List<Aluno> listaAlunos;
    private Map<String, Set<Aluno>> genderMap;

    public GerenciadorDeAlunos(String stringLista) {
        this.input = stringLista;
        this.listaAlunos = getListaAlunos();
        this.genderMap = getGenderMap();
    }

    private List<Aluno> getListaAlunos() {
        String[] listaString = input.split(",");
        List<Aluno> lista = new ArrayList<Aluno>();
        for (String aluno : listaString ) {
            String[] alunoSplit = aluno.split("-");
            if (alunoSplit.length > 1) {
                Aluno alunoCompleto = new Aluno(alunoSplit[0], alunoSplit[1]);
                lista.add(alunoCompleto);
            } else {
                Aluno alunoIncompleto = new Aluno(alunoSplit[0]);
                lista.add(alunoIncompleto);
            }
        }
        return lista;
    }

    private Map<String, Set<Aluno>> getGenderMap() {
        Map<String, Set<Aluno>> genero = new HashMap<>();
        for (Aluno aluno : this.listaAlunos) {
            if (aluno.getGenero() != null) {
                genero.putIfAbsent(aluno.getGenero(), new HashSet<>());
                genero.get(aluno.getGenero()).add(aluno);
            }
        }
        return genero;
    }

    public void sortByName() {
        Collections.sort(this.listaAlunos);
    }

    public void showList() {
        System.out.println("\nAlunos por ordem alfabética:");
        for (Aluno aluno : this.listaAlunos) {
            System.out.println(" -" + aluno);
        }
    }

    public void showGender() {
        if (!this.genderMap.isEmpty()) {
            System.out.println("\nAlunos do sexo masculino:");
            for (Aluno masc : this.genderMap.get("Masculino")) {
                System.out.println(" -" + masc);
            }
            System.out.println("\nAlunas do sexo feminino:");
            for (Aluno fem : this.genderMap.get("Feminino")) {
                System.out.println(" -" + fem);
            }
            System.out.println("\n");
        } else {
            System.out.println("\nNão é possível agrupar alunos por gênero\n");
        }
    }

}
