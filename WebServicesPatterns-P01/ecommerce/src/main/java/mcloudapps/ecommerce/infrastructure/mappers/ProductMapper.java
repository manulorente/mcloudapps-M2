package mcloudapps.ecommerce.infrastructure.mappers;

import org.mapstruct.Mapper;

import mcloudapps.ecommerce.domain.port.ProductDto;
import mcloudapps.ecommerce.dtos.requests.ProductRequestDto;
import mcloudapps.ecommerce.dtos.responses.ProductResponseDto;
import mcloudapps.ecommerce.infrastructure.models.ProductEntity;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDto toProductDto(ProductRequestDto productRequestDto);

    ProductResponseDto toProductResponseDto(ProductDto productDto);

    ProductEntity toProductEntity(ProductDto productDto);

    ProductDto toProductDto(ProductEntity productEntity);
    
}
