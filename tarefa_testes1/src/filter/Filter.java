
package filter;

import java.util.Arrays;
import java.util.List;

public class Filter {
    private String input;
    private List<String> pessoas;

    public Filter(String input) {
        this.input = input;
        this.pessoas = getPessoas();
    }

    public List<String> getPessoas() {
        return Arrays.asList(this.input.split(", "));
    }

    public List<String> getMulheres() {
        return this.pessoas.stream()
            .filter(pessoa -> pessoa.contains("-") && pessoa.split("-").length == 2)
            .filter(pessoa -> pessoa.split("-")[1]
            .equals("Mulher"))
            .toList();
    }

    public List<String> getHomens() {
        return this.pessoas.stream()
            .filter(pessoa -> pessoa.contains("-") && pessoa.split("-").length == 2)
            .filter(pessoa -> pessoa.split("-")[1]
            .equals("Homem"))
            .toList();
    }
}
