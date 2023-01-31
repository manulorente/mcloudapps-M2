package mcloudapps.ecommerce.dtos.responses;

import mcloudapps.ecommerce.domain.port.ProductDto;

public class CartItemResponseDto {

    ProductDto product;

    long quantity;

    public CartItemResponseDto() {
    }

    public CartItemResponseDto(ProductDto product, long quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public ProductDto getProduct() {
        return this.product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }

    public long getQuantity() {
        return this.quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "{" +
            " product='" + this.getProduct() + "'" +
            ", quantity='" + this.getQuantity() + "'" +
            "}";
    }

    
}
