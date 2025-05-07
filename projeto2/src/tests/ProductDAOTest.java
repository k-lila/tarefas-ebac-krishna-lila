package tests;

import java.math.BigDecimal;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

import main.dao.ProductDAO;
import main.domain.Product;
import main.exceptions.PrimaryKeyNotFound;

public class ProductDAOTest {
    private ProductDAO productDao;
    private String code;
    private String name;
    private String description;
    private BigDecimal value;

    public ProductDAOTest() {
        this.productDao = new ProductDAO();
        this.code = "teste";
        this.name = "teste";
        this.description = "teste";
        this.value = new BigDecimal(1);
    }


    @Test
    public void createEntryTest() throws PrimaryKeyNotFound {
        for (int i = 0; i < 10; i++) {
            Product product = new Product();
            product.setCode(String.format("teste%d", i));
            this.productDao.register(product);
        }
        Assert.assertEquals(this.productDao.all().size(), 10);
    }

    @Test
    public void searchEntryTest() throws PrimaryKeyNotFound {
        Product product = new Product();
        product.setCode(this.code);
        this.productDao.register(product);
        Product sameProduct = this.productDao.search(this.code);
        Assert.assertNotNull(sameProduct);
    }

    @Test
    public void deleteEntryTest() throws PrimaryKeyNotFound {
        Product product = new Product();
        product.setCode(this.code);
        this.productDao.register(product);
        this.productDao.delete(this.code);
        Product sameProduct = this.productDao.search(this.code);
        Assert.assertNull(sameProduct);
    }

    @Test
    public void updateEntryTest() throws PrimaryKeyNotFound {
        Product product = new Product();
        product.setCode(this.code);
        this.productDao.register(product);
        Product product2 = new Product();
        product2.setCode(this.code);
        product2.setName(this.name);
        product2.setDescription(this.description);
        product2.setValue(this.value);
        this.productDao.update(product2);
        Product updatedProduct = this.productDao.search(this.code);
        Assert.assertNotNull(updatedProduct.getCode());
        Assert.assertNotNull(updatedProduct.getName());
        Assert.assertNotNull(updatedProduct.getDescription());
        Assert.assertNotNull(updatedProduct.getValue());
    }

    @Test
    public void searchAllTest() throws PrimaryKeyNotFound {
        for (int i = 0; i < 10; i++) {
            Product product = new Product();
            product.setCode(String.format("teste%d", i));
            this.productDao.register(product);
        }
        Collection<Product> all = this.productDao.all();
        Assert.assertEquals(all.size(), 10);
    }
}
