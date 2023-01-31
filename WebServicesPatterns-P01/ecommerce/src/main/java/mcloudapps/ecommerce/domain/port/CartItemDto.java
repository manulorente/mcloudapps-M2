package mcloudapps.ecommerce.domain.port;

public class CartItemDto {

    ProductDto product;
    long quantity;

    public CartItemDto(ProductDto product, long quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartItemDto [product=" + product + ", quantity=" + quantity + "]";
    }

}
