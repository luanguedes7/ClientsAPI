package com.personalprojects.clients.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    private String Name;

    @Column(nullable = false, length = 11)
    private String CPF;

    @Column(name = "register_data")
    private LocalDate RegisterDate;

    public Client() {

    }

    public Client(Integer id, String Name, String CPF) {
        super();
        this.id = id;
        this.Name = Name;
        this.CPF = CPF;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public String getCPF() {
        return CPF;
    }

    @JsonFormat(pattern = "dd/MM/yyyy")
    public LocalDate getRegisterDate() {
        return RegisterDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void setRegisterDate(LocalDate registerDate) {
        RegisterDate = registerDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @PrePersist
    public void prePersist() {
        setRegisterDate(LocalDate.now());
    }
}
