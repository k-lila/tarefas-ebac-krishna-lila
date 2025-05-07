package tests;

import java.math.BigDecimal;
import java.util.Collection;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.dao.IProductDAO;
import main.dao.ProductDAO;
import main.domain.Product;
import main.exceptions.PrimaryKeyNotFound;
import main.services.IProductService;
import main.services.ProductService;


public class ProductServiceTest {
    
    private IProductService productService;
    private String code;
    private String name;
    private String description;
    private BigDecimal value;

    public ProductServiceTest() {
        IProductDAO productDAO= new ProductDAO();
        productService = new ProductService(productDAO);
        this.code = "teste";
        this.name = "teste";
        this.description = "teste";
        this.value = new BigDecimal(1);
    }

    @BeforeEach
    public void init() throws PrimaryKeyNotFound {
        Product product = new Product();
        product.setCode(code);
        product.setName(name);
        product.setDescription(description);
        product.setValue(value);
        productService.register(product);
    }

    @Test
    public void createProduct() throws PrimaryKeyNotFound {
        Product newProduct = new Product();
        newProduct.setCode("novoproduto");
        Integer num = this.productService.all().size();
        this.productService.register(newProduct);
        Assert.assertEquals(this.productService.all().size(), num + 1);
    }

    @Test
    public void searchProduct() throws PrimaryKeyNotFound {
        Product registered = productService.search(code);
        Assert.assertNotNull(registered);
    }


    @Test
    public void deleteProduct() throws PrimaryKeyNotFound {
        Product registered = productService.search(code);
        Assert.assertNotNull(registered);
        productService.delete(code);
        Product deleted = productService.search(code);
        Assert.assertNull(deleted);
    }

    @Test
    public void updateProduct() throws PrimaryKeyNotFound {
        String stringTest = "atualizado";
        BigDecimal updatedValue = new BigDecimal(2);
        Product updatedProduct = new Product();
        updatedProduct.setCode(code);
        updatedProduct.setName(stringTest);
        updatedProduct.setDescription(stringTest);
        updatedProduct.setValue(updatedValue);
        productService.update(updatedProduct);
        Product registered = productService.search(code);
        Assert.assertEquals(registered.getName(), stringTest);
        Assert.assertEquals(registered.getDescription(), stringTest);
        Assert.assertEquals(registered.getValue(), updatedValue);
    }

    @Test
    public void allProducts() throws PrimaryKeyNotFound{
        for (int i = 0; i < 10; i++) {
            Product p = new Product();
            p.setCode(String.format("%d", i));
            productService.register(p);
        }
        Collection<Product> all = productService.all();
        Assert.assertEquals(all.size(), 11);
    }
}
