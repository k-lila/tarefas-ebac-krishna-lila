package main.domain;

import java.math.BigDecimal;

import main.annotations.PrimaryKey;
import main.dao.Persistent;

public class Product implements Persistent {
    @PrimaryKey("getCode")
    private String code;
    private String name;
    private String description;
    private BigDecimal value;

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public BigDecimal getValue() { return value; }
    public void setValue(BigDecimal value) { this.value = value; }
    @Override
    public String toString() {
        return "Product [code=" + code + ", name=" + name + ", description=" + description + ", value=" + value + "]";
    }
}
