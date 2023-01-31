package mcloudapps.ecommerce.domain.port;

public interface ShoppingCartRepository {

    ShoppingCartDto create();

    ShoppingCartDto findById(Long id);

    void delete(Long id);

    ShoppingCartDto addProduct(Long id, long productId, long quantity);

    ShoppingCartDto deleteProduct(Long id, long productId);

    void finishShoppingCart(Long id);

    boolean existsShoppingCart(Long id);
    
}
