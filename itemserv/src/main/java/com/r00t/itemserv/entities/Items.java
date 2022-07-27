package com.r00t.itemserv.entities;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Items {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "BIGSERIAL NOT NULL")
    private BigInteger id;

    @NotNull
    @Column(name = "itemID", length = 8)
    private String itemID;

    @Column(length = 64, name = "itemName")
    @NotEmpty
    private String itemName;

    @Column(length = 64, name = "description")
    @NotEmpty
    private String description;

    @Column(length = 64, name = "quantity", columnDefinition = "BIGINT")
    @NotNull
    private BigInteger quantity;

    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
    @JoinColumn(name = "catalogID")
    private Catalogs catal0g;

    @Column(updatable = false)
    @CreationTimestamp
    @ColumnDefault(value = "CURRENT_TIMESTAMP")
    private Date createdDate;

    @Column
    @UpdateTimestamp
    @ColumnDefault(value = "CURRENT_TIMESTAMP")
    private Date updateDate;

    @Column(columnDefinition = "boolean default false")
    private boolean isDeleted;
}
