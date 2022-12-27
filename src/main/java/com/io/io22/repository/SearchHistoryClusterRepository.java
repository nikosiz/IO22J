package com.io.io22.repository;

import com.io.io22.entity.SearchHistoryClusterEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchHistoryClusterRepository extends CrudRepository<SearchHistoryClusterEntity, Long> {
}
