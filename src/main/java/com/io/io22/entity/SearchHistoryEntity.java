package com.io.io22.entity;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "search_history")
public class SearchHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "search_date")
    private LocalDateTime clusterSearchDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_email")
    private UserEntity userEntity;

    @ElementCollection
    private Collection<String> productEntity;

    public SearchHistoryEntity() {
    }

    public SearchHistoryEntity(LocalDateTime clusterSearchDate, UserEntity userEntity, Collection<String> productEntity) {
        this.clusterSearchDate = clusterSearchDate;
        this.userEntity = userEntity;
        this.productEntity = productEntity;
    }

    public Long getId() {
        return id;
    }

    public String getClusterSearchDate() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return clusterSearchDate.format(format);
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public List<String> getProductEntity() {
        return new ArrayList<>(productEntity);
    }
}
