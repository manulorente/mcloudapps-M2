package mcloudapps.ecommerce.dtos.responses;

public class ProductResponseDto {

    private String name;

    private String brand;

    private int stock;

    public ProductResponseDto() {
    }

    public ProductResponseDto(String name, String brand, int stock) {
        this.name = name;
        this.brand = brand;
        this.stock = stock;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + this.getName() + "'" +
            ", brand='" + this.getBrand() + "'" +
            ", stock='" + this.getStock() + "'" +
            "}";
    }
    
    
}
