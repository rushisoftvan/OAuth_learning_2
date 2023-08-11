package com.second.Oauthserver.Mapper;

import com.second.Oauthserver.dto.request.CreateProductRequest;
import com.second.Oauthserver.dto.response.ProductResponse;
import com.second.Oauthserver.entity.ProductEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.context.annotation.Configuration;

import java.util.List;



@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,injectionStrategy = InjectionStrategy.CONSTRUCTOR )
public interface ProductMapper {

    ProductEntity toEntity(CreateProductRequest createProductRequest);

       ProductResponse toDto(ProductEntity productEntity);
       List<ProductResponse> toProductResponseList(List<ProductEntity> products);


}
