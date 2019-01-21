package com.springbootrestapi.RESTFullPeace.controller;


	import java.util.List;

	import javax.validation.Valid;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

import com.springbootrestapi.RESTFullPeace.dao.DoctorDAO;
import com.springbootrestapi.RESTFullPeace.model.Doctor;

	
	@RestController
	@RequestMapping("/clinic")
	public class DoctorController {
	  @Autowired	
	  DoctorDAO doctorDAO;
	  
	  // to save an doctor into database
	  @PostMapping("/doctor")
	  public Doctor createDoctor(@Valid @RequestBody Doctor doc){
		  return doctorDAO.save(doc);
	  }
		  
	  // to get all doctors
	  @GetMapping("/doctor")	  
	  public List<Doctor> findAllDoctor(){
			return doctorDAO.findAll();
	  
	  
	  }
	   //get doc by doc id
	  @GetMapping("/doctor/{id}")
	  public ResponseEntity<Doctor> getDoctorId(@PathVariable(value = "id") Long docid){
		  Doctor doc = doctorDAO.findOne(docid);
		    if(doc==null){
		    	return ResponseEntity.notFound().build();
		    }
		    return ResponseEntity.ok().body(doc);
	  }
	  //update an doc by doc id
	  @PostMapping("/doctor/{id}")
	  public ResponseEntity<Doctor> updateDoctor(@PathVariable(value = "id") long docid,@Valid @RequestBody Doctor docDetails){
		  Doctor doc = doctorDAO.findOne(docid);
		  if(doc==null){
		    	return ResponseEntity.notFound().build();
		    }
		    doc.setName(docDetails.getName());
		    doc.setDepartment(docDetails.getDepartment());
		    doc.setJoining(docDetails.getJoining());
		    
		    Doctor updateDoctor = doctorDAO.save(doc);
		    return ResponseEntity.ok().body(updateDoctor);
	  }
	  //delete an employee
	  @DeleteMapping("/doctor/{id}")
	  public ResponseEntity<Doctor> deleteDoctor(@PathVariable(value = "id") Long docid){
		  Doctor doc = doctorDAO.findOne(docid);
		  if(doc==null){
		    	return ResponseEntity.notFound().build();
		    }
		    doctorDAO.delete(doc);
		    return ResponseEntity.ok().build();
	  }
	  
	  
	  
	  
	  
	}





