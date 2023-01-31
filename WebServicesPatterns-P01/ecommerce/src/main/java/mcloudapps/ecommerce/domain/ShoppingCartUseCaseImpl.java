package mcloudapps.ecommerce.domain;

import mcloudapps.ecommerce.domain.port.ShoppingCartDto;
import mcloudapps.ecommerce.domain.port.ShoppingCartRepository;
import mcloudapps.ecommerce.domain.port.ShoppingCartUseCase;

public class ShoppingCartUseCaseImpl implements ShoppingCartUseCase{
    
    private ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartUseCaseImpl(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    @Override
    public ShoppingCartDto create() {
        return this.shoppingCartRepository.create();
    }

    @Override
    public ShoppingCartDto findById(Long id) {
        return this.shoppingCartRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        if (this.shoppingCartRepository.existsShoppingCart(id)) {
            this.shoppingCartRepository.delete(id);
        }
    }

    @Override
    public ShoppingCartDto addProduct(Long id, long productId, long quantity) {
        if (this.shoppingCartRepository.existsShoppingCart(id)) {
            return this.shoppingCartRepository.addProduct(id, productId, quantity);
        }
        return null;
    }

    @Override
    public ShoppingCartDto deleteProduct(Long id, long productId) {
        if (this.shoppingCartRepository.existsShoppingCart(id)) {
            return this.shoppingCartRepository.deleteProduct(id, productId);
        }
        return null;
    }

    @Override
    public void finishShoppingCart(Long id) {
        if (this.shoppingCartRepository.existsShoppingCart(id)) {
            this.shoppingCartRepository.finishShoppingCart(id);
        }
    }
}
