package test;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.Acessorio;
import model.Carro;
import model.Marca;

public class Teste {

    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private EntityTransaction entityTransaction;

    private List<Marca> testeMarcas;
    private List<Carro> testeCarros;
    private List<Acessorio> testeAcessorios;

    public Teste() {
        testeMarcas = new ArrayList<>();
        testeCarros = new ArrayList<>();
        testeAcessorios = new ArrayList<>();

        Marca marca1 = new Marca();
        marca1.setNome("MarcaA");
        testeMarcas.add(marca1);
        Marca marca2 = new Marca();
        marca2.setNome("MarcaB");
        testeMarcas.add(marca2);

        Acessorio acessorio1 = new Acessorio();
        acessorio1.setNome("Ar condicionado");
        testeAcessorios.add(acessorio1);
        Acessorio acessorio2 = new Acessorio();
        acessorio2.setNome("GPS");
        testeAcessorios.add(acessorio2);

        Carro carro1 = new Carro();
        carro1.setMarca(marca1);
        carro1.setModelo("Modelo A1");
        List<Acessorio> carro1List = new ArrayList<>();
        carro1List.add(acessorio1);
        carro1.setAcessorios(carro1List);
        testeCarros.add(carro1);

        Carro carro2 = new Carro();
        carro2.setMarca(marca2);
        carro2.setModelo("Modelo B2");
        List<Acessorio> carro2List = new ArrayList<>();
        carro2List.add(acessorio1);
        carro2List.add(acessorio2);
        carro2.setAcessorios(carro2List);
        testeCarros.add(carro2);
    }

    @BeforeAll
    public static void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("mod33");
    }

    @BeforeEach
    public void setup() {
        entityManager = entityManagerFactory.createEntityManager();
        entityTransaction = entityManager.getTransaction();
    }

    @AfterEach
    public void clear() {
        if (entityManager != null) entityManager.close();
    }

    @AfterAll
    public static void close() {
        if (entityManagerFactory != null) entityManagerFactory.close();
    }

    @Test
    public void testeRegistro() {
        entityTransaction.begin();
        entityManager.persist(testeMarcas.get(0));
        entityManager.persist(testeMarcas.get(1));
        entityManager.persist(testeAcessorios.get(0));
        entityManager.persist(testeAcessorios.get(1));
        entityManager.persist(testeCarros.get(0));
        entityManager.persist(testeCarros.get(1));
        entityTransaction.commit();
    }

    @Test
    public void testeConsulta() {
        List<Carro> carros = entityManager.createQuery("SELECT c FROM Carro c", Carro.class).getResultList();
        List<Marca> marcas = entityManager.createQuery("SELECT m FROM Marca m", Marca.class).getResultList();
        List<Acessorio> acessorios = entityManager.createQuery("SELECT a FROM Acessorio a", Acessorio.class).getResultList();
        assert(carros.size() == 2);
        assert(marcas.size() == 2);
        assert(acessorios.size() == 2);
        for (Carro carro : carros) {
            assert(carro.getMarca() != null);
            assert(carro.getAcessorios() != null);
        }
    }
}
