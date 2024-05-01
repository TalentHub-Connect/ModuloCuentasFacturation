package com.facturations.facturation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facturations.facturation.models.Facturation;


public interface FacturationRepository extends JpaRepository<Facturation, Long> {
}
