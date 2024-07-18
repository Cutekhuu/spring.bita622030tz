package com.example.records.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.records.Model.InsurenceDetail;



@Repository
public interface InsurenceDetailRepository extends JpaRepository<InsurenceDetail, Long> {

}