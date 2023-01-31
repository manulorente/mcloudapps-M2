package mcloudapps.ecommerce.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import mcloudapps.ecommerce.infrastructure.models.ShoppingCartEntity;

public interface ShoppingCartJpaRepository extends JpaRepository<ShoppingCartEntity, Long>{
    @Transactional
    @Modifying
    @Query("UPDATE ShoppingCartEntity s SET s.finished = true WHERE s.id = :id")
    void updateShoppingCartFinishedById(@Param("id") Long id);

}
