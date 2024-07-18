package com.example.records.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.records.Model.MakeAppointment;

@Repository
public interface MakeAppointmentRepository extends JpaRepository<MakeAppointment, Long> {

}
