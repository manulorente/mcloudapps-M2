package mcloudapps.ecommerce.infrastructure.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CartItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shopping_cart_id")
    private ShoppingCartEntity shoppingCartEntity;

    private Long quantity;


    public CartItemEntity() {
    }

    public CartItemEntity(ProductEntity productEntity, ShoppingCartEntity shoppingCartEntity, Long quantity) {
        this.productEntity = productEntity;
        this.shoppingCartEntity = shoppingCartEntity;
        this.quantity = quantity;
    }

    public CartItemEntity(Long id, ProductEntity productEntity, ShoppingCartEntity shoppingCartEntity, Long quantity) {
        this.id = id;
        this.productEntity = productEntity;
        this.shoppingCartEntity = shoppingCartEntity;
        this.quantity = quantity;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public ProductEntity getProductEntity() {
        return this.productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    public ShoppingCartEntity getShoppingCartEntity() {
        return this.shoppingCartEntity;
    }

    public void setShoppingCartEntity(ShoppingCartEntity shoppingCartEntity) {
        this.shoppingCartEntity = shoppingCartEntity;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", quantity='" + getQuantity() + "'" +
            ", productEntity='" + getProductEntity() + "'" +
            ", shoppingCartEntity='" + getShoppingCartEntity() + "'" +
            "}";
    }
    
}
