package main.domain;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import main.annotations.PrimaryKey;
import main.dao.Persistent;

public class Sale implements Persistent{
    public enum Status {INICIADA, CONCLUIDA, CANCELADA}
    @PrimaryKey("getCode")
    private String code;
    private Client client;
    private Set<ProductQuantity> products;
    private BigDecimal totalValue;
    private Instant saleDate;
    private Status status;

    public Sale() {
        this.products = new HashSet<>();
    }

    private void validateStatus() {
		if (this.status == Status.CONCLUIDA) {
			throw new UnsupportedOperationException("IMPOSSÍVEL ALTERAR VENDA FINALIZADA");
		}
	}

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<ProductQuantity> getProducts() {
        return products;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public Instant getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Instant saleDate) {
        this.saleDate = saleDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void add(Product product, Integer quantity) {
        validateStatus();
        Optional<ProductQuantity> op = products.stream().filter(f -> f.getProduct().getCode().equals(product.getCode())).findAny();
        if (op.isPresent()) {
            ProductQuantity productQuantity = op.get();
            productQuantity.add(quantity);
        } else {
            ProductQuantity productQuantity = new ProductQuantity(product);
            productQuantity.add(quantity);
            products.add(productQuantity);
        }
        recalculateTotal();
    }

    public void remove(Product product, Integer quantity) {
        validateStatus();
        Optional<ProductQuantity> op = products.stream().filter(f -> f.getProduct().getCode().equals(product.getCode())).findAny();    
        if (op.isPresent()) {
            ProductQuantity productQuantity = op.get();
            if (productQuantity.getQuantity() > quantity) {
                productQuantity.remove(quantity);
            } else {
                products.remove(op.get());
            }
            recalculateTotal();
        }
    }

    public void removerTodosProdutos() {
		validateStatus();
		products.clear();
		totalValue = BigDecimal.ZERO;
	}

    public Integer getTotalQuantity() {
        Integer quantity = products.stream().reduce(0, (a, b) -> a + b.getQuantity(), Integer::sum);
        return quantity;
    }

    public void recalculateTotal() {
        validateStatus();
        BigDecimal total = BigDecimal.ZERO;
        for (ProductQuantity prod : this.products) {
            total = total.add(prod.getTotal());
        }
        this.totalValue = total;
    }
}
