package mcloudapps.ecommerce.infrastructure;

import java.util.List;
import java.util.stream.Collectors;

import mcloudapps.ecommerce.domain.port.ProductDto;
import mcloudapps.ecommerce.domain.port.ProductRepository;
import mcloudapps.ecommerce.infrastructure.mappers.ProductMapper;
import mcloudapps.ecommerce.infrastructure.repositories.ProductJpaRepository;

public class ProductRepositoryAdapter implements ProductRepository{

    private ProductJpaRepository productJpaRepository;
    private ProductMapper mapper;

    public ProductRepositoryAdapter(ProductJpaRepository productJpaRepository, ProductMapper mapper) {
        this.productJpaRepository = productJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public List<ProductDto> findAll() {
        return this.productJpaRepository.findAll().stream()
            .map(product -> this.mapper.toProductDto(product))
            .collect(Collectors.toList());
    }

    @Override
    public ProductDto findById(Long id) {
        return this.mapper.toProductDto(this.productJpaRepository
            .findById(id).get());
    }

    @Override
    public ProductDto create(ProductDto productDto) {
        return this.mapper.toProductDto(this.productJpaRepository
            .save(this.mapper.toProductEntity(productDto)));
    }

    @Override
    public ProductDto update(ProductDto productDto) {
        return this.mapper.toProductDto(this.productJpaRepository
            .save(this.mapper.toProductEntity(productDto)));
    }

    @Override
    public void delete(Long id) {
        this.productJpaRepository.deleteById(id);
    }
    
}
