package com.klef.demo.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category;
    private int quantity;
    private String location;
    private String status;

    private Long userId;

    // 🔥 IMPORTANT
    @Column(name = "donor_id")
    @JsonProperty
    private Long donorId;

    // Getters & Setters

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }

    public void setCategory(String category) { this.category = category; }

    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getLocation() { return location; }

    public void setLocation(String location) { this.location = location; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public Long getUserId() { return userId; }

    public void setUserId(Long userId) { this.userId = userId; }

    public Long getDonorId() { return donorId; }

    public void setDonorId(Long donorId) { this.donorId = donorId; }
}