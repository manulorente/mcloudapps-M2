package mcloudapps.ecommerce.services.impl;

import mcloudapps.ecommerce.domain.port.ShoppingCartDto;
import mcloudapps.ecommerce.domain.port.ShoppingCartUseCase;
import mcloudapps.ecommerce.dtos.responses.ShoppingCartResponseDto;
import mcloudapps.ecommerce.infrastructure.mappers.ShoppingCartMapper;
import mcloudapps.ecommerce.services.ShoppingCartService;

public class ShoppingCartServiceImpl implements ShoppingCartService{

    private ShoppingCartUseCase shoppingCartUseCase;
    private ShoppingCartMapper mapper;

    public ShoppingCartServiceImpl(ShoppingCartUseCase shoppingCartUseCase, ShoppingCartMapper mapper) {
        this.shoppingCartUseCase = shoppingCartUseCase;
        this.mapper = mapper;
    }

    @Override
    public ShoppingCartResponseDto findById(Long id) {
        return this.mapper.toShoppingCartResponseDto(this.shoppingCartUseCase.findById(id));
    }

    @Override
    public ShoppingCartResponseDto create() {
        ShoppingCartDto shoppingCartDto = this.shoppingCartUseCase.create();
        return this.mapper.toShoppingCartResponseDto(shoppingCartDto);
    }

    @Override
    public void delete(Long id) {
        this.shoppingCartUseCase.delete(id);
    }

    @Override
    public ShoppingCartResponseDto addProduct(Long id, Long productId, Long productQuantity) {
        ShoppingCartDto shoppingCartDto = this.shoppingCartUseCase.addProduct(id, productId, productQuantity);
        return this.mapper.toShoppingCartResponseDto(shoppingCartDto);
    }

    @Override
    public ShoppingCartResponseDto deleteProduct(Long id, Long productId) {
        ShoppingCartDto shoppingCartDto = this.shoppingCartUseCase.deleteProduct(id, productId);
        return this.mapper.toShoppingCartResponseDto(shoppingCartDto);
    }

    @Override
    public ShoppingCartResponseDto finishShoppingCart(Long id) {
        this.shoppingCartUseCase.finishShoppingCart(id);
        return this.mapper.toShoppingCartResponseDto(this.shoppingCartUseCase.findById(id));
    }
}
