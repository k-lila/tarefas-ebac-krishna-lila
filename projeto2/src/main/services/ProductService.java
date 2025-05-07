package main.services;

import java.util.Collection;

import main.dao.IProductDAO;
import main.domain.Product;
import main.exceptions.PrimaryKeyNotFound;
import main.services.generics.GenericService;

public class ProductService extends GenericService<Product, String> implements IProductService {

    public ProductService(IProductDAO iProductDAO) {
        super(iProductDAO);
    }

    @Override
    public void register(Product entity) throws PrimaryKeyNotFound {
        this.dao.register(entity);
    }

    @Override
    public Product search(String valor) throws PrimaryKeyNotFound {
        return this.dao.search(valor);
    }

    @Override
    public void delete(String valor) throws PrimaryKeyNotFound {
        this.dao.delete(valor);
    }

    @Override
    public void update(Product entity) throws PrimaryKeyNotFound {
        this.dao.update(entity);
    }

    @Override
    public Collection<Product> all() {
        return this.dao.all();
    }
}
