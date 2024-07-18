package com.example.records.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.records.Model.MakeAppointment;
import com.example.records.Repository.MakeAppointmentRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Appointment")
public class MakeAppointmentController {

    @Autowired
    private MakeAppointmentRepository repository;

    @GetMapping("/")
    public ResponseEntity<List<MakeAppointment>> getAllRecords() {
        List<MakeAppointment> appointments = repository.findAll();
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<MakeAppointment> addMakeAppointment(@RequestBody MakeAppointment record) {
        MakeAppointment appointment = repository.save(record);
        return new ResponseEntity<>(appointment, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MakeAppointment> getRecordById(@PathVariable Long id) {
        Optional<MakeAppointment> appointment = repository.findById(id);
        return appointment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MakeAppointment> updateRecord(@PathVariable Long id, @RequestBody MakeAppointment newAppointment) {
        return repository.findById(id)
                .map(existingAppointment -> {
                    existingAppointment.setIdNumber(newAppointment.getIdNumber());
                    existingAppointment. setAppointmentDate(newAppointment.getAppointmentDate());
                    existingAppointment.setDisease(newAppointment.getDisease());
                    MakeAppointment updatedAppointment = repository.save(existingAppointment);
                    return ResponseEntity.ok().body(updatedAppointment);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRecord(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok("Deleted appointment with ID: " + id);
    }
}
