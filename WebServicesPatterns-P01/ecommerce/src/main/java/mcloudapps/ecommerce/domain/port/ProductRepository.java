package mcloudapps.ecommerce.domain.port;

import java.util.List;

public interface ProductRepository {

    List<ProductDto> findAll();

    ProductDto findById(Long id);

    ProductDto create(ProductDto productDto);

    ProductDto update(ProductDto productDto);

    void delete(Long id);
    
}
