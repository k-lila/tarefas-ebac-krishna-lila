package dao;

public class Client implements IClient {
    private String name;
    public Client(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Não funciona sem configuração de banco de dados");
    }
}
