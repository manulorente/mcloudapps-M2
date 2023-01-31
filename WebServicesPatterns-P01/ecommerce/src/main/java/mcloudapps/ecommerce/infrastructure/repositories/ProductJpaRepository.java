package mcloudapps.ecommerce.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import mcloudapps.ecommerce.infrastructure.models.ProductEntity;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {

}