package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.Test;

import dao.ContratoDao;
import dao.IContratoDao;
import mocks.ContratoMockDao;
import services.IService;
import services.Service;

public class ServiceTest {

    @Test 
    public void salvarTest() {
        IContratoDao dao = new ContratoMockDao();
        IService service = new Service(dao);
        String retorno = service.salvar();
        assertEquals(retorno, "ok");
    }

    @Test 
    public void buscarTest() {
        IContratoDao dao = new ContratoMockDao();
        IService service = new Service(dao);
        String retorno = service.buscar();
        assertEquals(retorno, "ok");
    }

    @Test 
    public void excluirTest() {
        IContratoDao dao = new ContratoMockDao();
        IService service = new Service(dao);
        String retorno = service.excluir();
        assertEquals(retorno, "ok");
    }

    @Test 
    public void atualizarTest() {
        IContratoDao dao = new ContratoMockDao();
        IService service = new Service(dao);
        String retorno = service.atualizar();
        assertEquals(retorno, "ok");
    }

    @Test
    public void esperadoErroNoSalvarComBancoDeDadosTest() {
        IContratoDao dao = new ContratoDao();
        IService service = new Service(dao);
        assertThrows(UnsupportedOperationException.class, service::salvar);
    }


    @Test
    public void esperadoErroNoBuscarComBancoDeDadosTest() {
        IContratoDao dao = new ContratoDao();
        IService service = new Service(dao);
        assertThrows(UnsupportedOperationException.class, service::buscar);
    }


    @Test
    public void esperadoErroNoExcluirComBancoDeDadosTest() {
        IContratoDao dao = new ContratoDao();
        IService service = new Service(dao);
        assertThrows(UnsupportedOperationException.class, service::excluir);
    }


    @Test
    public void esperadoErroNoAtualizarComBancoDeDadosTest() {
        IContratoDao dao = new ContratoDao();
        IService service = new Service(dao);
        assertThrows(UnsupportedOperationException.class, service::atualizar);
    }

}

