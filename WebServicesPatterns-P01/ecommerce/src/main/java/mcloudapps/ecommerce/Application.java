package mcloudapps.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import mcloudapps.ecommerce.domain.ProductUseCaseImpl;
import mcloudapps.ecommerce.domain.ShoppingCartUseCaseImpl;
import mcloudapps.ecommerce.domain.port.ProductRepository;
import mcloudapps.ecommerce.domain.port.ProductUseCase;
import mcloudapps.ecommerce.domain.port.ShoppingCartRepository;
import mcloudapps.ecommerce.domain.port.ShoppingCartUseCase;
import mcloudapps.ecommerce.infrastructure.ProductRepositoryAdapter;
import mcloudapps.ecommerce.infrastructure.ShoppingCartRepositoryAdapter;
import mcloudapps.ecommerce.infrastructure.mappers.ProductMapper;
import mcloudapps.ecommerce.infrastructure.mappers.ShoppingCartMapper;
import mcloudapps.ecommerce.infrastructure.repositories.CartItemJpaRepository;
import mcloudapps.ecommerce.infrastructure.repositories.ProductJpaRepository;
import mcloudapps.ecommerce.infrastructure.repositories.ShoppingCartJpaRepository;
import mcloudapps.ecommerce.services.ProductService;
import mcloudapps.ecommerce.services.ShoppingCartService;
import mcloudapps.ecommerce.services.impl.ProductServiceImpl;
import mcloudapps.ecommerce.services.impl.ShoppingCartServiceImpl;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean 
	ProductUseCase productUseCase(ProductRepository productRepository) {
		return new ProductUseCaseImpl(productRepository);
	}	

	@Bean 
	ShoppingCartUseCase shoppingCartUseCase(ShoppingCartRepository shoppingCartRepository) {
		return new ShoppingCartUseCaseImpl(shoppingCartRepository);
	}

	@Bean 
	ProductService productService(ProductUseCase productUseCase, ProductMapper mapper) {
		return new ProductServiceImpl(productUseCase, mapper);
	}

	@Bean
	ShoppingCartService shoppingCartService(ShoppingCartUseCase shoppingCartUseCase, ShoppingCartMapper mapper) {
		return new ShoppingCartServiceImpl(shoppingCartUseCase, mapper);
	}

	@Bean
	ShoppingCartRepository ShoppingCartRepositoryAdapter(ShoppingCartJpaRepository shoppingCartJpaRepository,
	CartItemJpaRepository cartItemJpaRepository, ProductJpaRepository productJpaRepository,
	ShoppingCartMapper shoppingCartMapper) {
		return new ShoppingCartRepositoryAdapter(shoppingCartJpaRepository, cartItemJpaRepository, productJpaRepository, shoppingCartMapper);
	}

	@Bean
	ProductRepository productRepositoryAdapter(ProductJpaRepository productJpaRepository, ProductMapper mapper) {
		return new ProductRepositoryAdapter(productJpaRepository, mapper);
	}
}
