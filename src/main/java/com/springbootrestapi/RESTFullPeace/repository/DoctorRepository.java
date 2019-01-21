package com.springbootrestapi.RESTFullPeace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootrestapi.RESTFullPeace.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
