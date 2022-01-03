package com.dragonlin.hanashopapi.repositories;

import com.dragonlin.hanashopapi.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepo extends JpaRepository<ProductEntity,String> {
}
