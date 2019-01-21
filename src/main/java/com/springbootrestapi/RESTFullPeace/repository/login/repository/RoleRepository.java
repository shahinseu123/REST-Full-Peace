package com.springbootrestapi.RESTFullPeace.repository.login.repository;


	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;

    import com.springbootrestapi.RESTFullPeace.login.model.Role;

	public interface RoleRepository extends JpaRepository<Role, Integer> {
	    Role findByRole(String role);
	} 




