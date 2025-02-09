package com.personalprojects.clients.rest.dto;

import java.util.Objects;

public class ServiceProvidedDTO {

    private String description;
    private String price;
    private String date;
    private Integer idClient;

    public ServiceProvidedDTO() {}

    public ServiceProvidedDTO(String description, String price, String date, Integer idClient) {
        this.description = description;
        this.price = price;
        this.date = date;
        this.idClient = idClient;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setData(String date) {
        this.date = date;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ServiceProvidedDTO that = (ServiceProvidedDTO) o;
        return Objects.equals(idClient, that.idClient);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idClient);
    }
}
