package view;

import javax.swing.JOptionPane;

import domain.Cliente;

public class Asker {
    private String option;
    private Boolean isoptionvalid;

    public String nome;
    public long cpf;
    public long tel;
    public String end;
    public Integer num;
    public String cidade;
    public String estado;

    public Asker() {
        this.option = "";
        this.isoptionvalid = false;
    }

    public Boolean isOptionValid() {
        if (!this.option.equals("")) {
            this.isoptionvalid = true;
        }
        return this.isoptionvalid;
    }

    public String getOption() {
        return this.option;
    }

    private static void sair() {
        JOptionPane.showMessageDialog(null, "Até logo!", "Sair", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }


    public void askOption() {
        String label = "Digite:\n1 para cadastro\n2 para consulta\n3 para exclusão\n4 para alteração\n5 mostrar todos os registros\n0 para sair";
        String inputString = JOptionPane.showInputDialog(null, label, "Opções", JOptionPane.INFORMATION_MESSAGE);
        Boolean key = inputString.equals("1") || inputString.equals("2") || inputString.equals("3") || inputString.equals("4") || inputString.equals("5") || inputString.equals("0");
        while (!key) {
            inputString = JOptionPane.showInputDialog(null, "Opção inválida!\n" + label, "Opções", JOptionPane.INFORMATION_MESSAGE);
            key = inputString.equals("1") || inputString.equals("2") || inputString.equals("3") || inputString.equals("4") || inputString.equals("5") || inputString.equals("0");
        }
        if (key) {
            if (inputString.equals("0")) {
                sair();
            }
            this.option = inputString;
        }
    }

    public String askString(String label, int length) {
        String returnString = "";
        Boolean run = true;
        while (run) {
            String inputString = JOptionPane.showInputDialog(null, label, "Opções", JOptionPane.INFORMATION_MESSAGE);
            if (inputString.equals("0")) {
                run = false;
            } else if (inputString.length() >= length) {
                returnString = inputString;
                run = false;
            }
        }
        return returnString;
    }

    public Long askLong(String label, int length) {
        Long returnLong = 0L;
        Boolean run = true;
        while (run) {
            String inputString = JOptionPane.showInputDialog(null, label, "Opções", JOptionPane.INFORMATION_MESSAGE);
            if (inputString.equals("0")) {
                run = false;
            } else if (inputString.length() == length && inputString.matches("\\d+")) {
                returnLong = Long.parseLong(inputString);
                run = false;
            }
        }
        return returnLong;
    }

    public Integer askInteger(String label) {
        Integer returnInteger = -1;
        Boolean run = true;
        while (run) {
            String inputString = JOptionPane.showInputDialog(null, label, "Opções", JOptionPane.INFORMATION_MESSAGE);
            if (inputString.equals("-1")) {
                run = false;
            } else if (inputString.matches("\\d+")) {
                returnInteger = Integer.parseInt(inputString);
                run = false;
            }
        }
        return returnInteger;
    }

    public void askRegisterInfo() {
        String name = askString("Nome\nO nome deve ter no mínimo 3 caracteres\nDigite 0 para pular", 3);
        if (!name.equals("")) {this.nome = name;}
        Long cpf = askLong("CPF", 11);
        if (!cpf.equals(0L)) {this.cpf = cpf;}
        Long tel = askLong("Telefone", 1);
        if (!tel.equals(0L)) {this.tel = tel;}
        String end = askString("Endereço:", 3);
        if (!end.equals("")) {this.end = end;}
        Integer num = askInteger("Número");
        if (!num.equals(-1)) {this.num = num;}
        String cidade = askString("Cidade:", 2);
        if (!cidade.equals("")) {this.cidade = cidade;}
        String estado = askString("Estado:", 2);
        if (!estado.equals("")) {this.estado = estado;}
    }

    public Cliente askModifications(Cliente cliente) {
        String name = askString("Nome:", 3);
        if (!name.equals("")) { cliente.setNome(name); }
        Long tel = askLong("Telefone:", 1);
        if (!tel.equals(0L)) { cliente.setTel(tel); }    
        String end = askString("Endereço:", 3);
        if (!end.equals("")) { cliente.setEnd(end); }    
        Integer num = askInteger("Número");
        if (!num.equals(-1)) { cliente.setNumero(num); }    
        String cidade = askString("Cidade:", 2);
        if (!cidade.equals("")) { cliente.setCidade(cidade); }
        String estado = askString("Estado:", 2);
        if (!estado.equals("")) { cliente.setEstado(estado); }
        return cliente;
    }

    public Cliente createClient() {
        return new Cliente(this.nome, this.cpf == 0 ? null : this.cpf, this.tel == 0 ? null : this.tel, this.end, this.num == 0 ? null : this.num, this.cidade, this.estado);
    }
}
