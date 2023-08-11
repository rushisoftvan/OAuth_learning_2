package com.second.Oauthserver.entity;

import com.second.Oauthserver.enums.StatusEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name="product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer price;

    @Column(name = "ACTIVE_STATUS")
    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    @Column(name = "CREATED_DATE_TIME")
    private LocalDateTime createdDateTime;

    @Column(name = "UPDATED_DATE_TIME")
    private LocalDateTime updatedDateTime;


    @PrePersist
    public void beforePersist() {
        this.createdDateTime = LocalDateTime.now();
        this.updatedDateTime = LocalDateTime.now();
        this.status = StatusEnum.ACTIVE;
    }

    @PreUpdate
    public void beforeUpdate() {
        this.updatedDateTime = LocalDateTime.now();
    }



}
