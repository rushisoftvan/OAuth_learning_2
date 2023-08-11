package com.second.Oauthserver.repository;

import com.second.Oauthserver.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity , Integer> {

}
