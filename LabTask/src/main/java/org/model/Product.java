package org.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Product {

    @NotNull(message = "Can not be empty.")
    private Integer productId;

    @NotNull(message = "Can not be empty")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "only alphabets allowed")
    private String productName;

    @Min(value = 0)
    @Max(value = 1000)
    @NotNull(message = "Can not be empty")
    private Integer quantity;

    private String category;

    public Product() {
    }

    public Product(Integer productId, String productName, Integer quantity, String category) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.category = category;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
