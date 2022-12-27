package com.io.io22.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
public class SearchHistoryClusterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    private LocalDateTime clusterSearchDate;

    @OneToMany
    @JoinColumn(name = "productEntity_id")
    private Collection<ProductEntity> productEntity;

}
