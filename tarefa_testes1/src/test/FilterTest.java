package test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import filter.Filter;

public class FilterTest {
    @Test
    public void confereMulheres() {
        String inputString = "A-Homem, B-Mulher, C-Homem, D-Mulher, E-Mulher, F-Homem, G-Homem, H-Mulher";
        List<String> mulheres = new Filter(inputString).getMulheres();
        Boolean test = true;
        for (String m : mulheres) {
            if (!m.split("-")[1].equals("Mulher")) {
                test = false;
            }
        }
        assertTrue(test);
    }
}
