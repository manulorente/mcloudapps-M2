package mcloudapps.ecommerce.services;

import mcloudapps.ecommerce.dtos.responses.ShoppingCartResponseDto;

public interface ShoppingCartService {

    ShoppingCartResponseDto create();
    ShoppingCartResponseDto finishShoppingCart(Long id);
    ShoppingCartResponseDto findById(Long id);
    void delete(Long id);
    ShoppingCartResponseDto addProduct(Long id, Long productId, Long productQuantity);
    ShoppingCartResponseDto deleteProduct(Long id, Long productId);
    
}
