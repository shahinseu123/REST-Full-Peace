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

		
		@Entity
		@Table(name = "Doctor")
		@EntityListeners(AuditingEntityListener.class)
		public class Doctor {
		    @Id
		    @GeneratedValue(strategy = GenerationType.AUTO)
			private Long id;
		    @NotBlank
			private String name;
		    @NotBlank
			private String department;
		    @NotBlank
			private String joining ;
		    
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
			public String getDepartment() {
				return department;
			}
			public void setDepartment(String department) {
				this.department = department;
			}
			
			public String getJoining() {
				return joining;
			}
			public void setJoining(String joining) {
				this.joining = joining;
			}
			public Date getCreateAt() {
				return createAt;
			}
			public void setCreateAt(Date createAt) {
				this.createAt = createAt;
			}
			
		



}
