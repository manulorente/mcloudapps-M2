package mcloudapps.ecommerce.services.impl;

import java.util.Collection;
import java.util.stream.Collectors;

import mcloudapps.ecommerce.domain.port.ProductUseCase;
import mcloudapps.ecommerce.dtos.requests.ProductRequestDto;
import mcloudapps.ecommerce.dtos.responses.ProductResponseDto;
import mcloudapps.ecommerce.infrastructure.mappers.ProductMapper;
import mcloudapps.ecommerce.services.ProductService;

public class ProductServiceImpl implements ProductService{

    private ProductMapper mapper;
    private ProductUseCase productUseCase;

    public ProductServiceImpl(ProductUseCase productUseCase, ProductMapper mapper) {
        this.productUseCase = productUseCase;
        this.mapper = mapper;
    }

    @Override
    public Collection<ProductResponseDto> findAll() {
        return this.productUseCase.findAll().stream()
            .map(product -> this.mapper.toProductResponseDto(product))
            .collect(Collectors.toList());
    }

    @Override
    public ProductResponseDto findById(Long id) {
        return this.mapper.toProductResponseDto(this.productUseCase
            .findById(id));
    }

    @Override
    public ProductResponseDto create(ProductRequestDto productRequestDto) {
        return this.mapper.toProductResponseDto(this.productUseCase
            .create(this.mapper.toProductDto(productRequestDto)));
    }
    
    @Override
    public ProductResponseDto update(Long id, int stock) {
        return this.mapper.toProductResponseDto(this.productUseCase
            .update(id, stock));
    }

    @Override
    public void delete(Long id) {
        this.productUseCase.delete(id);
    }

}
