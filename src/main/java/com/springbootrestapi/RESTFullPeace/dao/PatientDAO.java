package com.springbootrestapi.RESTFullPeace.dao;


	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

import com.springbootrestapi.RESTFullPeace.model.Patient;
import com.springbootrestapi.RESTFullPeace.repository.PatientRepository;

	


	//patient data access object
	@Service
	public class PatientDAO {
		@Autowired
		PatientRepository patientRepository;
		
		//to save am patient
		public Patient save(Patient pat){
			return patientRepository.save(pat);
		}
		
		//search * patient
		public List<Patient> findAll(){
			return patientRepository.findAll();
		}
		
		//get an patient by id
		public Patient findOne(Long patid){
			return patientRepository.getOne(patid);
		}
		//delete an patient 
		public void delete(Patient pat){
			patientRepository.delete(pat);
		}

	

}
