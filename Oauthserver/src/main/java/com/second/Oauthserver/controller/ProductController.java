package com.second.Oauthserver.controller;

import com.second.Oauthserver.dto.request.CreateProductRequest;
import com.second.Oauthserver.dto.request.UpdateProductRequest;
import com.second.Oauthserver.dto.response.ApiResponse;
import com.second.Oauthserver.dto.response.ProductResponse;
import com.second.Oauthserver.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductService productService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/products")
    public ApiResponse<ProductResponse> saveProduct(@RequestBody CreateProductRequest createProductRequest){
        log.debug("<<<<<<<<< saveProduct()");
        ProductResponse addedProduct = this.productService.saveProduct(createProductRequest);
        ApiResponse.ApiResponseBuilder<ProductResponse> builder = ApiResponse.builder();
        log.debug("saveProduct() >>>>>>>");
        return builder.data(addedProduct).statusCode(HttpStatus.CREATED.value()).build();
    }

    @PreAuthorize("hasAuthority('CUSTOMER')")
    @GetMapping("products/{id}")
    public ApiResponse<ProductResponse> fetchProductById(@PathVariable("id") Integer productId){
        log.debug("<<<<<<<<< fetchProductById()");
        ProductResponse productById = this.productService.getProductById(productId);
        ApiResponse.ApiResponseBuilder<ProductResponse> builder = ApiResponse.builder();
        log.debug("fetchProductById() >>>>>>>");
        return builder.data(productById).statusCode(HttpStatus.OK.value()).build();
    }
    @PreAuthorize("hasAuthority('CUSTOMER')")
    @GetMapping("/products")
     public ApiResponse<List<ProductResponse>> getAllProducts(){
        log.debug("<<<<<<<<< getAllProducts()");
        List<ProductResponse> allProducts = this.productService.getAllProducts();
        ApiResponse.ApiResponseBuilder<List<ProductResponse>> builder = ApiResponse.builder();
        log.debug("<<<<<<<<< getAllProducts()");
        return builder.data( allProducts).statusCode(HttpStatus.OK.value()).build();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/products/{id}")
    public ApiResponse<Integer> updateProduct(@PathVariable("id") Integer id, UpdateProductRequest updateProductRequest){
        log.debug("<<<<<<<<< updateProduct()");
        Integer updatedProductId = this.productService.updateProduct(id, updateProductRequest);
        ApiResponse.ApiResponseBuilder<Integer> builder = ApiResponse.builder();
        log.debug("<<<<<<<<< updateProduct()");
        return builder.data(updatedProductId).statusCode(HttpStatus.OK.value()).build();
    }
}
