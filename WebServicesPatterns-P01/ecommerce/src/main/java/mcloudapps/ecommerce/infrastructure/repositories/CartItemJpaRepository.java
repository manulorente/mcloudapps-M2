package mcloudapps.ecommerce.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import mcloudapps.ecommerce.infrastructure.models.CartItemEntity;
import mcloudapps.ecommerce.infrastructure.models.ProductEntity;
import mcloudapps.ecommerce.infrastructure.models.ShoppingCartEntity;

public interface CartItemJpaRepository extends JpaRepository<CartItemEntity, Long>{

    CartItemEntity findByShoppingCartEntity(ShoppingCartEntity shoppingCartEntity);

    CartItemEntity findByShoppingCartEntityAndProductEntity(ShoppingCartEntity shoppingCartEntity, ProductEntity productEntity);
    
}
