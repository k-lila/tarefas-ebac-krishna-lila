package services;

import dao.IContratoDao;

public class Service implements IService {

    IContratoDao contratoDao;

    public Service(IContratoDao dao) {
        this.contratoDao = dao;
    }

    @Override
    public String salvar() {
        contratoDao.salvar();
        return "ok";
    }
    @Override
    public String buscar() {
        contratoDao.buscar();
        return "ok";
    }
    @Override
    public String excluir() {
        contratoDao.excluir();
        return "ok";
    }
    @Override
    public String atualizar() {
        contratoDao.atualizar();
        return "ok";
    }
}
