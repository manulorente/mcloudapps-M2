package mcloudapps.ecommerce.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import mcloudapps.ecommerce.dtos.responses.ShoppingCartResponseDto;
import mcloudapps.ecommerce.services.ShoppingCartService;

@RestController
@RequestMapping("/api/shoppingcarts")
public class ShoppingCartRestController {

    private ShoppingCartService shoppingCartService;

    public ShoppingCartRestController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @Operation(summary = "Create new shopping cart")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create new shopping cart",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ShoppingCartResponseDto.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid shopping cart supplied", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @PostMapping("/")
    public ShoppingCartResponseDto create() {
        return this.shoppingCartService.create();
    }

    @Operation(summary = "Update shopping cart by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update shopping cart by id",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ShoppingCartResponseDto.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid shopping cart supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Shopping cart not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @PatchMapping("/{id}")
    public ShoppingCartResponseDto update(@Parameter(description = "Shopping cart id to update", required = true)
                                          @PathVariable("id") Long id) {
        return this.shoppingCartService.finishShoppingCart(id);
    }
    
    @Operation(summary = "Find shopping cart by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Find shopping cart by id",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ShoppingCartResponseDto.class))}),
            @ApiResponse(responseCode = "404", description = "Shopping cart not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @GetMapping("/{id}")
    public ShoppingCartResponseDto findById(@Parameter(description = "Shopping cart id to find", required = true)
                                            @PathVariable("id") Long id) {
        return this.shoppingCartService.findById(id);
    }

    @Operation(summary = "Delete shopping cart by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete shopping cart by id",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ShoppingCartResponseDto.class))}),
            @ApiResponse(responseCode = "404", description = "Shopping cart not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @DeleteMapping("/{id}")
    public void delete(@Parameter(description = "Shopping cart id to delete", required = true)
                                          @PathVariable("id") Long id) {
        this.shoppingCartService.delete(id);
    }

    @Operation(summary = "Add certain quantity of product to shopping cart by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Add certain quantity of product to shopping cart by id",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ShoppingCartResponseDto.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid shopping cart supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Shopping cart not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @PostMapping("/{id}/product/{productId}/quantity/{prodQuantity}")
    public ShoppingCartResponseDto addProduct(@Parameter(description = "Shopping cart id to add product", required = true)
                                              @PathVariable("id") Long id,
                                              @Parameter(description = "Product id to add to shopping cart", required = true)
                                              @PathVariable("productId") Long productId,
                                              @Parameter(description = "Product quantity to add to shopping cart", required = true)
                                              @PathVariable("prodQuantity") Long prodQuantity) {
        return this.shoppingCartService.addProduct(id, productId, prodQuantity);
    }

    @Operation(summary = "Remove certain product from shopping cart by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Remove certain product from shopping cart by id",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ShoppingCartResponseDto.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid shopping cart supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Shopping cart not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @DeleteMapping("/{id}/product/{productId}")
    public ShoppingCartResponseDto removeProduct(@Parameter(description = "Shopping cart id to remove product", required = true)
                                                 @PathVariable("id") Long id,
                                                 @Parameter(description = "Product id to remove from shopping cart", required = true)
                                                 @PathVariable("productId") Long productId) {
        return this.shoppingCartService.deleteProduct(id, productId);
    }
}
