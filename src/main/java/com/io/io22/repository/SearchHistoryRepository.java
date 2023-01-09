package com.io.io22.repository;

import com.io.io22.entity.SearchHistoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface SearchHistoryRepository extends CrudRepository<SearchHistoryEntity, Long> {

    Collection<SearchHistoryEntity> findByUserEntity_Email(String userEmail);

}
