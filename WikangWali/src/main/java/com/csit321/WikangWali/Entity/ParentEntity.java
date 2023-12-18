package com.csit321.WikangWali.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblparent")
public class ParentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "parent_name")
    private String name;

    @Column(name = "parent_email")
    private String email;

    @Column(name = "parent_password")
    private String password;

    @Column(name = "contact_details")
    private String contactDetails;

    // Other fields for child's progress, etc.

    public ParentEntity() {
        // Default constructor
    }

    public ParentEntity(String name, String email, String password, String contactDetails) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.contactDetails = contactDetails;
        // Initialize other fields as needed
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

  
    @Override
    public String toString() {
        return "ParentEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", contactDetails='" + contactDetails + '\'' +
                // Add other fields to the string representation
                '}';
    }
}
