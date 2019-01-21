package com.springbootrestapi.RESTFullPeace.model;



	import java.util.Date;

	import javax.persistence.Entity;
	import javax.persistence.EntityListeners;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;
	import javax.persistence.Temporal;
	import javax.persistence.TemporalType;
	import javax.validation.constraints.NotBlank;

	import org.springframework.data.annotation.LastModifiedDate;
	import org.springframework.data.jpa.domain.support.AuditingEntityListener;
	// its a model class inside model package
	@Entity
	@Table(name = "Patient")
	@EntityListeners(AuditingEntityListener.class)
	public class Patient {
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
	    @NotBlank
		private String name;
	    @NotBlank
		private Long mobile;
	    @NotBlank
		private String age;
	    @NotBlank
	    private String gender;
	    @NotBlank
	    private String occupation;
	    @NotBlank
	    private String symptom_summery;
	    
	    
	    @Temporal(TemporalType.TIMESTAMP)
	    @LastModifiedDate
	    private Date createAt;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		
		public Long getMobile() {
			return mobile;
		}
		public void setMobile(Long mobile) {
			this.mobile = mobile;
		}
		public String getAge() {
			return age;
		}
		public void setAge(String age) {
			this.age = age;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getOccupation() {
			return occupation;
		}
		public void setOccupation(String occupation) {
			this.occupation = occupation;
		}
		public String getSymptom_summery() {
			return symptom_summery;
		}
		public void setSymptom_summery(String symptom_summery) {
			this.symptom_summery = symptom_summery;
		}
		public Date getCreateAt() {
			return createAt;
		}
		public void setCreateAt(Date createAt) {
			this.createAt = createAt;
		}
		
	




}
