package tests;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import main.domain.Product;
import main.domain.ProductQuantity;

public class ProductSetTest {

    private Product product;

    public ProductSetTest() {
        Product product = new Product();
        product.setCode("teste");
        product.setValue(BigDecimal.valueOf(1));
        this.product = product;
    }

    @Test
    public void productTest() {
        ProductQuantity productSet = new ProductQuantity(product);
        Assert.assertEquals(this.product, productSet.getProduct());
    }

    @Test
    public void totalValueTest() {
        ProductQuantity productSet = new ProductQuantity(product);
        productSet.setQuantity(10);
        Assert.assertEquals(productSet.getTotal(), BigDecimal.valueOf(10));
    }

    @Test
    public void addTest() {
        ProductQuantity productSet = new ProductQuantity(product);
        productSet.add(5);
        Assert.assertEquals(productSet.getQuantity(), Integer.valueOf(5));
    }


    @Test
    public void removeTest() {
        ProductQuantity productSet = new ProductQuantity(product);
        productSet.setQuantity(5);
        productSet.remove(3);
        Assert.assertEquals(productSet.getQuantity(), Integer.valueOf(2));
        productSet.remove(10);
        Assert.assertEquals(productSet.getQuantity(), Integer.valueOf(0));
    }
}