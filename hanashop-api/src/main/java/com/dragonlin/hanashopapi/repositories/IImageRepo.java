package com.dragonlin.hanashopapi.repositories;

import com.dragonlin.hanashopapi.entities.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IImageRepo extends JpaRepository<ImageEntity,String> {
}
