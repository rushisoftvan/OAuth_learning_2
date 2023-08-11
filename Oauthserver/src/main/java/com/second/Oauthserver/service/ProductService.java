package com.second.Oauthserver.service;

import com.second.Oauthserver.Exception.ProductNotFountException;
import com.second.Oauthserver.Mapper.ProductMapper;
import com.second.Oauthserver.dto.request.CreateProductRequest;
import com.second.Oauthserver.dto.request.UpdateProductRequest;
import com.second.Oauthserver.dto.response.ProductResponse;
import com.second.Oauthserver.entity.ProductEntity;
import com.second.Oauthserver.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    public ProductResponse saveProduct(@NotNull CreateProductRequest createProductRequest){
        ProductEntity product = this.productMapper.toEntity(createProductRequest);
        ProductEntity savedProduct = this.productRepository.save(product);
        return this.productMapper.toDto(savedProduct);
    }
    
    public ProductResponse getProductById(Integer productId){
        ProductEntity productEntityBYId = this.getProductEntityBYId(productId);
        return this.productMapper.toDto(productEntityBYId);
    }

    private ProductEntity getProductEntityBYId(Integer id){
        Optional<ProductEntity> product = this.productRepository.findById(id);
        if(product.isPresent()){
            return product.get();
        }
        throw  new ProductNotFountException("product is not found for : "+ id);
    }
    
    public List<ProductResponse> getAllProducts(){
        List<ProductEntity> productList = this.productRepository.findAll();
        return  this.productMapper.toProductResponseList(productList);
    }

    public Integer updateProduct(Integer id, UpdateProductRequest updateProductRequest){
        ProductEntity productById = this.getProductEntityBYId(id);
        productById.setName(updateProductRequest.getName());
        productById.setStatus(updateProductRequest.getStatus());
        productById.setPrice(updateProductRequest.getPrice());
        ProductEntity updatedProduct = this.productRepository.save(productById);
        return updatedProduct.getId();
    }

}
