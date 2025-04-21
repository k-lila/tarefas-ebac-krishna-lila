package mocks;

import dao.IContratoDao;

public class ContratoMockDao implements IContratoDao {
    @Override
    public String salvar() {
        return "ok";
    }

    @Override
    public String buscar() {
        return "ok";
    }

    @Override
    public String excluir() {
        return "ok";
    }

    @Override
    public String atualizar() {
        return "ok";
    }
}
