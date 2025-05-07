package main.domain;

import java.math.BigDecimal;

public class ProductQuantity {

    private Product product;
    private Integer quantity;
    private BigDecimal total;

    public ProductQuantity(Product product) {
        this.product = product;
        this.quantity = 0;
        this.total = getTotal();
    }

    public Product getProduct() {
        return this.product;
    }

    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public BigDecimal getTotal() {
        BigDecimal value = this.product != null ? this.product.getValue() : BigDecimal.valueOf(0);
        this.total = value.multiply(BigDecimal.valueOf(quantity));
        return total;
    }

    public void add(Integer num) {
        this.quantity += num;
    }

    public void remove(Integer num) {
        Integer result = this.quantity - num;
        this.quantity = result >= 0 ? result : 0;
    }
}
