package mcloudapps.ecommerce.domain.port;

import java.util.Collection;

public interface ProductUseCase {

    public Collection<ProductDto> findAll();

    public ProductDto findById(Long id);

    public ProductDto create(ProductDto productDto);

    public ProductDto update(Long id, int stock);

    public void delete(Long id);
    
}
