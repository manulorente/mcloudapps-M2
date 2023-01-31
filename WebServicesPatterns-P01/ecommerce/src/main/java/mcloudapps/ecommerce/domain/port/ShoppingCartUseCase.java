package mcloudapps.ecommerce.domain.port;

public interface ShoppingCartUseCase {

    public ShoppingCartDto create();

    public ShoppingCartDto findById(Long id);

    public void delete(Long id);

    public ShoppingCartDto addProduct(Long id, long productId, long quantity);

    public ShoppingCartDto deleteProduct(Long id, long productId);

    public void finishShoppingCart(Long id);
    
}
