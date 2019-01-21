package com.springbootrestapi.RESTFullPeace.dao;


	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

import com.springbootrestapi.RESTFullPeace.model.Doctor;
import com.springbootrestapi.RESTFullPeace.repository.DoctorRepository;

   
	
	//doctors data access object
	@Service
	public class DoctorDAO {
		@Autowired
		DoctorRepository doctorRepository;
		
		//to save am doctor
		public Doctor save(Doctor doc){
			return doctorRepository.save(doc);
		}
		
		//search * doctors
		public List<Doctor> findAll(){
			return doctorRepository.findAll();
		}
		
		//get an doctor by id
		public Doctor findOne(Long docid){
			return doctorRepository.getOne(docid);
		}
		//delete an doctor 
		public void delete(Doctor doc){
			doctorRepository.delete(doc);
		}

	}




