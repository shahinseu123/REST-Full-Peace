package com.springbootrestapi.RESTFullPeace.repository.login.service;


	
	import java.util.HashSet;
	import java.util.ArrayList;
	import java.util.Arrays;

    
    import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
	import org.springframework.stereotype.Service;

    import com.springbootrestapi.RESTFullPeace.login.model.Role;
    import com.springbootrestapi.RESTFullPeace.login.model.User;
    import com.springbootrestapi.RESTFullPeace.repository.login.repository.RoleRepository;
    import com.springbootrestapi.RESTFullPeace.repository.login.repository.UserRepository;
    
	

	@Service("userService")
	public class UserServiceImpl implements UserService {

		
		@Autowired
		private UserRepository userRepository;
		
		@Autowired
		private RoleRepository roleRepository;
		@Autowired
		
		private BCryptPasswordEncoder bCryptPasswordEncoder;
		public User findUserByEmail(String email) {
			
			return userRepository.findByEmail(email);
		}
		public void saveUser(User user) {
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			user.setActive(1);
			Role userRole = roleRepository.findByRole("ADMIN");
			user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
			userRepository.save(user);
			
			
		}
			
	}

	


