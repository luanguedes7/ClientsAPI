package com.personalprojects.clients.model.repository;

import com.personalprojects.clients.model.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
}
