package mocks;

import dao.IClient;

public class ClientMock implements IClient{
    private String name;
    public ClientMock(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
