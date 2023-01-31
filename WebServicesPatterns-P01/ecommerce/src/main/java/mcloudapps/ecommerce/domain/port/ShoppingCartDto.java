package mcloudapps.ecommerce.domain.port;


import java.util.List;

public class ShoppingCartDto {

    private Long id;
    private List<CartItemDto> items;
    private boolean finished;

    public ShoppingCartDto() {
    }

    public ShoppingCartDto(Long id, List<CartItemDto> items, boolean finished) {
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

    public List<CartItemDto> getItems() {
        return this.items;
    }

    public void setItems(List<CartItemDto> items) {
        this.items = items;
    }
    
    public boolean isFinished() {
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
