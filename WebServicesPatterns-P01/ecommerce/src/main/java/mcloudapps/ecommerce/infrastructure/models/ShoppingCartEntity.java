package mcloudapps.ecommerce.infrastructure.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "shopping_carts")
public class ShoppingCartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean finished;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "shoppingCartEntity")
    private List<CartItemEntity> items = new ArrayList<>();

    public ShoppingCartEntity() {
    }

    public ShoppingCartEntity(Long id, List<CartItemEntity> items, boolean finished) {
        this.id = id;
        this.items = items;
        this.finished = finished;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CartItemEntity> getItems() {
        return this.items;
    }

    public void setItems(List<CartItemEntity> items) {
        this.items = items;
    }

    public boolean isFinished() {
        return this.finished;
    }

    public boolean getFinished() {
        return this.finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + this.getId() + "'" +
            ", items='" + this.getItems() + "'" +
            ", finished='" + this.isFinished() + "'" +
            "}";
    }


    
}
