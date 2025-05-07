package main.dao;

import main.dao.generics.GenericDAO;
import main.domain.Product;

public class ProductDAO extends GenericDAO<Product, String> implements IProductDAO {

    @Override
    public Class<Product> getClassType() {
        return Product.class;
    }

    @Override
    public void updateData(Product entity, Product oldEntity) {
        oldEntity.setName(entity.getName());
        oldEntity.setCode(entity.getCode());
        oldEntity.setDescription(entity.getDescription());
        oldEntity.setValue(entity.getValue());
    }
}
