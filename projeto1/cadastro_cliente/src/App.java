import java.util.Collection;

import javax.swing.JOptionPane;

import dao.ClienteMapDAO;
import dao.IClienteDAO;
import domain.Cliente;
import view.Asker;

public class App {
    private static IClienteDAO iClienteDAO;

    public static void main(String[] args) throws Exception {
        iClienteDAO = new ClienteMapDAO();
        Asker asker = new Asker();
        Boolean run = true;
        while (run) {
            asker.askOption();
            if (asker.isOptionValid()) {
                if (asker.getOption().equals("1")) {
                    asker.askRegisterInfo();
                    iClienteDAO.cadastrar(asker.createClient());
                } else if (asker.getOption().equals("2")) {
                    Long cpf = asker.askLong("Digite o CPF", 11);
                    Cliente clienteProcurado = iClienteDAO.consultar(cpf);
                    if (clienteProcurado == null) {
                        JOptionPane.showMessageDialog(null, "Cliente não encontrado", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, clienteProcurado.toString(), "Resultado", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else if (asker.getOption().equals("3")) {
                    Long cpf = asker.askLong("Digite o CPF", 11);
                    Cliente clienteProcurado = iClienteDAO.consultar(cpf);
                    if (clienteProcurado == null) {
                        JOptionPane.showMessageDialog(null, "Cliente não encontrado", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        iClienteDAO.excluir(cpf);
                        JOptionPane.showMessageDialog(null, "Cliente excluído!", "Excluir", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else if (asker.getOption().equals("4")) {
                    Long cpf = asker.askLong("Digite o CPF", 11);
                    Cliente clienteProcurado = iClienteDAO.consultar(cpf);
                    if (clienteProcurado == null) {
                        JOptionPane.showMessageDialog(null, "Cliente não encontrado", "Modificar", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        Cliente novoCliente = asker.askModifications(clienteProcurado);
                        iClienteDAO.alterar(novoCliente);
                        JOptionPane.showMessageDialog(null, "Cliente alterado!", "Modificar", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else if (asker.getOption().equals("5")) {
                    Collection<Cliente> todos = iClienteDAO.buscarTodos();
                    String printString = "";
                    String spacer = "-".repeat(10);
                    for (Cliente cliente : todos) {
                        printString += String.format("%s\nNome: %s\nCPF: %s\n", spacer, cliente.getNome(), cliente.getCpf());
                    }
                    printString += spacer;
                    JOptionPane.showMessageDialog(null, printString, "Todos", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }
}
