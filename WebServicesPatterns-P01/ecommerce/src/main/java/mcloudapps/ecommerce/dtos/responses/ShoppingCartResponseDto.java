package mcloudapps.ecommerce.dtos.responses;

import java.util.List;

public class ShoppingCartResponseDto {
    
    private Long id;
    private List<CartItemResponseDto> items;
    private boolean finished;

    public ShoppingCartResponseDto() {
    }

    public ShoppingCartResponseDto(Long id, List<CartItemResponseDto> items, boolean finished) {
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

    public List<CartItemResponseDto> getCartItems() {
        return this.items;
    }

    public void setCartItems(List<CartItemResponseDto> items) {
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
            ", cartItems='" + this.getCartItems() + "'" +
            ", finished='" + this.isFinished() + "'" +
            "}";
    }

}
