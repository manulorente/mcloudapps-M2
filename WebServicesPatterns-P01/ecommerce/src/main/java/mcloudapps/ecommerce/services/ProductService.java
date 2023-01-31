package mcloudapps.ecommerce.services;

import java.util.Collection;

import mcloudapps.ecommerce.dtos.requests.ProductRequestDto;
import mcloudapps.ecommerce.dtos.responses.ProductResponseDto;

public interface ProductService {

    Collection<ProductResponseDto> findAll();

    ProductResponseDto findById(Long id);

    ProductResponseDto create(ProductRequestDto productRequestDto);

    ProductResponseDto update(Long id, int stock);

    void delete(Long id);
    
}
