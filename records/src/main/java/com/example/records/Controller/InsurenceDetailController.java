package com.example.records.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.records.Model.InsurenceDetail;
import com.example.records.Repository.InsurenceDetailRepository;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/")
public class InsurenceDetailController {
    @Autowired
    private InsurenceDetailRepository repository;

    @GetMapping("/")
    public ResponseEntity<List<InsurenceDetail>> getAllRecords() {
        List<InsurenceDetail> insurence = repository.findAll();
        return new ResponseEntity<>(insurence, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<InsurenceDetail> addInsuerenceDetail(@RequestBody InsurenceDetail record) {
        InsurenceDetail insurence = repository.save(record);
        return new ResponseEntity<>(insurence, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InsurenceDetail> getRecordById(@PathVariable Long id) {
        Optional<InsurenceDetail> insurence= repository.findById(id);
        return insurence.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<InsurenceDetail> updateRecord(@PathVariable Long id, @RequestBody InsurenceDetail newInsurerence) {
        return repository.findById(id)
                .map(existingInsurence -> {
                    existingInsurence.setNIDAID(newInsurerence.getNIDAID());
                    existingInsurence.setInsurenceID(newInsurerence.getInsurenceID());
                    InsurenceDetail updatedInsurence = repository.save(existingInsurence);
                    return ResponseEntity.ok().body(updatedInsurence);
                })
                .orElse(ResponseEntity.notFound().build());
    }


    
    


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRecord(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok("Deleted insurence with ID: " + id);
    }
}


