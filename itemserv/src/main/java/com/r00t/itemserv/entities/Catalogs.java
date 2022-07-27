package com.r00t.itemserv.entities;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Catalogs {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "BIGSERIAL NOT NULL")
    private BigInteger id;

    @NotNull
    @Column(name = "catalogID", length = 8)
    private String catalogID;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "catal0g", cascade = { CascadeType.ALL })
    private List<Items> itemsList;

    @Column(length = 64)
    @NotNull
    private String catalogName;

    @Column(length = 64)
    private String description;

    @Column(updatable = false)
    @ColumnDefault(value = "CURRENT_TIMESTAMP")
    @CreationTimestamp
    private Date createdDate;

    @Column
    @ColumnDefault(value = "CURRENT_TIMESTAMP")
    @UpdateTimestamp
    private Date updateDate;

    @Column(columnDefinition = "boolean default false")
    private boolean isDeleted;
}