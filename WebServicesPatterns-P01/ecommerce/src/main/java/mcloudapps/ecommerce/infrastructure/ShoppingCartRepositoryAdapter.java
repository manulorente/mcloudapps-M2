package mcloudapps.ecommerce.infrastructure;

import mcloudapps.ecommerce.domain.port.ShoppingCartDto;
import mcloudapps.ecommerce.domain.port.ShoppingCartRepository;
import mcloudapps.ecommerce.infrastructure.models.CartItemEntity;
import mcloudapps.ecommerce.infrastructure.models.ProductEntity;
import mcloudapps.ecommerce.infrastructure.models.ShoppingCartEntity;
import mcloudapps.ecommerce.infrastructure.repositories.CartItemJpaRepository;
import mcloudapps.ecommerce.infrastructure.repositories.ProductJpaRepository;
import mcloudapps.ecommerce.infrastructure.repositories.ShoppingCartJpaRepository;
import mcloudapps.ecommerce.infrastructure.mappers.ShoppingCartMapper;

public class ShoppingCartRepositoryAdapter implements ShoppingCartRepository{

    private ShoppingCartJpaRepository shoppingCartJpaRepository;
    private CartItemJpaRepository cartItemJpaRepository;
    private ProductJpaRepository productJpaRepository;
    private ShoppingCartMapper shoppingCartMapper;

    public ShoppingCartRepositoryAdapter(ShoppingCartJpaRepository shoppingCartJpaRepository,
            CartItemJpaRepository cartItemJpaRepository, ProductJpaRepository productJpaRepository,
            ShoppingCartMapper shoppingCartMapper) {
        this.shoppingCartJpaRepository = shoppingCartJpaRepository;
        this.cartItemJpaRepository = cartItemJpaRepository;
        this.productJpaRepository = productJpaRepository;
        this.shoppingCartMapper = shoppingCartMapper;
    }

    @Override
    public ShoppingCartDto create(){
        ShoppingCartEntity shoppingCartEntity = new ShoppingCartEntity();
        this.shoppingCartJpaRepository.save(shoppingCartEntity);
        return this.shoppingCartMapper.toShoppingCartDto(shoppingCartEntity);
    }

    @Override
    public ShoppingCartDto findById(Long id) {
        return this.shoppingCartMapper.toShoppingCartDto(this.shoppingCartJpaRepository
            .findById(id).get());
    }

    @Override
    public void delete(Long id) {
        this.shoppingCartJpaRepository.deleteById(id);
    }

    @Override
    public ShoppingCartDto addProduct(Long id, long productId, long quantity){
        ShoppingCartEntity shoppingCartEntity = this.shoppingCartJpaRepository.findById(id).get();
        CartItemEntity cartItemEntity = this.cartItemJpaRepository.findByShoppingCartEntity(shoppingCartEntity);
        ProductEntity productEntity = this.productJpaRepository.findById(productId).get();
        if (productEntity.getStock() >= quantity){
            if(cartItemEntity == null){
                cartItemEntity = new CartItemEntity(productEntity, shoppingCartEntity, quantity);
                this.cartItemJpaRepository.save(cartItemEntity);
            }else{
                cartItemEntity.setQuantity(cartItemEntity.getQuantity() + quantity);
                this.cartItemJpaRepository.save(cartItemEntity);
            }
            productEntity.setStock((int)(productEntity.getStock() - quantity));
            this.productJpaRepository.save(productEntity);
        }
        else
            throw new RuntimeException("No hay stock suficiente");
        return this.shoppingCartMapper.toShoppingCartDto(shoppingCartEntity);
    }

    @Override
    public ShoppingCartDto deleteProduct(Long id, long productId){
        ShoppingCartEntity shoppingCartEntity = this.shoppingCartJpaRepository.findById(id).orElseThrow();
        ProductEntity productEntity = this.productJpaRepository.findById(productId).orElseThrow();
        CartItemEntity cartItemEntity = this.cartItemJpaRepository.findByShoppingCartEntityAndProductEntity(shoppingCartEntity, productEntity);
        shoppingCartEntity.getItems().remove(cartItemEntity);
        if(cartItemEntity != null){
            this.cartItemJpaRepository.delete(cartItemEntity);
        }
        return this.shoppingCartMapper.toShoppingCartDto(shoppingCartEntity);
    }

    @Override
    public void finishShoppingCart(Long id){
        ShoppingCartEntity shoppingCartEntity = this.shoppingCartJpaRepository.findById(id).get();
        shoppingCartEntity.setFinished(true);
        this.shoppingCartJpaRepository.save(shoppingCartEntity);
    }

    @Override
    public boolean existsShoppingCart(Long id){
        return this.shoppingCartJpaRepository.existsById(id);
    }

    
}
