package com.springbootrestapi.RESTFullPeace.repository.login.repository;


	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;

    import com.springbootrestapi.RESTFullPeace.login.model.User;

	@Repository("userRepository")
	public interface UserRepository extends JpaRepository<User, Long> {
	     User findByEmail(String email);
	}


