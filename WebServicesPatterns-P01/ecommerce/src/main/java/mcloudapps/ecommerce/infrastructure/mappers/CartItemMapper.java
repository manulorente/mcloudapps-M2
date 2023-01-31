package mcloudapps.ecommerce.infrastructure.mappers;

import org.mapstruct.Mapper;

import mcloudapps.ecommerce.domain.port.CartItemDto;
import mcloudapps.ecommerce.dtos.responses.CartItemResponseDto;
import mcloudapps.ecommerce.infrastructure.models.CartItemEntity;

@Mapper(componentModel = "spring")
public interface CartItemMapper {

    CartItemResponseDto toCartItemResponseDto(CartItemDto cartItemDto);

    CartItemDto toCartItemDto(CartItemEntity cartItemEntity);

    CartItemEntity toCartItemEntity(CartItemDto cartItemDto);
    
}
