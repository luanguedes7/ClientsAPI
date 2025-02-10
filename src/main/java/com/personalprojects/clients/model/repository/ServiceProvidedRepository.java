package com.personalprojects.clients.model.repository;

import com.personalprojects.clients.model.entity.ServiceProvided;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServiceProvidedRepository extends JpaRepository<ServiceProvided, Integer> {

    @Query("SELECT s FROM ServiceProvided s JOIN s.client c where upper(c.Name) LIKE upper( :name) " +
            "and MONTH(s.date) =:month")
    List<ServiceProvided> findByNameClientAndMonth(@Param("name") String name, @Param("month") Integer month);
}
