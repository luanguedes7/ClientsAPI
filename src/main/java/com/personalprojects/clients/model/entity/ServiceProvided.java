package com.personalprojects.clients.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "tb_service")
public class ServiceProvided {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 155)
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    @Column(nullable = false)
    private BigDecimal price;

    public ServiceProvided() {

    }

    public ServiceProvided(Integer id, String description, Client client, BigDecimal price) {
        super();
        this.id = id;
        this.description = description;
        this.client = client;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ServiceProvided serviceProvided = (ServiceProvided) o;
        return Objects.equals(id, serviceProvided.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
