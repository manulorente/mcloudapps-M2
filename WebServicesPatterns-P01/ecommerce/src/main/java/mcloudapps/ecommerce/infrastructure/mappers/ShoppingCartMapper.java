package mcloudapps.ecommerce.infrastructure.mappers;

import org.mapstruct.Mapper;

import mcloudapps.ecommerce.domain.port.ShoppingCartDto;
import mcloudapps.ecommerce.dtos.responses.ShoppingCartResponseDto;
import mcloudapps.ecommerce.infrastructure.models.ShoppingCartEntity;

@Mapper(componentModel = "spring")
public interface ShoppingCartMapper {

    ShoppingCartResponseDto toShoppingCartResponseDto(ShoppingCartDto shoppingCartDto);

    ShoppingCartDto toShoppingCartDto(ShoppingCartEntity shoppingCartEntity);

    ShoppingCartEntity toShoppingCartEntity(ShoppingCartDto shoppingCartDto);
    
}
