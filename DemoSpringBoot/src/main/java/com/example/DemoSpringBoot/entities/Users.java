package com.example.DemoSpringBoot.entities;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern.Flag;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import com.example.DemoSpringBoot.validationz.PhoneNumberConstraint;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGSERIAL PRIMARY KEY NOT NULL")
    private BigInteger id;

    @Column
    @NotEmpty(message = "first name is required")
    @Size(max = 8, message = "The length of first name must be between 1 and 8 characters.")
    private String firstName;

    @Column
    @NotEmpty(message = "last name is required")
    @Size(max = 64, message = "The length of last name must be between 1 and 64 characters.")
    private String lastName;

    @Column
    @NotEmpty(message = "The email address is required.")
    @Email(message = "The email address is invalid.", flags = { Flag.CASE_INSENSITIVE })
    @Size(max = 64, message = "The length of email not exceed 64 characters")
    private String email;

    @Column
    @PhoneNumberConstraint
    private String phone;

    @Column(updatable = false)
    @CreationTimestamp
    @ColumnDefault(value = "current_timestamp")
    private Date createdDate;

    /**
     * Gen Constructor
     * 
     * @return
     */

    public Users() {

    }

    public Users(String firstName, String lastName, String email, String phone, Date createdDate) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.createdDate = createdDate;
    }

    /**
     * Gen Getter Setter
     * 
     * @return
     */

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = (createdDate != null) ? new Date(createdDate.getTime()) : new Date();
    }

}
