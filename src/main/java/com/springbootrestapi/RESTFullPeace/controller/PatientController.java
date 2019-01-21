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

    import com.springbootrestapi.RESTFullPeace.dao.PatientDAO;
    import com.springbootrestapi.RESTFullPeace.model.Patient;

	
	@RestController
	@RequestMapping("/clinic")
	public class PatientController {
	  @Autowired	
	  PatientDAO patientDAO;
	  
	  // to save an patient into database
	  @PostMapping("/patient")
	  public Patient createPatient(@Valid @RequestBody Patient pat){
		  return patientDAO.save(pat);
	  }
		  
	  // to get all patient
	  @GetMapping("/patient")	  
	  public List<Patient> findAllPatients(){
			return patientDAO.findAll();
	  
	  
	  }
	   //get employee by pat id
	  @GetMapping("/patients/{id}")
	  public ResponseEntity<Patient> getPatientById(@PathVariable(value = "id") Long patid){
		  Patient pat = patientDAO.findOne(patid);
		    if(pat==null){
		    	return ResponseEntity.notFound().build();
		    }
		    return ResponseEntity.ok().body(pat);
	  }
	  //update an pat by patient id
	  @PostMapping("/patients/{id}")
	  public ResponseEntity<Patient> updatePatient(@PathVariable(value = "id") long patid,@Valid @RequestBody Patient patDetails){
		  Patient pat = patientDAO.findOne(patid);
		  if(pat==null){
		    	return ResponseEntity.notFound().build();
		    }
		    pat.setName(patDetails.getName());
		    pat.setMobile(patDetails.getMobile());
		    pat.setAge(patDetails.getAge());
		    pat.setGender(patDetails.getGender());
		    pat.setOccupation(patDetails.getOccupation());
		    pat.setSymptom_summery(patDetails.getSymptom_summery());
		    
		    
		    Patient updatePatient = patientDAO.save(pat);
		    return ResponseEntity.ok().body(updatePatient);
	  }
	  //delete a patient
	  @DeleteMapping("/patient/{id}")
	  public ResponseEntity<Patient> deletePatient(@PathVariable(value = "id") Long patid){
		  Patient pat = patientDAO.findOne(patid);
		  if(pat==null){
		    	return ResponseEntity.notFound().build();
		    }
		    patientDAO.delete(pat);
		    return ResponseEntity.ok().build();
	  }
	  
	  
	  
	  
	  
	}





