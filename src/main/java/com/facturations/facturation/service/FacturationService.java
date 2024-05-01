package com.facturations.facturation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.facturations.facturation.models.Facturation;
import com.facturations.facturation.repository.FacturationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FacturationService {
    @Autowired
    private FacturationRepository repository;

    @Transactional
    public Facturation createFacturation(Facturation facturation) {
        return repository.save(facturation);
    }

    @Transactional(readOnly = true)
    public Optional<Facturation> getFacturationById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public Facturation updateFacturation(Long id, Facturation updatedFacturation) {
        return repository.findById(id).map(facturation -> {
            facturation.setFacturationDate(updatedFacturation.getFacturationDate());
            facturation.setPrice(updatedFacturation.getPrice());
            facturation.setFacturationId(updatedFacturation.getFacturationId());
            facturation.setStatus(updatedFacturation.getStatus());
            facturation.setCompanyId(updatedFacturation.getCompanyId());
            return repository.save(facturation);
        }).orElseThrow(() -> new RuntimeException("Facturation not found"));
    }

    @Transactional
    public void deleteFacturation(Long id) {
        repository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<Facturation> listAllFacturations() {
        return repository.findAll();
    }
}