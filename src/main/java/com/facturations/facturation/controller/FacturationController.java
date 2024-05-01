package com.facturations.facturation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.facturations.facturation.models.Facturation;
import com.facturations.facturation.service.FacturationService;



@RestController
@RequestMapping("/facturations")
public class FacturationController {

    @Autowired
    private FacturationService service;

    @PostMapping
    public ResponseEntity<Facturation> createFacturation(@RequestBody Facturation facturation) {
        return ResponseEntity.ok(service.createFacturation(facturation));
    }

    @GetMapping("/{facturationId}")
    public ResponseEntity<Facturation> getFacturation(@PathVariable Long facturationId) {
        return service.getFacturationById(facturationId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{facturationId}")
    public ResponseEntity<Facturation> updateFacturation(@PathVariable Long facturationId, @RequestBody Facturation facturation) {
        return ResponseEntity.ok(service.updateFacturation(facturationId, facturation));
    }

    @DeleteMapping("/{facturationId}")
    public ResponseEntity<Void> deleteFacturation(@PathVariable Long facturationId) {
        service.deleteFacturation(facturationId);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Facturation>> listAllFacturations() {
        return ResponseEntity.ok(service.listAllFacturations());
    }
}
