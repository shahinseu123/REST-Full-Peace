package com.springbootrestapi.RESTFullPeace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootrestapi.RESTFullPeace.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
