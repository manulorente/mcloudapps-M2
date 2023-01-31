package mcloudapps.ecommerce.domain;

import java.util.Collection;

import mcloudapps.ecommerce.domain.port.ProductDto;
import mcloudapps.ecommerce.domain.port.ProductRepository;
import mcloudapps.ecommerce.domain.port.ProductUseCase;

public class ProductUseCaseImpl implements ProductUseCase{

    private ProductRepository productRepository;

    public ProductUseCaseImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Collection<ProductDto> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public ProductDto findById(Long id) {
        return this.productRepository.findById(id);
    }

    @Override
    public ProductDto create(ProductDto productDto) {
        ProductDto newProductDto = new ProductDto(
                productDto.getName(),
                productDto.getBrand(),
                productDto.getStock()
        );
        return this.productRepository.create(newProductDto);
    }

    @Override
    public ProductDto update(Long id, int stock) {
        ProductDto productDto = this.productRepository.findById(id);
        productDto.setStock(stock);
        return this.productRepository.update(productDto);
    }

    @Override
    public void delete(Long id) {
        this.productRepository.delete(id);
    }
    
}
