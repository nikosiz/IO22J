package com.io.io22.repository;


import com.io.io22.entity.CartEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends CrudRepository<CartEntity, Long> {

    Optional<CartEntity> findByUserEntity_Email(String userEmail);

}
