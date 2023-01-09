package com.io.io22.repository;

import com.io.io22.entity.OfferEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends CrudRepository<OfferEntity, Long> {
}
